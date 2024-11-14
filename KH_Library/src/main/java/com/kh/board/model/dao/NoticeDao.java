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

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
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
	public int insertNotice(Connection conn, Notice n) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertNotice");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, n.getNoticeNo());
			pstmt.setString(2, n.getNoticeTitle());
			pstmt.setString(3, n.getNoticeContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	
	//메인페이지 공지리스트
	public ArrayList<Notice> indexSelectNotice(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<>();
		String sql = prop.getProperty("indexSelectNotice");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Notice(rset.getInt("NOTICE_NO")
									,rset.getString("NOTICE_TITLE")
									,rset.getDate("CREATE_DATE")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	
	// 글 시퀀스 번호 추출용 메소드
	public int selectBoardNo(Connection conn) {
		// select 구문으로 시퀀스 발행해오기
		int boardNo = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectBoardNo");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				boardNo = rset.getInt("NNO");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return boardNo;
	}

	
	// 첨부파일 추가하기
	public int insertAttachment(Connection conn, Attachment at) {
		
		//insert(DMl)
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, at.getRefNno());
			pstmt.setString(2, at.getOriginName());
			pstmt.setString(3, at.getChangeName());
			pstmt.setString(4, at.getFilePath());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}


	public Attachment selectAttachment(Connection conn, int nno) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Attachment at = null; // 조회되면 담을 객체
		
		String sql = prop.getProperty("selectAttachment");
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, nno);
			
			rset = pstmt.executeQuery();
			
			// 일반 게시글에 첨부파일은 하나만 등록될 수 있기 때문에 if문으로 처리
			if(rset.next()) {
				at = new Attachment(rset.getInt("FILE_NO")
									,rset.getString("ORIGIN_NAME")
									,rset.getString("CHANGE_NAME")
									,rset.getString("FILE_PATH"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return at;
		
	}


	public int deleteAttachment(Connection conn, int noticeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("deleteAttachment");
		
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

	

}
