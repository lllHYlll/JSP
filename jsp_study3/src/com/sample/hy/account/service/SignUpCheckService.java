package com.sample.hy.account.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.hy.account.dto.MemberDTO;

public class SignUpCheckService implements LoginService{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("m_id");
		String pw = request.getParameter("m_pw");
		String name = request.getParameter("m_name");
		String age = request.getParameter("m_age");
		String gender = request.getParameter("m_gender");
		String introduce = request.getParameter("m_introduce");
		
		MemberDTO dto = new MemberDTO(id, pw, name, age, gender, introduce);
		request.setAttribute("member", dto);
		
		return "";
	}

}
