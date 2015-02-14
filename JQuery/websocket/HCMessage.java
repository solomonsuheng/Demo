package WebSocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WsOutbound;

public class HCMessage extends MessageInbound {
	private int userIdName = 0;

	// 返回用户ID
	public int getUserIdName() {
		return this.userIdName;
	}

	@Override
	protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onTextMessage(CharBuffer buffer) throws IOException {
		// TODO Auto-generated method stub
		// 当有字符信息到达的时候
		String msg = buffer.toString();
		System.out.println(msg);

		// String fakeData =
		// "[{name : 'Hestavollane',data : [ 4.3, 5.1, 4.3, 5.2, 5.4, 4.7, 3.5, 4.1, 5.6, 7.4, 6.9,7.1, 7.9, 7.9, 7.5, 6.7, 7.7, 7.7, 7.4, 7.0, 7.1, 5.8,5.9, 7.4, 8.2, 8.5, 9.4, 8.1, 10.9, 10.4, 10.9, 12.4,12.1, 9.5, 7.5, 7.1, 7.5, 8.1, 6.8, 3.4, 2.1, 1.9, 2.8,2.9, 1.3, 4.4, 4.2, 3.0, 3.0 ]},{name : 'Voll',data : [ 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.1, 0.0, 0.3,0.0, 0.0, 0.4, 0.0, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, 0.0, 0.0, 0.6, 1.2, 1.7, 0.7, 2.9, 4.1, 2.6, 3.7,3.9, 1.7, 2.3, 3.0, 3.3, 4.8, 5.0, 4.8, 5.0, 3.2, 2.0,0.9, 0.4, 0.3, 0.5, 0.4 ]} ]";
		if (Math.random() > 0.8) {
			List<Double> dataList = new ArrayList<Double>();
			for (int i = 0; i < 49; i++) {
				dataList.add(((int) (1000 * Math.random())) / 100.0);
			}
			String c = "QWERTYUIOPLKJHGFDSAZXCVBNM";
			String fakeData3 = "{name:'" + c.charAt((int) (Math.random() * 10))
					+ "',data:" + dataList.toString() + "}";
			WsOutbound out = this.getWsOutbound();
			out.writeTextMessage(CharBuffer.wrap(fakeData3));
			out.flush();
		}
	}

	public static void main(String[] args) {
		List<Double> dataList = new ArrayList<Double>();
		for (int i = 0; i < 49; i++) {
			dataList.add(((int) (1000 * Math.random())) / 100.0);
		}
		String c = "QWERTYUIOPLKJHGFDSAZXCVBNM";
		String fakeData3 = "{name:'" + c.charAt((int) (Math.random() * 10))
				+ "',data:" + dataList.toString();
		System.out.println(fakeData3);
	}

	// 当客户端使用websocket连接服务器
	protected void onOpen(WsOutbound outbound) {
		super.onOpen(outbound);
		// 将服务器给该连接创建的hashCode作为该用户的唯一标识
		this.userIdName = outbound.hashCode();
		// 再将该唯一标识放入到Servlet所维护的列表中
		GetData.getSocketList().add(this);
	}

	// 当客户端断开websocket连接时候
	protected void onClose(int status) {
		// 从Servlet服务的列表中移除该对象实例
		EchoServlet.getSocketList().remove(this);
		super.onClose(status);
	}

}
