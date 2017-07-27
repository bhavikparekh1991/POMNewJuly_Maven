package testScripts;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;*/
import java.sql.*;

import org.testng.annotations.Test;

public class DBConnection {

	@Test
	public void DBtest() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection("https://www.obvibase.com/#table/nilzSFCAV78dVZAJ/*","bhavikparek","spring23");
		Statement stmt = con.createStatement();
		ResultSet resultSet = stmt.executeQuery("select * from accounts");
		System.out.println(resultSet);
		System.out.println("DB");
		
	

	}

}
