import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

/**
 * @author suheng
 * @time 2015年1月20日 下午4:31:37
 */
public class Demo {
	public static void main(String[] args) throws IOException {
		Configuration conf = new Configuration();
		InetSocketAddress addr = new InetSocketAddress("127.0.0.1", 8888);
		ClientProtocol proxy = (ClientProtocol) RPC.getProxy(
				ClientProtocol.class, 1L, addr, conf);
		int result = proxy.add(5, 6);
		String echoResult = proxy.echo("result");
		System.out.println(result + " " + echoResult);
	}
}
