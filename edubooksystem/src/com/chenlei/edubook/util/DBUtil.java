package com.chenlei.edubook.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private Connection conn = null;
	
	// һ���õ�����Connection�ķ���
	public Connection getCnt() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection(
					"jdbc:mysql://192.168.90.142:3306/lanoudb?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(){
		try{
			if(!conn.isClosed()){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
