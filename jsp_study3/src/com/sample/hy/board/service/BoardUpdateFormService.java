package com.sample.hy.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.hy.board.dao.BoardDAO;
import com.sample.hy.board.dto.BoardDTO;

public class BoardUpdateFormService implements BoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("doAction - BoardUpdateForm");
		String resultPath = "";

		String b_number = request.getParameter("number");
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.updateForm(b_number);

		request.setAttribute("update", dto);
		
		resultPath = "/updateForm";
		return resultPath;
	}
}
