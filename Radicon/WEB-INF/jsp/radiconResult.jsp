<%@page import="model.Radix"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	//リクエストスコープからradixインスタンスを取り出す
	Radix radix = (Radix)request.getAttribute("radix");

	//リクエストスコープからエラーメッセージを取り出す
	String errMsg = (String)request.getAttribute("errMsg");

%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>Radicon</title>
		</head>
		
		<body>
		
			<%if(radix !=null){ %>
			<p>
				10進数：<%= radix.getDecimal() %><br>
				 2進数：<%= radix.getBinary()%><br>
				 8進数：<%= radix.getOct() %><br>
				16進数：<%= radix.getHex() %><br>
			</p>
			<%}else{ %>
			<p><%=errMsg %></p>
			<%} %>
			<a href="/Radicon/radiconservlet">戻る</a>
			
		</body>
	</html>
	