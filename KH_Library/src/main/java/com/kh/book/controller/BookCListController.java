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
import com.kh.book.model.vo.BookCategory;
import com.kh.book.model.vo.BookCategoryInfo;
import com.kh.common.PageInfo;

/**
 * Servlet implementation class BookCListController
 */
@WebServlet("/clist.bk")
public class BookCListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		startPage = (currentPage-1) / pageLimit * pageLimit +1;
		
		endPage = startPage + pageLimit -1;
		
		if(maxPage<endPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		
		
		int cno = Integer.parseInt(request.getParameter("categoryNo"));

		ArrayList<Book> list = new BookService().selectList(pi, cno);
		
		ArrayList<BookCategoryInfo> bci = new BookService().selectCategory();
		
	
		
		request.setAttribute("list", list);
		request.setAttribute("pi", pi);	
		request.setAttribute("bci", bci);
		
		request.getRequestDispatcher("/views/book/bookCategoryListView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
