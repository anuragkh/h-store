num_records=2006226

# Benchmark get latency
query_distribution="1.00|0.00|0.00|0.00"
bash gen-slog-props.sh $num_records $query_distribution
ant hstore-prepare hstore-benchmark -Dproject="slog" -Dhosts="localhost:0:0" -Dclient.blocking_concurrent=1 2>&1 | tee get.log

# Benchmark search latency
query_distribution="0.00|1.00|0.00|0.00"
bash gen-slog-props.sh $num_records $query_distribution
ant hstore-prepare hstore-benchmark -Dproject="slog" -Dhosts="localhost:0:0" -Dclient.blocking_concurrent=1 2>&1 | tee search.log

# Benchmark insert latency
query_distribution="0.00|0.00|1.00|0.00"
bash gen-slog-props.sh $num_records $query_distribution
ant hstore-prepare hstore-benchmark -Dproject="slog" -Dhosts="localhost:0:0" -Dclient.blocking_concurrent=1 2>&1 | tee insert.log
