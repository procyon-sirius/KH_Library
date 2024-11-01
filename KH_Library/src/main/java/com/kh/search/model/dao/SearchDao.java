package com.kh.search.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SearchDao {

	private Properties prop = new Properties();
	
	
	public SearchDao() {

		String filePath = SearchDao.class.getResource("/resources/mappers/board-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
