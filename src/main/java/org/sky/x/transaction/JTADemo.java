package org.sky.x.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.XAConnection;
import javax.sql.XADataSource;

import org.sky.x.bean.BaseBean;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

/**
 * 
 * @author eclipskym
 *
 */
public class JTADemo {
	
	public static XADataSource getXADataSource(){
		MysqlXADataSource dataSource = new MysqlXADataSource();
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/x_user_read");
		dataSource.setUser("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	public static XAConnection getXAConnection(XADataSource dataSource){
		XAConnection conn = null;
		try {
			conn = dataSource.getXAConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void getPrepareStatement(BaseBean baseBean) throws Exception{
		Class.forName("com.mysql.java.Driver");
		Connection conn = DriverManager.getConnection("");
		PreparedStatement pstm = conn.prepareStatement("select * from t_user where user_id = ? and use_name = ? and register_time = ?");
//		pstm.set
		
	}
	
	public static void main(String[] args){
//		XADataSource xaDS = 
	}
}
