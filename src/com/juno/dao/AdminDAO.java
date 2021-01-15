package com.juno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.juno.dto.AdminVO;
import com.juno.dto.MemberVO;
import com.juno.dto.OrderVO;
import com.juno.dto.ProductVO;
import com.juno.dto.QnaVO;
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

	public ArrayList<ProductVO> listProduct(Paging paging, String key) {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		/** <sql> */
		String sql = "SELECT * FROM "
				+ " (SELECT * FROM "
				+ " (SELECT ROWNUM AS RN, T.* FROM "
				+ " (SELECT * FROM PRODUCT WHERE NAME LIKE '%'||?||'%' ORDER BY PSEQ DESC) T"
				+ " ) WHERE RN >= ?"
				+ " ) WHERE RN <= ?";
		/** </sql> */

		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
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

	public int getAllCount(String tableName, String fieldName, String key) {
		int count = 0;
		String sql = "SELECT COUNT(*) as count from " + tableName
				+ " WHERE " + fieldName + " LIKE '%'||?||'%'";
		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
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

	public void updateProduct(ProductVO product) {
		String sql = "UPDATE PRODUCT SET KIND = ?, USEYN = ?, NAME = ?, PRICE1 = ?, PRICE2 = ?, PRICE3 = ?, CONTENT = ?, IMAGE = ?, BESTYN = ? WHERE PSEQ = ?";
		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getKind());
			pstmt.setString(2, product.getUseyn());
			pstmt.setString(3, product.getName());
			pstmt.setInt(4, product.getPrice1());
			pstmt.setInt(5, product.getPrice2());
			pstmt.setInt(6, product.getPrice3());
			pstmt.setString(7, product.getContent());
			pstmt.setString(8, product.getImage());
			pstmt.setString(9, product.getBestyn());
			pstmt.setInt(10, product.getPseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

	public ArrayList<MemberVO> listMember(Paging paging, String fieldName, String key) {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		String sql = ""
			+ "SELECT * FROM ("
			+ "SELECT * FROM ("
			+ "SELECT ROWNUM AS RN, M.* FROM ((select * from member where " + fieldName + " like '%'||?||'%' order by indate desc) m)"
			+ ") WHERE RN >= ?"
			+ ") WHERE RN <= ?";
		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getString("id"));
				m.setPwd(rs.getString("pwd"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				m.setZip_num(rs.getString("zip_num"));
				m.setAddress(rs.getString("address"));
				m.setPhone(rs.getString("phone"));
				m.setUseyn(rs.getString("useyn"));
				m.setIndate(rs.getTimestamp("indate"));
				list.add(m);
			}
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}
	
	public void updateOrderResult(int odseq) {
		String sql = "UPDATE ORDER_DETAIL SET RESULT = '2' WHERE ODSEQ = ?";
		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, odseq);
			pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

	public ArrayList<OrderVO> listOrder(Paging paging, String key) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		
		String sql = "SELECT * FROM ("
			+ "SELECT * FROM ("
			+ "SELECT ROWNUM AS RN, O.* FROM"
		 	+ "((SELECT * FROM ORDER_VIEW WHERE MNAME LIKE '%'||?||'%' ORDER BY RESULT, oseq DESC) O)"
			+ ") WHERE RN >= ?"
			+ ") WHERE RN <= ?";

		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				OrderVO o = new OrderVO();
				o.setOdseq(rs.getInt("odseq"));
				o.setOseq(rs.getInt("oseq"));
				o.setId(rs.getString("id"));
				o.setIndate(rs.getTimestamp("indate"));
				o.setMname(rs.getString("mname"));
				o.setZip_num(rs.getString("zip_num"));
				o.setAddress(rs.getString("address"));
				o.setPhone(rs.getString("phone"));
				o.setPseq(rs.getInt("pseq"));
				o.setQuantity(rs.getInt("quantity"));
				o.setPname(rs.getString("pname"));
				o.setPrice2(rs.getInt("price2"));
				o.setResult(rs.getString("result"));

				list.add(o);
			}
			
		} catch (Exception e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}

	public ArrayList<QnaVO> listQna(Paging paging, String key) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		
		String sql = "SELECT * FROM ("
			+ "SELECT * FROM ("
			+ "SELECT ROWNUM AS RN, O.* FROM"
		 	+ "((SELECT * FROM QNA WHERE SUBJECT LIKE '%'||?||'%' ORDER BY QSEQ DESC) O)"
			+ ") WHERE RN >= ?"
			+ ") WHERE RN <= ?";

		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, key);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				QnaVO q = new QnaVO();
				q.setQseq(rs.getInt("qseq"));
				q.setSubject(rs.getString("subject"));
				q.setContent(rs.getString("content"));
				q.setId(rs.getString("id"));
				q.setIndate(rs.getTimestamp("indate"));
				q.setReply(rs.getString("reply"));
				q.setRep(rs.getString("rep"));
				list.add(q);
			}
			
		} catch (Exception e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}

	public QnaVO getQna(int qseq) {
		QnaVO q = null;
		String sql = "SELECT * FROM QNA WHERE QSEQ = ?";

		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				q = new QnaVO();
				q.setQseq(rs.getInt("qseq"));
				q.setSubject(rs.getString("subject"));
				q.setContent(rs.getString("content"));
				q.setReply(rs.getString("reply"));
				q.setId(rs.getString("id"));
				q.setRep(rs.getString("rep"));
				q.setIndate(rs.getTimestamp("indate"));
			}
			
		} catch (Exception e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return q;
	}

	public void qnaAttachAnswer(QnaVO q) {
		String sql = "UPDATE QNA SET REPLY = ?, REP = '2' WHERE QSEQ = ?";
		try {
			con = Dbman.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, q.getReply());
			pstmt.setInt(2, q.getQseq());
			pstmt.executeUpdate();
		} catch (Exception e) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

}
