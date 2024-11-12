package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Notice;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

public class FreeBoardDao {
	
	private Properties prop = new Properties();
	
	public FreeBoardDao() {
		
		String filePath = QnADao.class.getResource("/resources/mappers/board-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
}
	
	
	// 게시글 수 조회
	public int listCount(Connection conn) {
		
		Statement stmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = conn.createStatement();
			rset= stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return listCount;
		
	}

	
	// 게시글목록 조회
	public ArrayList<Board> selectFreeboardList(Connection conn, PageInfo pi) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> freeBoard = new ArrayList<>();
		
		String sql = prop.getProperty("selectFreeboardList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				freeBoard.add(new Board(
										rset.getInt("BOARD_NO"),
										rset.getString("USER_ID"),
										rset.getString("BOARD_TITLE"),
										rset.getDate("CREATE_DATE"),
										rset.getInt("COUNT")
									));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return freeBoard;
	}

	
	
	// 조회수 증가
	public int increaseCount(Connection conn, int nno) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		String sql = prop.getProperty("increaseCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			
			listCount = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return listCount;
	}

	
	
	// 게시글 조회
	public Board selectFreeBoard(Connection conn, int nno) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board fb = new Board();
		
		String sql = prop.getProperty("selectFreeBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				fb.setBoardNo(rset.getInt("BOARD_NO"));  
				fb.setUserNo(rset.getString("USER_ID"));	
				fb.setUserNo_Int(rset.getInt("USER_NO"));	
				fb.setBoardTitle(rset.getString("BOARD_TITLE"));	
				fb.setBoardContent(rset.getString("BOARD_CONTENT"));	
				fb.setDate(rset.getDate("CREATE_DATE"));	
				fb.setCount(rset.getInt("COUNT"));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return fb;
	}
	
	
	// 이전글 다음글 조회
	public ArrayList<Board> preNnext(Connection conn, int nno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> preNnext = new ArrayList<>();
		
		String sql = prop.getProperty("preNnext");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			pstmt.setInt(2, nno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				preNnext.add(new Board(
							rset.getInt("BOARD_NO"),
							rset.getString("BOARD_TITLE"),
							rset.getDate("CREATE_DATE"),
							rset.getString("post_position")
							));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		return preNnext;
	}

	
	
	// 게시글 작성
	public int insertFreeboard(Connection conn, String title, String content, int userNo) {
	
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertFreeboard");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	
	// 게시글 수정
	public int updateFreeBoard(Connection conn, String title, String content, int nno) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateFreeBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, nno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	
	// 게시글 삭제
	public int deleteFreeBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteFreeBoard");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			System.out.println(boardNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
	
	

	
}
