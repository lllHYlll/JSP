<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP & Servlet Study Community - 회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<fieldset>
		<legend>JSP & Servlet Study Community - 회원가입</legend>
		<form action="/Account/SignUpCheck" method="post" id="signUp">
			아이디 : <input type="text" name="m_id"><br/>
			패스워드 : <input type="password" name="m_pw"><br/>
			이름 : <input type="text" name="m_name" placeholder="ex)Sara"><br/>
			나이 : <input type="number" name="m_age"/><br/>
			성별 : <input type="radio" name="m_gender" value="남자" checked="checked"/> 남자 
					 <input type="radio" name="m_gender" value="여자"/> 여자<br/>
			자기소개 : <textarea rows="4" cols="30" name="m_introduce">간단히 자기 소개 부탁드립니다.</textarea><br/>
			<input type="submit" value="확인"/><br/>
			<input type="reset" value="다시 작성"/>
		</form>
	</fieldset>
	
	<!-- jQuery로 폼 값 유효성 체크 -->
	<script type="text/javascript" src="/asset/jQuery/jquery-3.0.0.min.js"></script>
	<script>
		$(function(){
			$('#signUp').submit(function(){
			var id = $('input[name="m_id"]').val();										// 아이디
				var pw = $('input[name="m_pw"]').val();								// 패스워드
				var name = $('input[name="m_name"]').val();						// 이름
				var age = $('input[name="m_age"]').val();							// 나이
				var introduce = $('textarea[name="m_introduce"]').val();		// 자기소개
				
				if( !id ){
					alert("아이디를 입력하세요");
					return false;
				}
				if( id.length > 40){
					alert("아이디는 40글자제한입니다.");
					return false;
				}
				if( !pw ){
					alert("비밀번호를 입력하세요");
					return false;
				}
				if( pw.length > 20){
					alert("비밀번호는 20글자제한입니다.");
					return false;
				}
				
				if( !name ){
					alert("이름을 입력하세요");
					return false;
				}
				if( name.length > 20){
					alert("이름은 20글자제한입니다.");
					return false;
				}
				if( !age ){
					alert("나이를 입력하세요");
					return false;
				}
				if( age.length > 3){
					alert("나이는100살제한입니다.");
					return false;
				}
				if( !introduce ){
					alert("자기소개를 입력하세요");
					return false;
				}
				if( introduce.length > 100){
					alert("자기소개는 100글자제한입니다.");
					return false;
				}
				
			});
		});
	</script>
	
</body>
</html>