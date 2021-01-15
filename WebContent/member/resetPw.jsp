<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function resetPw() {
	if (document.frm.pwd.value === "") {
		alert("pwd");
		document.frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value !== document.frm.pwd_chk.value) {
		alert("pwd chk");
		document.frm.pwd_chk.focus();
		return false;
	}
	
	return true;
};
</script>
</head>
<body>
    <h2>비밀번호 재설정</h2>
    <form method="post" name="frm" action="shop.do">
        <input type="hidden" name="command" value="??">
        <input type="hidden" name="id" value="${m.id}">
        <table align="center" bgcolor="black" cellspacing="1" width="400">
        	<tr align="center" bgcolor="white">
        		<td width="430">
        			<h3>비밀번호 <input type="text" name="pwd"></h3>
        		</td>
        	</tr>
        	<tr align="center" bgcolor="white">
        		<td width="430">
        			<h3>비밀번호 <input type="text" name="pwd_chk"></h3>
        		</td>
        	</tr>
        	<tr align="center" bgcolor="white">
        		<td width="430">
        			<input type="submit" value="비밀번호 재설정" onclick="return resetPw();">
        		</td>
        	</tr>
        </table>
    </form>
</body>
</html>