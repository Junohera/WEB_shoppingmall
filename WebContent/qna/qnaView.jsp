<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html" %>
<%@ include file="sub_menu.jsp" %>

<article>
    <h2>1:1 고객 게시판</h2>
    <h3>고객님의 질문에 대해서 운영자가 1:1답변을 드립니다.</h3>
    <form name="formm" method="POST">
        <input type="hidden" name="command" value="qnaUpdateForm">
        <input type="hidden" name="qseq" value="${qna.qseq}">
        <table>
            <tr>
                <th>제목</th><td width="600" style="text-align: left;color: white;">${qna.subject}</td>
            </tr>
            <tr>
                <th>등록일</th><td align="left" style="text-align: left;color: white;"><fmt:formatDate value="${qna.indate}" type="date"></fmt:formatDate></td>
            </tr>
            <tr>
                <th>질문내용</th>
                <td align="left" style="text-align: left; font-size: 115%;color: white;"><pre>${qna.content}</pre></td>
            </tr>
            <tr>
                <th>답변내용</th>
                <td align="left" style="text-align: left; color: white;">${qna.reply}</td>
            </tr>
        </table>
        <div class="clear"></div>
        <div id="buttons" style="float: right;">
            <c:if test="${loginUser.id eq qna.id}">
        		<input type="submit" value="수정하기" class="submit" onclick="location.href='shop.do?command=qnaUpdateForm'">
        	</c:if>
            <input type="button" value="목록보기" class="submit" onclick="location.href='shop.do?command=qnaList'">
            <input type="button" value="쇼핑계속하기" class="cancel" onclick="location.href='shop.do?command=index'">
        </div>
    </form>
</article>

<%@ include file="../footer.jsp"%>