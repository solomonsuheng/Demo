package Demo;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @author suheng
 * @time 2014年10月29日 上午10:50:46
 */
public class WordCount {
	public static class WordCountMapper extends
			Mapper<Object, Text, Text, IntWritable> {
		public void map(Object key, Text values, Context context)
				throws IOException, InterruptedException {
			StringTokenizer st = new StringTokenizer(values.toString());
			while (st.hasMoreTokens()) {
				context.write(new Text(st.nextToken()), new IntWritable(1));
			}
		}
	}

	public static class WordCountReducer extends
			Reducer<Text, IntWritable, Text, IntWritable> {
		public void reduce(Text key, Iterable<IntWritable> values,
				Context context) throws IOException, InterruptedException {
			int sum = 0;
			for (IntWritable val : values) {
				sum += val.get();
			}

			context.write(new Text(key), new IntWritable(sum));
		}
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "WordCount Demo");
		job.setJarByClass(WordCount.class);// jar class
		job.setMapperClass(WordCountMapper.class);
		job.setCombinerClass(WordCountReducer.class);// Combiner可以对Reducer进行复用
		job.setReducerClass(WordCountReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
