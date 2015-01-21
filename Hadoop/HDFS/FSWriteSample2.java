package Chapter_2;

import java.io.IOException;
import java.util.Random;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

/**
 * @author suheng
 * @time 2015年1月17日 下午8:04:05
 */
public class FSWriteSample2 {
	static int index = 0;

	public static void main(String[] args) throws IOException {
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		for (int i = 0; i < 99999; i++) {
			sb.append((char) rand.nextInt(100));
		}
		byte[] buff = sb.toString().getBytes();

		Path path = new Path("writeSample2.txt");
		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(conf);
		FSDataOutputStream fsout = fs.create(path, new Progressable() {

			@Override
			public void progress() {
				// TODO Auto-generated method stub
				System.out.println(++index);
			}
		});

		fsout.write(buff);
		IOUtils.closeStream(fsout);
	}
}
