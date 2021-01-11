package com.juno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.juno.dto.CartVO;
import com.juno.util.Dbman;

public class CartDAO {
    private CartDAO() {}
    private static CartDAO ist = new CartDAO();
    public static CartDAO getIst() {return ist;}
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

	public void insertCart(CartVO cart) {
		String sql = "INSERT INTO CART(CSEQ, ID, PSEQ, QUANTITY) "
				+ "VALUES(CART_SEQ.NEXTVAL, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cart.getId()) ;
			pstmt.setInt(2, cart.getPseq()) ;
			pstmt.setInt(3, cart.getQuantity()) ;
			pstmt.executeUpdate();
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

	public void updateCart(CartVO cart) {
		String sql = "UPDATE cart SET PWD = ?, WHERE ID = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(7, cart.getId());
			pstmt.executeUpdate();
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}



	public ArrayList<CartVO> selectCart(String id) {
		ArrayList<CartVO> list = new ArrayList<CartVO>();
		String sql = "SELECT * FROM CART_VIEW WHERE ID = ? AND RESULT = '1' ORDER BY CSEQ DESC";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
                CartVO cart = new CartVO();
				cart.setCseq(rs.getInt(1));
				cart.setId(rs.getString(2));
				cart.setPseq(rs.getInt(3));
				cart.setQuantity(rs.getInt(4));
				// cart.setResult(rs.getInt(5));
				cart.setIndate(rs.getTimestamp(6));
				cart.setPname(rs.getString(7));
				cart.setPrice2(rs.getInt(8));
				cart.setMname(rs.getString(9));
				
				list.add(cart);
			}
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}

	public void deleteCart(int cseq) {
		String sql = "DELETE FROM CART WHERE CSEQ = ?";
		
		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cseq);
			pstmt.executeUpdate();
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}
}
