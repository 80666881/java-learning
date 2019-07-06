import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			
			ServletContext c	= request.getServletContext();

			String userName = (String) request.getSession().getAttribute("userName");

			PrintWriter pw = response.getWriter();

			pw.println("<h1>Hello Servlet</h1>");

			if (null != userName)
				pw.printf("<p>%s 当前在线</p>", userName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}