<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.sample.hy.board.dto.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP & Servlet Study Community - Board Home</title>
</head>
<body>
	<h1>JSP & Servlet Study Community - boardHome.jsp</h1>
	<h2> 게시판 </h2>
	
	<table>
		<thead>
		<tr>
			<th> 번호				</th>
			<th> 제목				</th>
			<th> 작성자			</th>
			<th> 조회				</th>
			<th> 작성일자  	</th>
		</tr>
		</thead>
		<tbody>
			<c:choose > 
				<c:when test="${fn:length(list) != null }">
						 <c:forEach var="list" items="${list }">
								<tr>
										<td>${list.number}</td>
										<td><c:forEach begin="1" end="${list.indent}">ー</c:forEach>
										<a href="/Board/ReadForm?number=${list.number}">${list.title }</a></td>
										<td>${list.writer}</td>
										<td>${list.hit}</td>
										<td>${list.date}</td>
								</tr>
						</c:forEach>
				</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5">empty List</td>
						</tr>
					</c:otherwise>		
				</c:choose>
			</tbody>
	</table>
	
	<a href="/Board/WriteForm"> 글 작성 </a>&nbsp; &nbsp;
	<a href="/Board/BoardHome"> 글 목록 / 새로고침</a>
	
	
</body>
</html>