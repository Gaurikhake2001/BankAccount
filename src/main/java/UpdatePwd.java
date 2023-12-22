

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

@WebServlet("/UpdatePwd")
public class UpdatePwd extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String s1 = request.getParameter("un");
		String s2 = request.getParameter("npd");
		try
		{

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Account","root", "root");
		
		PreparedStatement pst = con.prepareStatement("Update Bank_Account set pwd=? where uname =?");
		pst.setString(1, s2);
		pst.setString(2, s1);
		pst.executeUpdate();
		
		pw.println("<h2> Password Updated Successfully</h2>");
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.include(request, response);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
