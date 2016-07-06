package com.sample.hy.board.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sample.hy.board.dao.BoardDAO;
import com.sample.hy.board.dto.BoardDTO;

public class BoardWriteOKService implements BoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		BoardDTO dto = new BoardDTO();
		BoardDAO dao = BoardDAO.getInstance();

		dto.setTitle(request.getParameter("b_title"));
		dto.setWriter((String) session.getAttribute("name"));
		dto.setContent(request.getParameter("b_content"));
		dto.setDate(new Timestamp(System.currentTimeMillis()));

		dao.insertArticle(dto);
		return "";
	}

}
