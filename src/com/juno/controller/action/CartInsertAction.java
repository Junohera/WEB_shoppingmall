package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dao.CartDAO;
import com.juno.dto.CartVO;
import com.juno.dto.MemberVO;

public class CartInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 장바구니에 상품을 추가한 후 바로 장바구니 리스트로 이동하여 목록을 확인하게합니다.
		String url = "shop.do?command=cartList";

		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");

		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			CartVO cart = new CartVO();
			cart.setId(member.getId());
			cart.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			cart.setPseq(Integer.parseInt(request.getParameter("pseq")));

			CartDAO.getIst().insertCart(cart);
		}

		// insert이므로 forward가 아닌 sendRedirect
		response.sendRedirect(url);
	}

}
