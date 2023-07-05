package Vacunacion.Modelo.DB;

import java.sql.SQLException;

public interface Operacion {
	
	//Operciones abstractas para la sobrescritura en la superclase que lo implementan
	boolean CreateRow() throws SQLException;
	void ReadRow() throws SQLException;
	boolean UpdateRow() throws SQLException;
	boolean DeleteRow() throws SQLException;
	
}
