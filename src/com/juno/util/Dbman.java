package com.juno.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Dbman {
	public static Connection getConnection() {
		Connection con = null;
		Context initContext;
		try {
			// server.xml파일에서 Context태그로된 내용을 읽어서 저장하기 위한 객체 생성
			initContext = new InitialContext();
			// 객체 초기화
			Context envContext = (Context)initContext.lookup("java:/comp/env");
			// name이 jdbc/myoracle이란 개체 찾아서 리턴된 값을 DataSource가 받음
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			// 생성된 DBCP에서 연결 객체를 하나 전달받습니다.
			con = ds.getConnection();
		} catch (SQLException e) {
		} catch (NamingException e) {e.printStackTrace();}
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (con != null) con.close();
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
