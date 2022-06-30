<%@page import="model.EvMsgLogic"%>
<%@page import="model.SiteEV"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
SiteEV siteEV = (SiteEV) application.getAttribute("siteEV");
String evMsg = (String) application.getAttribute("evMsg");

%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>いいね・よくないねのサンプルプログラム</title>
		</head>
		
		<body>
			<h1>細内のページへようこそ</h1>
			
			<p>
			<!-- いいね・よくないね表示 -->
			<a href="/Web09/MinatoIndex?action=like">いいね</a>
			<%= siteEV.getLike() %>人
			<a href="/Web09/MinatoIndex?action=unlike">よくないね</a>
			<%= siteEV.getUnlike() %>人
			</p>
			<%=evMsg%>
			
			<h2>湊くんとは？</h2>
		</body>
	</html>