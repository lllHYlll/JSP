package com.sample.hy.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.hy.board.dao.BoardDAO;
import com.sample.hy.board.dto.BoardDTO;

public class BoardReplyFormService implements BoardService {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("doAction - BoardReplyForm");
		String resultPath = "";
		
		String b_number = request.getParameter("number");
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.readArticle(b_number);

		request.setAttribute("reply", dto); // 게시글 정보를 넘겨준다 -> 답변글작성폼

		resultPath = "/replyWriteForm";
		return resultPath;
	}

}
