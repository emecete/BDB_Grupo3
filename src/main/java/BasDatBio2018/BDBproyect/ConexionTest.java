package BasDatBio2018.BDBproyect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionTest {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/ailuropoda_melanoleuca_core_91_1?" +
                                           "user=root&password=mojitomoreno96&useSSL=false");

            // Do something with the Connection

           
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
