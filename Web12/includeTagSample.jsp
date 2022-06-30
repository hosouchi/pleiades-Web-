<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "/WEB-INF/header/header.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>インクルードのサンプル</title>
	</head>
	
	<body>
		
		<p>アクセス日時：<%= nowStr %></p>
		
		<h1>どこつぶ</h1>
		<p>どこつぶとは・・・</p>
		
		<!-- footer.jspを取り込む -->
		<jsp:include page="WEB-INF/footer/footer.jsp"/>
	</body>
</html>