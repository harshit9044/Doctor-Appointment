

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/patientsendmsgservlet")
public class patientsendmsgservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String a = request.getParameter("sender");
			String b = request.getParameter("receiver");
			String c = request.getParameter("message");
			//System.out.println(a+b+c);
			String sql = "insert into chattable (sender , receiver , msg) values(?,?,?)";
			Connection conn=DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,a);
			pstmt.setString(2, b);
			pstmt.setString(3,c);
			
			int q = pstmt.executeUpdate();
			if(q>0)
				System.out.println("successful");
			else System.out.println("fucked up");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
