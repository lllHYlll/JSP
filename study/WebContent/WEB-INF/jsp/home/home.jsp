<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	

	<h1>Home.jsp Page</h1>
	
	<nav>
		<a href="http://www.google.com">Google</a>
		<a href="http://www.naver.com">Naver</a>
		<a href="http://www.daum.net">Daum</a>
		<a href="/Board/BoardHome">게시판</a>
	</nav>
	
	<h3>안녕하세요 ~ ${name}님</h3>
	
	<form action="/Account/ModifyMemberInfo" method="post">
		<input type="submit" value="개인정보수정"/>
	</form>
	
	<a href="/Account/Logout"> LogOut </a>
</body>
</html>