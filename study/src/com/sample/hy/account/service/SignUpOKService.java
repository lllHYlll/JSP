package com.sample.hy.account.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.hy.account.dao.MemberDAO;
import com.sample.hy.account.dto.MemberDTO;

public class SignUpOKService implements LoginService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("START : [ /SignUpOKService]");

		// signUpCheckPage.jsp 에서 넘어온 값 저장
		String id = request.getParameter("m_id");
		String pw = request.getParameter("m_pw");
		String name = request.getParameter("m_name");
		String age = request.getParameter("m_age");
		String gender = request.getParameter("m_gender");
		String introduce = request.getParameter("m_introduce");

		// DTO 객체에 저장
		MemberDTO dto = new MemberDTO(id, pw, name, age, gender, introduce);

		MemberDAO dao = MemberDAO.getInstance();
		dao.insertMember(dto);
		
		System.out.println("END : [ /SignUpOKService ]");

		return "";

	}

}
