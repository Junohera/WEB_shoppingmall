package com.juno.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.dao.MemberDAO;

public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/idCheck.jsp";
		String id = request.getParameter("id");
		int result = MemberDAO.getIst().confirmId(id);
		request.setAttribute("id", id);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
