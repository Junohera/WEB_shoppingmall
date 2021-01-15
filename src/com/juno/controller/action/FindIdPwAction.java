package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.dao.MemberDAO;
import com.juno.dto.MemberVO;

public class FindIdPwAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/viewId.jsp";

		MemberVO member = new MemberVO();

		String confirmNum = request.getParameter("confirmNum");
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPwd(request.getParameter("pw"));
		
		MemberDAO.getIst().resetPw(member);
	}

}
