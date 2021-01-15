<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
    <h1>Q&amp;A 게시판</h1>
    <form name="frm" method="POST">
        <input type="hidden" name="qseq" value="${q.qseq}">

        <table id="orderList">
            <tr>
                <th width="20%">제목</th>
                <td align="left">${q.subject} ${q.rep}</td>
            </tr>
            <tr>
                <th>등록일</th>
                <td align="left">
                    <fmt:formatDate value="${q.indate}"></fmt:formatDate>
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td align="left">${q.content}</td>
            </tr>
        </table>
        <c:choose>
            <c:when test="${q.rep == '1'}">
                <table id="orderList">
                    <tr>
                        <td colspan="2"><img src="admin/images/opinionimg01.gif"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <textarea name="reply" cols="50" rows="3"></textarea>
                            <input type="button" value="저장" class="btn" onclick="go_rep();">
                        </td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <table id="orderList">
                    <tr>
                        <th>댓글</th>
                        <td align="left">${q.reply}</td>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>
        <input type="button" value="목록" class="btn" onclick="go_list();">
    </form>
</article>

<%@ include file="/admin/footer.jsp"%>