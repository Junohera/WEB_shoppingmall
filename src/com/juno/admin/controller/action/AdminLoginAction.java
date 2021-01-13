package com.juno.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.controller.action.Action;
import com.juno.dao.AdminDAO;
import com.juno.dto.AdminVO;

public class AdminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=admin";

		String msg = "";
		String workId = request.getParameter("workId");
		String workPwd = request.getParameter("workPwd");

		AdminVO admin = AdminDAO.getIst().workerCheck(workId, workPwd);
		
		if (admin == null) {
			msg = "없는아이디입니다";
		} else if (admin.getPwd() == null) {
			msg = "관리자정보 오류. 개발자에게 문의하세요";
		} else if (!admin.getPwd().equals(workPwd)) {
			msg = "암호가 다릅니다";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", admin);
			url = "shop.do?command=adminProductList";
		}
		request.setAttribute("message", msg);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
