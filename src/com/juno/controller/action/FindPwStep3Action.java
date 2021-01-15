package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.dto.MemberVO;

public class FindPwStep3Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/resetPw.jsp";
		
		MemberVO m = new MemberVO();
		String confirmNum = request.getParameter("confirmNum");
		m.setId(request.getParameter("id"));
		m.setName(request.getParameter("Name"));
		m.setPhone(request.getParameter("Phone"));
		
		if (!confirmNum.equals("0000")) {
			url = "member/findPwConfirmNumber.jsp";
		}
		
		request.setAttribute("m", m);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
