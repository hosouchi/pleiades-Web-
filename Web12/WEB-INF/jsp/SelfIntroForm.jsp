<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>自己紹介入力画面</title>
	</head>
	
	<body>
		
		<form action ="/Web12/selfintro" method="post">
		名前：<input type="text" name="name"><br>
		出身地：<input type="text" name="from"><br>
		趣味：<input type="text" name="hobby"><br>
		<input type = "submit" value="決定">
		</form> 
		
	</body>
</html>