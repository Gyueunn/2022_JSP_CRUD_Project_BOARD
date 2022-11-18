<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.example.dao.BoardDAO, com.example.bean.BoardVO"%>
<%@ page import="com.example.common.FileUpload" %>
<%
	request.setCharacterEncoding("utf-8");
	String sid = request.getParameter("id");
	if (sid != ""){  
		int id = Integer.parseInt(sid);
		BoardDAO boardDAO = new BoardDAO();
		BoardVO u = new BoardVO();
		u.setSeq(id);
		//업로드한 photo 파일 삭제
		String filename = u.getFileName();
		if(filename != null) FileUpload.deleteFile(request, filename);
		//회원정보 삭제
		boardDAO.deleteBoard(u);
	}
	response.sendRedirect("posts.jsp");
%>