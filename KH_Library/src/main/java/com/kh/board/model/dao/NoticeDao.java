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
	
	
	public ArrayList<Notice> selectNoticeList(Connection conn) {
	
		ArrayList<Notice> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			stmt = conn.createStatement();
			rset= stmt.executeQuery(sql);
			
			
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
			JDBCTemplate.close(stmt);
			
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
		
		int b = nno-1;
		int a = nno+1;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b);
			pstmt.setInt(2, a);
			
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
	

}
