num_records=$1
query_distribution=$2
echo "## ------------------------------------------------------------
## H-Store Benchmark Configuration Parameters
## ------------------------------------------------------------

builder = edu.berkeley.cs.benchmark.conviva.ConvivaProjectBuilder

data_file = /home/ec2-user/conviva
inserts_file = /home/ec2-user/conviva.inserts
query_file = /home/ec2-user/conviva.queries

query_distribution=$query_distribution
num_records=$num_records
" > properties/benchmarks/conviva.properties
