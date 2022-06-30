<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>画像アップローダー：入力フォーム</title>
	</head>
	
	<body>
		<h3 style="color:white; background-color:green">画像アップローダー：入力フォーム予定</h3>
		<form action="/kawaren/imgupload" method="post" enctype="multipart/form-data">
		
		<table>
			<tr><td>投稿者名：</td><td><input type="text" name="cont"></td></tr>
			<tr><td>コメント：</td><td><textarea rows="3" cols="30" name="comment"></textarea></td></tr>
			<tr><td>画像ファイル：</td><td><input type="file" name="imgfile" accept="image/jpeg" ></td></tr>
			<tr><td colspan="2" align="right"><input type="submit" value="画像を送信"></td></tr>
		</table>
		
		</form>
	</body>
	
</html>