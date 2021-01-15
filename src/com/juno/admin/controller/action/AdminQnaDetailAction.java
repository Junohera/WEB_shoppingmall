package com.juno.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.controller.action.Action;
import com.juno.dao.QnaDAO;
import com.juno.dto.AdminVO;
import com.juno.dto.QnaVO;

public class AdminQnaDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/qna/qnaDetail.jsp";
		
		if ((AdminVO)request.getSession().getAttribute("loginAdmin") == null) {
			url = "shop.do?command=admin";
		} else {
			String qseq = request.getParameter("qseq");
			QnaVO q = QnaDAO.getIst().getQna(Integer.parseInt(qseq));
			System.out.println(q);
			request.setAttribute("q", q);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
