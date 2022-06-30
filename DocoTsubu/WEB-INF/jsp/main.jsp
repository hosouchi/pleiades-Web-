<%@page import="model.Mutter"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%
	//ログイン中のユーザーを取得する
	//User loginUser = (User)session.getAttribute("loginUser");

	//EL式で直接取得するため不要
	//アプリケーションスコープからつぶやきリストを取得する
	//List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
	
	//リクエストスコープから、エラーメッセージを取得する
	//String errMsg = (String)request.getAttribute("errMsg");
%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>どこつぶ</title>
	</head>
	
	<body>
		<h1>どこつぶメイン</h1>
		
		<p>
		<%--<%=loginUser.getName()さんログイン中--%>
		<c:out value="${loginUser.name}さんログイン中"/>
		<a href = "/DocoTsubu/Logout">ログアウト</a>
		</p>
		
		<!-- 最新のつぶやきリストを取得させる -->
		<p><a href = "/DocoTsubu/Main">更新</a></p>
		
		<!-- つぶやき入力 -->
		<form action="/DocoTsubu/Main" method= "post">
			<input type = "text" name = "text">
			<input type = "submit" value = "つぶやく">
		</form>
		
		<!-- エラーメッセージを表示 -->
		<!-- スコープからインスタンスを取得できたらnullではないはずだ！ -->
		<%-- 
		<% if(errMsg != null){ %>
		<p style="color:red;"><strong><%= errMsg %></strong></p>
		<%} %>
		--%>
		<c:if test="${not empty errMsg}">
			<p style ="color:red;"><b><c:out value="${errMsg}"/></b></p>
		</c:if>
		
		<!-- つぶやきリストを表示 -->
		<!-- 拡張for文でつぶやきを1件ずつ取得 -->
		
		<%-- 
			forEachタグを使用するため、変更する
		<% for(Mutter mutter : mutterList){ %>
		<p><%= mutter.getUserName() %>:<%= mutter.getText() %></p>
		<%} %>
		--%>
		
		<%--アプリケーションスコープに保存されているmutterListからMutterインスタンスを一つずつ取り出す --%>
		
		<c:forEach var="mutter" items="${mutterList}">
			
			<%--変数mutterにはMutterインスタンスが格納される --%>
			<%--Mutterインスタンスは... --%>
			<p>
				<c:out value="${mutter.userName}"/>
				:
				<c:out value="${mutter.text }"/>
			</p>
		
		</c:forEach>	
			
	</body>
</html>