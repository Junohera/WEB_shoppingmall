<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="header.jsp" %>

<div id="main_img">
	<img src="images/main_img.jpg">
</div>

<h2>new Item</h2>
<div id="bestProduct">
	<c:forEach items="${newProductList }" var="product">
		<div id="item">
			<a href="shop.do?command=productDetail&pseq=${product.pseq }">
				<img src="product_images/${product.image }">
				<h3>${product.name } -
				<fmt:formatNumber value="${product.price2 }" type="currency"></fmt:formatNumber>
				</h3>
			</a>
		</div>
	</c:forEach>
</div>

<div class="clear"></div>

<h2>best Item</h2>
<div id="bestProduct">
	<c:forEach items="${bestProductList }" var="product">
		<div id="item">
			<a href="shop.do?command=productDetail&pseq=${product.pseq }">
				<img src="product_images/${product.image }">
				<h3>${product.name } -
				<fmt:formatNumber value="${product.price2 }" type="currency"></fmt:formatNumber>
				</h3>
			</a>
		</div>
	</c:forEach>
</div>

<%@ include file="footer.jsp" %>