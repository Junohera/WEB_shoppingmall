<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html" %>
<%@ include file="sub_menu.jsp" %>

<article>
    <h2>${title}</h2>
    <form name="formm" method="POST">
        <table id="cartList">
            <tr>
                <th>주문일자</th>
                <th>주문번호</th>
                <th>상품명</th>
                <th>결제금액</th>
                <th>주문상세</th>
                <th>처리상태</th>
            </tr>
            <c:forEach var="order" items="${orderList}" varStatus="status">
                <tr>
                    <td>
                        <fmt:formatDate value="${order.indate}" type="date"></fmt:formatDate>
                    </td>
                    <td>${order.oseq}</td>
                    <td>${order.pname}</td>
                    <td><fmt:formatNumber value="${order.price2}" type="currency"></fmt:formatNumber></td>
                    <td><a href="shop.do?command=orderDetail&oseq=${order.oseq}">조회</a></td>
                    <td>
                        <c:if test="${order.result == '1'}">미처리</c:if>
                        <c:if test="${order.result == '2'}">완료</c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <div class="clear"></div>
        <div id="buttons" style="float:right;">
            <input type="button" value="쇼핑계속하기" class="cancel" onclick="location.href='shop.do?command=index'">

        </div>
    </form>
</article>

<%@ include file="../footer.jsp"%>