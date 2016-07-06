package com.sample.hy.board.dispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.hy.board.service.BoardDeleteService;
import com.sample.hy.board.service.BoardHomeService;
import com.sample.hy.board.service.BoardReadFormService;
import com.sample.hy.board.service.BoardReplyFormService;
import com.sample.hy.board.service.BoardReplyOKService;
import com.sample.hy.board.service.BoardService;
import com.sample.hy.board.service.BoardUpdateFormService;
import com.sample.hy.board.service.BoardUpdateOKService;
import com.sample.hy.board.service.BoardWriteOKService;

/*
 * 게시판에 관여하는 Dispatcher Servlet
 */
@WebServlet("/Board/*")
public class BoardDispatcher extends HttpServlet {
	
	private String prefix = "/WEB-INF/jsp/board";
	private String surfix = ".jsp";
	private String viewPage = "";
	
	private static final long serialVersionUID = 1L;

	public BoardDispatcher() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doAction(request, response);
	}
	

	private void doAction(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		BoardService service = null;

		String uri = request.getRequestURI(); 						// 요청받은 URI
		String contextPath = request.getContextPath(); 				// 요청받은 ContextPath
		String filePath = uri.substring(contextPath.length()); 		// 요청받은 File 이름

		System.out.println(uri);
		switch (filePath) {
		case "/Board/BoardHome":
			service = new BoardHomeService();
			viewPage = service.execute(request, response); 			// boardHome.jsp
			forwardPage(viewPage, request, response);
			break;
		case "/Board/WriteForm":
			viewPage = "/writeForm";
			forwardPage(viewPage, request, response);
			break;
		case "/Board/WriteOK":
			service = new BoardWriteOKService();
			service.execute(request, response);
			response.sendRedirect("/Board/BoardHome");
			break;
		case "/Board/ReadForm":
			service = new BoardReadFormService();
			viewPage = service.execute(request, response);
			forwardPage(viewPage, request, response);
			break;
		case "/Board/UpdateForm":
			service = new BoardUpdateFormService();
			viewPage = service.execute(request, response);
			forwardPage(viewPage, request, response);
			break;
		case "/Board/UpdateOK":
			service = new BoardUpdateOKService();
			viewPage = service.execute(request, response);
			response.sendRedirect("/Board/BoardHome");
			break;
		case "/Board/DeleteBoard":
			service = new BoardDeleteService();
			viewPage = service.execute(request, response);
			response.sendRedirect("/Board/BoardHome");
			break;
		case "/Board/ReplyForm":
			service = new BoardReplyFormService();
			viewPage = service.execute(request, response);
			forwardPage(viewPage, request, response);
			break;
		case "/Board/ReplyOK":
			service = new BoardReplyOKService();
			service.execute(request, response);
			response.sendRedirect("/Board/BoardHome");
			break;
		}
		
	}
	
	/*
	 *  forward 메소드
	 */
	public void forwardPage(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		viewPage = prefix + viewPage + surfix;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
