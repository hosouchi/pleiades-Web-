<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page language="java" pageEncoding="UTF-8"%>

<%

//現在時刻を取得
Date now = new Date();

//現在時刻を文字列へ変換
SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

//現在時刻を文字列へ変換
String nowStr = sdf.format(now);

%>

