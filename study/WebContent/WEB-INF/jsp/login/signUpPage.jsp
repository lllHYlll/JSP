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
			패스워드확인 : <input type="password" name="m_pwChk" ><br/>
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
	<script type="text/javascript" src="/asset/jQuery/jquery.validate.min.js"></script>
	<script>
		$().ready(function(){
			$('#signUp').validate({
				onfocusout : false,
				rules : {
					m_id :{ required : true, rangelength : [2, 40]},
					m_pw : {required : true, rangelength : [5, 20] },
					m_pwChk : {required : true, rangelength : [5, 20], equalTo : '#m_pw'},
					m_name : { required : true, rangelength : [1, 20]},
					m_age : {required : true, range : [1, 120]},
					m_introduce : {required : true, rangelength : [1, 100]}
				},
				messages : {
					m_id : {
						required : "아이디를 입력하세요.", 
						rangelength : $.validator.format('아이디는 최소 2자에서 최대 40자 까지입니다.')
						},
					m_pw : { 
						required : "비밀번호를 입력하세요.", 
						rangelength : $.validator.format('비밀번호는 최소 5자에서 최대 20자 까지입니다.')
						},
					m_pwChk : {
						required : "비밀번호 확인란을 입력하세요.", 
						rangelength : $.validator.format('비밀번호 확인란은 최소 5자에서 최대 20자까지입니다.'), 
						equalTo : '비밀번호 항목과 일치하지 않습니다.'
						},
					m_name : {
						required : "이름을 입력하세요",
						rangelength : $.validator.format('이름은 최소 1자에서 최대 20자까지입니다.')
					},
					m_age : {
						required : "나이를 입력해주세요",
						range : $.validator.format("120살 까지 입력이 가능합니다.")
					},
					m_introduce : {
						required : "자기소개를 입력해주세요",
						rangelength : $.validator.format("자기소개는 최소 1자에서 100자까지입니다.")
					}
				}
			});
		});
		
	</script>
	
</body>
</html>