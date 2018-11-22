

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registerdoctorservlet")
public class registerdoctorservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DBUtil.getConnection();
			String username = request.getParameter("dusername");
			String password = request.getParameter("dpassword");
			String doctype = request.getParameter("doctortype");
			String sql = "insert into logindoctor values(?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2, password);
			pstmt.setString(3,doctype);
			
			int result = pstmt.executeUpdate();
			
			
			String sql2="create table "+username+"(patientname varchar(120),date varchar(120))";
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			int result2 = pstmt2.executeUpdate();
			System.out.println(result);
			System.out.println(result2);
			pstmt.close();
			pstmt2.close();
			conn.close();
			response.sendRedirect("firsthomepage.jsp");
		} catch (Exception e) {
			out.println("something went wrong : " + e.getMessage());
		}
	}

}
