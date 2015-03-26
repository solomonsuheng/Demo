package SparkDemo;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class RDDOperation {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf().setAppName("RDD").setMaster("local");
		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> lines = sc
				.textFile("/Users/gesuheng/WorkSpace/sparkWorkSpace/hello");
		JavaRDD<Integer> lineLengths = lines.map(s -> s.length());
		int totalLength = lineLengths.reduce((a, b) -> a + b);
		System.out.println(totalLength);
		System.out.println("我已经菜刀你是谁了" + lineLengths);
	}
}
