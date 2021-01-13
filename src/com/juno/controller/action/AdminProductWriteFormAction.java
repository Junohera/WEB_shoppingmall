package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dto.AdminVO;

public class AdminProductWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productWrite.jsp";
		HttpSession session = request.getSession();
		AdminVO admin = (AdminVO) session.getAttribute("loginAdmin");
		
		if (admin == null) {
			url = "shop.do?command=admin";
		} else {
			String kindList[] = {"Heels", "Boots", "Sandals", "Slipers", "Snicakers", "Sale"};
			request.setAttribute("kindList", kindList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
