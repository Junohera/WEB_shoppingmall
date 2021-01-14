package com.juno.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.controller.action.Action;
import com.juno.dao.AdminDAO;
import com.juno.dto.AdminVO;
import com.juno.dto.QnaVO;

public class AdminQnaAnswerFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=adminQnaDetail";
		
		if ((AdminVO) request.getSession().getAttribute("loginAdmin") == null) {
			url = "shop.do?command=admin";
		} else {
			QnaVO q = new QnaVO();
			q.setQseq(Integer.parseInt(request.getParameter("qseq")));
			q.setReply(request.getParameter("reply"));
			AdminDAO.getIst().qnaAttachAnswer(q);
			
			url += "&qseq=" + q.getQseq(); 
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}