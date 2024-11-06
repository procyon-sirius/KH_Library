package com.kh.board.controller.QnABoard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.QnAService;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Reply;

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
		
		// Q 리스트 조회
		ArrayList<Board> bList = new QnAService().selectQList();
		request.setAttribute("bList", bList);
		
		
		// R 리스트 조회
		ArrayList<Reply> rList = new QnAService().selectAList();
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
