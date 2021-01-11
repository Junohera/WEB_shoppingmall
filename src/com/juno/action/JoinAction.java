package com.juno.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dao.MemberDAO;
import com.juno.dto.MemberVO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String zip_num = request.getParameter("zip_num");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone = request.getParameter("phone");

		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setEmail(email);
		member.setZip_num(zip_num);
		member.setAddress(addr1 + " " + addr2);
		member.setPhone(phone);

		MemberDAO.getIst().insertMember(member);

		HttpSession session = request.getSession();
		session.setAttribute("loginUser", member);
		response.sendRedirect("shop.do?command=loginForm");
	}

}
