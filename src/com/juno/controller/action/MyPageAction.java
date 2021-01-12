package com.juno.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dto.MemberVO;
import com.juno.dto.OrderVO;

public class MyPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/mypage.jsp";
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			// 지금 나타내려고하는 목록은 하나의 주문안에 있는 상품 리스트가 아니라
			// 그 상품들을 품고 있는 주문들의 리스트입니다.
			// 주문들의 리스트들중 아직 배송처리 또는 발송처리가 안된 주문들의 리스트
			// 주문한 상품들 -> 주문1건 -> 주문들의 리스트
			// 따라서 화면에 표시될때는 주문에 들어있는 대표상품 이름을 이용해서
			// XXXX포함 2건과 같이 표시할 예정입니다.
			// 다만 주문한 상품들은 orderDetail 에서 표시하고 현재는 표기하지 않을 예정이니
			// 주문을 대표하는 (상품명 : XXXX 포함 2건)주문의 리스트가 만들어질 예정입니다.
			ArrayList<Integer> oseqList = OrderDAO.getIst().selectSeqOrderIng(member.getId());
			
			ArrayList<OrderVO> orderList = new ArrayList<OrderVO>();
			for (int oseq : oseqList) {
				// 현재 oseq와 로그인아이디를 이용해 주문리스트를 검색(대상: order_view)
				// 주문번호 한건의 주문상세내역들 
				ArrayList<OrderVO> orderListIng = OrderDAO.getIst().listOrderById(member.getId(), oseq);
				
				OrderVO ovo = orderListIng.get(0);
				
				ovo.setPname(ovo.getPname() + " 포함 " + orderListIng.size() + " 건");
				
				int totalPrice = 0;
				for (OrderVO ovo1 : orderListIng) {
					totalPrice += ovo1.getPrice2() * ovo1.getQuantity();
				}
				ovo.setPrice2(totalPrice);
				
				orderList.add(ovo);
			}
			
			request.setAttribute("orderList", orderList);
			request.setAttribute("title", "진행 중인 주문 내역");
		}
		
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
