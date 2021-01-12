package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dao.QnaDAO;
import com.juno.dto.MemberVO;
import com.juno.dto.QnaVO;

public class QnaUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "qna/qnaUpdateForm.jsp";
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			QnaVO qna = QnaDAO.getIst().getQna(Integer.parseInt(request.getParameter("qseq")));
			request.setAttribute("qna", qna);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
