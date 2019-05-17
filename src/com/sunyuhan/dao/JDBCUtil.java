package com.sunyuhan.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



	


public class JDBCUtil {
	 static String driverClass = null;
	 static String url = null;
	 static String name = null;
	 static String password = null;
	 
	 static {
		 try {
			 Properties properties = new Properties();
			 
			 //InputStream is = new FileInputStream("jdbc.properties");//对应文件位于工程根目录下
			 //使用类加载器，去读取src底下的资源文件。后面在Servlet
			 InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			 //导入输入流			
			 properties.load(is);
			 
			 //读取属性
			 driverClass = properties.getProperty("driverClass");
			 url = properties.getProperty("url");
			 name = properties.getProperty("name");
			 password = properties.getProperty("password");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	 
	 
	/**
	 * 获取连接对象
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			//2.建立连接    参数一：协议+访问的数据库，参数二：用户名，参数三：密码。
			conn = DriverManager.getConnection(url,name,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void release(Connection conn,Statement st,ResultSet rs) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}
	
	public static void release(Connection conn,Statement st) {
		closeSt(st);
		closeConn(conn);
	}
	
	private static void closeRs(ResultSet rs){
		try {
			if (rs!=null) {
				rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		
	}
	private static void closeSt(Statement st){
		try {
			if (st!=null) {
				st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				st = null;
			}
		
	}
	private static void closeConn(Connection conn ){
		try {
			if (conn!=null) {
				conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				conn = null; 
			}
		
	}

}
