<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<title>サンプルプログラム</title>
		</head>
		
		<body>
		
			<p>サンプルプログラム</p>
			
			<!-- リクエストパラメーターの送信先と、リクエスト方法を記述 -->
			<form action="/Web05/FormSampleServlet" method="post">
			
			<!-- リクエストパラメーター -->
			名前:<br>
			<input type="text" name="name"><br>
			
			<br>
			
			性別:<br>
			男<input type="radio" name="gender" value="0">
			女<input type="radio" name="gender" value="1">
			<br>
			<br>
			<input type ="submit" value="登録">
			
			</form>
		
		</body>
	</html>