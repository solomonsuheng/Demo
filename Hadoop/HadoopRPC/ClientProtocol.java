import java.io.IOException;

import org.apache.hadoop.ipc.VersionedProtocol;

/**
 * @author suheng
 * @time 2015年1月20日 下午4:16:08
 */
public interface ClientProtocol extends VersionedProtocol {
	// 版本号，默认情况下，不同版本号的RPC Client和Server之间不能相互通信
	public static final long versionID = 1L;

	String echo(String value) throws IOException;

	int add(int v1, int v2) throws IOException;
}
