package com.juno.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.controller.action.Action;
import com.juno.dao.AdminDAO;
import com.juno.dto.AdminVO;
import com.juno.dto.ProductVO;
import com.juno.util.Paging;

public class AdminProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productList.jsp";
		HttpSession session = request.getSession();
		AdminVO admin = (AdminVO) session.getAttribute("loginAdmin");
		
		if (admin == null) {
			url = "shop.do?command=admin";
		} else {
			/** <paging> */
			int page = 1;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			int totalCount = AdminDAO.getIst().getAllCount("product");
			paging.setTotalCount(totalCount);

			/** </paging> */
			
			ArrayList<ProductVO> productList = AdminDAO.getIst().listProduct(paging);
			request.setAttribute("productList", productList);
			request.setAttribute("paging", paging);
		}
		request.getRequestDispatcher(url).forward(request, response);
	} 

}
