<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ex.Fruit" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>練習12-2</title>
		</head>
		
		<body>
			<p>
			<c:out value="${fruit.name}の値段は${fruit.price}です"/>
			</p>
		</body>
	</html>