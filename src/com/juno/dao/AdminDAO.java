package com.juno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.juno.dto.AdminVO;
import com.juno.dto.ProductVO;
import com.juno.util.Dbman;
import com.juno.util.Paging;

public class AdminDAO {
    private AdminDAO() {}
    private static AdminDAO ist = new AdminDAO();
    public static AdminDAO getIst() {return ist;}
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
	public AdminVO workerCheck(String id, String pwd) {
		AdminVO a = null;
		String sql = "SELECT * FROM WORKER WHERE ID = ?";
		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				a = new AdminVO();
				a.setId(rs.getString("id"));
				a.setName(rs.getString("name"));
				a.setPhone(rs.getString("phone"));
				a.setPwd(rs.getString("pwd"));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return a;
	}

	public ArrayList<ProductVO> listProduct(Paging paging) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		/** <sql> */
		String sql = "SELECT * FROM "
				+ " (SELECT * FROM "
				+ " (SELECT ROWNUM AS RN, T.* FROM "
				+ " (SELECT * FROM PRODUCT ORDER BY PSEQ DESC) T"
				+ " ) WHERE RN >= ?"
				+ " ) WHERE RN <= ?";
		/** </sql> */

		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ProductVO pvo = new ProductVO();
                pvo.setPseq(rs.getInt("pseq"));
				pvo.setName(rs.getString("name"));
				pvo.setKind(rs.getString("kind"));
				pvo.setPrice1(rs.getInt("price1"));
				pvo.setPrice2(rs.getInt("price2"));
				pvo.setPrice3(rs.getInt("price3"));
				pvo.setContent(rs.getString("content"));
				pvo.setImage(rs.getString("image"));
				pvo.setUseyn(rs.getString("useyn"));
				pvo.setBestyn(rs.getString("bestyn"));
				pvo.setIndate(rs.getTimestamp("indate"));
                list.add(pvo);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}

	public int getAllCount(String tableName) {
		int count = 0;
		String sql = "SELECT COUNT(*) as count from " + tableName;
		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return count;
	}

	public void insertProduct(ProductVO p) {
		String sql = "INSERT INTO PRODUCT(PSEQ, KIND, NAME, PRICE1, PRICE2, PRICE3, CONTENT, IMAGE) VALUES(PRODUCT_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p.getKind());
			pstmt.setString(2, p.getName());
			pstmt.setInt(3, p.getPrice1());
			pstmt.setInt(4, p.getPrice2());
			pstmt.setInt(5, p.getPrice3());
			pstmt.setString(6, p.getContent());
			pstmt.setString(7, p.getImage());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}
}
