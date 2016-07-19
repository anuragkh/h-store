num_records=2006226

# Benchmark get latency
query_distribution="1.00|0.00|0.00|0.00"
for query_distribution in "0.50|0.50|0.00|0.00" "0.34|0.33|0.33|0.00" "0.00|0.00|1.00|0.00"; do
  for num_threads in 32 64; do
    bash gen-slog-props.sh $num_records $query_distribution
    dist_str=${query_distribution//\|/\_}
    echo $dist_str
    ant hstore-prepare hstore-benchmark -Dproject="slog" -Dhosts="localhost:0:0" -Dclient.threads_per_host=$num_threads 2>&1 | tee throughput_${dist_str}_${num_threads}.log
  done
done
