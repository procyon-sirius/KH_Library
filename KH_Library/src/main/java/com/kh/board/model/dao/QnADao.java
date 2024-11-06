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
import com.kh.board.model.vo.Reply;
import com.kh.common.JDBCTemplate;

public class QnADao {
	
	private Properties prop = new Properties();
	
		public QnADao() {
			
			String filePath = QnADao.class.getResource("/resources/mappers/board-mapper.xml").getPath();
			
			try {
				prop.loadFromXML(new FileInputStream(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	
	
	
		
	// 조회수 증가
	public int increaseCount(Connection conn, int bno) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("listCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



	
	
	// Q 리스트 조회 
	public ArrayList<Board> selectQList(Connection conn) {
		
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Board> b = new ArrayList<>();
		String sql = prop.getProperty("selectQList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				b.add(new Board(
								 rset.getInt("BOARD_NO"),
								 rset.getInt("BOARD_TYPE_NO"),
								 rset.getString("USER_ID"),
								 rset.getString("BOARD_TITLE"),
								 rset.getString("BOARD_CONTENT"),
								 rset.getDate("CREATE_DATE"),
								 rset.getInt("COUNT")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return b;
	}




	
	// R 리스트 조회
	public ArrayList<Reply> selectRList(Connection conn) {
		
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Reply> r = new ArrayList<>();
		String sql = prop.getProperty("selectAList");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
		while(rset.next()) {
			
			r.add(new Reply(
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
			JDBCTemplate.close(stmt);
		}
		
		return r;
	}
	
	
	
	
	



	
	

}
