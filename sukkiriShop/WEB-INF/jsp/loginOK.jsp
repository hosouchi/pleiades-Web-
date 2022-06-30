<%--ログイン成功画面を出力するビュー --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>スッキリ商店：ログイン成功</title>
	</head>
	
	<body>
		<h3 style="color:white; background-color:blue;">スッキリ商店：ログイン成功しました</h3>
		<p>ようこそ<c:out value="${userId}"/>さん</p>
		<a href="/sukkiriShop/WelcomeServlet">トップページへ戻る</a>
		<a href="/sukkiriShop/LogoutServlet">ログアウトする</a>
	</body>
</html>