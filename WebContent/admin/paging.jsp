<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        text-align:center;
    }
    #paging{
        font-size:150%;
    }
</style>
</head>
<body>
    <div id="paging">
        <c:url var="action" value="shop.do?command=${param.command}"/>
        <c:if test="${param.prev}">
            <a href="${action}&page=${param.beginPage - 1}">&lt;</a>
        </c:if>
        <c:forEach var="i" begin="${param.beginPage}" end="${param.endPage}" step="1" varStatus="status">
            <c:choose>
                <c:when test="${param.page == i}">
                    ${i}
                </c:when>
                <c:otherwise>
                    <a href="${action}&page=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${param.next}">
            <a href="${action}&page=${param.endPage+1}">&gt;</a>
        </c:if>
    </div>
</body>
</html>