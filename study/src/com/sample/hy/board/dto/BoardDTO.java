package com.sample.hy.board.dto;

import java.sql.Timestamp;

public class BoardDTO {
	
	/*
	 *  DB의 필드항목 Getter / Setter 선언
	 */
	
	private int number;			// 글 번호
	private String title;				// 글 제목
	private String writer;			// 글 작성자
	private String content;		// 글 내용
	private int hit;					// 조회수 default = 0;
	private Timestamp date;		// 작성일자
	private int group;				// 리플 - 원본글과 그룹핑
	private int depth;				// 리플 - 글의 깊이
	private int indent;				// 리플 - 출력 인덴트

	public BoardDTO() {
	}
	
	public BoardDTO(int number, String title, String writer, String content, int hit, Timestamp date, int group, int depth, int indent) {
		this.number = number;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.hit = hit;
		this.date = date;
		this.group = group;
		this.depth = depth;
		this.indent = indent;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}
	
	
	

}
