package com.juno.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.juno.controller.action.Action;
import com.juno.dao.AdminDAO;
import com.juno.dto.AdminVO;
import com.juno.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AdminProductUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop.do?command=adminProductDetail";
		HttpSession session = request.getSession();
		AdminVO admin = (AdminVO) session.getAttribute("loginAdmin");
		if (admin == null) {
			url = "shop.do?command=admin";
		} else {
			ProductVO product = new ProductVO();
			ServletContext context = session.getServletContext();
			String uploadFilePath = context.getRealPath("product_images");
			MultipartRequest multi = new MultipartRequest(
				request,
				uploadFilePath,
				5 * 1024 * 1024,
				"UTF-8",
				new DefaultFileRenamePolicy()
			);
			product.setPseq(Integer.parseInt(multi.getParameter("pseq")));
			product.setKind(multi.getParameter("kind"));
			product.setName(multi.getParameter("name"));
			product.setPrice1(Integer.parseInt(multi.getParameter("price1")));
			product.setPrice2(Integer.parseInt(multi.getParameter("price2")));
			product.setPrice3(Integer.parseInt(multi.getParameter("price3")));
			product.setContent(multi.getParameter("content"));
			product.setUseyn(multi.getParameter("useyn"));
			product.setBestyn(multi.getParameter("bestyn"));
			if (multi.getFilesystemName("image") == null) {
				product.setImage(multi.getParameter("nonmakeImg"));
			} else {
				product.setImage(multi.getFilesystemName("image"));
			}
			AdminDAO.getIst().updateProduct(product);
			url += "&pseq=" + product.getPseq();
		}

		response.sendRedirect(url);
	}

}
