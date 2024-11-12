package com.kh.board.controller.freeBoard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.board.model.service.FreeboardService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class FreeBoardInsertController
 */
@WebServlet("/insert.fb")
public class FreeBoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreeBoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("/views/board/freeBoard/freeBoardEnrollForm.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		int userNo = loginUser.getUserNo();
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		int result = new FreeboardService().insertFreeboard(title,content,userNo);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "게시글 등록이 완료되었습니다.");
			response.sendRedirect(request.getContextPath());
		}else {
			request.getSession().setAttribute("alertMsg", "게시글 작성에 실패하였습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	
	}

}
