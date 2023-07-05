import java.sql.*;
import javax.swing.*;

public class Psql {
	static final String URL = "jdbc:postgresql://localhost:5432/dbprueba";
	static final String USER = "postgres";
	static final String PASS = "123ABC459";
	private Connection conectar;
	
	// 
	public Connection getConectar() {
		return conectar;
	}

	public static String getUrl() {
		return URL;
	}

	public static String getUser() {
		return USER;
	}

	public static String getPass() {
		return PASS;
	}

	public void crearConexion(){
		try {
			Class.forName("org.postgresql.Driver");
			conectar = DriverManager.getConnection(URL, USER, PASS);
			JOptionPane.showMessageDialog(null, "Base de datos conectada con éxito.");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al conectar." + e);
		}	
	}
	
	public void cerrarConexion() {
		try {
			conectar.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cerrar conexión." + e);
		}
	}
	
	
	
}
