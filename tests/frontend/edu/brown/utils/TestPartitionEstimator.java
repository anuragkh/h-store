package edu.brown.utils;

import java.util.*;

import org.junit.Ignore;
import org.junit.Test;
import org.voltdb.VoltTable;
import org.voltdb.VoltTableRow;
import org.voltdb.VoltType;
import org.voltdb.VoltTable.ColumnInfo;
import org.voltdb.benchmark.tpcc.procedures.neworder;
import org.voltdb.benchmark.tpcc.procedures.paymentByCustomerId;
import org.voltdb.catalog.*;
import org.voltdb.utils.VoltTypeUtil;

import edu.brown.BaseTestCase;
import edu.brown.catalog.CatalogCloner;
import edu.brown.catalog.CatalogKey;
import edu.brown.catalog.CatalogUtil;
import edu.brown.catalog.special.MultiColumn;
import edu.brown.catalog.special.MultiProcParameter;
import edu.brown.hashing.*;

/**
 * 
 * @author pavlo
 *
 */
public class TestPartitionEstimator extends BaseTestCase {

    protected static AbstractHasher hasher;
    protected static final int NUM_PARTITIONS = 100;
    protected static final int BASE_PARTITION = 1;
    
    @Override
    protected void setUp() throws Exception {
        super.setUp(ProjectType.TPCC);
        this.addPartitions(NUM_PARTITIONS);
        if (hasher == null) {
            hasher = new DefaultHasher(catalog_db, NUM_PARTITIONS); // CatalogUtil.getNumberOfPartitions(catalog_db));
        }
    }
    
    /**
     * testMultiAttributePartitioning
     */
    public void testMultiAttributePartitioning() throws Exception {
        // This checks that the ProcParameters and the StmtParameters get mapped to
        // the same partition for a multi-attribute partitioned Procedure+Table
        Database clone_db = CatalogCloner.cloneDatabase(catalog_db);
        PartitionEstimator p_estimator = new PartitionEstimator(clone_db);

        // Procedure
        Procedure catalog_proc = this.getProcedure(clone_db, paymentByCustomerId.class);
        ProcParameter catalog_params[] = new ProcParameter[] {
            this.getProcParameter(clone_db, catalog_proc, 1),   // D_ID
            this.getProcParameter(clone_db, catalog_proc, 0),   // W_ID
        };
        MultiProcParameter mpp = MultiProcParameter.get(catalog_params);
        assertNotNull(mpp);
        assert(mpp.getIndex() >= 0);
        catalog_proc.setPartitionparameter(mpp.getIndex());

        // Table
        Table catalog_tbl = this.getTable(clone_db, "DISTRICT");
        String table_key = CatalogKey.createKey(catalog_tbl);
        Column catalog_cols[] = new Column[] {
            this.getColumn(clone_db, catalog_tbl, "D_ID"),
            this.getColumn(clone_db, catalog_tbl, "D_W_ID"),
        };
        MultiColumn mc = MultiColumn.get(catalog_cols);
        assertNotNull(mc);
        catalog_tbl.setPartitioncolumn(mc);
        p_estimator.initCatalog(clone_db);
        
        // Procedure Partition
        Long proc_params[] = new Long[] {
            new Long(NUM_PARTITIONS-1), // W_ID
            new Long(BASE_PARTITION),   // D_ID
        };
        Integer proc_partition = p_estimator.getBasePartition(catalog_proc, proc_params, true);
        assertNotNull(proc_partition);
        assert(proc_partition >= 0);
        assert(proc_partition < NUM_PARTITIONS);
        
        // Statement Partition
        Statement catalog_stmt = this.getStatement(clone_db, catalog_proc, "getDistrict");
        Long stmt_params[] = new Long[] {
            new Long(proc_params[0].longValue()), // W_ID
            new Long(proc_params[1].longValue()), // D_ID
        };
        Map<String, Set<Integer>> stmt_partitions = p_estimator.getTablePartitions(catalog_stmt, stmt_params, proc_partition);
        System.err.println(StringUtil.formatMaps(stmt_partitions));
        assertNotNull(stmt_partitions);
        assertEquals(1, stmt_partitions.size());
        assert(stmt_partitions.containsKey(table_key));
        assertEquals(1, stmt_partitions.get(table_key).size());
        assertEquals(stmt_partitions.get(table_key).toString(), proc_partition, CollectionUtil.first(stmt_partitions.get(table_key)));
    }
    
