package com.kh.board.controller.freeBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.FreeboardService;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class FreeBoardUpdateController
 */
@WebServlet("/update.fb")
public class FreeBoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int nno = Integer.parseInt(request.getParameter("nno"));
		Board fb = new FreeboardService().selectFreeBoard(nno);
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("Freeboard", fb);
		request.getRequestDispatcher("views/board/freeBoard/freeBoardUpdateForm.jsp").forward(request, response);
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int nno = Integer.parseInt(request.getParameter("nno"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		int result = new FreeboardService().updateFreeBoard(title,content,nno);
		
		String alertMsg = "";
		if(result>0) {
			alertMsg = "공지글 수정성공";
		}else {
			alertMsg = "공지글 수정실패";
		}
		
		request.getSession().setAttribute("alertMsg", alertMsg);
		response.sendRedirect(request.getContextPath()+"/detail.fb?nno="+nno+"&currentPage="+currentPage);
	
	
	
	
	}

}
