<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP & Servlet Study Community - readForm.jsp</title>
</head>
<body>
	<h1>JSP & Servlet Study Community - readForm.jsp</h1>
	
	<p>게시글 번호 : ${read.number }</p>
	<p>작성자 : ${read.writer }</p>
	<p>글 제목 : ${read.title }</p>
	<p>조회수 : ${read.hit}</p>
	<p>작성일자 : ${read.date}</p>
	<p>작성내용 : ${read.content}</p>
	<hr>
	<a href="/Board/UpdateForm?number=${read.number}">수정하기</a> &nbsp; &nbsp;
	<a href="/Board/DeleteBoard?number=${read.number}">삭제하기</a> &nbsp; &nbsp;
	<a href="/Board/ReplyForm?number=${read.number}">답변글 쓰기</a> &nbsp; &nbsp;
	<a href="/Board/BoardHome">목록으로</a>
	
	
	
</body>
</html>