package com.kh.board.controller.QnABoard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.QnAService;

/**
 * Servlet implementation class QnAUpdateController
 */
@WebServlet("/update.qna")
public class QnAUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		
		request.getRequestDispatcher("/views/board/QnABoard/qnaUpdateForm.jsp").forward(request, response);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
	
		int result = new QnAService().updateQnA(boardNo,title,content);
		
		String alertMsg = "";
		if(result>0) {
			alertMsg = "문의글을 수정하였습니다.";
		}else {
			alertMsg = "문의글을 수정하지못했습니다.";
		}
		
		request.getSession().setAttribute("alertMsg", alertMsg);
		response.sendRedirect(request.getContextPath()+"/qnaBoard?nno="+boardNo);
		
	
	
	}

}