    /**
     * testMultiProcParameter
     */
    public void testMultiProcParameter() throws Exception {
        //  Try to partition TPC-C's neworder on W_ID and D_ID parameters
        Database clone_db = CatalogCloner.cloneDatabase(catalog_db);
        Procedure catalog_proc = this.getProcedure(clone_db, neworder.class);
        PartitionEstimator p_estimator = new PartitionEstimator(clone_db);

        ProcParameter catalog_params[] = new ProcParameter[] {
            this.getProcParameter(clone_db, catalog_proc, 0),   // W_ID
            this.getProcParameter(clone_db, catalog_proc, 1),   // D_ID
        };
        MultiProcParameter mpp = MultiProcParameter.get(catalog_params);
        assertNotNull(mpp);
        assert(mpp.getIndex() >= 0);
        catalog_proc.setPartitionparameter(mpp.getIndex());
        p_estimator.initCatalog(clone_db);
        
        // Case #1: Both parameters have values in the input
        Long params[] = new Long[] {
            new Long(NUM_PARTITIONS-1), // W_ID
            new Long(BASE_PARTITION),   // D_ID
        };
        Integer partition0 = p_estimator.getBasePartition(catalog_proc, params, true);
        assertNotNull(partition0);
        assert(partition0 >= 0);
//        System.err.println("partition0=" + partition0);
        assert(partition0 < NUM_PARTITIONS);
        
        // Case #2: The second parameter is null
        params = new Long[] {
            new Long(NUM_PARTITIONS-1), // W_ID
            null,                       // D_ID
        };
        Integer partition1 = p_estimator.getBasePartition(catalog_proc, params, true);
        assertNotNull(partition1);
        assert(partition1 >= 0);
        assert(partition1 < NUM_PARTITIONS);
//        System.err.println("partition1=" + partition1);
        assert(partition0.equals(partition1) == false);
        
        // Case #3: The first parameter is null
        params = new Long[] {
            null,                       // W_ID
            new Long(BASE_PARTITION),   // D_ID
        };
        Integer partition2 = p_estimator.getBasePartition(catalog_proc, params, true);
        assertNotNull(partition2);
        assert(partition2 >= 0);
        assert(partition2 < NUM_PARTITIONS);
//        System.err.println("partition2=" + partition2);
        assert(partition0.equals(partition2) == false);
    }
    
    
    /**
     * testMultiColumn
     */
    public void testMultiColumn() throws Exception {
        // Try to use multi-column partitioning on DISTRICT and see whether we can
        // actually get the right answer for neworder.getDistrict
        Database clone_db = CatalogCloner.cloneDatabase(catalog_db);
        Table catalog_tbl = this.getTable(clone_db, "DISTRICT");
        String table_key = CatalogKey.createKey(catalog_tbl);
        
        Column catalog_col0 = this.getColumn(clone_db, catalog_tbl, "D_ID");
        Column catalog_col1 = this.getColumn(clone_db, catalog_tbl, "D_W_ID");
        MultiColumn mc = MultiColumn.get(catalog_col0, catalog_col1);
        catalog_tbl.setPartitioncolumn(mc);
//        System.err.println("MUTLI COLUMN: " + mc);
        
        Procedure catalog_proc = this.getProcedure(clone_db, neworder.class);
        Statement catalog_stmt = this.getStatement(clone_db, catalog_proc, "getDistrict");

        Long params[] = new Long[] {
            new Long(BASE_PARTITION), // D_ID
            new Long(NUM_PARTITIONS - 1), // D_W_ID
        };
        PartitionEstimator p_estimator = new PartitionEstimator(clone_db);
        Map<String, Set<Integer>> p = p_estimator.getTablePartitions(catalog_stmt, params, BASE_PARTITION);
        assertNotNull(p);
        
        // Just check to make sure that we get back exactly one partition
        assert(p.containsKey(table_key));
        assertEquals("Unexpected result: " + p.get(table_key), 1, p.get(table_key).size());
        int stmt_partition = CollectionUtil.first(p.get(table_key));
        assert(stmt_partition >= 0) : "Invalid Partition: " + p.get(table_key);
        
        // Now create VoltTable and test that
        VoltTable vt = new VoltTable(new ColumnInfo[] {
            new ColumnInfo(catalog_col0.getName(), VoltType.get(catalog_col0.getType())),   // D_ID 
            new ColumnInfo(catalog_col1.getName(), VoltType.get(catalog_col1.getType())),   // D_W_ID
        });
        vt.addRow(params[0], params[1]);
        VoltTableRow vt_row = vt.fetchRow(0);
        int vt_partition = p_estimator.getTableRowPartition(catalog_tbl, vt_row);
        assert(vt_partition >= 0) : "Invalid Partition: " + vt_partition;
        assertEquals(stmt_partition, vt_partition);
    }
    
