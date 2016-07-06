package com.sample.hy.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sample.hy.board.dto.BoardDTO;

public class BoardDAO {
	
	/*
	 *  DB와의 연결 및 실질적인 로직 구현
	 */
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO(){
		
	}
	
	public static BoardDAO getInstance(){
		return instance;
	}
	
	/*
	 *  게시판 글 입력 메소드
	 */
	public void insertArticle(BoardDTO dto){
		
		int articleNumber = 0; 		// 글 번호
		String query = "";				// SQL 쿼리
		try{
			
			conn = getConnection();
			query = "SELECT MAX(b_number) FROM board";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if( rs.next()){
				articleNumber = rs.getInt(1) + 1; 		// 현재 최고번호의 +1
			}else{
				articleNumber = 1;								// 게시글이 없다면 1 부터 시작
			}
			
			query = "INSERT INTO board (b_number, b_title, b_writer, b_content, b_date, b_group) values (?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNumber);
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getWriter());
			pstmt.setString(4, dto.getContent());
			pstmt.setTimestamp(5, dto.getDate());
			pstmt.setInt(6, articleNumber);
			pstmt.executeUpdate();
			System.out.println("INSERT Success!");
		}catch(Exception e){
			System.out.println("INSERT Failed");
			e.printStackTrace();
		}finally{
			try{
				if ( rs != null) rs.close();
				if ( pstmt != null) pstmt.close();
				if( conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	/*
	 * 게시판 글 리스트 메소드
	 */
	public List<BoardDTO> listArticle(){
		//쿼리문 = 게시글은 최신글이 위로가게끔, 리플한 게시글 최근글이 위로 가게끔 작성
		// DESC -> 내림차순 , ASC -> 오름차순
		String query = "SELECT b_number, b_title, b_writer, b_hit, b_date, b_group, b_depth, b_indent FROM board ORDER BY b_group DESC, b_depth ASC";
		
		List<BoardDTO> dtos = new ArrayList<BoardDTO>();
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
				while(rs.next()){
					BoardDTO dto = new BoardDTO();
					dto.setNumber(rs.getInt("b_number"));
					dto.setTitle(rs.getString("b_title"));
					dto.setWriter(rs.getString("b_writer"));
					dto.setHit(rs.getInt("b_hit"));
					dto.setDate(rs.getTimestamp("b_date"));
					dto.setGroup(rs.getInt("b_group"));
					dto.setDepth(rs.getInt("b_depth"));
					dto.setIndent(rs.getInt("b_indent"));
					dtos.add(dto);
				}
		}catch(Exception e){
//			System.out.println("listArticle - Failed!");
			e.printStackTrace();
		}finally{
			try{
				if( rs != null) rs.close();
				if( pstmt != null) pstmt.close();
				if( conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	/*
	 *  게시판 글 수정 폼 메소드
	 */
	public BoardDTO updateForm(String num){
		String query = "SELECT * FROM board WHERE b_number =?";
		BoardDTO dto = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			if(rs.next()){
				dto = new BoardDTO();
				dto.setNumber(rs.getInt("b_number"));
				dto.setTitle(rs.getString("b_title"));
				dto.setWriter(rs.getString("b_writer"));
				dto.setContent(rs.getString("b_content"));
				dto.setHit(rs.getInt("b_hit"));
				dto.setDate(rs.getTimestamp("b_date"));
//				System.out.println("UPDATE FORM Success");
			}
		}catch(Exception e){
//			System.out.println("UPDATE FORM Failed");
		}finally{
			try{
				if( rs != null) rs.close();
				if( pstmt != null) pstmt.close();
				if( conn != null) conn.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	/*
	 * 게시판 글 수정완료 메소드
	 */
	public void updateOKArticle(String number, String title, String content){
		String query = "UPDATE board SET b_title = ?, b_content = ? WHERE b_number =?";
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, Integer.parseInt(number));
			pstmt.executeUpdate();
//			System.out.println("updateOKArticle() - Success");
		}catch(Exception e){
//			System.out.println("updateOKArticle() - Failed");
			e.printStackTrace();
		}finally{
			try{
				if ( pstmt != null ) pstmt.close();
				if ( conn != null ) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	/*
	 * 게시판 글 삭제 메소드
	 */
	public void deleteArticle(String number){
		String query = "DELETE FROM board WHERE b_number = ?";
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, number);
			pstmt.executeUpdate();
//			System.out.println("deleteArticle - Success");
		}catch(Exception e){
//			System.out.println("deleteArticle - Failed");
			e.printStackTrace();
		}finally{
			try{
				if ( pstmt != null ) pstmt.close();
				if ( conn != null ) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
	}
	
	/*
	 *  글 읽기 메소드
	 */
	public BoardDTO readArticle(String boardNum) {
		upHit(boardNum);		// 글 읽을 때 마다 조회수를 1씩 증가
		
		String query = "SELECT * FROM board WHERE b_number =?";
		BoardDTO dto = null;
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(boardNum));
			rs = pstmt.executeQuery();
			
			if( rs.next() ){
				int b_number = rs.getInt("b_number");
				String b_title = rs.getString("b_title");
				String b_writer = rs.getString("b_writer");
				String b_content = rs.getString("b_content");
				int b_hit = rs.getInt("b_hit");
				Timestamp b_date = rs.getTimestamp("b_date");
				int b_group = rs.getInt("b_group");
				int b_depth = rs.getInt("b_depth");
				int b_indent = rs.getInt("b_indent");
				
				dto = new BoardDTO(b_number, b_title, b_writer, b_content, b_hit, b_date, b_group, b_depth, b_indent);
//				System.out.println("readArticle() - Success");
			}
		}catch(Exception e){
//			System.out.println("readArticle() - Failed");
		}finally{
			try{
				if ( rs != null) rs.close();
				if( pstmt != null ) pstmt.close();
				if ( conn != null ) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return dto;
		
	}
	
	/*
	 * 조회수 증가 메소드
	 */
	private void upHit(String boardNum) {
		String query = "UPDATE board SET b_hit = b_hit + 1 WHERE b_number = ?";
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(boardNum));
			pstmt.executeUpdate();
//			System.out.println("upHit() - Success");
		}catch(Exception e){
//			System.out.println("upHit() - Success");
			e.printStackTrace();
		}finally{
			try{
				if ( pstmt != null ) pstmt.close();
				if ( conn != null ) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}

	/*
	 *  DB 연결 메소드
	 */
	private Connection getConnection(){
		
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/management");
			conn = ds.getConnection();
//			System.out.println("DB Connection Success!");
			
		}catch(Exception e){
//			System.out.println("DB Connection Failed");
			e.printStackTrace();
		}
		return conn;
	}
	
	/*
	 * 답변글 작성 메소드
	 */
	public void replyInsertArticle(String number, String writer, String title, String content, Timestamp date, String group, String depth, String indent) {
		String query = "";			// 쿼리문
		int articleNumber = 0;		// 글 번호
		
		System.out.println("group : " + group + ", depth : " + depth);
		depthUp(group, depth);		// 답변글의 깊이 메소드
		try{
			query = "SELECT MAX(b_number) FROM board";		// 현재 최신글번호를 취득한다.
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if( rs.next() ){
				articleNumber = rs.getInt(1) + 1;	
			}else{
				articleNumber = 1;
			}
			
			query = "INSERT INTO board (b_number, b_writer, b_title, b_content, b_date, b_group, b_depth, b_indent) values (?, ?, ?, ?, ?, ?, ?, ? ) ";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNumber);
			pstmt.setString(2, writer);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setTimestamp(5, date);
			pstmt.setInt(6, Integer.parseInt(group));								//★
			pstmt.setInt(7, (Integer.parseInt(depth) +1 ));
			pstmt.setInt(8, (Integer.parseInt(indent) + 1));
			pstmt.executeUpdate();
//			System.out.println("replyInsertArticle - Success");
			
		}catch(Exception e){
//			System.out.println("replayInsertArticle - Failed");
			e.printStackTrace();
		}finally{
			try{
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	/*
	 *  게시글 답변시 글 깊이를 증가시키는 메소드
	 */
	private void depthUp(String bGroup, String bDepth) {
		try{
			conn = getConnection();
			String query = "UPDATE board SET b_depth = b_depth + 1 WHERE b_group = ? and b_depth > ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bGroup));
			pstmt.setInt(2, Integer.parseInt(bDepth));
			pstmt.executeUpdate();
//			System.out.println("depthUp - Success");
		}catch(Exception e){
//			System.out.println("depthUp - Failed");
			e.printStackTrace();
		}finally{
			try{
				if( pstmt != null ) pstmt.close();
				if( conn!= null ) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}

}
