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
@WebServlet(name="Test2", urlPatterns = {"/test2"})
public class TestTervlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int score = 75;
		
		request.setAttribute("title", "[테스트 화면2]");
		request.setAttribute("score", score);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/test2.jsp");
		rd.forward(request, response);
	}


}
