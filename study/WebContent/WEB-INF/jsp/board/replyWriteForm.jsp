<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP & Servlet Study Community - replyWriteForm.jsp</title>
</head>
<body>
	<h1>JSP & Servlet Study Community - replyWriteForm.jsp</h1>
	<h2> 게시판 답변글 쓰기</h2>
	
	<h3>${reply.number} 번글 에 대한 답변글 작성란입니다.</h3>
	<fieldset>
		<legend>게시판 답변글 쓰기</legend>
		<form action="/Board/ReplyOK" method="post">
			<input type="hidden" name="b_number" value="${reply.number}">
			<input type="hidden" name="b_writer" value="${reply.writer}">
			<input type="hidden" name="b_group" value="${reply.group}">
			<input type="hidden" name="b_depth" value="${reply.depth}">
			<input type="hidden" name="b_indent" value="${reply.indent}">
			
			<p> 제목 : <input type="text" name="b_title" value="${reply.title}"></p>
			<p> 작성자 : ${reply.writer} </p>
			<p> 내용 : <textarea rows="20" cols="50" name="b_content"> 글을 작성해 주세요 ! </textarea></p>
			<input type="submit" value="답변글 작성"> <input type="reset" value="다시 쓰기">
		</form>
	</fieldset>

</body>
</html>