package com.juno.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dao.CartDAO;
import com.juno.dto.CartVO;
import com.juno.dto.MemberVO;

public class CartListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/cartList.jsp";

		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");

		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			ArrayList<CartVO> cartList = CartDAO.getIst().selectCart(member.getId());
			
			int totalPrice = 0;
			for (CartVO c : cartList) {
				totalPrice += c.getPrice2() * c.getQuantity();
			}

			request.setAttribute("cartList", cartList);
			request.setAttribute("totalPrice", totalPrice);
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
