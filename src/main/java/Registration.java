

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Account","root", "root");
		
		PreparedStatement ps = con.prepareStatement("insert into Bank_Account values(?,?,?,?,?,?,?,?)");
		ps.setString(1, request.getParameter("t1"));
		ps.setString(2, request.getParameter("t2"));
		ps.setString(3, request.getParameter("t3"));
		ps.setString(4, request.getParameter("t4"));
		ps.setString(5, request.getParameter("t5"));
		ps.setString(6, request.getParameter("t6"));
		ps.setString(7, request.getParameter("t7"));
		ps.setString(8, request.getParameter("t8"));
		
		ps.executeUpdate();
		out.println("Registration Successful...");
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
