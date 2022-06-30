<%--ログイン画面を出力するビュー --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>スッキリ商店：ログインページ</title>
	</head>
	
	<body>
		<h3 style="color:white; background-color:lime;">スッキリ商店：ログイン画面</h3>
		
		<form action ="/sukkiriShop/LoginServlet" method = "post">
		ユーザーID：<input type="text" name ="userid"><br>
		パスワード：<input type="password" name ="pass"><br>
		<input type="submit" value="ログイン">
		</form>
		
	</body>
</html>