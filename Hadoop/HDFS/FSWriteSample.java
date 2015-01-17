package Chapter_1;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

/**
 * @author suheng
 * @time Jan 17, 2015 6:05:03 PM
 */
public class FSWriteSample {
	public static void main(String[] args) throws IOException {
		Path path = new Path("writeSample.txt");// create new path
		Configuration conf = new Configuration();// setting configuration
		FileSystem fs = FileSystem.get(conf);
		FSDataOutputStream fsout = fs.create(path);
		byte[] buff = "Hello World".getBytes();
		fsout.write(buff);
		IOUtils.closeStream(fsout);
	}
}