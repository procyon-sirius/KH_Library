package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.board.model.vo.Reply;
import com.kh.common.JDBCTemplate;

public class ReplyDao {
	
	private Properties prop = new Properties();
	
	public ReplyDao() {
		
		String filePath = QnADao.class.getResource("/resources/mappers/reply-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
// ------------------------> QnA ------------------------------	
	// 문의글 답변 생성 메소드
	public int insertReply(Connection conn, String content, int boardNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertReply");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
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



	// 답변 수정하기 
	public int updateReply(Connection conn, String content, int boardNo) {
		

		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, content);
			pstmt.setInt(2, boardNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	// 답변 삭제하기
	public int deleteReply(Connection conn, int noticeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteReply");
		
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



	
// ------------------------> 자유게시판 ------------------------------
	
	// 자유게시판 댓글 생성 메소드
	public int insertFBReply(Connection conn, String content, int boardNo, int writerNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertFBReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			pstmt.setInt(2, writerNo);
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



	// 댓글 리스트 조회
	public ArrayList<Reply> selectFBreplyList(Connection conn, int nno) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Reply> r = new ArrayList<>();
		String sql = prop.getProperty("selectFBreplyList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				r.add(new Reply(
							rset.getInt("REPLY_NO"),
							rset.getInt("BOARD_NO"),
							rset.getString("USER_ID"),
							rset.getString("REPLY_CONTENT"),
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
		
		return r;
	}



	// 댓글 조회
	public Reply selectFBreply(Connection conn, int replyNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Reply r = new Reply();
		String sql = prop.getProperty("selectFBreply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r.setReplyNo(rset.getInt("REPLY_NO"));
				r.setUserNo(rset.getString("USER_ID"));
				r.setReplyContent(rset.getString("REPLY_CONTENT"));
				r.setDate(rset.getDate("CREATE_DATE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return r;
		
	}



	// 답변삭제 메소드
	public int deletefbReply(Connection conn, int replyNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deletefbReply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	// 댓글 수정하기
	public int updateFreply(Connection conn, int rno, String content) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("updateFreply");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, content);
			pstmt.setInt(2, rno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	 
	public String selectRconent(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String r = "";
		String sql = prop.getProperty("selectRconent");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				r = rset.getString("REPLY_CONTENT");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return r;
		
	}
	
}
