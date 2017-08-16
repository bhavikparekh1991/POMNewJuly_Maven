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

        /*------connection url----*/
        String dbUrl= "jdbc:mysql://localhost:3307/bkptestdb";//

        /*------dbUsername----*/
        String dbUsername= "dbbkpfree";

        /*------dbPassword----*/
        String dbPassword= "iamhappy1234+";

        /*------db query---*/
        String query= "SELECT * FROM Presonal_Info";

        /*-----load Mysql jdbc driver------*/
        Class.forName("com.mysql.jdbc.Driver");


        /*----Get connection to DB*/
        Connection con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);

        //create statement object
        Statement stmt = con.createStatement();

        //send sql query to database
        ResultSet rs= stmt.executeQuery(query);


        // while loop to get ResultSet all rows data
        while(rs.next()){

            //Store columns state,country,created,modified as separate strings 

            //(pls chk spellings of column name and also datatypes of the column if it is int change it to (rs.getInt) before running)

            String state =rs.getString("name");
            String country =rs.getString("country_id");
            String created_DATE= rs.getString("created");
            String modified_DATE=rs.getString("modified");
            System.out.println(state);
            System.out.println(country);
            System.out.println(created_DATE);
            System.out.println(modified_DATE);
        }

        //Close db connection

        con.close();
 }

}
