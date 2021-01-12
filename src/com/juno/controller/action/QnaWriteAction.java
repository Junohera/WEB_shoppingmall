package com.juno.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.dao.QnaDAO;
import com.juno.dto.MemberVO;
import com.juno.dto.QnaVO;

public class QnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=qnaList";
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		if (member == null) {
			url = "shop.do?command=loginForm";
		} else {
			QnaVO qna = new QnaVO();
			qna.setSubject(request.getParameter("subject"));
			qna.setContent(request.getParameter("content"));
			qna.setId(member.getId());
			QnaDAO.getIst().insertQna(qna);
		}
		
		response.sendRedirect(url);
	}
}
