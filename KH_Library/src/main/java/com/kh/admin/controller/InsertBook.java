package com.kh.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kh.book.model.service.BookService;
import com.kh.book.model.vo.Book;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.vo.Member;
import com.kh.search.model.service.SearchService;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class InsertBook
 */
@WebServlet("/insertBook.ma")
public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginUser");
		if(m==null || !m.getUserId().equals("admin")) {
			request.setAttribute("errorMsg", "관리자 계정만 접근할 수 있습니다.");
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
		}else {
			ArrayList<BookCategoryInfo> bookcList = new SearchService().selectBookCategoryList();
			request.setAttribute("category", bookcList);
			request.setAttribute("mode", "insertBook");
			request.getRequestDispatcher("/views/member/admin/admin.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
			
		//해당 요청이 multipart 요청인지 확인 
		if(ServletFileUpload.isMultipartContent(request)) {
			//최대 용량
			int maxSize = 10*1024*1024;
			//저장 경로 request.getSession().getServletContext().getRealPath("") : webapp 까지 경로
			String savePath = request.getSession().getServletContext().getRealPath("/resources/img/");
			
			//MultipartRequest(request, 저장경로, 파일최대사이즈, 인코딩, 파일명객체);
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			boolean flag = false;
			if(multiRequest.getOriginalFileName("upload-book-img") != null) {
				//이름 변경되어 서버에 올라간 파일명
				String str = multiRequest.getFilesystemName("upload-book-img");
				
				//파일명이 시퀀스에서 제대로 뽑혔는지 확인
				//시퀀스 실행중 오류가 생겼다면 파일명이 0.ext로 나오기 때문에
				//시퀀스 최소번호 1000일경우 파일명 : 1000.ext의 최소 문자길이 8보다 작을 경우는 시퀀스 오류로 간주 
				if(str.length()<8) {
					flag = false;
				}else {
					flag = true;
				}
			}
			
			
			if(flag) {
				String title = multiRequest.getParameter("title");
				String author = multiRequest.getParameter("author");
				String publisher = multiRequest.getParameter("publisher");
				int publishDate = Integer.parseInt(multiRequest.getParameter("publishDate"));
				String age = multiRequest.getParameter("age");
				String[] category = multiRequest.getParameterValues("search-book-category");
				String summary = multiRequest.getParameter("summary");
				
				Book b = new Book();
				b.setBookTitle(title);
				b.setBookAuthor(author);
				b.setPublisher(publisher);
				b.setPublishDate(publishDate);
				b.setAgeRank(age);
				b.setSummary(summary);
				
				//첨부파일 여부 확인
				//multiRequest의 getOriginalFileName("키값")
				String imgName = "temp.jpg";
				if(multiRequest.getOriginalFileName("upload-book-img") != null) {
					//이름 변경되어 서버에 올라간 파일명
					imgName = multiRequest.getFilesystemName("upload-book-img");
					b.setImgName(imgName);
					
					//변경된 파일명이 "bookId.확장자" 이기 때문에 확장자 제외하면 bookId가 된다.
					int index = imgName.lastIndexOf(".");
					int bookId = Integer.parseInt(imgName.substring(0,index));
					b.setBookId(bookId);
				}
				
				int result = new BookService().insertBook(b,category);
				HttpSession session = request.getSession();
				String alertMsg = "";
				if(result>0) {
					alertMsg = "등록 완료";
				}else {
					alertMsg = "등록 실패";
					new File(savePath+imgName).delete();
				}
				session.setAttribute("alertMsg", alertMsg);
				response.sendRedirect(request.getContextPath()+"/insertBook.ma");
			
			}else {
				String imgName = multiRequest.getFilesystemName("upload-book-img");
				new File(savePath+imgName).delete();
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "등록 실패");
				response.sendRedirect(request.getContextPath()+"/insertBook.ma");
			}
		}
	}

}
