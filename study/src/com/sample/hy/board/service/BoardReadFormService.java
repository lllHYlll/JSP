package com.sample.hy.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.hy.board.dao.BoardDAO;
import com.sample.hy.board.dto.BoardDTO;

public class BoardReadFormService implements BoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		String resultPath = "";
		String b_number = request.getParameter("number");

		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.readArticle(b_number);
		request.setAttribute("read", dto);

		resultPath = "/readForm";
		return resultPath;
	}

}
