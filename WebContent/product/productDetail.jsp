<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html" %>
<%@ include file="sub_menu.html" %>

<article>
    <div id="itemdetail" style="float: left;">
        <h1>Item</h1>
        <form method="POST" name="formm">
            <fieldset>
                <legend>Item detail Info</legend>
                <span style="float: left;">
                    <img src="product_images/${product.image}" style="border-radius: 20px;">
                </span>
                <h2>${product.name}</h2>
                <label>가격 : </label><p>${product.price2} 원</p>
                <label>수량 : </label><input type="text" name="quantity" id="quantity" size="2" value="1"><br>
                <label>제품 설명 : </label><label>${product.content}</label><br>
                <input type="hidden" name="pseq" value="${product.pseq}"><br>
            </fieldset>
            <div class="clear"></div>
            <div id="buttons">
                <input type="button" value="to cart" class="submit" onclick="go_cart();">
                <input type="button" value="buy" class="submit" onclick="go_order();">
                <input type="reset" value="cancel" class="cancel">
            </div>
        </form>
    </div>
</article>

<%@ include file="../footer.jsp"%>