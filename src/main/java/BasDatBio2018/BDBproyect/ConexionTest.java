package BasDatBio2018.BDBproyect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class ConexionTest {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String query = "SELECT gene_id, stable_id from gene";
        
        try {
            
        	conn =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/ailuropoda_melanoleuca_core_91_1?" +
                                           "user=root&password=mojitomoreno96&useSSL=false&serverTimezone=UTC");

            // Do something with the Connection
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            
            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }
            
            while ( rs.next() ) {
                int numColumns = rs.getMetaData().getColumnCount();
                for ( int i = 1 ; i <= numColumns ; i++ ) {
                   // Column numbers start at 1.
                   // Also there are many methods on the result set to return
                   //  the column as a particular type. Refer to the Sun documentation
                   //  for the list of valid conversions.
                    System.out.print(rs.getObject(i) + "\t");
                }
                System.out.print('\n');
            }

           
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
        	if(rs != null) {
        		try {
        			rs.close();
        		}catch (SQLException sqlEx) {} //ignore
        		
        		rs = null;
        	}
        	
        	if (stmt != null) {
        		try {
        			stmt.close();
        		} catch (SQLException sqlEx) {} //ignore
        		
        		stmt = null;
        	}
        }
    }
}
