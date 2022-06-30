<%@page import="model.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- taglibディレクティブでprefixとuriを設定する -->
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>自己紹介を返す</title>
	</head>
	
	<body>
		<p>
		${person.from}出身の${person.name}さん。こんにちは！<br>
		今度${person.hobby}しましょうね。
		</p>
		
		<%--もしも静岡出身なら --%>
		
		<a href="/Web12/selfintro">戻る</a>
	</body>
</html>