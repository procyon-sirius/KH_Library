package com.kh.board.controller.commentBoard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.CommentService;
import com.kh.board.model.vo.Reply;
import com.kh.book.model.vo.Book;

/**
 * Servlet implementation class CommentDetailController
 */
@WebServlet("/detail.cm")
public class CommentDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bno = Integer.parseInt(request.getParameter("bno"));
		Book b = new CommentService().selectBookForComment(bno);
		
		int boardN = new CommentService().selectClist(bno);
		ArrayList<Reply> rlist = new ArrayList<>();
		rlist = new CommentService().selectReply(boardN);
		int rCount = new CommentService().replyCount(boardN);
		
		request.setAttribute("rlist", rlist);
		request.setAttribute("rCount", rCount);
		request.setAttribute("bno", bno);
		request.setAttribute("b", b);
		request.getRequestDispatcher("views/board/commentBoard/commentDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
