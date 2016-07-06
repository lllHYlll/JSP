package com.sample.hy.account.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.hy.account.dao.MemberDAO;
import com.sample.hy.account.dto.MemberDTO;

public class ModifyMemberInfoService implements LoginService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("START : [ /ModifyMemberInfo]");
		
		String resultPath = "";

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = dao.FindMemberInfoByID(id);
		request.setAttribute("memberInfo", dto);

		resultPath = "/login/modifyMemberPage";

		System.out.println("END : [ /ModifyMemberInfo ]");

		return resultPath;
	}

}
