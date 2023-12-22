

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Account")
public class Account extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String s1 = request.getParameter("un");
		out.println("<h2>Welcome"+" "+s1+"</h2> ");
		
		out.println("<form method='post' action='Balance'>");
		out.println("Enter Account No: <input type='text' name='a'><br><br>");
		out.println("<input type='submit' value='Check'>");
		
		out.println("</form>");
		

	}
}

