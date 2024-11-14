package com.kh.board.controller.notice;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.service.NoticeService;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Notice;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class NoticeInsertController
 */
@WebServlet("/insert.no")
public class NoticeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("/views/board/notice/noticeEnrollForm.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			int maxSize = 10 * 1024 * 1024;
			String savePath = request.getSession().getServletContext().getRealPath("/resources/uploadFiles/");
			MultipartRequest multiRequset = new MultipartRequest(request,savePath,maxSize,"UTF-8",new MyFileRenamePolicy());
			
			
		String title = multiRequset.getParameter("title");
		String content = multiRequset.getParameter("content");
		int currentPage = Integer.parseInt(multiRequset.getParameter("currentPage"));
		
		Notice n  = new Notice();
		n.setNoticeTitle(title);
		n.setNoticeContent(content);
		
		Attachment at = null;
		
			if(multiRequset.getOriginalFileName("uploadFile")!=null) {
				at = new Attachment();
				at.setOriginName(multiRequset.getOriginalFileName("uploadFile"));
				at.setChangeName(multiRequset.getFilesystemName("uploadFile"));
				at.setFilePath("/resources/uploadFiles");
			}
			
			int result = new NoticeService().insertNotice(n,at);
			
			if(result>0) {
				request.getSession().setAttribute("alertMsg", "공지글 작성 성공!");
				response.sendRedirect(request.getContextPath()+"/notice?currentPage="+currentPage);
				
			}else {
				// 첨부파일이 있었다면 서버에 업로드 되었을테니 필요없어진 파일 삭제처리하기
				if(at!=null) {
					// 삭제하고자 하는 파일 경로로 파일객체 생성 후 삭제 메소드 수행
					new File(savePath+at.getChangeName()).delete();
				}
				request.setAttribute("errorMsg", "공지글 작성 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		
		}

	}
}
