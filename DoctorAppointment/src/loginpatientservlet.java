

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/loginpatientservlet")
public class loginpatientservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("pusername");
		String password=request.getParameter("ppassword");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DBUtil.getConnection();
			HttpSession session = request.getSession();
			String sql = "select password from loginpatient where username = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs != null)
			{
				rs.next();
				String dbpassword = rs.getString("password");
				if( dbpassword.equals(password) )
				{
					session.setAttribute("patientusername", uname);
					response.sendRedirect("welcomepatient.jsp");
				}
				else out.println(" you entered wrong password ...so go back and try again:");
			}
			else
			{
				out.println("username does not exist ...go and register \n first");
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("unable to connect " + e.getMessage());
		}
		finally {
			out.close();
		}
		
	}

}
