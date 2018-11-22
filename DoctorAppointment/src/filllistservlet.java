

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

/**
 * Servlet implementation class filllistservlet
 */
@WebServlet("/filllistservlet")
public class filllistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("working");
			String str= "select * from logindoctor";
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(str);
			ResultSet rs = pstmt.executeQuery();
			//String result ="" ;
			
			ArrayList<String> list = new ArrayList<String>();
			
			while(rs.next())
			{
				list.add(rs.getString(1));
			}
			
			String json= new Gson().toJson(list);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			//System.out.println("working2");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
