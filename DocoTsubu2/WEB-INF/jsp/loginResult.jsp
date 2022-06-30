<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//セッションスコープからログインユーザー情報を取得する
	//ログインできていれば、インスタンスを取得できるが失敗していればnull
	User loginUser = (User)session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>どこつぶ</title>
	</head>
	
	<body>
		<h1>どこつぶログイン</h1>
		
		<%-- ログイン成功時のHTML --%>
		
		<% if(loginUser != null){ %>
		<p>ログインに成功しました</p>
		<p>ようこそ<%= loginUser.getName() %>さん</p>
		
		<%--まだMain処理は作成していないため、現段階では404発生 --%>
		<a href = "/DocoTsubu2/Main">つぶやき投稿・閲覧</a>
		<% }else{ %>
		
		
		<%-- ログイン失敗時のHTML --%>
		<p>ログイン失敗しました</p>
		<a href="/DocoTsubu2/">TOPへ</a>
		<%} %>
	</body>
</html>