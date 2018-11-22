

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registerpatientservlet")
public class registerpatientservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   PrintWriter out = response.getWriter();
		   out.print("working ok");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DBUtil.getConnection();
			String username= request.getParameter("pusername");
			String password= request.getParameter("ppassword");
			
			String sql = "insert into loginpatient values(?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			
			int result = pstmt.executeUpdate();
			 
			if(result==1)
				out.println("successful updation");
			else out.println("failed to insert");
			pstmt.close();
			conn.close();
			
			response.sendRedirect("firsthomepage.jsp");
			
		} catch (Exception e) {
		
			out.println("Some Error Occured ");
			e.getMessage();
		}
		
		
	}

}
