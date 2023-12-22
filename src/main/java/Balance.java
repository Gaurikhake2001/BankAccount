

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


@WebServlet("/Balance")
public class Balance extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String s1 = request.getParameter("a");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Account" ,"root","root");
			
			
			PreparedStatement ps = con.prepareStatement("select Balance from Bank_Account where Ac_No=?");
			ps.setString(1, s1);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				out.println("<h2>Your Balance is"+ rs.getString(1)+"<h2>");
			}
			else
			{
				
				out.println("<h2>No Such Account Exists</h2>");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	}

}
