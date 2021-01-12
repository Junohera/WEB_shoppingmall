package com.juno.controller.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.juno.dao.ProductDAO;
import com.juno.dto.CartVO;
import com.juno.dto.OrderVO;
import com.juno.dto.ProductVO;
import com.juno.util.Dbman;

public class OrderDAO {
    private OrderDAO() {}
    private static OrderDAO ist = new OrderDAO();
    public static OrderDAO getIst() {return ist;}

    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

	public int insertOrder(ArrayList<CartVO> list, String id) {
        int Oseq = 0;

        
        try {
            con = Dbman.getConnection();
            
            // 주문번호(시퀀스 자동입력)와 구매자 아이디로 orders테이블에 레코드 추가
            String sql = "INSERT INTO ORDERS(OSEQ, ID) VALUES (ORDERS_SEQ.NEXTVAL, ?)";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();

            // orders테이블에 시퀀스로 입력된 가장 마지막(방금 추가한) 주문번호 조회
            sql = "SELECT MAX(OSEQ) FROM ORDERS";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Oseq = rs.getInt(1);
            }
            pstmt.close();

            // list의 주문들을 orders에서 얻은 마지막 주문 번호와 함께 order_detail에 추가
            for (CartVO cart: list) {
                sql = "INSERT INTO ORDER_DETAIL(ODSEQ, OSEQ, PSEQ, QUANTITY) "
                    + "VALUES (ORDER_DETAIL_SEQ.NEXTVAL, ?, ?, ?)";

                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, Oseq);
                pstmt.setInt(2, cart.getPseq());
                pstmt.setInt(3, cart.getQuantity());
                pstmt.executeUpdate();
                pstmt.close();
                
             // order_detail에 추가된 카트내용은 처리된 내역으로 삭제
             // sql = "DELETE FROM CART WHERE CSEQ = ?";
                sql = "UPDATE CART SET RESULT = '2' WHERE CSEQ = ?";
                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, cart.getCseq());
                pstmt.executeUpdate();
            }
            
            
        } catch (SQLException e) {e.printStackTrace();
        } finally {Dbman.close(con, pstmt, rs);}

		return Oseq;
	}
	
	public ArrayList<OrderVO> listOrderById(String id, int oseq) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		String sql = "SELECT * FROM ORDER_VIEW WHERE ID = ? AND RESULT = '1' AND OSEQ = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, oseq);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
                OrderVO order = new OrderVO();
				order.setOdseq(rs.getInt("odseq"));
                order.setOseq(rs.getInt("oseq"));
                order.setId(rs.getString("id"));
                order.setIndate(rs.getTimestamp("indate"));
                order.setMname(rs.getString("mname"));
                order.setZip_num(rs.getString("zip_num"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setPseq(rs.getInt("pseq"));
                order.setPname(rs.getString("pname"));
                order.setQuantity(rs.getInt("quantity"));
                order.setPrice2(rs.getInt("price2"));
                order.setResult(rs.getString("result"));
				
				list.add(order);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}
	
	public ArrayList<OrderVO> listOrderById2(String id, int oseq) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		
		String sql = "SELECT * FROM ORDER_VIEW WHERE ID = ? AND OSEQ = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, oseq);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				OrderVO order = new OrderVO();
				order.setOdseq(rs.getInt("odseq"));
                order.setOseq(rs.getInt("oseq"));
                order.setId(rs.getString("id"));
                order.setIndate(rs.getTimestamp("indate"));
                order.setMname(rs.getString("mname"));
                order.setZip_num(rs.getString("zip_num"));
                order.setAddress(rs.getString("address"));
                order.setPhone(rs.getString("phone"));
                order.setPseq(rs.getInt("pseq"));
                order.setPname(rs.getString("pname"));
                order.setQuantity(rs.getInt("quantity"));
                order.setPrice2(rs.getInt("price2"));
                order.setResult(rs.getString("result"));
				
				list.add(order);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}
	
	public ArrayList<Integer> selectSeqOrderIng(String id) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		String sql = "SELECT DISTINCT OSEQ FROM ORDER_VIEW WHERE ID = ? AND RESULT = '1' ORDER BY OSEQ DESC";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				list.add(rs.getInt(1));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}
	
	public ArrayList<Integer> oseqListAll(String id) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		String sql = "SELECT DISTINCT OSEQ FROM ORDER_VIEW WHERE ID = ? ORDER BY OSEQ DESC";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {				
				list.add(rs.getInt(1));
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}

	public int directInsertOrder(int pseq, String id, int quantity) {
		int oseq = 0;
		ProductVO product = null;
		
		try {
			
			/** 1. 전달된 pseq를 이용하여 상품을 검색하고, ProductVO에 담습니다.*/
			String sql = "select * from product where pseq = ?";
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product = new ProductVO();
				product.setPseq(rs.getInt("pseq"));
				product.setName(rs.getString("name"));
				product.setKind(rs.getString("kind"));
				product.setPrice1(rs.getInt("price1"));
				product.setPrice2(rs.getInt("price2"));
				product.setPrice3(rs.getInt("price3"));
				product.setContent(rs.getString("content"));
				product.setImage(rs.getString("image"));
				product.setUseyn(rs.getString("useyn"));
				product.setBestyn(rs.getString("bestyn"));
				product.setIndate(rs.getTimestamp("indate"));
			}
			pstmt.close();
			
			/** 2. 전달된 아이디를 이용하여 orders 테이블에 레코드를 추가합니다.*/
			sql = "INSERT INTO ORDERS (OSEQ, ID) VALUES (ORDERS_SEQ.NEXTVAL, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();

			/** 3. orders 에 추가한 주문번호(oseq)와 상품정보들을 이용하여 order_detail에 레코드를 추가*/
			// 3-1. orders테이블에 시퀀스로 입력된 가장 마지막(방금 추가한) 주문번호 조회
            sql = "SELECT MAX(OSEQ) FROM ORDERS";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            int lastOseq = 0;
            if (rs.next()) {
                lastOseq = rs.getInt(1);
            }
            pstmt.close();
            
            // 3-2. order시퀀스와 product시퀀스, 그리고 수량을 orderdetail에 저장
            sql = "INSERT INTO ORDER_DETAIL(ODSEQ, OSEQ, PSEQ, QUANTITY) "
            		+ " VALUES (ORDER_DETAIL_SEQ.NEXTVAL, ?, ?, ?)";

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, lastOseq);
            pstmt.setInt(2, product.getPseq());
            pstmt.setInt(3, quantity);
            pstmt.executeUpdate();
            pstmt.close();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		/** 4. oseq 값 리턴*/
		return oseq;
	}
}
