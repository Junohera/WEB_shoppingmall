package com.juno.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juno.dao.ProductDAO;
import com.juno.dto.ProductVO;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "index.jsp";
		
		ProductDAO pdao = ProductDAO.getIst();
		
		ArrayList<ProductVO> newlist = pdao.getNewList();
		ArrayList<ProductVO> bestlist = pdao.getBestList();
		                                                                                                                                                                                                                                                                                                                
		request.setAttribute("newProductList", newlist);
		request.setAttribute("bestProductList", bestlist);

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
