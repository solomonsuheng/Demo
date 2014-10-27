package DBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author suheng
 * @time 2014年10月27日 下午3:12:14
 */
public class MySQLDB {
	// 数据域
	Connection con = null;
	Statement st = null;
	String sql = "select * from user";
	ResultSet rs = null;

	public MySQLDB(String ip, String name, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载驱动
			con = DriverManager.getConnection("jdbc:mysql://" + ip + "/mac",
					name, password);// 根据URL和MySQL账户密码获取连接
			st = con.createStatement();//
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 加载MySQL驱动
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean destory() {
		boolean flag = false;
		try {
			this.rs.close();
			this.con.close();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public void testConn() {
		try {
			// 创建一个Statement对象,用于将SQL语句发送到数据库中(Statement不能防止SQL注入)
			this.rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("uname") + ":"
						+ rs.getString("upwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 将SQL执行,返回数据集合
	}
}
