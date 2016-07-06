package com.sample.hy.board.service;

import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.hy.board.dao.BoardDAO;

public class BoardReplyOKService implements BoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("doAction - BoardReplyOK");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		//replyWriteForm.jsp 에서 넘어온 값
		String b_number = request.getParameter("b_number");
		String b_writer = request.getParameter("b_writer");
		String b_title = request.getParameter("b_title");
		String b_content = request.getParameter("b_content");
		String b_group = request.getParameter("b_group");
		String b_depth = request.getParameter("b_depth");
		String b_indent = request.getParameter("b_indent");
		
		Timestamp b_date = new Timestamp(System.currentTimeMillis());
		dao.replyInsertArticle(b_number, b_writer, b_title, b_content, b_date, b_group, b_depth, b_indent);

		return "";
	}

}
