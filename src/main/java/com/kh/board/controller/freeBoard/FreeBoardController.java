package com.kh.board.controller.freeBoard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.FreeboardService;
import com.kh.board.model.service.ReplyService;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Reply;
import com.kh.common.PageInfo;

/**
 * Servlet implementation class FreeBoardController
 */
@WebServlet("/freeBoard")
public class FreeBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardController() {
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
		
		
		currentPage = 1; // 기본값 설정

		if (request.getParameter("currentPage") != null) {
		    currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		listCount = new FreeboardService().listCount();
		pageLimit = 10;
		boardLimit = 10;
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		startPage = (currentPage-1) / pageLimit * pageLimit +1;
		
		endPage = startPage + pageLimit -1;
		
		if(maxPage<endPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = new PageInfo(listCount,currentPage,pageLimit,boardLimit,maxPage,startPage,endPage);
		request.setAttribute("pi", pi);
		
		
		ArrayList<Board> freeBoard = new FreeboardService().selectFreeboardList(pi);
		request.setAttribute("freeBoard", freeBoard);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/board/freeBoard/freeBoard.jsp");
		view.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
