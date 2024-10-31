package com.kh.book.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BookDao {
	
	private Properties prop = new Properties();
	
	public BookDao() {
		
		String filePath = BookDao.class.getResource("/resources/mappers/book-mapper.xml").getPath();
	
		try {
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
