package com.kh.board.controller.commentBoard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.CommentService;
import com.kh.board.model.service.ReplyService;

/**
 * Servlet implementation class CommentDeleteController
 */
@WebServlet("/delete.cm")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int replyNo = Integer.parseInt(request.getParameter("replyNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		
		int result = new CommentService().deleteComment(replyNo);
		HttpSession session = request.getSession();
		
		if(result>0) {
			session.setAttribute("alertMsg", "코멘트가 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/commentBoard?currentPage="+currentPage);
		}else {
			session.setAttribute("alertMsg", "코멘트 삭제에 실패하였습니다.");
			response.sendRedirect(request.getContextPath()+"/");
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
