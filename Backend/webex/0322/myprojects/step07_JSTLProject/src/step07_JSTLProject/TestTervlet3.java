package step07_JSTLProject;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestTervlet11
 */
@WebServlet(name="Test3", urlPatterns = {"/test3"})
public class TestTervlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] color = {"red","green","blue"};
		int num = 10;
		
		request.setAttribute("title", "[테스트 화면3]");
		request.setAttribute("color", color);
		request.setAttribute("num", num);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/test3.jsp");
		rd.forward(request, response);
	}

}
