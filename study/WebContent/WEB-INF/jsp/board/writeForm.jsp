<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP & Servlet Study Community - writeForm</title>
</head>
<body>
	<h1>JSP & Servlet Study Community - writeForm.jsp</h1>
	<h2> 게시판 글쓰기</h2>
	
	<fieldset>
		<legend>게시판 글 쓰기</legend>
		<form action="/Board/WriteOK" method="post" id="writeOK">
			<p> 제목 : <input type="text" name="b_title"></p>
			<p> 작성자 : ${name } </p>
			<p> 내용 : <textarea rows="20" cols="50" name="b_content"> 글을 작성해 주세요 ! </textarea></p>
			<input type="submit" value="글 작성"> <input type="reset" value="다시 쓰기">
		</form>
	</fieldset>
	
	<!-- jQuery로 폼 값 유효성 체크 -->
	<script type="text/javascript" src="/asset/jQuery/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="/asset/jQuery/jquery.validate.min.js"></script>
	<script>
		$().ready(function(){
			$('#writeOK').validate({
				onfocusout : false,
				rules : {
					b_title :{ required : true, rangelength : [1, 30]},
					b_content : {required : true, rangelength : [1, 300] },
				},
				messages : {
					b_title : {
						required : "제목을 입력하세요.", 
						rangelength : $.validator.format('제목은 최소 1자에서 최대 30자 까지입니다.')
						},
					b_content : { 
						required : "글 내용을 입력하세요", 
						rangelength : $.validator.format('글 내용은 최소 1자에서 최대 300자 까지입니다.')
						},
					}
			});
		});
		
	</script>
	
</body>
</html>