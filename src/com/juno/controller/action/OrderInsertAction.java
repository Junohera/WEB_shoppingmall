package com.juno.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dao.CartDAO;
import com.juno.dto.CartVO;
import com.juno.dto.MemberVO;

public class OrderInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=orderList";
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			// 주문자 아이디로 검색한 카트목록을 먼저 추출
			ArrayList<CartVO> list = CartDAO.getIst().selectCart(member.getId());
			
			// 추출한 list와 주문자의 아이디를 가지고 orderDAO에 가서 오더와 오더디테일에 데이터를 추가
			int Oseq = OrderDAO.getIst().insertOrder(list, member.getId());
			
			// 방금 주문에 성공한 주문번호를 갖고 오더리스트로 이동합니다.
			url = "shop.do?command=orderList&oseq=" + Oseq;
		}
		
		response.sendRedirect(url);
	}

}
