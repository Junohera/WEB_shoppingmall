package com.juno.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dao.OrderDAO;
import com.juno.dto.MemberVO;
import com.juno.dto.OrderVO;

public class OrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderList.jsp";
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			int oseq = Integer.parseInt(request.getParameter("oseq"));
			ArrayList<OrderVO> list = OrderDAO.getIst().listOrderById(member.getId(), oseq);
			int totalPrice = 0;
			
			for (OrderVO o: list) {
				totalPrice += o.getPrice2() * o.getQuantity();
			}
			
			request.setAttribute("totalPrice", totalPrice);
			request.setAttribute("orderList", list);
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
