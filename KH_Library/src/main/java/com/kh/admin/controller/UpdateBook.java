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

import com.kh.admin.model.service.AdminBookService;
import com.kh.book.model.vo.Book;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.MyFileRenamePolicy;
import com.kh.member.model.vo.Member;
import com.kh.search.model.service.SearchService;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateBook
 */
@WebServlet("/updateBook.ma")
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("loginUser");
		int bid = Integer.parseInt(request.getParameter("bookId"));
		if(m==null || !m.getUserId().equals("admin")) {
			request.setAttribute("errorMsg", "관리자 계정만 접근할 수 있습니다.");
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
		}else {
			Book b = new AdminBookService().selectUpdateBook(bid);
			request.setAttribute("book", b);
			
			ArrayList<String> categoryTemp = new AdminBookService().selectBookCategory(bid);
			String bookCategory = String.join(",", categoryTemp);
			request.setAttribute("bookCategory", bookCategory);
			
			ArrayList<BookCategoryInfo> bookcList = new SearchService().selectBookCategoryList();
			request.setAttribute("category", bookcList);
			
			request.setAttribute("mode", "updateBook");
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
			
			int bookId = Integer.parseInt(multiRequest.getParameter("bookId"));
			String title = multiRequest.getParameter("title");
			String author = multiRequest.getParameter("author");
			String publisher = multiRequest.getParameter("publisher");
			int publishDate = Integer.parseInt(multiRequest.getParameter("publishDate"));
			String age = multiRequest.getParameter("age");
			String[] category = multiRequest.getParameterValues("book-category");
			String summary = multiRequest.getParameter("summary");
			String imgName = multiRequest.getParameter("imgName");
			
			Book b = new Book();
			b.setBookId(bookId);
			b.setBookTitle(title);
			b.setBookAuthor(author);
			b.setPublisher(publisher);
			b.setPublishDate(publishDate);
			b.setAgeRank(age);
			b.setSummary(summary);
			b.setImgName(imgName);

			String changeName = "";
			//첨부파일 여부 확인
			//multiRequest의 getOriginalFileName("키값")
			if(multiRequest.getOriginalFileName("upload-book-img") != null) {
				//이름 변경되어 서버에 올라간 파일명
				changeName = multiRequest.getFilesystemName("upload-book-img");
				b.setImgName(changeName);
			}
			
			
			int result = new AdminBookService().updateBook(b,category);

			HttpSession session = request.getSession();
			String alertMsg = "";

			if(multiRequest.getOriginalFileName("upload-book-img") != null) {

				if(result>0) {
					alertMsg = "수정 완료";
					new File(savePath+imgName).delete();
				}else {
					alertMsg = "수정 실패";
					new File(savePath+changeName).delete();
				}
				
			}else {//이미지 첨부 x
				if(result>0) {
					alertMsg = "수정 완료";
				}else {
					alertMsg = "수정 실패";
				}
			}
			
			session.setAttribute("alertMsg", alertMsg);
			response.sendRedirect(request.getContextPath()+"/updateBook.ma?bookId="+bookId);
			
		}
		
	}

}
