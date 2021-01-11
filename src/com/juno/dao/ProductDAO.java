package com.juno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.juno.dto.ProductVO;
import com.juno.util.Dbman;

public class ProductDAO {
    private ProductDAO() {}
    private static ProductDAO ist = new ProductDAO();
    public static ProductDAO getIst() {return ist;}
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
	public ArrayList<ProductVO> getNewList() {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "select * from new_pro_view";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO pvo = new ProductVO();
                pvo.setPseq(rs.getInt("pseq"));
                pvo.setName(rs.getString("name"));
                pvo.setPrice2(rs.getInt("price2"));
                pvo.setImage(rs.getString("image"));
                list.add(pvo);
			}
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}
	public ArrayList<ProductVO> getBestList() {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		String sql = "select * from best_pro_view";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductVO pvo = new ProductVO();
                pvo.setPseq(rs.getInt("pseq"));
                pvo.setName(rs.getString("name"));
                pvo.setPrice2(rs.getInt("price2"));
                pvo.setImage(rs.getString("image"));
                list.add(pvo);
			}
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}
	public ArrayList<ProductVO> listKindProduct(String kind) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		
		String sql = "select * from product where kind = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, kind);
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
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}

		return list;
	}
	public ProductVO getProduct(String pseq) {
		ProductVO pvo = null;
		
		String sql = "select * from product where pseq = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pvo = new ProductVO();
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
			}
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}

		return pvo;
	}

}