package com.sample.hy.board.service;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.hy.board.dao.BoardDAO;
import com.sample.hy.board.dto.BoardDTO;

public class BoardHomeService implements BoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("doAction - BoardHome");
		String resultPath = "";

		BoardDAO dao = BoardDAO.getInstance();
		List<BoardDTO> dtos = dao.listArticle();

		request.setAttribute("list", dtos);

		resultPath = "/boardHome";
		return resultPath;
	}

}
