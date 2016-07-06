<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP & Servlet Study Community - 개인정보수정</title>
</head>
<body>

	<h1>개인정보수정</h1>
	<fieldset>
		<legend>JSP & Servlet Study Community - 회원가입</legend>
		<form action="/Account/ModifyMemberOK" method="post">
			아이디 : ${memberInfo.id }<br/>
			패스워드 : <input type="password" name="m_pw" ><br/>
			이름 : ${memberInfo.name }<br/>
			나이 : <input type="number" name="m_age" value="${memberInfo.age }"><br/>
			성별 : <input type="radio" name="m_gender" value="남자" checked="checked"> 남자 
					 <input type="radio" name="m_gender" value="여자"> 여자<br/>
			자기소개 : <textarea rows="4" cols="30" name="m_introduce" >${memberInfo.introduce }</textarea><br/>
			<input type="submit" value="확인"><br/>
			<input type="reset" value="다시 작성"/>
		</form>
	</fieldset>

</body>
</html>