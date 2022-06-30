<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import= "dto.*" %>
<%@ page import= "read.ReadPrefsFile" %>
<%@ page import= "java.util.List" %>
    
    
 <%
 	List<Pref> pf = ReadPrefsFile.readPrefs();
 %>
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>練習問題2</title>
	</head>
	
	<body>
	
	<table border = "1">
	
		<tr>
			<th>コード</th>
			<th>地名</th>
			<th>県名</th>
			<th>県庁所在地</th>
			<th>面積</th>
		</tr>
		
		<%for(int i = 0; i < pf.size(); i++){ %>
			<tr>
				<td><%=pf.get(i).getCode() %></td>
				<td><%=pf.get(i).getRegion() %></td>
				<td><%=pf.get(i).getPrefName() %></td>
				<td><%=pf.get(i).getPrefCapital() %></td>
				<td><%=pf.get(i).getArea() %></td>
			</tr>	
		<%} %>
	
	</table>
	
	</body>
</html>