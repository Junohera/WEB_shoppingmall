<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<script>
    function go_search() {
        if (document.frm.key === "") return;
        document.frm.action = "shop.do?command=adminMemberList&page=1";
        document.frm.submit();
    }
    function go_total() {
        document.frm.key.value = "";
        document.frm.action = "shop.do?command=adminMemberList&page=1";
        document.frm.submit();
    }
</script>
<article>
    <h1>회원리스트</h1>    
    <form name="frm" method="POST">
        <table style="float:right;">
            <tr>
                <td>
                    회원이름
                    <input type="text" name="key" id="key" value="${key}">
                    <input type="button" value="검색" class="btn" onclick="go_search();">
                    <input type="button" name="btn_total" value="전체보기" class="btn" onclick="go_total();">
                </td>
            </tr>
        </table>
        <br>
        <table id="orderList">
            <tr>
                <th>아이디(탈퇴여부)</th>
                <th>이름</th>
                <th>이메일</th>
                <th>우편번호</th>
                <th>주소</th>
                <th>전화</th>
                <th>가입일</th>
            </tr>
            <c:forEach var="m" items="${memberList}" varStatus="status">
                <tr>
                    <td>
                        ${p.id}
                        <c:choose>
                            <c:when test="${m.useyn == 'y'}">
                                <input type="checkbox" name="useyn" disabled="disabled">
                            </c:when>
                            <c:otherwise>
                                <input type="checkbox" name="useyn" checked="checked" disabled="disabled">
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${m.name}</td>
                    <td>${m.email}</td>
                    <td>${m.zip_num}</td>
                    <td>${m.address}</td>
                    <td>${m.phone}</td>
                </tr>
            </c:forEach>
        </table>

        <jsp:include page="/admin/paging.jsp">
            <jsp:param value="${paging.page}" name="page"/>
            <jsp:param value="${paging.beginPage}" name="beginPage"/>
            <jsp:param value="${paging.endPage}" name="endPage"/>
            <jsp:param value="${paging.prev}" name="prev"/>
            <jsp:param value="${paging.next}" name="next"/>
            <jsp:param name="adminMemberList" value="${command}"/>
        </jsp:include>
    </form>
</article>

<%@ include file="/admin/footer.jsp"%>