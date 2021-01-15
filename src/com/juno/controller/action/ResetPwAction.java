package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.dao.MemberDAO;
import com.juno.dto.MemberVO;

public class ResetPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/resetPwComplete.jsp";
		MemberVO m = new MemberVO();
		m.setId(request.getParameter("id"));
		m.setPwd(request.getParameter("pw"));
		MemberDAO.getIst().resetPw(m);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
