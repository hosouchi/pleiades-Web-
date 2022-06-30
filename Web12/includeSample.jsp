<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>インクルードサンプル</title>
	</head>
	
	<body>
		<p>こんにちは</p>
		
		<%--includeSampleFooter.jspを取り込む --%>
		
		<%
			RequestDispatcher dispatcher = request.getRequestDispatcher("/includeSampleFooter.jsp");
			dispatcher.include(request, response);
		%>
	</body>
</html>