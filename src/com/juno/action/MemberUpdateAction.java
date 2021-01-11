package com.juno.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dao.MemberDAO;
import com.juno.dto.MemberVO;

public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=index";
		MemberVO member = new MemberVO();
		member.setId(request.getParameter("id"));
		member.setPwd(request.getParameter("pwd"));
		member.setName(request.getParameter("name"));
		member.setEmail(request.getParameter("email"));
		member.setZip_num(request.getParameter("zip_num"));
		member.setAddress(request.getParameter("addr1") + request.getParameter("addr2"));
		member.setPhone(request.getParameter("phone"));
		
		MemberDAO.getIst().updateMember(member);
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", member);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
