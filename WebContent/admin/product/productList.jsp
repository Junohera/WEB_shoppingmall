<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<script>
    function go_search() {
        if (document.frm.key.value === "") {
            return false;
        }
        document.frm.action = "shop.do?command=adminProductList&page=1";
        document.frm.submit();  
    };

    function go_total() {
        document.frm.key.value = "";
        document.frm.action = "shop.do?command=adminProductList&page=1";
        document.frm.submit();
    };
</script>
<article>
    <h1>상품리스트</h1>
    <form name="frm" method="POST">
        <table>
            <tr>
                <td width="642">
                    상품명 <input type="text" name="key" id="key" value="${key}">
                    <input class="btn" type="button" name="btn_search" value="검색" onclick="go_search();">
                    <input class="btn" type="button" name="btn_total" value="전체보기" onclick="go_total();">
                    <input class="btn" type="button" name="btn_write" value="상품등록" onclick="go_wrt();">
                    <input type="hidden" name="all_view" value="y">
                </td>
            </tr>
        </table>
        <table id="productList">
            <tr>
                <th>번호</th>
                <th>상품명</th>
                <th>원가</th>
                <th>판매가</th>
                <th>등록일</th>
                <th>사용유무</th>
            </tr>
            <c:choose>
                <c:when test="${productListSize <= 0}">
                    <tr>
                        <td width="100%" colspan="7" align="center" height="23">등록된 상품이 없습니다.</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <c:forEach var="p" items="${productList}" varStatus="status">
                        <tr>
                            <td height="23" align="center">${p.pseq}</td>
                            <td style="text-align: left; padding-left: 50px; padding-right: 0px;">
                                <a href="#" onclick="go_detail('${p.pseq}');">${p.name}</a>
                            </td>
                            <td><fmt:formatNumber value="${p.price1}"></fmt:formatNumber></td>
                            <td><fmt:formatNumber value="${p.price2}"></fmt:formatNumber></td>
                            <td><fmt:formatDate value="${p.indate}"></fmt:formatDate></td>
                            <td>
                                <c:choose>
                                    <c:when test="${p.useyn == 'n'}">미사용</c:when>
                                    <c:otherwise>사용</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </table>
        <br>
        <jsp:include page="/admin/paging.jsp">
            <jsp:param name="page" value="${paging.page}"/>
            <jsp:param name="beginPage" value="${paging.beginPage}" />
            <jsp:param name="endPage" value="${paging.endPage}" />
            <jsp:param name="prev" value="${paging.prev}" />
            <jsp:param name="next" value="${paging.next}"/>
            <jsp:param name="command" value="adminProductList"/>
        </jsp:include>
    </form>
</article>

<%@ include file="/admin/footer.jsp"%>