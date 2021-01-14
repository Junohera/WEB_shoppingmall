package com.juno.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.controller.action.Action;
import com.juno.dao.AdminDAO;
import com.juno.dto.AdminVO;

public class AdminOrderSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=adminOrderList";

		AdminVO admin = (AdminVO)request.getSession().getAttribute("loginAdmin");
		if (admin == null) {
			url = "shop.do?command=admin";
		} else {
			String[] resultArr = request.getParameterValues("result");
			
			for (String odseq : resultArr) {
				AdminDAO.getIst().updateOrderResult(Integer.parseInt(odseq));
			}
		}
		
		response.sendRedirect(url);
	}

}
