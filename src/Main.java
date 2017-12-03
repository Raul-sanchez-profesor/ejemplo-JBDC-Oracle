import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

 
/**
 * 
 * @author Raul Sanchez Galan
 * @version 1.0
 * 
 * Ejemplo de uso de JDBC para conectarse a una base de datos Oracle local
 *
 */
public class Main {
 
    public static void main(String []args){
    	String user="admin";//Usuario de la BD
    	String password="admin";//Password del usuario de la base de datos
    	
    	Connection cn=abrirConexionConOracle(user,password); //Establecemos la conexion con Oracle
    	
    	String sentenciaSQL="DROP TABLE persona";
    	ejecutaSentenciaSQL(sentenciaSQL,cn);//Ejecutamos la setencia SQL
    }

    
    
    
    
    
    /**
     * Metodo para ejecutar una setencia SQL, dada una conexion a una base de datos
     * 
     * @param sentenciaSQL String que contiene la setencia sql que se va a ejecutar
     * @param cn Connection. Conexión a la base de datos sobre la que se va a ejecutar la sentencia SQL
     */
	private static void ejecutaSentenciaSQL(String sentenciaSQL, Connection cn) {
		Statement stmt = null;
		try {
			stmt = cn.createStatement();
			stmt.executeUpdate(sentenciaSQL);
			cn.close();//Cerramos la conexion
			System.out.println("Setencia ejecutada con exito");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Metodo para abrir una conexion estandar para Oracle Express en local
	 * dado un usuario y contraseña
	 * 
	 * @param user String. Usuario de la conexión.
	 * @param password String. Password
	 * @return Connection. La conexión establecida.
	 */
	private static Connection abrirConexionConOracle(String user, String password) {
		Connection cn=null;
		try {
			 cn = DriverManager.getConnection("jdbc:oracle:thin:"+user+"/"+password+"@localhost:1521:XE", user, password);
			return cn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
	}
	
}