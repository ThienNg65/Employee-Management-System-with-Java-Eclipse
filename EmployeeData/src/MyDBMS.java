import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.*;

public class MyDBMS {

	public static Connection ConnectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			 
			Connection conn = DriverManager.getConnection(  
					 "jdbc:mysql://localhost:3306/employee_management","root","123456");  
			 
			JOptionPane.showMessageDialog(null,"Connection Succeed!");
			return conn;
			
		} catch (Exception ex) { 
			JOptionPane.showMessageDialog(null,"Connection Error!");
			return null;
		} 
		
	}
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			 
			Connection conn = DriverManager.getConnection(  
					 "jdbc:mysql://localhost:3306/employee_management","root","123456");  
			 
			System.out.println("Connection Succeed!");
			
			Statement stmt = conn.createStatement();
			//executeQuery
			String sql = "SELECT * FROM admin";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("Truy van thanh cong");
			while (rs.next()) {
				System.out.println("username: " + rs.getString("username"));
				System.out.println("password: " + rs.getString("password"));
			}
			
		} catch (Exception ex) { 
			System.out.println("Connection Error!\n" + ex.getMessage());

		} 
		
		
		//ConnectDB();
	}
*/
}
