package Vacunacion.Modelo.DB;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class OperacionesBD{
	
	//Atributos para sentencias
	protected Statement consulta;
	protected PreparedStatement modifica;
	protected BD conexion;
	
	//Constructor con cadena conexi�n interna
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
				ms="Base de datos establecida con �xito.";
			}else {
				ms="Clase no encontrada. Conexi�n no establecida";
			}
		} catch (SQLException e) {
			ms="Error. Base de datos no conectada con �xito.\n"+ e.getMessage();
		}
		return ms;
	}
	
	public String DesconectarConexion() {
		String ms;
		boolean estado;
		try {
			estado=conexion.cerrarConexion();
			if (estado) {
				ms="Operaci�n realizada con �xito."; //Base de datos desconectada
			}else {
				ms="Clase no encontrada. Conexi�n no establecida";
			}
		} catch (SQLException e) {
			ms="Error al cerrar conexi�n.\n" + e.getMessage();
		}
		return ms;
	}
	
	
}
