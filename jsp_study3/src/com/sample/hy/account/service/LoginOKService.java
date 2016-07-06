package com.sample.hy.account.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.hy.account.dao.MemberDAO;
import com.sample.hy.account.dto.MemberDTO;

public class LoginOKService implements LoginService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("START : [ /LoginOKService ]");
		
		String id, pw;					// 입력한 아이디, 비밀번호
		int loginCheck;				// 로그인 성공시 = 1, 비밀번호 불일치 = 0, 아이디가 없을시 = -1;
		String resultPath = "";		// 반환주소값
		
		HttpSession session = request.getSession();
		
		id = request.getParameter("m_id");
		pw = request.getParameter("m_pw");
		
		MemberDAO dao = MemberDAO.getInstance();
		Map<String, Object> resultMap = dao.LoginCheck(id, pw);
		pw = "";																							//비밀번호 초기화
		loginCheck = (int) resultMap.get("resultCheck");
		MemberDTO dto = new MemberDTO();
		dto =  (MemberDTO) resultMap.get("resultDTO");
		
		// 로그인 성공시 세션에 정보 저장
		if(loginCheck == 1){
			session.setAttribute("id", dto.getId());
			session.setAttribute("name", dto.getName());
			resultPath = "/home/home";
		} else {
			resultPath = "/login/loginPage";
		}
		System.out.println("END : [ /LoginOKService ]");
		return resultPath;
	}

}
