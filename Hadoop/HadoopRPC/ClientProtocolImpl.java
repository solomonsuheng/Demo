import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.ProtocolSignature;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.RPC.Server;

/**
 * @author suheng
 * @time 2015年1月20日 下午4:18:02
 */
public class ClientProtocolImpl implements ClientProtocol {

	// 重载的方法，用于获取协议的签名
	@Override
	public ProtocolSignature getProtocolSignature(String protocol,
			long clientVersion, int hashCode) throws IOException {
		// TODO Auto-generated method stub
		return new ProtocolSignature(ClientProtocol.versionID, null);
	}

	// 重载的方法，用于获取自定义的协议版本号
	@Override
	public long getProtocolVersion(String protocol, long clientVersion)
			throws IOException {
		// TODO Auto-generated method stub
		return ClientProtocol.versionID;
	}

	@Override
	public String echo(String value) throws IOException {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public int add(int v1, int v2) throws IOException {
		// TODO Auto-generated method stub
		return v1 + v2;
	}

	public static void main(String[] args)
			throws HadoopIllegalArgumentException, IOException {
		// 直接使用静态类Builder构造一个RPC Server，并调用函数start()启动该Server
		Configuration conf = new Configuration();
		Server server = new RPC.Builder(conf).setProtocol(ClientProtocol.class)
				.setInstance(new ClientProtocolImpl())
				.setBindAddress("127.0.0.1").setPort(8888).setNumHandlers(5)
				.build();
		server.start();
	}
}
