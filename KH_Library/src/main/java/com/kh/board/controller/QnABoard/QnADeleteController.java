package com.kh.board.controller.QnABoard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.QnAService;
import com.kh.board.model.service.ReplyService;

/**
 * Servlet implementation class QnADeleteController
 */
@WebServlet("/delete.qna")
public class QnADeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnADeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		int result = new QnAService().deleteQnA(boardNo);
		HttpSession session = request.getSession();
		
		if(result>0) {
			session.setAttribute("alertMsg", "문의글이 삭제되었습니다.");
			response.sendRedirect(request.getContextPath()+"/qnaBoard?currentPage=1");
		}else {
			session.setAttribute("alertMsg", "문의글 삭제에 실패하였습니다.");
			response.sendRedirect(request.getContextPath()+"/");
		}
	}

}