    /**
     * testArrayParameters
     */
    public void testArrayParameters() throws Exception {
        // Grab TPC-C's neworder and pass an array of W_ID's to getWarehouseTaxRate
        // Check that we get back all of the partitions that we expect from the array
        Table catalog_tbl = this.getTable("WAREHOUSE");
        String table_key = CatalogKey.createKey(catalog_tbl);
        Procedure catalog_proc = this.getProcedure(neworder.class);
        Statement catalog_stmt = this.getStatement(catalog_proc, "getWarehouseTaxRate");
        
        int num_warehouses = 5;
        Long params_object[] = new Long[num_warehouses];
        long params_primitive[] = new long[num_warehouses];
        Set<Integer> expected = new HashSet<Integer>();
        for (int i = 0; i < num_warehouses; i++) {
            long w_id = NUM_PARTITIONS - i - 1;
            params_object[i] =  new Long(w_id);
            params_primitive[i] = w_id;
            expected.add((int)w_id);
        } // FOR
        assertEquals(params_object.length, expected.size());
        assertEquals(params_primitive.length, expected.size());
//        System.err.println("EXPECTED: " + expected);
        
        // OBJECT
        Map<String, Set<Integer>> p = p_estimator.getTablePartitions(catalog_stmt, new Object[]{ params_object }, BASE_PARTITION);
        assertNotNull(p);
        assert(p.containsKey(table_key));
//        System.err.println("OBJECT: " + p.get(table_key));
        assertEquals(expected.size(), p.get(table_key).size());
        assertEquals(expected, p.get(table_key));
        
        // PRIMITIVE
        p = p_estimator.getTablePartitions(catalog_stmt, new Object[]{ params_object }, BASE_PARTITION);
        assertNotNull(p);
        assert(p.containsKey(table_key));
//        System.err.println("PRIMITIVE: " + p.get(table_key));
        assertEquals(expected.size(), p.get(table_key).size());
        assertEquals(expected, p.get(table_key));
        
    }
    
    /**
     * testSelect
     */
    public void testSelect() throws Exception {
        Procedure catalog_proc = this.getProcedure(neworder.class);
        Statement catalog_stmt = this.getStatement(catalog_proc, "getDistrict");
        assertNotNull(catalog_stmt);
//        System.err.println(CatalogUtil.getDisplayName(this.getTable("DISTRICT").getPartitioncolumn()));
        
        for (int w_id = 1; w_id < NUM_PARTITIONS; w_id++) {
            Object params[] = new Integer[]{ 2, w_id }; // d_id, d_w_id
            PartitionEstimator estimator = new PartitionEstimator(catalog_db, hasher);
            Collection<Integer> partitions = estimator.getAllPartitions(catalog_stmt, params, BASE_PARTITION);
            assertEquals(w_id, (int)CollectionUtil.first(partitions));
        } // FOR
    }
    
