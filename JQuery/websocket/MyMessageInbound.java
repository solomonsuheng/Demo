package WebSocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

public class MyMessageInbound extends MessageInbound {
	// 给每一个用户分配一个id
	// 每一个MyMessageInbound创建的实例都相当于一个连接到服务器的实例
	private int userIdName = 0;

	// 返回用户ID
	public int getUserIdName() {
		return this.userIdName;
	}

	@Override
	protected void onBinaryMessage(ByteBuffer buffer) throws IOException {
		// 处理二进制消息到达，如音频文件或者视频文件
	}

	@Override
	protected void onTextMessage(CharBuffer buffer) throws IOException {
		// 当有字符信息到达的时候
		String msg = buffer.toString();
		System.out.println(msg);

		// 用于给用户返回信息
		for (MyMessageInbound mmi : EchoServlet.getSocketList()) {
			WsOutbound out = mmi.getWsOutbound();
			out.writeTextMessage(CharBuffer.wrap(msg));
			out.flush();
		}

	}

	// 当客户端使用websocket连接服务器
	protected void onOpen(WsOutbound outbound) {
		super.onOpen(outbound);
		// 将服务器给该连接创建的hashCode作为该用户的唯一标识
		this.userIdName = outbound.hashCode();
		// 再将该唯一标识放入到Servlet所维护的列表中
		EchoServlet.getSocketList().add(this);
	}

	// 当客户端断开websocket连接时候
	protected void onClose(int status) {
		// 从Servlet服务的列表中移除该对象实例
		EchoServlet.getSocketList().remove(this);
		super.onClose(status);
	}
}
