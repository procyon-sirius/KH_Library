package com.kh.board.controller.freeBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.ReplyService;
import com.kh.board.model.vo.Reply;

/**
 * Servlet implementation class FreeBoardReplyUpdateController
 */
@WebServlet("/update.frp")
public class FreeBoardReplyUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardReplyUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int replyNo = Integer.parseInt(request.getParameter("rno"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		Reply frp = new ReplyService().selectFBreply(replyNo);
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("frp", frp);
		
		request.getRequestDispatcher("/views/board/freeBoard/freeBoardReplyUpdateForm.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
