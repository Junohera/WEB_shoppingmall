package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dao.MemberDAO;
import com.juno.dto.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/loginFail.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberVO member = MemberDAO.getIst().getMember(id);
		
		HttpSession session = request.getSession();
		System.out.println("logionAction");
		if (member != null) {
			if (member.getPwd() != null) {
				if (member.getPwd().equals(pwd)) {
					session.setAttribute("loginUser", member);
					url = "shop.do?command=index";
				}
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
