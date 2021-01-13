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

public class OrderAllAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "mypage/mypage.jsp";
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			ArrayList<OrderVO> orderList = new ArrayList<OrderVO>(); 
			ArrayList<Integer> oseqList = OrderDAO.getIst().oseqListAll(member.getId());
			
			for (int oseq: oseqList) {
				ArrayList<OrderVO> orderListAll = OrderDAO.getIst().listOrderById2(member.getId(), oseq);
				OrderVO ovo = orderListAll.get(0);
				ovo.setPname(ovo.getPname() + "포함" + orderListAll.size() + "건");
				int totalPrice = 0;
				for (OrderVO ovo1 : orderListAll) {
					totalPrice += ovo1.getPrice2() * ovo1.getQuantity();
				}
				ovo.setPrice2(totalPrice);
				orderList.add(ovo);
			}
			request.setAttribute("title", "총 주문내역");
			request.setAttribute("orderList", orderList);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
