package com.sample.hy.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.hy.board.dao.BoardDAO;

public class BoardUpdateOKService implements BoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("doAction - BoardUpdateOK");
		String resultPath = "";
		
		String b_number = request.getParameter("b_number");
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		System.out.println("bNum : " + b_number);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.updateOKArticle(b_number, b_title, b_content);
		
		resultPath = "/boardHome";
		
		return resultPath;
	}

}
