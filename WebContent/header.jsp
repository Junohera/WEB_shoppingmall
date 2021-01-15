<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/shopping.css" rel="stylesheet">
<script src="member/member.js"></script>
<script src="mypage/mypage.js"></script>
</head>
<body>
	<div id="wrap">
		<header>
			<div id="logo">
				<a href="shop.do?command=index">
					<img src="images/logo.png" width="180" height="100">
				</a>
			</div>
			
			<nav id="category_menu">
				<ul>
					<c:choose>
						<c:when test="${empty loginUser}">
							<li><a href="shop.do?command=loginForm">sign in</a></li>
							<li><a href="shop.do?command=contract">sign up</a></li>
						</c:when>
						<c:otherwise>
							<li style="color: #820775;font-weight:bold;font-size:120%;">
								${loginUser.name}(${loginUser.id})
							</li>
							<li><a href="shop.do?command=memberUpdateForm&id=${loginUser.id}">update</a></li>
							<li><a href="shop.do?command=logout">logout</a></li>
						</c:otherwise>
					</c:choose>
					<li><a href="shop.do?command=cartList">cart</a></li>
					<li><a href="shop.do?command=mypage">profile</a></li>
					<li><a href="shop.do?command=qnaList" style="border: 0px;">Q&amp;A(1:1)</a></li>
				</ul>
			</nav>
			
			<nav id="top_menu">
				<ul>
					<li><a href="shop.do?command=category&kind=1">Heels</a></li>
					<li><a href="shop.do?command=category&kind=2">Boots</a></li>
					<li><a href="shop.do?command=category&kind=3">Sandals</a></li>
					<li><a href="shop.do?command=category&kind=4">Sneakers</a></li>
					<li><a href="shop.do?command=category&kind=5">Slipper</a></li>
					<li><a href="shop.do?command=category&kind=6">On Sale</a></li>
				</ul>
			</nav>
		</header>