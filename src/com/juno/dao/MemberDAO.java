package com.juno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.juno.controller.action.AddressVO;
import com.juno.dto.MemberVO;
import com.juno.util.Dbman;

public class MemberDAO {
    private MemberDAO() {}
    private static MemberDAO ist = new MemberDAO();
    public static MemberDAO getIst() {return ist;}
    
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    
	public MemberVO getMember(String id) {
		MemberVO member = null;
		
		String sql = "select * from member where id = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
                member = new MemberVO();
                member.setId(rs.getString("id"));
                member.setPwd(rs.getString("pwd"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setZip_num(rs.getString("zip_num"));
                member.setAddress(rs.getString("address"));
                member.setPhone(rs.getString("phone"));
                member.setUseyn(rs.getString("useyn"));
                member.setIndate(rs.getTimestamp("indate"));
			}
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return member;
	}

	public int confirmId(String id) {
		int result = 0;
		
		String sql = "select * from member where id = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
                result = 1;
			}
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return result;
	}

	public ArrayList<AddressVO> selectAddressByDong(String dong) {
		ArrayList<AddressVO> list = new ArrayList<AddressVO>();
		
		String sql = "select * from address where dong like '%'||?||'%'";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				AddressVO address = new AddressVO();
				address.setZip_num(rs.getString("zip_num"));
				address.setSido(rs.getString("sido"));
				address.setGugun(rs.getString("gugun"));
				address.setDong(rs.getString("dong"));
				address.setZip_code(rs.getString("zip_code"));
				address.setBunji(rs.getString("bunji"));
				list.add(address);
			}
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
		
		return list;
	}

	public void insertMember(MemberVO member) {
		String sql = "INSERT INTO MEMBER (ID, PWD, NAME, ZIP_NUM, ADDRESS, EMAIL, PHONE) VALUES (?, ?, ?, ?, ?, ?, ?)";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getZip_num());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getPhone());
			pstmt.executeUpdate();
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

	public void updateMember(MemberVO member) {
		String sql = "UPDATE MEMBER SET PWD = ?, NAME = ?, ZIP_NUM = ?, ADDRESS = ?, EMAIL = ?, PHONE = ? WHERE ID = ?";
		con = Dbman.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPwd());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getZip_num());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getId());
			pstmt.executeUpdate();
		} catch (SQLException e ) {e.printStackTrace();
		} finally {Dbman.close(con, pstmt, rs);}
	}

    
}
