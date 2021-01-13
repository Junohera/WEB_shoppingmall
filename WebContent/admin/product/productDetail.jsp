<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
    <article>
        <h1>상품 상세보기</h1>
        <form name="frm" method="POST">
            <table id="list">
                <tr>
                    <th>상품분류</th>
                    <td colspan="5">
                        ${kind}
                    </td>
                </tr>
                <tr>
                    <th align="center">상품명</th>
                    <td colspan="5">${p.name}</td>
                </tr>
                <tr>
                    <th>원가[A]</th>
                    <td width="60">${p.price1}</td>
                    <th>판매가[B]</th>
                    <td width="60">${p.price2}</td>
                    <th>[B-A]</th>
                    <td >${p.price3}</td>
                </tr>
                <tr>
                    <th>상세설명</th>
                    <td colspan="5">${p.content}</td>
                </tr>
                <tr>
                    <th>상품이미지</th>
                    <td colspan="5" align="center">
                        <img src="product_images/${p.image}" width="200px">
                    </td>
                </tr>
            </table>
            <input type="button" value="수정" class="btn" onclick="go_mod('${p.pseq}')">
            <input type="button" value="목록" class="btn" onclick="go_mov()">
        </form>
    </article>
<%@ include file="/admin/footer.jsp"%>