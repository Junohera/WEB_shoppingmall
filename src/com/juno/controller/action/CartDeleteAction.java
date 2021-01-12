package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.dao.CartDAO;

public class CartDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=cartList";
		String [] cseqArr = request.getParameterValues("cseq");
		
		System.out.println("cseqArr #########################################");
		System.out.println(cseqArr);
		for (String cseq: cseqArr) {
			CartDAO.getIst().deleteCart(Integer.parseInt(cseq));	
		}

		// request를 사용하지않으면서, 혹여나 새로고침할 경우, form이 재전송되어 이미 처리된 작업을 또 시도할 수있으니, 
		// forward가 아닌 sendRedirect로 처리.		
		response.sendRedirect(url);
	}

}
