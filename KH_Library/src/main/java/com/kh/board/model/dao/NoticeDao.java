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

import com.kh.board.model.vo.Notice;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

public class NoticeDao {

	private Properties prop = new Properties();
	
	public NoticeDao() {
		
		String filePath = NoticeDao.class.getResource("/resources/mappers/notice-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Notice> selectNoticeList(Connection conn, PageInfo pi) {
	
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		
		// 시작번호 : (currentPage-1)*게시글 보여줄 수+1
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;

		// 끝번호 : 현재페이지 수 * 게시글 보여줄 수
		int endRow = pi.getCurrentPage() * pi.getBoardLimit();
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset= pstmt.executeQuery();
			
			
			while(rset.next()) {
				
				list.add(new Notice(
									rset.getInt("NOTICE_NO"),
									rset.getInt("USER_NO"),
									rset.getString("NOTICE_TITLE"),
									rset.getString("NOTICE_CONTENT"),
									rset.getInt("COUNT"),
									rset.getDate("CREATE_DATE")
						
						));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		return list;
	}

	
	
	// 조회수 증가 
	public int increaseCount(Connection conn, int nno) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("increaseCount");
			
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	
	// 공지사항 상세조회

	public Notice selectNotice(Connection conn, int nno) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice n = new Notice();
		String sql = prop.getProperty("selectNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n.setNoticeNo(rset.getInt("NOTICE_NO"));
				n.setNoticeTitle(rset.getString("NOTICE_TITLE"));
				n.setNoticeContent(rset.getString("NOTICE_CONTENT"));
				n.setNumber(rset.getInt("COUNT"));
				n.setDate(rset.getDate("CREATE_DATE"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return n;
	}


	
	// 이전글 다음글 조회
	public ArrayList<Notice> preNnext(Connection conn, int nno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> preNnext = new ArrayList<>();
		
		String sql = prop.getProperty("preNnext");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			pstmt.setInt(2, nno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				preNnext.add(new Notice(
							rset.getInt("NOTICE_NO"),
							rset.getString("NOTICE_TITLE"),
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

	
	
	// 공지사항 글 수정
	public int updateNotice(Connection conn, String title, String content, int nno) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateNotice");
		
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

	
	
	
	
	
	// 공지사항 삭제
	public int deleteNotice(Connection conn, int noticeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, noticeNo);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	
	
	
	
	
	// 공지사항 게시글 등록
	public int insertNotice(Connection conn, String title, String content) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertNotice");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			
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
