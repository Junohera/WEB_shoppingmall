<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
    <h1>상품수정 ${p.kind}</h1>
    <form name="frm" method="POST" enctype="multipart/form-data">
        <input type="hidden" name="pseq" value="${p.pseq}">
        <input type="hidden" name="nonmakeImg" value="${p.image}">
        <table id="list">
            <tr>
                <th>상품분류</th>
                <td colspan="5">
                    <select name="kind" id="select_kind">
                        <c:forEach var="kind" items="${kindList}" varStatus="status">
                            <c:choose>
                                <c:when test="${p.kind == status.count}">
                                    <option value="${status.count}" selected="selected">${kind}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${status.count}">${kind}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <th>상품명</th>
                <td width="343" colspan="5">
                    <input type="text" name="name" id="name" size="47" maxlength="100" value="${p.name}">
                </td>
            </tr>
            <tr>
                <th>원가[A]</th>
                <td width="70">
                    <input type="text" name="price1" id="price1" size="11" value="${p.price1}">
                </td>
            </tr>
            <tr>
                <th>원가[B]</th>
                <td width="70">
                    <input type="text" name="price2" id="price2" size="11" value="${p.price2}">
                </td>
            </tr>
            <tr>
                <th>[B-A]</th>
                <td width="72">
                    <input type="text" name="price3" id="price3" size="11" value="${p.price2 - p.price1}">
                </td>
            </tr>
            <tr>
                <th>베스트상품</th>
                <td>
                    <c:choose>
                        <c:when test="${p.bestyn == 'y'}">
                            <input type="checkbox" name="bestyn" value="y" id="bestyn_y" checked="checked">
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="bestyn" value="n" id="bestyn_n" >
                        </c:otherwise>
                    </c:choose>
                </td>
                
                <th>사용유무</th>
                <td>
                    <c:choose>
                        <c:when test="${p.useyn == 'y'}">
                            <input type="checkbox" name="useyn" value="y" id="useyn_y" checked="checked">
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" name="useyn" value="n" id="useyn_n">
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>

            <tr>
                <th>상세설명</th>
                <td colspan="5">
                    <textarea name="content" id="" cols="70" rows="8">${p.content}</textarea>
                </td>
            </tr>
            <tr>
                <th>상품이미지</th>
                <td colspan="5">
                    <img src="product_images/${p.image}" width="200pt">
                    <br>
                    <input type="file" name="image" id="image" >
                </td>
            </tr>
        </table>
        <input class="btn" type="button" value="수정" onclick="go_mod_save()">
        <input class="btn" type="button" value="취소" onclick="location.href='shop.do?command=adminProductDetail&pseq=${p.pseq}'">

    </form>
</article>

<%@ include file="/admin/footer.jsp"%>