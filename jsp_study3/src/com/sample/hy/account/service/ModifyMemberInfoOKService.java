package com.sample.hy.account.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.hy.account.dao.MemberDAO;
import com.sample.hy.account.dto.MemberDTO;

public class ModifyMemberInfoOKService implements LoginService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("START : [ /ModifyMemberInfoOKService ]");
		
		String resultPath = "";
		HttpSession session = request.getSession();
		MemberDTO dto = null;
		MemberDAO dao = MemberDAO.getInstance();

		String id = (String) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		String pw = request.getParameter("m_pw");
		String age = request.getParameter("m_age");
		String gender = request.getParameter("m_gender");
		String introduce = request.getParameter("m_introduce");

		dto = new MemberDTO(id, pw, name, age, gender, introduce);
		
		dao.modifyMember(dto);

		resultPath = "/home/home";

		System.out.println("END : [ /ModifyMemberInfoOKService ]");
		return resultPath;
	}

}
