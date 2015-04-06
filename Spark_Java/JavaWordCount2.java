package Demo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;



public class JavaWordCount2 {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("Usage: Javafile");
            System.exit(1);
        }

        //Setting environment
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("Simple");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        //Get data to RDD
        JavaRDD<String> distFile = javaSparkContext.textFile(args[0]);

        JavaRDD<String> line = distFile.flatMap(s -> Arrays.asList(s.split(" ")));

        JavaPairRDD<String, Integer> one = line.mapToPair(s -> (new Tuple2<String, Integer>(s, 1)));

        JavaPairRDD<String, Integer> count = one.reduceByKey((num1, num2) -> num1 + num2);

        List<Tuple2<String, Integer>> output = count.collect();

        System.out.println("Hi This is a fuck day, tell me the reason");
        for (Tuple2<String, Integer> stringIntegerTuple2 : output) {
            System.out.println(stringIntegerTuple2._1()+" : "+stringIntegerTuple2._2());
        }

        javaSparkContext.stop();


    }
}
