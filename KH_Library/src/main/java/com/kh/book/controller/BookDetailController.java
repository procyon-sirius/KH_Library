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
import com.kh.book.model.vo.BookCategoryInfo;

/**
 * Servlet implementation class BookDetailController
 */
@WebServlet("/detail.bk")
public class BookDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bookId"));
		
		request.setCharacterEncoding("UTF-8");

		//BookCategoryInfo bi = new BookService().selectBookCategory(bno);
		
		//System.out.println(bi);
		
		int ten;
		int twenty;
		int thirty;
		int forty;
		int fifty;
		int sixty;
		
		ten = new BookService().tenRent(bno);
		twenty = new BookService().twentyRent(bno);
		thirty = new BookService().thirtyRent(bno);
		forty = new BookService().fortyRent(bno);
		fifty = new BookService().fiftyRent(bno);
		sixty = new BookService().sixtyRent(bno);
		
		ArrayList<BookCategoryInfo> biList = new BookService().selectBookCategory(bno);
		
		Book b = new BookService().selectBook(bno);
		
		request.setAttribute("b", b);
		request.setAttribute("biList", biList);
		
		request.setAttribute("ten", ten);
		request.setAttribute("twenty", twenty);
		request.setAttribute("thirty", thirty);
		request.setAttribute("forty", forty);
		request.setAttribute("fifty", fifty);
		request.setAttribute("sixty", sixty);
		
		request.getRequestDispatcher("/views/book/bookDetail.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
