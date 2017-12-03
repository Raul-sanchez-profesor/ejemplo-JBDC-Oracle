import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
 
/**
 * 
 * @author Raul Sanchez Galan
 * @version 1.0.0
 * 
 * Eemplo de uso de JDBC para conectarse a una base de datos Oracle local
 *
 */
public class Main {
 
    public static void main(String []args){
    	String user="admin";//Usuario de la BD
    	String password="admin";//Password del usuario de la base de datos
    	
    	Connection cn=abrirConexionConOracle(user,password); //Establecemos la conexion con Oracle
    	
    	String sentenciaSQL="DROP TABLE pablo";
    	ejecutaSentenciaSQL(sentenciaSQL,cn);//Ejecutamos la setencia SQL
    }

    
    
    
    
    
    
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

	private static Connection abrirConexionConOracle(String user, String password) {
		Connection cn=null;
		try {
			 cn = DriverManager.getConnection("jdbc:oracle:thin:"+user+"/"+password+"@localhost:1521:XE", user, password);
			return cn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cn;
	}
	
}