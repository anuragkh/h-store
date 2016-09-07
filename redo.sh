hostname=${1:-localhost}
dataset=${2:-tpch}
get=${3}
search=${4}
insert=${5}
delete=${6}
num_threads=${7}

if [ "$dataset" = "conviva" ]; then
  project="conviva"
  num_records=159412
elif [ "$dataset" = "tpch" ]; then
  project="slog"
  num_records=2006226
fi

query_distribution="${get}|${search}|${insert}|${delete}"
bash gen-${project}-props.sh $num_records $query_distribution
dist_str=${query_distribution//\|/\_}
echo $dist_str
ant hstore-prepare -Dproject="$project" -Dhosts="${hostname}:0:0"
rsync -arL /home/ec2-user/h-store $hostname:/home/ec2-user
ant hstore-benchmark -Dproject="$project" -Dclient.threads_per_host=$num_threads 2>&1 | tee throughput_${dist_str}_${num_threads}.log
