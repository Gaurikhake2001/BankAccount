

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String s1 = request.getParameter("un");
		String s2 = request.getParameter("pd");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Account" ,"root","root");
			
			
			PreparedStatement ps = con.prepareStatement("select * from Bank_Account where uname=? and pwd=?");
			ps.setString(1, s1);
			ps.setString(2, s2);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				
				RequestDispatcher rd = request.getRequestDispatcher("Account");
				rd.forward(request, response);
			}
			else
			
				out.println("Login Failed");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
				
				out.println("<a href='Update'>Forget Password</a>");
				
				rs.close();
				con.close();
				out.close();
			
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
