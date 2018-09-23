package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.user;

public class userDAO {
	private static Connection connection;
	private PreparedStatement ps;
	public static Connection getConnection() {
		try {

			// 1 driver
			Class.forName("com.mysql.jdbc.Driver");
			// 2 connection
			String url = "jdbc:mysql://localhost:3306/jdbcdemo";
			connection = (Connection) DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public List<user> getAllUser() throws SQLException {
		String sql = "SELECT * FROM users";
		List<user> list = new ArrayList<>();
		ps = (PreparedStatement) getConnection().prepareStatement(sql);
		ResultSet resultSet = ps.executeQuery();
		while(resultSet.next()) {
			user user = new user();
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			list.add(user);
		}
		return list;
	}
	
	public void add(user user) throws SQLException {
		String sql = "INSERT INTO users(username, password) " + "VALUES(?, ?)"; 
		PreparedStatement preparedStatement = (PreparedStatement) getConnection().prepareStatement(sql);
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.executeUpdate();
	}
	
}
