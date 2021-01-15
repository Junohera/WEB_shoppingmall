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
		<h2>Id / Pw 찾기</h2>
		<form method="post" name="frm">
			<table bgcolor="black" cellspacing="1" width="460">
				<tr align="center" bgcolor="white" height="200">
					<td width="230">
						<h3>아이디 찾기</h3><br>
						<input type="button" class="submit" value="이동" onclick="move_id();">
					</td>
					<td width="230">
						<input type="button" class="submit" value="이동" onclick="move_Pw();">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>