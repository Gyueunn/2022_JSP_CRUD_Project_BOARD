package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.bean.BoardVO;
import com.example.utill.JDBCUtil;

public class BoardDAO {

	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String BOARD_INSERT = "insert into BOARD (category, title, writer, content, fileName) values (?, ?, ?, ?, ?)";
	private final String BOARD_UPDATE = "update BOARD set category=?, title=?, writer=?, content=?, fileName=? where seq=?";
	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
	private final String BOARD_GET = "select * from BOARD  where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	public int insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getCategory());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getWriter());
			stmt.setString(4, vo.getContent());
			stmt.setString(5, vo.getFileName());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getCategory());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getWriter());
			stmt.setString(4, vo.getContent());
			stmt.setString(5, vo.getFileName());
			stmt.setInt(6, vo.getSeq());

			System.out.println(vo.getCategory() + "-" + vo.getTitle() + "-" + vo.getWriter() + "-" + vo.getContent() + "-" + vo.getFileName() + "-" + vo.getSeq());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public BoardVO getBoard(int seq) {
		BoardVO one = new BoardVO();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSeq(rs.getInt("seq"));
				one.setCategory(rs.getString("category"));
				one.setTitle(rs.getString("title"));
				one.setWriter(rs.getString("writer"));
				one.setContent(rs.getString("content"));
				one.setFileName(rs.getString("fileName"));
				one.setCnt(rs.getInt("cnt"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO one = new BoardVO();
				one.setSeq(rs.getInt("seq"));
				one.setCategory(rs.getString("category"));
				one.setTitle(rs.getString("title"));
				one.setWriter(rs.getString("writer"));
				one.setContent(rs.getString("content"));
				one.setFileName(rs.getString("fileName"));
				one.setRegdate(rs.getDate("regdate"));
				one.setEditdate(rs.getDate("editdate"));
				one.setCnt(rs.getInt("cnt"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	public String getPhotoFilename(int sid) {
		String filename = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, sid);
			rs = stmt.executeQuery();
			if(rs.next()) {
				filename = rs.getString("fileName");
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filename;
	}
}
