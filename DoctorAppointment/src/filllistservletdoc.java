

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/filllistservletdoc")
public class filllistservletdoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ok");
		String username = request.getParameter("username");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "select sender from chattable where receiver = ? ";
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<String> l = new ArrayList<>();
			while(rs.next())
			{
				l.add(rs.getString(1));
			}
			
			String json = new Gson().toJson(l);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			System.out.println(username);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
