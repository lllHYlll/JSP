<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP & Servlet Study Community - Login</title>
<link href="/asset/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<link href="/asset/custom/css/signin.css" rel="stylesheet">
</head>


<body>

<div class="container">

      <form class="form-signin" action="/Account/LoginOK" method="post">
        <h2 class="form-signin-heading">Welcome to My Page</h2>
        <label for="memberName" class="sr-only">Email address</label>
        <input type="text" id="memberName" class="form-control" name="m_id" placeholder="Input your ID" required autofocus>
        <label for="memberPassword" class="sr-only">Password</label>
        <input type="password" id="memberPassword" class="form-control" name="m_pw" placeholder="Input your Password" required>

        <button type="submit" class="btn btn-lg btn-primary btn-block" >Sign in</button>
        <a  href="/Account/SignUp" class="btn btn-lg btn-success btn-block" >Sign up</a>
      </form>
	
    </div>
</body>
</html>