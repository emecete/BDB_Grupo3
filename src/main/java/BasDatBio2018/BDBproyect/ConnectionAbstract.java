package BasDatBio2018.BDBproyect;

/*
 * Clase abstracta relacionada con la conexión a la base de datos. Su implementación 
 * dependerá de tres clases concretas que heredan de esta. Cada una de estas clases concretas 
 * corresponderá a la conexión en cada uno de los tres SGBD.
 */
public abstract class ConnectionAbstract {
	
	//Indica si la consulta es optimizada o no	
	private boolean opt;					
	
	
	//Constructor de la clase
	public ConnectionAbstract(boolean opt){		
		this.opt = opt;						
	}
	
	//Realiza una consulta
	public abstract void MakeQuery(String search, String category);	
	
	//Combrueba si la consulta ha devuelto un resultado
	public abstract boolean QueryMade();	
	
}
