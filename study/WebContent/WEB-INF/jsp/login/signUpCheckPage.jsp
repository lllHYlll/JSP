<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP & Servlet Study Community - 가입입력확인</title>
</head>
<body>

	<h1>입력확인</h1>
	<form action="/Account/SignUpOK" method="post">
	아이디 :  ${member.id }				<input type="hidden" name="m_id" value="${member.id}"/><br/> 
										<input type="hidden" name="m_pw" value="${member.pw}">
	이름 : 	${member.name}				<input type="hidden" name="m_name" value="${member.name}" /><br/>
	나이 : 	${member.age}				<input type="hidden" name="m_age" value="${member.age}"/><br/>
	성별 : 	${member.gender}			<input type="hidden" name="m_gender" value="${member.gender}"/><br/>
	자기소개 :  ${member.introduce}		<input type="hidden" name="m_introduce" value="${member.introduce }"/><br/>
	
		<input type="submit" value="가입"/>
	</form>
</body>
</html>