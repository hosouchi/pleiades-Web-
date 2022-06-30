<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="ex.*" %>
    
<%

//インスタンス生成
Employee emp = new Employee("001","湊雄輔");

%>
   
    
<!DOCTYPE html>

	<html>
		<head>
			<meta charset="UTF-8">
			<title>練習4-1</title>
		</head>
		
		<body>
		
			<% for(int i = 0; i<10; i++){	//10回繰り返し
				
				//3で割って余りが0の時は赤色にする
				if(i % 3 == 0){%>	
				<p style="color:red">
				
				<%}else{%>
					<p>
					<%} %>
				
				IDは<%=emp.getId() %>、名前は<%=emp.getName() %>。</p>
			<%} %>
		
		</body>
	</html>