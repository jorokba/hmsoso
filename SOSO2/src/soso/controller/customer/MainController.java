package soso.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soso.dao.NoticeDao;
import soso.entities.Notice;
import soso.mybatis.MyBatisNoticeDao;

@WebServlet("/customer/main")
public class MainController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String _code = request.getParameter("code");

		NoticeDao noticeDao = new MyBatisNoticeDao();
		Notice notice;
		
		notice = noticeDao.get(_code);
		request.setAttribute("n", notice);

		request.getRequestDispatcher("/WEB-INF/views/customer/main.jsp").forward(request, response);
	}
}