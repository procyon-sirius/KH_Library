package com.kh.board.controller.QnABoard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.NoticeService;
import com.kh.board.model.service.QnAService;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Notice;
import com.kh.board.model.vo.Reply;
import com.kh.common.PageInfo;

/**
 * Servlet implementation class QnAListController
 */
@WebServlet("/qnaBoard")
public class QnAListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAListController() {
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
		
		listCount = new QnAService().QlistCount();
		
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
		
		
		// Q 리스트 조회
		ArrayList<Board> bList = new QnAService().selectQList(pi);
		request.setAttribute("bList", bList);
		
		// R 리스트 조회
		ArrayList<Reply> rList = new QnAService().selectAList(pi);
		request.setAttribute("rList", rList);

		RequestDispatcher view = request.getRequestDispatcher("/views/board/QnABoard/qnaBoard.jsp");
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
