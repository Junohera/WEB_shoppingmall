<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        background-color: #a890f6;
        font-family: Verdana, Geneva, Tahoma, sans-serif;
    }
    #popup {
        padding: 0 10px;
    }
    #popup h1 {
        font-family: Verdana, Geneva, Tahoma, sans-serif;
        font-size: 45px;
        color: #CCC;
        font-weight: normal;
    }
    table#zipcode {
        border-collapse: collapse;
        border-top: 3px solid #fff;
        border-bottom: 3px solid #fff;
        margin-top: 15px;
        width: 100%;
    }
    table#zipcode th, table#zipcode td {
        text-align: center;
        color: #FFF;
        border-bottom: 1px dotted #fff;
    }
    table th, td {
        padding: 10px;
    }
    table#zipcode a {
        display: block;
        height: 20px;
        text-decoration: none;
        color: #FFF;
        padding: 10px;
    }
    table#zipcode a:hover {
        color: #F90;
        font-weight: bold;
    }
</style>
<script>
    function result(zipNum, sido, gugun, dong) {
        opener.document.joinForm.zip_num.value = zipNum;
        opener.document.joinForm.addr1.value = sido + " " + gugun + " " + dong;
        self.close();
    };
</script>
</head>
<body>
    <div id="popup">
        <h1>Search Zip</h1>
        <form action="shop.do" method="get" name="formm">
            <input type="hidden" name="command" value="findZipNum">
            동 이름 : <input type="text" name="dong" id="dong" >
            <input type="submit" value="search" class="submit">
        </form>
        <table id="zipcode"> <!--검색된 우편번호와 동이 표시되는 곳-->
            <tr><th>우편번호</th><th>주소</th></tr>
            <c:forEach var="address" items="${addressList}" varStatus="status">
                <tr>
                    <td>${address.zip_num}</td>
                    <td>
                        <a href="#" onclick="result('${address.zip_num}', '${address.sido}', '${address.gugun}', '${address.dong}');">
                            ${address.sido} ${address.gugun} ${address.bunji}
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html> 