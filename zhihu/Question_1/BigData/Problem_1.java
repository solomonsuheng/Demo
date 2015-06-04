package zhihu;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Problem_1 {
	public static class problem_1_Mapper extends
			Mapper<Object, Text, Text, NullWritable> {
		public void map(Object key, Text values, Context context)
				throws IOException, InterruptedException {
			context.write(new Text(values.toString()), NullWritable.get());
		}
	}

	public static class problem_1_Reducer extends
			Reducer<Text, NullWritable, Text, NullWritable> {
		public void reduce(Text key, NullWritable n, Context context)
				throws IOException, InterruptedException {
			context.write(new Text(key), NullWritable.get());
		}
	}

	public static void main(String[] args) throws IOException,
			ClassNotFoundException, InterruptedException {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf, "Problem_1");
		job.setJarByClass(Problem_1.class);// jar class
		job.setMapperClass(problem_1_Mapper.class);
		job.setReducerClass(problem_1_Reducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
