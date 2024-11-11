package com.kh.common;

import java.io.File;

import com.kh.book.model.service.BookService;
import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {
		// 원본파일명 추출
		String originName = originFile.getName();
		//파일 확장자 : 원본파일 그대로
		String ext = originName.substring(originName.lastIndexOf("."));
		
		//시퀀스에서 다음 BookId 받아오기
		int bid = new BookService().BNONextVal();
		
		String changeName = Integer.toString(bid)+ext;
		
		//originFile.getParent() :해당 파일의 부모 폴더 경로 반환
		//부모폴더 경로로 변경된 이름의 파일객체 생성됨
		return new File(originFile.getParent(),changeName);
	}
	
}
