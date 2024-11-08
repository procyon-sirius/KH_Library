package com.kh.board.controller.QnABoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.QnAService;

/**
 * Servlet implementation class QnAInsertController
 */
@WebServlet("/insert.qna")
public class QnAInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/views/board/QnABoard/qnaEnrollForm.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int userId = Integer.parseInt(request.getParameter("userId"));
		int result = new QnAService().insertQnA(title,content,userId);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "문의글 작성 성공!");
			response.sendRedirect(request.getContextPath());
			
		}else {
			request.setAttribute("errorMsg", "문의글 작성 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	
	}
	
	
	
	
	

}
