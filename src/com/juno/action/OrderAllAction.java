package com.juno.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dto.MemberVO;
import com.juno.dto.OrderVO;

public class OrderAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/mypage.jsp";
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			ArrayList<OrderVO> list = OrderDAO.getIst();
			
			request.setAttribute("title", "총 주문내역");
			request.setAttribute("orderList", list);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
