package BasDatBio2018.BDBproyect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Esta clase corresponde a las conexiones realizadas con las peculiaridades de MySQL.
 */
public class ConnectionMySQL extends ConnectionAbstract{
	private Connection conn;
	private Statement stmt;
    private ResultSet rs;
	
	public ConnectionMySQL(boolean opt) {
		super(opt);
		conn=null;
		stmt=null;
		rs=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
		}
		
		try {
            /* Esta variable guarda el nombre de la base de datos en la que se realiza la conexión. Si la consulta es optimizada
             * conecta con la base de datos optimizada(en este caso con la que tiene índices), y si no, conecta con la no optimizada.
             */
			String bd;
			if(opt == true) {
            	bd = "ailuropoda_melanoleuca_core_91_1";
            }else {
            	bd = "ailuropoda_melanoleuca_core_91_1_sin_indices";
            }
        	conn =
               DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ bd +"?" +
                                           "user=root&password=mojitomoreno96&useSSL=false&serverTimezone=UTC");
		}catch(SQLException ex) {
	            // handle any errors
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	    }
	}
	
	public boolean QueryMade() {
		return rs != null;
	}
	
	public void MakeQuery(String search, String category) {
		
		Search mysearch = new Search(search, category);
		String myquery = mysearch.SimpleSearch();
	/*
	 * Procedimiento típico para realizar consultas. Se crea un Statement a partir de la conexión. Se ejecuta una consulta
	 * en el Statement mediante el método .executeQuery(...). La consulta la habremos elaborado previamente a través de la clase Search.
	 * Si la consulta se ejecuta correctamente, guardamos el resultado en rs que es del tipo ResultSet. Tanto stmt con rs están declarados
	 * como atributos privados de la clase.		
	 */
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(myquery);
        
			if (stmt.execute(myquery)) {
				rs = stmt.getResultSet();
			}
			
		}catch(SQLException ex){
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
		}
	}	
	
	
}
