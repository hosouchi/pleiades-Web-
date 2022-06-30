<%--indexページ（ダイスをスタートさせる画面） --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>インデックスページ</title>
	</head>
	
	<body>
		<h1>ダイス</h1>
		
		<%--dicesが空でなければ、discesの個数を表示 --%>
		<c:if test="${not empty dices}">
		<p>前回：<c:out value="${dices.size()}"/>回</p> 
		</c:if>
		
		<a href="/dice/DiceServlet">スタート</a>
	</body>
</html>