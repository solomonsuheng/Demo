package KK;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Suheng on 15/4/11.
 */
public class WordCount {
    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("Simple");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);

        JavaRDD<String> distFile = javaSparkContext.textFile("/Users/gesuheng/WorkSpace/sparkWorkSpace/data1");

        JavaPairRDD<String,Integer> wordPair = distFile.flatMap(line -> Arrays.asList(line.split(" "))).mapToPair(line -> new Tuple2(line, 1));

        List<Tuple2<String, Integer>> out = wordPair.reduceByKey((a, b) -> (a + b)).collect();
        for (Tuple2<String, Integer> ss : out) {
            System.out.print("#"+ss._1()+" : "+ss._2());
        }
    }


    public static void printRDD(List<String> out) {
        for (String s : out) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
