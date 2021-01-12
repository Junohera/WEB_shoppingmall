package com.juno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.juno.dto.QnaVO;
import com.juno.util.Dbman;

public class QnaDAO {
    private QnaDAO() {}
    private static QnaDAO ist = new QnaDAO();
    public static QnaDAO getIst() {return ist;}
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
    public void insertQna(QnaVO qna) {
		String sql = "INSERT INTO QNA(QSEQ, SUBJECT, CONTENT, ID) VALUES (QNA_SEQ.NEXTVAL, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qna.getSubject());
			pstmt.setString(2, qna.getContent());
			pstmt.setString(3, qna.getId());
			pstmt.executeUpdate();
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

	public void updateQna(QnaVO qna) {
		String sql = "UPDATE QNA SET SUBJECT = ?, CONTENT = ? WHERE QSEQ = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qna.getSubject());
			pstmt.setString(2, qna.getContent());
			pstmt.setInt(3, qna.getQseq());
			pstmt.executeUpdate();
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

    public ArrayList<QnaVO> listQna(String id) {
		ArrayList<QnaVO> list = new ArrayList<QnaVO>();
		String sql = "SELECT * FROM QNA WHERE ID = ? ORDER BY QSEQ DESC";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
                QnaVO qna = new QnaVO();
				qna.setQseq(rs.getInt("qseq"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setReply(rs.getString("reply"));
				qna.setId(rs.getString("id"));
				qna.setRep(rs.getString("rep"));
				qna.setIndate(rs.getTimestamp("indate"));
				list.add(qna);
			}
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}
    
    public QnaVO getQna(int qseq) {
		QnaVO qna = null;
		String sql = "SELECT * FROM QNA WHERE QSEQ = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qseq);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
                qna = new QnaVO();
				qna.setQseq(rs.getInt("qseq"));
				qna.setSubject(rs.getString("subject"));
				qna.setContent(rs.getString("content"));
				qna.setReply(rs.getString("reply"));
				qna.setId(rs.getString("id"));
				qna.setRep(rs.getString("rep"));
				qna.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return qna;
	}
}
