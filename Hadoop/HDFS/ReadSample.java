package Chapter_1;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * @author suheng
 * @time 2015年1月17日 下午7:07:31
 */
public class ReadSample {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		Path path = new Path("writeSample.txt");
		FSDataInputStream fsin = fs.open(path);
		byte[] buff = new byte[128];
		int length = 0;
		while ((length = fsin.read(buff, 0, 128)) != -1) {
			System.out.println(new String(buff, 0, length));
		}
	}
}
