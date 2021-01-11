<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style>
    body {font-family: Verdana, Geneva, Tahoma, sans-serif;}
    #wrap {
        margin: 0 60px;
        font-size: 130%;
        font-weight: bold;
    }
    h1 {
        font-size: 45px;
        color: #ccc;
        font-weight: normal;
    }
</style>

<script>
    function idok() {
        opener.joinForm.id.value = document.frm.id.value;
        opener.joinForm.reid.value = document.frm.id.value;
        self.close();
    };
</script>

<div id="wrap">
    <h2>ID check</h2>
    <form action="shop.do" method="POST" name="frm">
        <input type="hidden" name="command" value="idCheckForm">
        id : <input type="text" name="id" id="id" value="${id}" size="20">
        <input type="submit" value="check">
    </form>

    <div style="margin-top:20px;">
        <c:choose>
            <c:when test="${result == 0}">
                ${id} is available.
                <input type="button" value="use" onclick="idok('${id}');">
            </c:when>
            <c:otherwise>
                ${id} is already.
                <script>
                    opener.document.joinForm.id.value = "";
                </script>
            </c:otherwise>
        </c:choose>
    </div>
</div>