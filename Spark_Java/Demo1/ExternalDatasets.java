package SparkDemo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class ExternalDatasets {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("ED").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> distFile = sc
				.textFile("/Users/gesuheng/WorkSpace/sparkWorkSpace/hello");
		System.out.println(distFile.map(s -> s.length())
				.reduce((a, b) -> a + b));
	}
}
