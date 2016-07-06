package com.sample.hy.account.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutService implements LoginService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("START : [ /LogoutService ]");

		String resultPath = null;
		
		// 세션무효화
		HttpSession session = request.getSession();
		session.invalidate();
		
		resultPath = "/login/loginPage";

		System.out.println("END : [ /LogoutService ]");
		
		return resultPath;
	}

}
