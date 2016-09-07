function greaterthan() {
  num1=$1
  num2=$2
  echo $num1'>'$num2 | bc -l
}
dataset=$1
path=vary_$dataset
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
    max=0.00
    for num_threads in 2 4 8 16 32; do
      thput=`grep "Throughput" $path/throughput_${get}_${search}_${insert}_${delete}_${num_threads}.log | awk '{ print $3 }'`
      errors=`grep "Error when trying load data for" $path/throughput_${get}_${search}_${insert}_${delete}_${num_threads}.log`
      #if [ "$thput" = "" ] || [ "$errors" != "" ]; then
      #  thput="\e[31mredo\e[0m"
      #fi
      while [ "$thput" = "" ] || [ "$errors" != "" ]; do
        bash redo.sh ip-172-31-25-116 $dataset $get $search $insert $delete $num_threads
        mv throughput_${get}_${search}_${insert}_${delete}_${num_threads}.log $path/
        thput=`grep "Throughput" $path/throughput_${get}_${search}_${insert}_${delete}_${num_threads}.log | awk '{ print $3 }'`
        errors=`grep "Error when trying load data for" $path/throughput_${get}_${search}_${insert}_${delete}_${num_threads}.log`
      done
      echo -e "$search $get $insert $num_threads $thput"
      gt=`greaterthan $thput $max`
      if [ "$gt" = "1" ]; then
        max=$thput
      fi
    done
    echo "${search} ${get} ${insert} ${max}" >> ${path}_${type}.agg
  done
done
