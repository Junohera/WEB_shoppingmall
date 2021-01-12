package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dao.QnaDAO;
import com.juno.dto.MemberVO;
import com.juno.dto.QnaVO;

public class QnaUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=qnaView";
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			QnaVO qna = new QnaVO();
			qna.setSubject(request.getParameter("subject"));
			qna.setContent(request.getParameter("content"));
			qna.setQseq(Integer.parseInt(request.getParameter("qseq")));
			QnaDAO.getIst().updateQna(qna);

			request.setAttribute("qseq", qna.getQseq());
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
