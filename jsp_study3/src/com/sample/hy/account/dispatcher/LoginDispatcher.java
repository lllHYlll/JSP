package com.sample.hy.account.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.hy.account.service.LoginOKService;
import com.sample.hy.account.service.LoginService;
import com.sample.hy.account.service.LogoutService;
import com.sample.hy.account.service.ModifyMemberInfoOKService;
import com.sample.hy.account.service.ModifyMemberInfoService;
import com.sample.hy.account.service.SignUpCheckService;
import com.sample.hy.account.service.SignUpOKService;

/*
 * 로그인에 관여하는 Dispatcher Servlet
 */
@WebServlet("/Account/*")
public class LoginDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginDispatcher() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		
		LoginService service = null;
		
		String uri = request.getRequestURI();							// 요청받은 URI
		String contextPath = request.getContextPath();			// 요청받은 ContextPath
		String filePath = uri.substring(contextPath.length());	// 요청받은 File 이름
		String prefix = "/WEB-INF/jsp";	
		String surfix = ".jsp";
		String viewPage = "";
		
		System.out.println(uri);
		switch(filePath){
		case "/Account/Login":
			viewPage = "/login/loginPage";
			break;
		case "/Account/LoginOK":
			service = new LoginOKService();
			viewPage = service.execute(request, response);
			break;
		case "/Account/SignUp":
			viewPage = "/login/signUpPage";
			break;
		case "/Account/SignUpCheck":
			service = new SignUpCheckService();
			service.execute(request, response);
			viewPage = "/login/signUpCheckPage";
			break;
		case "/Account/SignUpOK":
			service = new SignUpOKService();
			service.execute(request, response);
			viewPage = "/login/loginPage";
			break;
		case "/Account/ModifyMemberInfo":
			service = new ModifyMemberInfoService();
			viewPage = service.execute(request, response);
			break;
		case "/Account/ModifyMemberOK":
			service = new ModifyMemberInfoOKService();
			viewPage = service.execute(request, response);
			break;
		case "/Account/Logout":
			service = new LogoutService();
			viewPage = service.execute(request, response);
			break;
		}
		
//		System.out.println("uri : " + uri);
//		System.out.println("contextPath : " + contextPath);
//		System.out.println("filePath  : " + filePath);
//		System.out.println("viewPage : " + viewPage);
		
		viewPage = prefix + viewPage + surfix;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
