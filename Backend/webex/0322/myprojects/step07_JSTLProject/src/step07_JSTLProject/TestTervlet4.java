package step07_JSTLProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestTervlet11
 */
@WebServlet(name="Test4", urlPatterns = {"/test4"})
public class TestTervlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list=new ArrayList<>();
	      list.add(new User("kim","010-1111-1111"));
	      list.add(new User("lee","010-2222-1111"));
	      list.add(new User("park","010-3333-1111"));
	      
	      request.setAttribute("title", "[테스트 화면 4]");
	      request.setAttribute("list", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("view/test4.jsp");
		rd.forward(request, response);
	}

}