    /**
     * testGetPartitionsFragments
     */
    @Ignore
    public void testFragments() throws Exception {
        Table catalog_tbl = catalog_db.getTables().get("DISTRICT");
        assertNotNull(catalog_tbl);
        Procedure catalog_proc = catalog_db.getProcedures().get("neworder");
        assertNotNull(catalog_proc);
        Statement catalog_stmt = catalog_proc.getStatements().get("getDistrict");
        assertNotNull(catalog_stmt);
        
        for (int w_id = 1; w_id < NUM_PARTITIONS; w_id++) {
            Object params[] = new Integer[]{ 2, w_id }; // d_id, d_w_id
            PartitionEstimator estimator = new PartitionEstimator(catalog_db, hasher);
            Collection<Integer> partitions = estimator.getAllPartitions(catalog_stmt, params, BASE_PARTITION);
            assertEquals(w_id, (int)CollectionUtil.first(partitions));
        } // FOR
    }
    
    /**
     * testGetPartitionsInsert
     */
    public void testInsert() throws Exception {
        Table catalog_tbl = catalog_db.getTables().get("ORDERS");
        assertNotNull(catalog_tbl);
        Procedure catalog_proc = catalog_db.getProcedures().get("neworder");
        assertNotNull(catalog_proc);
        Statement catalog_stmt = catalog_proc.getStatements().get("createOrder");
        assertNotNull(catalog_stmt);
        
        PartitionEstimator estimator = new PartitionEstimator(catalog_db, hasher);
        Object params[] = new Object[catalog_stmt.getParameters().size()];
        int w_id = 9;
        //  3001, 1, 9, 376, Mon Aug 10 00:28:54 EDT 2009, 0, 13, 1]
        for (int i = 0; i < params.length; i++) {
            StmtParameter catalog_param = catalog_stmt.getParameters().get(i);
            VoltType type = VoltType.get((byte)catalog_param.getJavatype());
            if (i == 2) {
                params[i] = w_id;
            } else {
                params[i] = VoltTypeUtil.getRandomValue(type);
            }
            //System.out.print((i != 0 ? ", " : "[") + params[i].toString() + (i + 1 == params.length ? "\n" : "")); 
        } // FOR
        
        Collection<Integer> partitions = estimator.getAllPartitions(catalog_stmt, params, BASE_PARTITION);
//        System.out.println(catalog_stmt.getName() + " Partitions: " + partitions);
        assertFalse(partitions.isEmpty());
        assertEquals(1, partitions.size());
        assertEquals(w_id, (int)CollectionUtil.first(partitions));
    }
    
    /**
     * testReplicatedSelect
     */
    @Test
    public void testReplicatedSelect() throws Exception {
        Catalog new_catalog = new Catalog();
        new_catalog.execute(catalog.serialize());
        
        Database new_database = CatalogUtil.getDatabase(new_catalog);
        assertNotNull(new_database);
        final Table new_table = new_database.getTables().get("WAREHOUSE");
        assertNotNull(new_table);
        new_table.setIsreplicated(true);
        new_table.setPartitioncolumn(new Column() {
            @SuppressWarnings("unchecked")
            @Override
            public <T extends CatalogType> T getParent() {
                return ((T)new_table);
            }
        });
        
        PartitionEstimator p_estimator = new PartitionEstimator(new_database, hasher);
        Procedure catalog_proc = new_database.getProcedures().get(neworder.class.getSimpleName());
        Statement catalog_stmt = catalog_proc.getStatements().get("getWarehouseTaxRate");
        assertNotNull(catalog_stmt);
        
        // We should get back exactly one partition id (base_partition)
        Object params[] = new Object[] { new Long(1234) };
        Set<Integer> partitions = p_estimator.getAllPartitions(catalog_stmt, params, BASE_PARTITION);
        assertNotNull(partitions);
        assertEquals(1, partitions.size());
        assertEquals(BASE_PARTITION, CollectionUtil.first(partitions).intValue());
    }
    
