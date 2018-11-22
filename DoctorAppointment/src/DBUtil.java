import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String mySqlUser = "root";
	private static final String mySqlPwd = "harshit9044";
	private static final String mySQLCS = "jdbc:mysql://localhost:3306/docapp";
	
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(mySQLCS,mySqlUser,mySqlPwd);
	}


}
