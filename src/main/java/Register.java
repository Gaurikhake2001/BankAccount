

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		out.println("<body style='min-height: 150vh;background-color:white;'>"
				+ "<div style='margin:auto;width: 1000px;max-width: 100%;'>"
				+ "<form method='get' action='Registration'style='align-content:center;width:20%;height:100%;padding:20px;align-content:center;background-color: skyblue;border-radius: 4px;box-shadow: 0 8px 16px;'>"
				+ "<h2 style='align:center; color:Green; text-transform: uppercase; text-decoration: underline; text-shadow: 2px 0px lime;'>Registration page</h2>"
				+ "Username:<input type='text' name='t1'><br><br>"
				+ "Password:<input type='text' name='t2'><br><br>"
				+ "First Name:<input type='text' name='t3'><br><br>"
				+ "Last Name:<input type='text' name='t4'><br><br>"
				+ "Account No.:<input type='text' name='t5'><br><br>"
				+ "Contact No.:<input type='text' name='t6'><br><br>"
				+ "Address<input type='text' name='t7'><br><br>"
				+ "Balance<input type='text' name='t8'><br><br>"
				+ "<input type='submit' value='Register'style=' margin-left: 15%; width: 120px; height: 34px;background: blue;border-radius:4px;cursor: pointer;margin-top: 20px;'>"
				+ "</form>");
	}

}
