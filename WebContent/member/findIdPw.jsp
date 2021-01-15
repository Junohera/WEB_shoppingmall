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
    <h2>비밀번호 찾기</h2>
    <form method="POST" name="frm" action="shop.do">
        <input type="hidden" name="command" value="findPwStep2">
        <table align="center" bgcolor="black" cellcpacing="1" width="400">
            <tr align="center" bgcolor="white">
                <td width="430">
                    <h3>
                        아이디
                    </h3>
                </td>
            </tr>
        </table>


    </form>
</body>
</html>