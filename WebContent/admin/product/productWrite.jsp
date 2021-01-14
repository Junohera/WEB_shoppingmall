<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
    <article>
        <h1>상품 등록</h1>
        <form name="frm" method="POST" enctype="multipart/form-data">
            <table id="list">
                <tr>
                    <th>상품분류</th>
                    <td colspan="5">
                        <select name="kind">
                        	<c:forEach items="${kindList }" var="kind" varStatus="status">
                        		<option value="${status.count}">${kind}</option>
                        	</c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th align="center">상품명</th>
                    <td colspan="5" width="343">
                    	<input type="text" name="name" size="47" maxlength="100">
					</td>
                </tr>
                <tr>
                    <th>원가[A]</th>
                    <td width="70">
                    	<input type="text" name="price1" size="11">
                    </td>
                    <th>판매가[B]</th>
                    <td width="70">
                        <input type="text" name="price2" size="11">
                    </td>
                    <th>[B-A]</th>
                    <td width="72">
                        <input type="text" name="price3" size="11">
                    </td>
                </tr>
                <tr>
                    <th>상세설명</th>
                    <td colspan="5">
                        <textarea name="content" cols="70" rows="8"></textarea>
                    </td>
                </tr>
                <tr>
                    <th>상품이미지</th>
                    <td width="343" colspan="5" align="center">
                        <input type="file" name="image">
                    </td>
                </tr>
            </table>
            <input type="button" value="등록" class="btn" onclick="go_save()">
            <input type="button" value="목록" class="btn" onclick="go_mov()">
        </form>
    </article>
<%@ include file="/admin/footer.jsp"%>