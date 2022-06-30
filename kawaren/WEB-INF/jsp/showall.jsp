<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>画像ダウンローダ。全投稿をリストで見る。</title>
	</head>
	
	<body>
		<h3 style="color:white; background-color:mediumslateblue;">画像アップローダ：全投稿リスト</h3>
		
		<table border="1">
			<tr><th>画像のファイル名</th><th>投稿者名/コメント</th></tr> <!-- これはタイトル行 -->
			
			<c:forEach var="bean" items="${list}">	<%--t_imgテーブルの行数分繰り返し --%>
				<tr>
					<td rowspan="2"><img src="http://localhost:8080/kawaren/imgdownload?filename=${bean.filename}"width="300" height="300"></td>
					<td>${bean.cont}</td>
				</tr> 
				<tr><td>${bean.comment}</td></tr>
			</c:forEach>
		</table>
		
	</body>
</html>