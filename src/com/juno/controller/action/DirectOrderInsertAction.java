package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dto.MemberVO;

public class DirectOrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=orderList";
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			int pseq = Integer.parseInt(request.getParameter("pseq"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int Oseq = OrderDAO.getIst().directInsertOrder(pseq, member.getId(), quantity);
			
			
			url = "shop.do?command=orderList&oseq=" + Oseq;
		}
		
		response.sendRedirect(url);
	}

}
