num_records=$1
query_distribution=$2
echo "## ------------------------------------------------------------
## H-Store Benchmark Configuration Parameters
## ------------------------------------------------------------

builder = edu.berkeley.cs.benchmark.slog.SLOGProjectBuilder

data_file = /home/ec2-user/tpch
inserts_file = /home/ec2-user/tpch.inserts
query_file = /home/ec2-user/tpch.queries

query_distribution=$query_distribution
num_records=$num_records
" > properties/benchmarks/slog.properties
