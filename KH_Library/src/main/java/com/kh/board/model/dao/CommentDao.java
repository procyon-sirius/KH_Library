package com.kh.board.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
	

}
