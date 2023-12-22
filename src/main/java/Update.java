import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Update")
public class Update extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String s1 = request.getParameter("un");
		out.println("<form method='get' action='UpdatePwd'>");
		out.println("Username:<input type='text' name='un' value='"+s1+"'><br><br>");
		out.println("New Password:<input type='password' name='npd'><br><br>");
		out.println("<input type='Submit' value='Update'>");
		out.println("</form>");
	}

}

