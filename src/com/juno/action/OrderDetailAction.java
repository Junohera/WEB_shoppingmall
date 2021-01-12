package com.juno.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dto.MemberVO;
import com.juno.dto.OrderVO;

public class OrderDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/orderDetail.jsp";
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			int oseq = Integer.parseInt(request.getParameter("oseq"));
			
			OrderDAO odao = OrderDAO.getIst();
			
			ArrayList<OrderVO> orderList = odao.listOrderById2(member.getId(), oseq);
			
			int totalPrice = 0;
			for (OrderVO ovo : orderList) {
				totalPrice += ovo.getPrice2() * ovo.getQuantity();
			}
			
			request.setAttribute("orderDetail", orderList.get(0));
			request.setAttribute("orderList", orderList);
			request.setAttribute("totalPrice", totalPrice);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
