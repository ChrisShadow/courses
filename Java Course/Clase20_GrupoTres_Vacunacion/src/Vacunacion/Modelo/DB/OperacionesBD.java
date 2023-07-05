package Vacunacion.Modelo.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class OperacionesBD{
	
	//Atributos para sentencias
	protected Statement consulta;
	protected PreparedStatement modifica;
	protected BD conexion;
	
	//Constructor con cadena conexión interna
	public OperacionesBD() {
		conexion=new BD();
	}

	public  OperacionesBD(BD conexion) {
		this.conexion = conexion;
	}
	
	public String EstablecerConexion() {
		String ms;
		boolean estado;
		try {
			estado= conexion.crearConexion();
			if (estado) {
				ms="Base de datos establecida con éxito.";
			}else {
				ms="Clase no encontrada. Conexión no establecida";
			}
		} catch (SQLException e) {
			ms="Error. Base de datos no conectada con éxito.\n"+ e.getMessage();
		}
		return ms;
	}
	
	public String DesconectarConexion() {
		String ms;
		boolean estado;
		try {
			estado=conexion.cerrarConexion();
			if (estado) {
				ms="Operación realizada con éxito."; //Base de datos desconectada
			}else {
				ms="Clase no encontrada. Conexión no establecida";
			}
		} catch (SQLException e) {
			ms="Error al cerrar conexión.\n" + e.getMessage();
		}
		return ms;
	}
	
	
}
