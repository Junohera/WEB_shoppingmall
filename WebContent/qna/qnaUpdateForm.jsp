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
    <form name="formm" method="POST" action=shop.do>
        <input type="hidden" name="command" value="qnaUpdate">
        <input type="hidden" name="qseq" value="${qna.qseq}">
        <fieldSet>
            <legend>Board Info</legend>
            <label>Title</label><input type="text" name="subject" id="subject" value="${qna.subject}" size="60"><br>
            <label>Content</label><textarea name="content" cols="65" rows="8">${qna.content}</textarea>
        </fieldSet>
        <div class="clear"></div>
        <div id="buttons" style="float: right;">
            <input type="submit" value="수정하기" class="submit">
            <input type="reset" value="취소" class="cancel">
            <input type="button" value="쇼핑 계속하기" class="submit" onclick="location.href='shop.do?command=index'">
        </div>
    </form>
</article>

<%@ include file="../footer.jsp"%>