import java.sql.*;


public class BD {

	//Atributos de conexión
	static final String URL = "jdbc:postgresql://localhost:5432/jugador";
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
	
	public boolean crearConexion() throws SQLException{
		boolean result;
		try {
			Class.forName("org.postgresql.Driver");
			conectar = DriverManager.getConnection(URL,USER,PASS);
			result=true;
		} catch (ClassNotFoundException e) {
			System.err.println("Error al conectar." + e);
			result=false;
		}
		return result;
	}
	
	public boolean cerrarConexion() throws SQLException{
		boolean result;
		try {
			Class.forName("org.postgresql.Driver");
			conectar.close();
			result=true;
		} catch (ClassNotFoundException e) {
			System.err.println("Error al cerrar conexión." + e);
			result=false;
		}
		return result;
	}
	
}
