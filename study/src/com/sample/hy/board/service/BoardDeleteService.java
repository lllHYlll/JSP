package com.sample.hy.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.hy.board.dao.BoardDAO;

public class BoardDeleteService implements BoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("doAction - BoardDelete");
		String resultPath = "";
		String b_number = request.getParameter("number");

		BoardDAO dao = BoardDAO.getInstance();
		dao.deleteArticle(b_number);

		resultPath = "/boardHome";
		return resultPath;
	}

}
