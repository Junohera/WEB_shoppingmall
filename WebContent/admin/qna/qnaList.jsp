<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<script>
function go_search_qna() {
    if (document.frm.key.value === "") return;
    document.frm.action = "shop.do?command=adminQnaList&page=1";
    document.frm.submit();
};
function go_total_qna() {
    document.frm.key.value = "";
    document.frm.action = "shop.do?command=adminQnaList&page=1";
    document.frm.submit();
};
</script>
<article>
    <h1>Q&amp;A 게시글 리스트</h1>
    <form name="frm" method="POST">
    	<table style="float:right;">
    		<tr>
	    		<td>주문자이름
		    		<input type="text" name="key" value="${key}"/>
		    		<input type="button" value="검색" class="btn" onclick="go_search_qna();"/>
		    		<input type="button" value="전체보기" class="btn" onclick="go_total_qna();"/>
	    		</td>
    		</tr>
    	</table>
        <table id="orderList">
            <tr>
                <th>번호(답변여부)</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
            <c:forEach var="q" items="${qnaList}" varStatus="status">
                <tr>
                    <td>
                        ${q.qseq}
                        <c:choose>
                            <c:when test="${q.rep == '1'}">(미처리)</c:when>
                            <c:otherwise>(답변완료)</c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="#" onclick="javascript:go_view('${q.qseq}');">${q.subject}</a>
                    </td>
                    <td>${q.id}</td>
                    <td><fmt:formatDate value="${q.indate}"></fmt:formatDate></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <jsp:include page="/admin/paging.jsp">
            <jsp:param name="page" value="${paging.page}"/>
            <jsp:param name="beginPage" value="${paging.beginPage}" />
            <jsp:param name="endPage" value="${paging.endPage}" />
            <jsp:param name="prev" value="${paging.prev}" />
            <jsp:param name="next" value="${paging.next}"/>
            <jsp:param name="command" value="adminQnaList"/>
        </jsp:include>
    </form>
</article>

<%@ include file="/admin/footer.jsp"%>