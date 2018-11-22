

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
;

@WebServlet("/doctorlistservlet")
public class doctorlistservlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String dtype = request.getParameter("doctortype");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DBUtil.getConnection();	
			String sql ="select * from logindoctor where doctortype =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dtype );
			ResultSet rs = pstmt.executeQuery();
			String result = "";
			while(rs.next())
			{
				result += rs.getString("username") + "|";
			}
			result=result.substring(0,result.length()-1);
			
			String json= new Gson().toJson(result);
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
			//response.getWriter().write("{\"name\":\""+ result +"\"}");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		//response.setContentType("text/html");
		//String json=new Gson().toJson();
		//response.setContentType("application/json");
		//response.setCharacterEncoding("UTF-8");
		//response.getWriter().write(json);
	}

}
