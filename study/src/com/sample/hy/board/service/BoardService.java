package com.sample.hy.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardService {
	
	String execute(HttpServletRequest request, HttpServletResponse response);

}
