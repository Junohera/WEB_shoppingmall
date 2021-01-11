<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html" %>
<%@ include file="sub_menu.html" %>

<article>
    <h2>Edit Profile</h2>
    <form action="shop.do" method="POST" name="joinForm">
        <input type="hidden" name="command" value="memberUpdate">
        <fieldset>
            <legend>Basic Info</legend>
            <label>User ID</label>
            <input type="text" name="id" id="id" value="${member.id}" readonly><br>
            <label>password</label><input type="password" name="pwd" id="pwd" ><br>
            <label>Retype Password</label><input type="password" name="pwdCheck" id="pwdCheck" ><br>
            <label>Name</label><input type="text" name="name" value="${member.name}"><br>
            <label>E-mail</label><input type="text" name="email" value="${member.email}"><br>
        </fieldset>
        <fieldset>
            <legend>Optional</legend>
            <label>Zip Code</label><input type="text" name="zip_num" size="10" value="${member.zip_num}">
            <input type="button" value="주소찾기" class="dup" onclick="post_zip()"><br>
            <label>Address</label>
            <input type="text" name="addr1" size="50" value="${addr1}"><br>
            <label>&nbsp;</label>
            <input type="text" name="addr2" size="25" value="${addr2}"><br>
            <label>Phone Number</label>
            <input type="text" name="phone" value="${member.phone}"><br>
        </fieldset>
        <div class="clear"></div>
        <div id="buttons">
            <input type="button" value="update" class="submit" onclick="go_update();">
            <input type="reset" value="cancel" class="cancel">
        </div>

    </form>
</article>

<%@ include file="../footer.jsp"%>