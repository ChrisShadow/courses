package Vacunacion.Modelo.DB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Vacunacion.Modelo.Usuario;
import Vacunacion.Modelo.Vacuna;

public class OperacionesBD_Vacuna extends OperacionesBD implements Operacion{
	
	//Atributos
	private Vacuna vacu;	
	private OperacionesBD_Usuario oB= new OperacionesBD_Usuario();
		
	//Clases abstractas de la lista enlazada
	private List<Vacuna> listaVc; 	
	
	
	//Para la subfunción de opeaciones, consultar lista de las vacunas de la BD
	public List<Vacuna> getListaVc() {
		return listaVc;
	}

	//
	public Vacuna getVacu() {
		return vacu;
	}

	public void setVacu(Vacuna vacu) {
		this.vacu = vacu;
	}

	
	@Override
	public boolean CreateRow() throws SQLException {
		//Controla el resultado de executeUpdate
		int controlFun=0;
		boolean resul=false;
		String con=this.EstablecerConexion(); //valor del mensaje guardado en la función de la superclase OperacionesBD
		//System.out.println(con);
		if (con.equals("Base de datos establecida con éxito.")) {  //Evaluar el valor del mensaje guardado en la función de la superclase OperacionesBD
			String sentencia="INSERT INTO registro_vacuna (id_persona, nro_dosis, vacuna, lote, fecha_aplicacion, departamento, distrito) VALUES (?, ?, ?, ?, ?, ?, ?)";
			modifica=conexion.getConectar().prepareStatement(sentencia);
			modifica.setInt(1, vacu.getId().getId());
			modifica.setInt(2, vacu.getNroDosis());
			modifica.setString(3, vacu.getVacuna());
			modifica.setString(4, vacu.getLote());
			modifica.setString(5, vacu.getFechaAp());
			modifica.setInt(6, vacu.getNroDep());
			modifica.setString(7, vacu.getDistrito());
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
		String sentencia="Select * from registro_vacuna order by id_persona";
		Vacuna v;
		//subclase de la lista enlazada
		ArrayList<Vacuna> liV= new ArrayList<Vacuna>();
		String con=this.EstablecerConexion(); //valor del mensaje guardado en la función de la superclase OperacionesBD
		//System.out.println(con);
		if (con.equals("Base de datos establecida con éxito.")) {  //Evaluar el valor del mensaje guardado en la función de la superclase OperacionesBD
			this.consulta=this.conexion.getConectar().createStatement();
			result=consulta.executeQuery(sentencia);
			if (!result.equals(null)) { //Evalua existencia de tuplas en la tabla
				while (result.next()) {
					v=new Vacuna();
					int id=result.getInt("id_persona");
					Usuario u=oB.ReadRow(id) ; //Obtner el idUsuario
					v.setId(u);
					v.setNroDosis(result.getInt("nro_dosis"));
					v.setVacuna(result.getString("vacuna"));
					v.setLote(result.getString("lote"));
					v.setFechaAp(result.getString("fecha_aplicacion"));
					v.setNroDep(result.getInt("departamento"));
					v.setDistrito(result.getString("distrito"));
					liV.add(v);
				}
				listaVc=liV; //establecer la lista de Equipo
			}else {
				listaVc=null;
			}
			consulta.close();
		}else {
			listaVc=null;
		}
		
	}
	
	@Override
	public boolean UpdateRow() throws SQLException {
		//Controla el resultado de executeUpdate
		int controlFun=0;
		boolean resul=false;
		String con=this.EstablecerConexion(); //valor del mensaje guardado en la función de la superclase OperacionesBD
		//System.out.println(con);
		if (con.equals("Base de datos establecida con éxito.")) {  //Evaluar el valor del mensaje guardado en la función de la superclase OperacionesBD
			String sentencia="UPDATE registro_vacuna SET nro_dosis=?, vacuna=?, lote=?, fecha_aplicacion=?, departamento=?, distrito=? WHERE id_persona=?";
			modifica=conexion.getConectar().prepareStatement(sentencia);
			modifica.setInt(1, vacu.getNroDosis());
			modifica.setString(2, vacu.getVacuna());
			modifica.setString(3, vacu.getLote());
			modifica.setString(4, vacu.getFechaAp());
			modifica.setInt(5, vacu.getNroDep());
			modifica.setString(6, vacu.getDistrito());
			modifica.setInt(7, vacu.getId().getId());
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
			String sentencia="Delete from registro_vacuna WHERE id_persona=? and nro_dosis=?";
			modifica=conexion.getConectar().prepareStatement(sentencia);
			modifica.setInt(1, vacu.getId().getId());
			modifica.setInt(2, vacu.getNroDosis());
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

	public Vacuna ReadRow(int id) throws SQLException {
		ResultSet result=null;
		String sentencia="Select * from registro_vacuna where id_persona="+id;
		Vacuna v;
		String con=this.EstablecerConexion(); //valor del mensaje guardado en la función de la superclase OperacionesBD
		//System.out.println(con);
		if (con.equals("Base de datos establecida con éxito.")) {  //Evaluar el valor del mensaje guardado en la función de la superclase OperacionesBD
			this.consulta=this.conexion.getConectar().createStatement();
			result=consulta.executeQuery(sentencia);
			if (!result.equals(null)) { //Evalua existencia de tuplas en la tabla
				v=new Vacuna();
				while (result.next()) {
					int iD=result.getInt("id_persona");
					Usuario u=oB.ReadRow(iD) ; //Obtner el idUsuario
					v.setId(u);
					v.setNroDosis(result.getInt("nro_dosis"));
					v.setVacuna(result.getString("vacuna"));
					v.setLote(result.getString("lote"));
					v.setFechaAp(result.getString("fecha_aplicacion"));
					v.setNroDep(result.getInt("departamento"));
					v.setDistrito(result.getString("distrito"));
				}
			}else {
				v=null;
			}
			consulta.close();
		}else {
			v=null;
		}
		return v;
	}	
	
	
}
