package com.juno.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.controller.action.Action;
import com.juno.dao.ProductDAO;
import com.juno.dto.AdminVO;
import com.juno.dto.ProductVO;

public class AdminProductUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productUpdate.jsp";

		HttpSession session = request.getSession();
		AdminVO admin = (AdminVO) session.getAttribute("loginAdmin");

		if (admin == null) {
			url = "shop.do?command=admin";
		} else {
			String pseq = request.getParameter("pseq");
			ProductVO p = ProductDAO.getIst().getProduct(pseq);
			request.setAttribute("p", p);

			String kindList[] = {"Heels", "Boots", "Sandals", "Slipers", "Snicakers", "Sale"};
			request.setAttribute("kindList", kindList);
			int index = Integer.parseInt(p.getKind());
			request.setAttribute("kind", kindList[index]);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
