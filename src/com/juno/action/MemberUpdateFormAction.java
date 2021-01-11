package com.juno.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.dao.MemberDAO;
import com.juno.dto.MemberVO;

public class MemberUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/updateForm.jsp";
		String id = request.getParameter("id");
		MemberVO member = MemberDAO.getIst().getMember(id);

		String addr = member.getAddress();
		int k1 = addr.indexOf(" "); // 첫번째 공백의 위치찾음
		int k2 = addr.indexOf(" ", k1 + 1); // 첫번째 공백위치의 다음위치부터 공백위치찾음
		int k3 = addr.indexOf(" ", k2 + 1); // 두번째 공백위치의 다음위치부터 공백위치찾음

		String addr1 = addr.substring(0, k3);
		String addr2 = addr.substring(k3 + 1);

		request.setAttribute("member", member);
		request.setAttribute("addr1", addr1);
		request.setAttribute("addr2", addr2);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
