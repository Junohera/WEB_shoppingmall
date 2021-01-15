<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<h2> ??? </h2>
		<form method="post" name="frm" action="shop.do">
			<input type="hidden" name="command" value="findPwStep3">
			<table bgcolor="black" cellspacing="1" width="460">
				<tr align="center" bgcolor="white">
					<td width="430">
						<h3>
							아이디 : ${m.id}
							<input type="hidden" name="id" value="${m.id}">
						</h3>
					</td>
				</tr>
				<tr align="center" bgcolor="white">
					<td width="430">
						<h3>
							성명 : ${m.name}
							<input type="hidden" name="name" value="${m.name}">
						</h3>
					</td>
				</tr>
				<tr align="center" bgcolor="white">
					<td width="430">
						<h3>전화번호 : ${m.phone}</h3>
						<input type="hidden" name="phone" value="${m.name}">
					</td>
				</tr>
				<tr align="center" bgcolor="white">
					<td width="430">
						<h3>
							인증번호 <input type="text" name="confirmNum" id="confirmNum" >
							전송받은 번호를 입력하세요
							<input type="submit" value="인증번호 확인">
						</h3>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>