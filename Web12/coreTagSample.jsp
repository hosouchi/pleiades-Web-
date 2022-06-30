<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%-- jspファイルを記述していく前に、taglibディレクティブを記述する --%>
<%-- これから便利なアクションタグを使っていくよ～ --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Coreタグサンプル</title>
	</head>
	
	<body>
		<%--<c:set>を使う。javaでいう変数宣言。var属性が変数名　value属性が値 --%>
		<c:set var="data" value="<h1>こんにちは</h1>" />
		
		<%--1.EL式でdataを取り出す --%>
		<p>①EL式： ${data}</p>
		
		<%--2.<c:out>を使う。value属性に取り出したい値のEL式を書く。サニタイジング対策 --%>
		<p>②c:out:<c:out value="${data}"/></p>
		
		<hr>
		
		<%--3.<c:if> --%>
		<%--test属性に条件式を記述。javaでいうelseがないif文 --%>
		<c:set var="greeting" value="こんにちは"/>
		<p><c:out value="${greeting}"/></p>
		
							<!-- ↓javaで使った条件演算式が使用できる -->
		<c:if test="${greeting == 'こんにちは'}">
			<!-- ここに合致したときの処理を書いていく -->
			<p>おなかすいたー</p>
		</c:if>
		
		<hr>
		
		<%--<c:choose> --%>
		<%--javaでいう「if-else-if構文」 --%>
		<%--<c:choose>という全体の中に色々書いていく --%>
		
		<c:set var="age" value="9"/>
		
		<c:choose>
			<%--0~9 --%>
			<c:when test="${age<10 }">
				<p><c:out value="${age}"/>歳のあなたは「ちっす」です</p>
			</c:when>
		
			<%--10~19→10代 --%>
			<c:when test="${age<20 }">
				<p><c:out value="${age}"/>歳のあなたは「10代」です</p>
			</c:when>
			
			<%--20~29→20代 --%>
			<c:when test="${age<30 }">
				<p><c:out value="${age}"/>歳のあなたは「20代」です</p>
			</c:when>
			
			<%--30~39→30代 --%>
			<c:when test="${age<40 }">
				<p><c:out value="${age}"/>歳のあなたは「30代」です</p>
			</c:when>
			
			<%--40~49→40代 --%>
			<c:when test="${age<50 }">
				<p><c:out value="${age}"/>歳のあなたは「40代」です</p>
			</c:when>
			
			<%--50~59→50代 --%>
			<c:when test="${age<60 }">
				<p><c:out value="${age}"/>歳のあなたは「50代」です</p>
			</c:when>
			
			<%--その他→ちっす --%>
			<c:otherwise>
				<p><c:out value="${age}"/>歳のあなたは「ちっす」です</p>
			</c:otherwise>
			
		</c:choose>
		
		<hr>
		
		<%--<c:forEach> --%>
		<%--javaでいうfor文です --%>
		<%--通常のfor文を紹介。var属性→int iみたいなもの --%>
		<%--begin属性→i=0; 0のこと（初期値） --%>
		<%--end属性→i <= 9; ★9のこと★　ややこしい--%>
		<%--step属性→i++ のこと --%>
		
		<c:forEach var="i" begin="1" end="9" step="1">
		
			<%--変数iをhtmlで出力 --%>
			<p>forEach:<c:out value="${i}"/></p>
			
		</c:forEach>
		
		<hr>
		
		
	</body>
</html>