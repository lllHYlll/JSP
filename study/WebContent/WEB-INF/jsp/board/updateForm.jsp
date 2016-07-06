<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP & Servlet Study Community - updateForm.jsp</title>
</head>
<body>
	<h1>JSP & Servlet Study Community - updateForm.jsp</h1>

	<h2> 게시판 글쓰기</h2>
	
	<fieldset>
		<legend>게시판 글 쓰기</legend>
		<form action="/Board/UpdateOK" method="post">
			<input type="hidden" name="b_number" value="${update.number }">
			<p> 제목 : <input type="text" name="b_title" value="${update.title }"></p>
			<p> 글번호 : ${update.number} </p>
			<p> 조회수 : ${update.hit } &nbsp; &nbsp; / 작성일자 : ${update.date } </p>
			<p> 작성자 : ${name } </p>
			<p> 내용 : <textarea rows="20" cols="50" name="b_content"> ${update.content }</textarea></p>
			<input type="submit" value="글 수정"> <input type="reset" value="다시 쓰기">
		</form>
	</fieldset>
</body>
</html>