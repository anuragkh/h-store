num_records=2006226
hostname=${1:-localhost}

delete=0.00

for search in 0.00 0.10 0.20 0.30 0.40 0.50 0.60 0.70 0.80 0.90 1.00; do
  remaining=`echo "scale=2;1.00-$search" | bc`
  for type in get insert mix; do
    if [ "$type" = "get" ]; then
      get=`printf "%0.2f" $remaining`
      insert=0.00
    elif [ "$type" = "insert" ]; then
      get=0.00
      insert=`printf "%0.2f" $remaining`
    elif [ "$type" = "mix" ]; then
      half=`echo "scale=2;$remaining*0.50" | bc`
      get=`printf "%0.2f" $half`
      insert=`printf "%0.2f" $half`
    fi
    query_distribution="${get}|${search}|${insert}|${delete}"
    for num_threads in 2 4 8 16 32; do
      bash gen-slog-props.sh $num_records $query_distribution
      dist_str=${query_distribution//\|/\_}
      echo $dist_str
      ant hstore-prepare -Dproject="slog" -Dhosts="${hostname}:0:0"
      rsync -arL /home/ec2-user/h-store $hostname:/home/ec2-user
      ant hstore-benchmark -Dproject="slog" -Dclient.threads_per_host=$num_threads 2>&1 | tee throughput_${dist_str}_${num_threads}.log
    done
  done
done
