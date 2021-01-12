<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp"%>

<%@ include file="sub_img.html" %>
<%@ include file="sub_menu.html" %>

<article>
    <h1>Login</h1>
    <form action="shop.do" method="POST" name="loginFrm">
        <input type="hidden" name="command" value="login">
        <fieldset><legend></legend>
            <label>User ID</label><input type="text" name="id"><br>
            <label>Password</label><input type="password" name="pwd"><br>
        </fieldset>
        <div id="buttons">
            <input type="submit" value="login" class="submit" onclick="return loginCheck();">
            <input type="button" value="sign Up" class="cancel"  onclick="location.href='shop.do?command=contract'">
            <input type="button" value="find id/pw" class="submit" onclick="find_id();">
        </div>
    </form>
</article>

<%@ include file="../footer.jsp"%>