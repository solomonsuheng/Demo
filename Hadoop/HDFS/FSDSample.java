package Chapter_2;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * @author suheng
 * @time 2015年1月17日 下午7:49:54
 */
public class FSDSample {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		FSDataInputStream fsin = fs.open(new Path("writeSample.txt"));
		byte[] buff = new byte[128];
		int length = 0;
		while ((length = fsin.read(buff, 0, 128)) != -1) {
			System.out.println(new String(buff, 0, length));
		}
		fsin.seek(0);
		byte[] buff2 = new byte[128];
		fsin.read(buff2, 0, 128);
		System.out.println("buff2 = " + new String(buff2));
		System.out.println(buff2.length);
	}
}
