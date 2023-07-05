import java.sql.*;

import javax.swing.JOptionPane;

public class TestPsqlCon {
	
	Psql con= new Psql();
	private Statement ps;
	private PreparedStatement pss;
	
	public ResultSet consultarBD(String sql) {
		ResultSet consulta=null;
		try {
			con.crearConexion();
			ps=con.getConectar().createStatement();
			consulta=ps.executeQuery(sql);
			System.out.println("Datos seleccionados correctamente (:=)");
			return consulta;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrió un error en la consulta." + e.getMessage());
			System.out.println("Programa finalizado.");
		}finally {
			con.cerrarConexion();
		}
		return consulta;
	}
	/*public void  ejecutarSQL(String sql) {
		con.crearConexion();
		try {
			ps= con.getConectar().prepareStatement(sql);
			ps.execute();
			ps.close();
			con.cerrarConexion();
			System.out.println("Datos seleccionados correctamente (:=).");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocurrió un error." + e.getMessage());
			System.out.println("Programa finalizado.");
		}
	}*/
	
	
	public static void main(String[] args) {
		TestPsqlCon metodos = new TestPsqlCon();
		ResultSet consulta=null;
		consulta=metodos.consultarBD("select * from \"Persona\";");
		try {
			while(consulta.next()) {
				System.out.println("Id Persona: " + consulta.getString("Idpersona")+"\nNro. Cedula: "+ consulta.getString("Cedula")+
						"\nNombre y Apelldido: "+consulta.getString("Nombre")+"\nEdad: "+consulta.getString("Edad")+"\nPrograma finalizado.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//Eliminar
		//DELETE FROM \"Persona\" WHERE \"Idpersona\"=5;
		//Actualizar
		//UPDATE \"Persona\"	SET \"Cedula\"='6695012',  \"Nombre\"='Julio Ortellado'" + "	WHERE \"Idpersona\"=1;
		//Insertar
		//insert into \"Persona\"(\"Cedula\", \"Nombre\",\"Edad\") " + "Values('6695011','Chris Daniel',21);
			
	}
}
