package Demo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by gesuheng on 15/4/6.
 */
public class JavaWordCount {
    private static Pattern SPACE = Pattern.compile(" ");

    public static void main(String[] args) {
        //Check the path of the input file
        if (args.length < 1) {
            System.err.println("Usage: JavaFile");
            System.exit(1);
        }

        //Setting environment
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("Simple Spark Demo");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);


        //Getting data from external file
        JavaRDD<String> distFile = javaSparkContext.textFile(args[0]);
        JavaRDD<String> line = distFile.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterable<String> call(String s) throws Exception {
                return Arrays.asList(SPACE.split(s));
            }
        });

        JavaPairRDD<String, Integer> ones = line.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        });

        JavaPairRDD<String, Integer> stringIntegerJavaPairRDD = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });

        List<Tuple2<String, Integer>> output = stringIntegerJavaPairRDD.collect();

        for (Tuple2<String, Integer> stringIntegerTuple2 : output) {
            System.out.println(stringIntegerTuple2._1() + " : " + stringIntegerTuple2._2());
        }
        javaSparkContext.stop();
    }
}
