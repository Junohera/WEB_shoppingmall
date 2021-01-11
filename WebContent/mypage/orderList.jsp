<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html" %>
<%@ include file="sub_menu.jsp" %>

<article>
	<h2>Order List</h2>
	<form name="formm" method="post">
		<table id="cartList">
			<tr>
				<th>상품명</th>
				<th>수량</th>
				<th>가격</th>
				<th>주문일</th>
				<th>진행상태</th>
			</tr>
			
			<c:forEach var="order" items="${orderList}" varStatus="status">
				<tr>
					<td>
						<a href="shop.do?command=productDetail&pseq=${order.pseq}">
							<h3>
								${order.pname}
							</h3>
						</a>
					</td>
					<td>${order.quantity}</td>
					<td><fmt:formatNumber value="${order.price2 * order.quantity}" type="currency"></fmt:formatNumber></td>
					<td><fmt:formatDate value="${order.indate}" type="date" /></td>
					<td>처리 진행중</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="2">총액</th>
				<th colspan="2">
					<fmt:formatNumber value="${totalPrice}" type="currency"></fmt:formatNumber>
				</th>
				<th>주문 처리가 완료되었습니다.</th>
			</tr>
		</table>
	</form>
</article>

<%@ include file="../footer.jsp"%>