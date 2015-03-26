package SparkDemo;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class ParallelizedCollection {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("PC").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		JavaRDD<Integer> distData = sc.parallelize(list);
		System.out.println(distData.reduce((a, b) -> a + b));
	}
}
