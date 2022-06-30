<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="ex.Fruit" %>
<% 
	//セッションスコープへ保存された、Fruitインスタンスを取得する
	Fruit fruit = (Fruit)session.getAttribute("fruit");  
%>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>練習8-2</title>
		</head>
		
		<body>
		
			<P><%=fruit.getName() %>の値段は<%=fruit.getPrice() %></P>
		</body>
	</html>