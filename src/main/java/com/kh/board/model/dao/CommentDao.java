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
import com.kh.board.model.vo.Reply;
import com.kh.book.model.vo.Book;
import com.kh.common.JDBCTemplate;
import com.kh.common.PageInfo;

public class CommentDao {
	
	private Properties prop = new Properties();
	
	public CommentDao() {
		
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
		String sql = prop.getProperty("cListCount");
		
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
	
	
	// 책 목록 조회
	public ArrayList<Book> selectCommentList(Connection conn, PageInfo pi) {
		
		ArrayList<Book> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectCommentList");
		
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
				
				Book b = new Book();
				b.setBookId(rset.getInt("BOOK_ID"));
				b.setBookTitle(rset.getString("BOOK_TITLE"));
				b.setBookAuthor(rset.getString("BOOK_AUTHOR"));
				
				list.add(b);
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



	// 책 내용 조회
	public Book selectBookForComment(Connection conn, int bno) {
	
		Book b = new Book ();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectBookForComment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b.setBookId(rset.getInt("BOOK_ID"));
				b.setBookTitle(rset.getString("BOOK_TITLE"));
				b.setBookAuthor(rset.getString("BOOK_AUTHOR"));
				b.setPublisher(rset.getString("PUBLISHER"));
				b.setSummary(rset.getString("SUMMARY"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		
		return b;
	}



	// 게시글 만들기
	public int createComment(Connection conn, int bookNo, int writerNo) {
		
		int b = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("createComment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, writerNo);
			pstmt.setInt(2, bookNo);
			b = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return b;
	}



	// 게시글 유무 체크
	public int selectClist(Connection conn, int bookNo) {
		int boardN = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectClist");
	
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bookNo);
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					boardN = rset.getInt("BOARD_NO");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
		return boardN;
	}



	// 코멘트 생성
	public int createReply(Connection conn, int boardN, int writerNo, String comment) {
		int createReply = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("createReply");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardN);
			pstmt.setInt(2, writerNo);
			pstmt.setString(3, comment);
			createReply = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return createReply;
	}



	// 코멘트 조회
	public ArrayList<Reply> selectReply(Connection conn, int bno) {
	
		ArrayList<Reply> rlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReply");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			rset= pstmt.executeQuery();
			
			while(rset.next()) {
				
				Reply r = new Reply();
				r.setReplyNo(rset.getInt("REPLY_NO"));
				r.setUserNo(rset.getString("USER_ID"));
				r.setReplyContent(rset.getString("REPLY_CONTENT"));
				r.setDate(rset.getDate("CREATE_DATE"));
				
				rlist.add(r);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
			
		}
		return rlist;
	
	}


	public int replyCount(Connection conn, int boardN) {
		int rCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("createComment");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardN);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				rCount = rset.getInt("COUNT");
				System.out.println(rCount);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return rCount;
	}
	

	

}
