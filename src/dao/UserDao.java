package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import bean.PageObject;
import bean.User;

import com.mysql.jdbc.ResultSet;

public class UserDao {
	private static Connection con;
	private static String username; // 用户名
	private static String password; // 密码
	private static String url; // 数据库名

	// 从配置文件中加载数据
	public static void init() {
		InputStream inputStream = UserDao.class.getClassLoader()
				.getResourceAsStream("mysql.properties");
		Properties p = new Properties();
		try {
			p.load(inputStream);
			username = p.getProperty("username");
			password = p.getProperty("password");
			url = p.getProperty("url");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 获取数据库连接
	public void getConn() {
		try {
			init();
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("success");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 关闭数据库连接
	public void closeConn() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void add(User user) {
		String sql = "insert into user(name,age) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
	}

	public void update() {
	}


	/**
	 * 查询数据库，将结果封装为list集
	 * 
	 * @param page
	 * @return
	 */
	public List<Map<String, Object>> queryForList(PageObject page) {
		List<Map<String, Object>> list = new ArrayList<>();
		String sql = "select * from user limit ?,?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, page.getPage());
			ps.setInt(2, page.getPageSize());
			ResultSet rs = (ResultSet) ps.executeQuery();
			while (rs.next()) {
				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				int count = resultSetMetaData.getColumnCount(); // 获取列数
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 0; i < count; i++) {
					//将查询结果的列名作为map的键(key)，列的值作为map的值(value)
					map.put(resultSetMetaData.getColumnName(i + 1), rs
							.getObject(resultSetMetaData.getColumnName(i + 1)));
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
