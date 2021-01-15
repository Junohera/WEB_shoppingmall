package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.dao.MemberDAO;
import com.juno.dto.MemberVO;

public class FindPwStep2Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/findPwConfirmNumber.jsp";

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		MemberVO m = MemberDAO.getIst().confirmIdNamePhone(id, name, phone);

		if (m == null) {
			request.setAttribute("msg", "이름과 전화번호가 일치하는 회원이 없습니다.");
			request.setAttribute("id", id);
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			url = "member/findPwForm.jsp";
		}
		request.setAttribute("m", m);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
