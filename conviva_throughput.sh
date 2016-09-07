num_records=159412
hostname=${1:-localhost}
curdir=`pwd`

for query_distribution in "0.00|0.00|1.00|0.00"; do
  for num_threads in 8; do
    bash gen-conviva-props.sh $num_records $query_distribution
    dist_str=${query_distribution//\|/\_}
    echo $dist_str
    ant hstore-prepare -Dproject="conviva" -Dhosts="${hostname}:0:0"
    rsync -arL /home/ec2-user/h-store $hostname:/home/ec2-user
    ant hstore-benchmark -Dproject="conviva" -Dclient.threads_per_host=$num_threads 2>&1 | tee throughput_${dist_str}_${num_threads}.log
  done
done
