

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/patientappointmentservlet")
public class patientappointmentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("doctorname");
		String type = request.getParameter("doctortype");
		String d = request.getParameter("date");
		String pname = request.getParameter("patientname");
		try {
			Connection conn=DBUtil.getConnection();
			String sql = "insert into "+username+" values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,pname);
			pstmt.setString(2,d);
			int t = pstmt.executeUpdate();
			response.getWriter().write("Congratulations! You have successfully registered .");
		}
		catch(Exception e)
		{
			response.getWriter().write("somethng went wrong , possible reason is : "+e.getMessage());
		}
	}

}
