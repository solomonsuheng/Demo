package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToMYSQL {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");// 加载驱动
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://ip:3306/", "username", "password");// 根据URL和MySQL账户密码获取连接
			System.out.println(con);// 测试con的状态
			Statement st = con.createStatement();//
			// 创建一个Statement对象,用于将SQL语句发送到数据库中(Statement不能防止SQL注入)
			String sql = "select * from user";// 创建一个SQL语句用于查询
			ResultSet rs = st.executeQuery(sql);// 将SQL执行,返回数据集合
			while (rs.next()) {// 判断返回的数据集合中是否有数据
				System.out.println(rs.getString("uname"));// 根据数据集合的一条,获取字段值输出
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 加载MySQL驱动
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
