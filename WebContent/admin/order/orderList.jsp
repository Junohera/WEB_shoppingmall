<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>
<script>
function go_search_order() {
	if (document.frm.key.value === "") return;
	document.frm.action = "shop.do?command=adminOrderList&page=1";
	document.frm.submit();
}

function go_total() {
	document.frm.key.value = "";
	document.frm.action = "shop.do?command=adminOrderList&page=1";
	document.frm.submit();
}
</script>
<article>
    <h1>주문리스트</h1>
    <form name="frm" method="POST">
        <table style="float:right;">
            <tr>
                <td>
                    주문자 이름
                    <input type="text" name="key" id="key" value="${key}">
                    <input type="button" value="검색" class="btn" onclick="go_search_order();">
                    <input type="button" value="전체보기" name="btn_total" class="btn" onclick="go_total();">
                </td>
            </tr>
        </table>
        <table id="orderList">
            <tr>
                <th>주문번호(처리여부)</th>
                <th>주문자</th>
                <th>상품명</th>
                <th>수량</th>
                <th>우편번호</th>
                <th>배송지</th>
                <th>전화</th>
                <th>주문일</th>
            </tr>
            <c:forEach var="o" items="${orderList}" varStatus="status">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${o.result == '1'}">
                                <span style="font-weight:bold; color: blue;">${o.oseq}</span>
                                (<input type="checkbox" name="result" value="${o.odseq}"> 미처리)
                            </c:when>
                            <c:otherwise>
                                <span style="font-weight:bold; color: red;">${o.oseq}</span>
                                (<input type="checkbox" checked="checked" disabled="disabled"> 처리완료)
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${o.mname}</td>
                    <td>${o.pname}</td>
                    <td>${o.quantity}</td>
                    <td>${o.zip_num}</td>
                    <td>${o.address}</td>
                    <td>${o.phone}</td>
                    <td><fmt:formatDate value="${o.indate}"></fmt:formatDate></td>
                </tr>
            </c:forEach>
        </table>

        <input type="button" value="주문처리(입금확인)" style="width:200px;" class="btn" onclick="go_order_save();">

        <br>

        <jsp:include page="/admin/paging.jsp">
            <jsp:param name="page" value="${paging.page}"/>
            <jsp:param name="beginPage" value="${paging.beginPage}" />
            <jsp:param name="endPage" value="${paging.endPage}" />
            <jsp:param name="prev" value="${paging.prev}" />
            <jsp:param name="next" value="${paging.next}"/>
            <jsp:param name="command" value="adminOrderList"/>
        </jsp:include>
    </form>
</article>

<%@ include file="/admin/footer.jsp"%>