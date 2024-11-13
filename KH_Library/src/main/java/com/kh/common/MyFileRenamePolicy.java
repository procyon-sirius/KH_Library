package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {

		//원본파일명 추출
		String originName = originFile.getName();
		
		//수정파일명 : 파일 업로드된 시간(년월일시분초)+5자리 랜덤값(10000~99999)
		//파일 확장자 : 원본파일 확장자 그대로 
		
		//1.파일 업로드된 시간
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		int ranNum = (int)(Math.random()*90000) + 10000;
		
		//3.원본파일 확장자
		//원본파일명 : xxx.jpg
		//마지막 . 기준으로 잘라내면 확장자 추출가능
		String ext = originName.substring(originName.lastIndexOf("."));
		String changeName = currentTime + ranNum + ext;
		
		//originFile.getParent() : 해당파일의 부보 폴더 경로 반환
		//부모폴더 경로로 변경된 이름의 파일객체 생성됨
		return new File(originFile.getParent(), changeName);
	}
	
}
