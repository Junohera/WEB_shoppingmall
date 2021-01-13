package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dao.ProductDAO;
import com.juno.dto.AdminVO;
import com.juno.dto.ProductVO;

public class AdminProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productDetail.jsp";
		HttpSession session = request.getSession();
		AdminVO admin = (AdminVO) session.getAttribute("loginAdmin");
		if (admin == null) {
			url = "shop.do?command=admin";
		} else {
			String pseq = request.getParameter("pseq");
			ProductVO product = ProductDAO.getIst().getProduct(pseq);
			
			// 카테고리별 타이틀
			String [] kindList = {"0", "Heels", "Boots", "Sandals", "Slipers", "Snicakers", "Sale"};
			
			int selectedIndex = Integer.parseInt(product.getKind());
			request.setAttribute("p", product);
			request.setAttribute("kind", kindList[selectedIndex]);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
