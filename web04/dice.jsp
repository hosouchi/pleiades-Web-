<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//1-6の乱数を発生させる
	int dice1 = new java.util.Random().nextInt(6)+1;
	int dice2 = new java.util.Random().nextInt(6)+1;
	int dice3 = new java.util.Random().nextInt(6)+1;
	
	//運勢メッセージと回数の表示用関数
	String msg = null;
	int count = 1;
	
%>

<!DOCTYPE html>
<html>
	
	<head>
	<meta charset="UTF-8">
	<title>練習問題1</title>
	</head>
	
	<body>
	
	<table border = "1">
		
		<tr>
			<th>回数</th>
			<th>乱数1</th>
			<th>乱数2</th>
			<th>乱数3</th>
		</tr>
		
		<tr>
			<td><%=count %></td>
			<td><%=dice1 %></td>
			<td><%=dice2 %></td>
			<td><%=dice3 %></td>
		</tr>
		
		<%--3つのサイコロが1以外の時にループさせる--%>
		<% while(!(dice1 == 1 && dice2 == 1 && dice3 == 1)){
		%>
		<% count++;%>
		
		<tr>
			<td><%=count %></td>
			<td><%=dice1 = new java.util.Random().nextInt(6)+1%></td>
			<td><%=dice2 = new java.util.Random().nextInt(6)+1%></td>
			<td><%=dice3 = new java.util.Random().nextInt(6)+1%></td>
			
		</tr>
			
		<%} %>
		
		<% 
		//ループを抜けて運勢を表示させる
		if(count<50){
			msg = "ラッキー";
		}else if(count<=100){
			msg = "まぁまぁラッキー";
		}else if(count>=200){
			msg = "残念";
		}else{
			msg = "普通";
		}
		%>
	</table>
	
	<br>
	すべてのサイコロが1になるまでにかかった回数は<%=count %>でした。
	<br>
	あなたの運勢は<%=msg %>
	
	</body>
	
</html>