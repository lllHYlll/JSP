package com.sample.hy.account.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sample.hy.account.dto.MemberDTO;

public class MemberDAO {
	
	// 전역변수 선언
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/*
	 *  Singleton pattern 구현
	 */
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
	}
	
	public static MemberDAO getInstance(){
		return instance;
	}
	
	/*
	 *  INSERT DB
	 */
	public void insertMember(MemberDTO dto){
		
		String query = "INSERT INTO members values(?,?,?,?,?,?)";
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAge());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, dto.getIntroduce());
			pstmt.executeUpdate();

			System.out.println("insertMember -- Success!");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	/*
	 *  UPDATE DB
	 */
	public void modifyMember(MemberDTO dto){
		
		String query = "UPDATE members SET m_pw=?, m_age=?, m_gender=?, m_introduce =? WHERE m_id=?";
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1	, dto.getPw());
			pstmt.setString(2	, dto.getAge());
			pstmt.setString(3	, dto.getGender());
			pstmt.setString(4, dto.getIntroduce());
			pstmt.setString(5	, dto.getId());
			pstmt.executeUpdate();
			System.out.println("modifyMember -- Success!");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if( pstmt != null) pstmt.close();
				if( conn != null) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
	}
	
	
	/*
	 *  Login Check
	 */
	public Map<String, Object> LoginCheck(String id, String pw){
		MemberDTO dto = new MemberDTO();
		Map<String, Object> resultMap = new HashMap<>();
		
		int judgement = 0;		// 로그인 성공시 = 1, 비밀번호 불일치 = 0, 아이디가 없을시 = -1;
		String dbPassword;		// DB에 저장된 비밀번호 선언
		
		String query = "SELECT * FROM members WHERE m_id = ?";
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				
				dbPassword = rs.getString("m_pw");
				// DB에 저장된 비밀번호와 입력된 비밀번호 체크
				if(dbPassword.equals(pw)){
					judgement = 1;

					// DB에 저장된 정보를 DTO 객체에 저장
					dto.setId( rs.getString("m_id"));
					dto.setName(rs.getString("m_name")); 
					dto.setPw(rs.getString("m_pw"));
					dto.setAge(rs.getString("m_age"));
					dto.setGender(rs.getString("m_gender"));
					dto.setIntroduce(rs.getString("m_introduce"));
					
					resultMap.put("resultDTO", dto);
					System.out.println("비밀번호 일치 -- Success!");
				}else {
					judgement = -1;
					System.out.println("비밀번호 불일치 -- Failed");
				}
			}else {
				judgement = 0;
				System.out.println("아이디가 없음 -- Failed");
			}
			System.out.println("LoginCheck -- Completed");
		}catch(Exception e){
			System.out.println("LoginCheck -- Failed");
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				pw = "";
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		resultMap.put("resultCheck", judgement);
		return resultMap;
		
	}
	
	/*
	 *  회원정보검색
	 */
	public MemberDTO FindMemberInfoByID(String id) {
		
		String query = "SELECT * FROM members WHERE m_id = ?";
		MemberDTO dto = new MemberDTO();
		
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if( rs.next() ){
				dto.setId(id);
				dto.setName(rs.getString("m_name"));
				dto.setAge(rs.getString("m_age"));
				dto.setGender(rs.getString("m_gender"));
				dto.setIntroduce(rs.getString("m_introduce"));
			}
			
			System.out.println("FindMemberInfoByID Success");
		}catch(Exception e){
			System.out.println("FindMemberInfoByID Failed");
		}finally{
			try{
				if( rs != null ) rs.close();
				if( pstmt != null ) pstmt.close();
				if( conn != null ) conn.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	
	/*
	 *  DB Connection Method !
	 */
	private Connection getConnection(){
		
		try{
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/management");
			conn = ds.getConnection();
			System.out.println("DB Connection Success!");
			
		}catch(Exception e){
			System.out.println("DB Connection Failed");
			e.printStackTrace();
		}
		return conn;
	}


}
