

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

@WebServlet("/fillchatboxservlet")
public class fillchatboxservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("fine");
		String receiver = request.getParameter("receiver");
		String sender = request.getParameter("sender");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "select * from chattable where sender = ? and receiver = ? union select * from chattable where sender = ? and receiver = ? order by tt asc";
			Connection conn = DBUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,sender);
			pstmt.setString(2,receiver);
			pstmt.setString(3,receiver);
			pstmt.setString(4,sender);
			
			ResultSet rs = pstmt.executeQuery();
			
			ArrayList<ArrayList<String>> l = new  ArrayList<ArrayList<String>>();
			
			while(rs.next())
			{
				ArrayList<String> li = new ArrayList<String>();
				li.add(rs.getString(1));
				li.add(rs.getString(3));
				li.add(rs.getString(4));
				l.add(li);
			}
			
			String json = new Gson().toJson(l);
			
			response.getWriter().write(json);
			
			//System.out.println(sender + receiver);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
