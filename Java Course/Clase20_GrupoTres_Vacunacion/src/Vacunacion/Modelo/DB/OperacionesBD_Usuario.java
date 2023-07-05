package Vacunacion.Modelo.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Vacunacion.Modelo.Usuario;

public class OperacionesBD_Usuario extends OperacionesBD implements Operacion{

	//Atributos
	private Usuario user;
	
	//Clases abstractas de la lista enlazada
	private List<Usuario> listaUs; 	
	
	
	//Para la subfunción de opeaciones, consultar lista de los usuarios de la BD
	public List<Usuario> getListaUs() {
		return listaUs;
	}


	//
	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	@Override
	public boolean CreateRow() throws SQLException {
		//Controla el resultado de executeUpdate
		int controlFun=0;
		boolean resul=false;
		String con=this.EstablecerConexion(); //valor del mensaje guardado en la función de la superclase OperacionesBD
		//System.out.println(con);
		if (con.equals("Base de datos establecida con éxito.")) {  //Evaluar el valor del mensaje guardado en la función de la superclase OperacionesBD
			String sentencia="INSERT INTO usuario(nombre, distrito, numero_registro, correo, estado) VALUES ( ?, ?, ?, ?, ?)";
			modifica=conexion.getConectar().prepareStatement(sentencia);
			modifica.setString(1, user.getNombre());
			modifica.setString(2, user.getDistrito());
			modifica.setInt(3, user.getNroReg());
			modifica.setString(4, user.getCorreo());
			modifica.setString(5, user.getEstado());
			controlFun= modifica.executeUpdate();
			//Control del resultado de executeUpdate
			if (controlFun>0) {
				resul=true;
			}else{
				resul=false;
			}
			modifica.close();
		}else{
			resul=false;
		}
		
		return resul;
	}
	
	@Override
	public void ReadRow() throws SQLException {
		ResultSet result=null;
		String sentencia="Select * from usuario order by id_usuario";
		Usuario u;
		//subclase de la lista enlazada
		ArrayList<Usuario> liU= new ArrayList<Usuario>();
		String con=this.EstablecerConexion(); //valor del mensaje guardado en la función de la superclase OperacionesBD
		//System.out.println(con);
		if (con.equals("Base de datos establecida con éxito.")) {  //Evaluar el valor del mensaje guardado en la función de la superclase OperacionesBD
			consulta=conexion.getConectar().createStatement();
			result=consulta.executeQuery(sentencia);
			if (!result.equals(null)) { //Evalua existencia de tuplas en la tabla
				while (result.next()) {
					u=new Usuario();
					u.setId(result.getInt("id_usuario"));
					u.setNombre(result.getString("nombre"));
					u.setDistrito(result.getString("distrito"));
					u.setNroReg(result.getInt("numero_registro"));
					u.setCorreo(result.getString("correo"));
					u.setEstado(result.getString("estado"));
					liU.add(u);
				}
				listaUs=liU; //establecer la lista de Equipo
			}else {
				listaUs=null;
			}
			consulta.close();
		}else {
			listaUs=null;
		}
	}
	
	//Para consultar por Id usuario
	public Usuario ReadRow(int idU) throws SQLException {
		ResultSet result=null;
		String sentencia="Select * from usuario where id_usuario="+idU;
		Usuario u=null;
		String con=this.EstablecerConexion(); //valor del mensaje guardado en la función de la superclase OperacionesBD
		//System.out.println(con);
		if (con.equals("Base de datos establecida con éxito.")) {  //Evaluar el valor del mensaje guardado en la función de la superclase OperacionesBD
			this.consulta=this.conexion.getConectar().createStatement();
			result=consulta.executeQuery(sentencia);
			if (!result.equals(null)) { //Evalua existencia de tuplas en la tabla
				while (result.next()) {
					u=new Usuario();
					u.setId(result.getInt("id_usuario"));
					u.setNombre(result.getString("nombre"));
					u.setDistrito(result.getString("distrito"));
					u.setNroReg(result.getInt("numero_registro"));
					u.setCorreo(result.getString("correo"));
					u.setEstado(result.getString("estado"));
				}
			}else {
				u=null;
			}
			consulta.close();
		}else {
			u=null;
		}
		
		return u;
	}
	
	@Override
	public boolean UpdateRow() throws SQLException {
		//Controla el resultado de executeUpdate
		int controlFun=0;
		boolean resul=false;
		String con=this.EstablecerConexion(); //valor del mensaje guardado en la función de la superclase OperacionesBD
		//System.out.println(con);
		if (con.equals("Base de datos establecida con éxito.")) {  //Evaluar el valor del mensaje guardado en la función de la superclase OperacionesBD
			String sentencia="UPDATE usuario SET  nombre=?, distrito=?, numero_registro=?, correo=?, estado=? WHERE id_usuario=?";
			modifica=conexion.getConectar().prepareStatement(sentencia);
			modifica.setString(1, user.getNombre()); //En el mismo orden que la sentencia cuidando el tipo de dato de la bd
			modifica.setString(2, user.getDistrito());
			modifica.setInt(3, user.getNroReg());
			modifica.setString(4, user.getCorreo());
			modifica.setString(5, user.getEstado());
			modifica.setInt(6, user.getId());
			controlFun= modifica.executeUpdate();
			//Control del resultado de executeUpdate
			if (controlFun>0) {
				resul=true;
			}else{
				resul=false;
			}
			modifica.close();
		}else{
			resul=false;
		}
		
		return resul;		
	}
	
	@Override
	public boolean DeleteRow() throws SQLException {
		//Controla el resultado de executeUpdate
		int controlFun=0;
		boolean resul=false;
		String con=this.EstablecerConexion(); //valor del mensaje guardado en la función de la superclase OperacionesBD
		//System.out.println(con);
		if (con.equals("Base de datos establecida con éxito.")) {  //Evaluar el valor del mensaje guardado en la función de la superclase OperacionesBD
			String sentencia="Delete from usuario WHERE id_usuario=?";
			modifica=conexion.getConectar().prepareStatement(sentencia);
			modifica.setInt(1, user.getId());
			controlFun= modifica.executeUpdate();
			//Control del resultado de executeUpdate
			if (controlFun>0) {
				resul=true;
			}else{
				resul=false;
			}
			modifica.close();
		}else{
			resul=false;
		}
		
		return resul;			
	}	
	
	
}
