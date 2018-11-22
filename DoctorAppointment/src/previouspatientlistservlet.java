

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class previouspatientlistservlet
 */
@WebServlet("/previouspatientlistservlet")
public class previouspatientlistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = (String)request.getParameter("docname");
		PrintWriter out = response.getWriter();
		try {
			Connection conn = DBUtil.getConnection();
			String sql = "select * from "+s;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet r = pstmt.executeQuery();
			
			ArrayList<HashMap<String,String>> l=new ArrayList<HashMap<String,String>>();
			
			Date presentdate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			/*patients p = new patients();
			p.name="Amit";
			p.date="kkk";*/
			while(r.next())
			{
				Date rdate = sdf.parse(r.getString(2));
				if(presentdate.compareTo(rdate) > 0)
				{
					HashMap<String,String> h = new HashMap<>();
					h.put("name", r.getString(1));
					h.put("date", r.getString(2));
					l.add(h);
				}
			}
			String json = new Gson().toJson(l);
			out.write(json);
		/*	while(r.next())
			{
				
			}*/
		}catch(Exception e)
		{
			out.write("Someting went wrong : "+ e.getMessage());
		}
		
	}

}
