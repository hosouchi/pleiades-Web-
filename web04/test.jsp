<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- JSPファイルでのクラスのインポート方法 --%>
<%@ page import = "java.util.ArrayList,java.util.Date" %>

<%
	String name = "細内";

	int a = 10;
	int b = 15;
	int c = a*b;

%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>JSPテスト中</title>
	</head>
	<body>
	
		<% for(int i = 0; i<10; i++) {%>
		
		//この中はJavaコードのため、javaのコメントの書き方を使用できる
			<%= name %>
		<% }%> 
		
	</body>
</html>