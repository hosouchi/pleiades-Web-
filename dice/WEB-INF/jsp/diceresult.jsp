<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ダイス。結果画面を表示</title>
	</head>
	
	<body>
		<h1>ダイス</h1>
		<%--スコープに保存されているdicesの個数を取得する --%>
		<p>計 ： <c:out value="${dices.size()}"/>回</p>
		
		<%--デフォルトページだから/diceのあとにindex.jspを入力しなくて良い --%>
		<p><a href="/dice/">戻る</a></p>
		
		<%--サイコロ履歴を出力 --%>
		<table border="1">
			
			<%--項目行 --%>
			<tr>
				<th>回数</th>
				<th>サイコロ1</th>
				<th>サイコロ2</th>
				<th>サイコロ3</th>
			</tr>
			
			<%-- データ行はまだどのくらいになるのか分からない。dicesの個数分出力--%>
			<%-- 拡張for文を使用してみる→ループが現在何週目か分からないから新しく作ろう --%>
			<%-- 
			<c:set var="i" value="0"/>
			<c:forEach var="" items="${dices}">
				<c:set var="i" value="${i+1 }"/>
			--%>
			
			<%-- 通常のfor文を使用 --%>
			<c:forEach var="i" begin="0" end="${dices.size()-1}" step="1">
				<tr>
				
				<%--1列目 --%>
				<td><c:out value="${i+1}"/></td>
				
				<%--2列目 --%>
				<c:choose>
					<c:when test="${dices[i].dice1 == 1}">
					<td style="color:red; background-color:yellow;"><c:out value="${dices[i].dice1}"/></td>
					</c:when>
					<c:otherwise>
						<td><c:out value="${dices[i].dice1}"></c:out>
					</c:otherwise>
				</c:choose>
			
				<%--3列目 --%>
				<c:choose>
					<c:when test="${dices[i].dice2 == 1}">
					<td style="color:red; background-color:yellow;"><c:out value="${dices[i].dice2}"/></td>
					</c:when>
					<c:otherwise>
						<td><c:out value="${dices[i].dice2}"></c:out>
					</c:otherwise>
				</c:choose>
				
				<%--4列目 --%>
				<c:choose>
					<c:when test="${dices[i].dice3 == 1}">
					<td style="color:red; background-color:yellow;"><c:out value="${dices[i].dice3}"/></td>
					</c:when>
					<c:otherwise>
						<td><c:out value="${dices[i].dice3}"></c:out>
					</c:otherwise>
				</c:choose>
	
				</tr>
				
			</c:forEach>
			
		</table>
	</body>
</html>