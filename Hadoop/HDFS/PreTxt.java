package Chapter_4;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class PreTxt {
	private static String text = "hello world goodbye world \n"
			+ "hello hadoop goodbye hadoop";

	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path file = new Path("preTxt.txt");// 创建写入文件路径
		FSDataOutputStream fsout = fs.create(file);
		fsout.write(text.getBytes());
		IOUtils.closeStream(fsout);
	}
}
