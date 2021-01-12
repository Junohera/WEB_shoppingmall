package com.juno.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.controller.action.Action;

public class AdminAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/adminLogin.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
