package com.juno.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.dao.MemberDAO;

public class FindZipNumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/findZipNum.jsp";
		String dong = request.getParameter("dong");

		if (dong != null) {
			if (dong.equals("") == false) {
				ArrayList<AddressVO> list = MemberDAO.getIst().selectAddressByDong(dong);
				System.out.println("System.out.println(list.size());");
				System.out.println(list.size());
				request.setAttribute("addressList", list);
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
