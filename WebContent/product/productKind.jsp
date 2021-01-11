<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html" %>
<%@ include file="sub_menu.html" %>

<article>
    <h2>Item</h2>
    <c:forEach var="p" items="${productKindList}" varStatus="status">
        <div id="item">
            <a href="shop.do?command=productDetail&pseq=${p.pseq}">
                <img src="product_images/${p.image}"/>
                <h3>${p.name}</h3>
                <p>${p.price2}</p>
            </a>
        </div>
    </c:forEach>
    <div class="clear"></div>
</article>

<%@ include file="../footer.jsp"%>