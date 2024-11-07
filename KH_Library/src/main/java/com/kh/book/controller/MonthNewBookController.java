package com.kh.book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.book.model.service.BookService;
import com.kh.book.model.vo.Book;
import com.kh.common.PageInfo;

/**
 * Servlet implementation class MonthNewBookController
 */
@WebServlet("/mnewBook.bk")
public class MonthNewBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonthNewBookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList<Book> mlist = new ArrayList<>();
		
		int listCount;
		int currentPage;
		int pageLimit;
		int boardLimit;
		
		int maxPage;
		int startPage;
		int endPage;
		
		listCount = new BookService().listCount();
		
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		pageLimit = 10;
		boardLimit = 20;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		if(currentPage != 1 && currentPage > maxPage) {
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
		}
		
		startPage = (currentPage-1) / pageLimit * pageLimit +1;
		
		endPage = startPage + pageLimit -1;
		
		if(maxPage<endPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		mlist = new BookService().monthNewBook(pi);
		
		
		request.setAttribute("pi", pi);
		request.setAttribute("mlist", mlist);
		request.getRequestDispatcher("/views/book/mnewBookView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