    /**
     * testInvalidateCache
     */
    @Test
    public void testInvalidateCache() throws Exception {
        Catalog new_catalog = new Catalog();
        new_catalog.execute(catalog.serialize());
        
        Database new_database = CatalogUtil.getDatabase(new_catalog);
        assertNotNull(new_database);
        final Table new_table = new_database.getTables().get("WAREHOUSE");
        assertNotNull(new_table);
        new_table.setPartitioncolumn(new Column() {
            @SuppressWarnings("unchecked")
            @Override
            public <T extends CatalogType> T getParent() {
                return ((T)new_table);
            }
        });
        
        PartitionEstimator p_estimator = new PartitionEstimator(catalog_db, hasher);
        Procedure catalog_proc = this.getProcedure(neworder.class);
        Statement catalog_stmt = catalog_proc.getStatements().get("getWarehouseTaxRate");
        assertNotNull(catalog_stmt);
        
        // First calculate the partitions for the query using the original catalog
        // We should get back exactly one partition id (base_partition)
        Object params[] = new Object[] { new Long(BASE_PARTITION) };
        Set<Integer> partitions = p_estimator.getAllPartitions(catalog_stmt, params, BASE_PARTITION);
        assertNotNull(partitions);
        assertEquals(1, partitions.size());
        assertEquals(BASE_PARTITION, CollectionUtil.first(partitions).intValue());
        
        // Then reset the catalog in p_estimator and run the estimation again
        // The new catalog has a different partition column for WAREHOUSE, so we should get
        // back all the partitions
        p_estimator.initCatalog(new_database);
        catalog_proc = new_database.getProcedures().get(catalog_proc.getName());
        catalog_stmt = catalog_proc.getStatements().get("getWarehouseTaxRate");
        
        Set<Integer> new_partitions = p_estimator.getAllPartitions(catalog_stmt, params, BASE_PARTITION);
        Collection<Integer> all_partitions = CatalogUtil.getAllPartitionIds(new_database);
        assertNotNull(new_partitions);
        assertEquals(all_partitions.size(), new_partitions.size());
    }
    
    /**
     * testPopulateColumnJoinsAll
     */
    @Ignore
    public void testPopulateColumnJoinsAll() {
        Map<Column, Set<Column>> column_joins = new TreeMap<Column, Set<Column>>();
        Table catalog_tbl = this.getTable("DISTRICT");
        
        Column last = null;
        List<Column> order = new ArrayList<Column>();
        for (Column catalog_col : catalog_tbl.getColumns()) {
            column_joins.put(catalog_col, new TreeSet<Column>());
            if (last != null) {
                column_joins.get(last).add(catalog_col);
                column_joins.get(catalog_col).add(last);
            }
            last = catalog_col;
            order.add(catalog_col);
        } // FOR
        assertNotNull(last);
        
        PartitionEstimator.populateColumnJoins(column_joins);
        for (Column catalog_col : order) {
            assert(column_joins.containsKey(catalog_col));
            assertEquals(order.size() - 1, column_joins.get(catalog_col).size());
        } // FOR
    }
    
    /**
     * testPopulateColumnJoinsSplit
     */
    @SuppressWarnings("unchecked")
    public void testPopulateColumnJoinsSplit() {
        Map<Column, Set<Column>> column_joins = new TreeMap<Column, Set<Column>>();
        Table catalog_tbl = this.getTable("DISTRICT");
        
        Column last[] = { null, null };
        HashSet split[] = {
            new HashSet<Column>(),
            new HashSet<Column>(),
        };
        
        int ctr = 0;
        for (Column catalog_col : catalog_tbl.getColumns()) {
            column_joins.put(catalog_col, new TreeSet<Column>());
            
            int idx = ctr++ % 2;
            if (last[idx] != null) {
                column_joins.get(last[idx]).add(catalog_col);
                column_joins.get(catalog_col).add(last[idx]);
            }
            last[idx] = catalog_col;
            split[idx].add(catalog_col);
        } // FOR
        assertNotNull(last);
//        System.err.println("split[0]: " + split[0]);
//        System.err.println("split[1]: " + split[1] + "\n");
        
        PartitionEstimator.populateColumnJoins(column_joins);
        ctr = 0;
        for (Column catalog_col : catalog_tbl.getColumns()) {
            assert(column_joins.containsKey(catalog_col));
            int idx = ctr++ % 2;
//            System.err.println(catalog_col + ": " + column_joins.get(catalog_col));
            assertEquals(split[idx].size() - 1, column_joins.get(catalog_col).size());
            
            column_joins.get(catalog_col).add(catalog_col);
            assert(column_joins.get(catalog_col).containsAll(split[idx]));
        } // FOR
    }
}