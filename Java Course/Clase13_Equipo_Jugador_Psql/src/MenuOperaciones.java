import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class MenuOperaciones {
	
	
	//Atributos para sentencias
	private Statement consulta;
	private PreparedStatement modifica;
	
	//Clases abstractas de la lista enlazada
	private List<Equipo> listaEq; 
	private List<Jugador> listaJug; 
	
	//Clase BD
	private BD bd;
	
	//
	public MenuOperaciones() {
		this.bd= new BD();
	}
	
	public MenuOperaciones(BD bd) {
		this.bd = bd;
	}
	
	
	//
	public BD getBd() {
		return bd;
	}

	public void setBd(BD bd) {
		this.bd = bd;
	}
	
	//Funciones para jugador

	//Insertar
	public boolean SentenciaInsertar(Jugador j) throws SQLException {
		//Controla el resultado de executeUpdate
		int controlFun=0;
		boolean i;
		String insertSql="insert into jugador (nro_documento, tipo_documento, nombres, apellidos, fecha_nacimiento, id_equipo) VALUES ( ?, ?, ?, ?, ?, ?)";
		bd.crearConexion();
		modifica= bd.getConectar().prepareStatement(insertSql);
		modifica.setString(1, j.getNroDoc());
		modifica.setString(2, j.getTipoDoc());
		modifica.setString(3, j.getNombre());
		modifica.setString(4, j.getApellido());
		modifica.setString(5, j.getFechaNac());
		modifica.setInt(6, j.getIdEqu().getIdEq());
		controlFun= modifica.executeUpdate();
		//Control del resultado de executeUpdate
		if (controlFun>0) {
			i=true;
		}else{
			i=false;
		}
		modifica.close();	
		//this.cerrarConexion();
			
		return i;
	}
	

	//Modificar
	public boolean SentenciaModificar(Jugador j) throws SQLException {
		//Controla el resultado de executeUpdate
		int controlFun=0;
		boolean i;
		String modtSql="UPDATE jugador SET  total_tarjetas_rojas=?, total_tarjetas_amarillas=?, total_tantos_convertidos=? WHERE id_jugador=?";
		bd.crearConexion();
		modifica= bd.getConectar().prepareStatement(modtSql);
		modifica.setInt(1, j.getTotTarRo());
		modifica.setInt(2, j.getTotTarAm());
		modifica.setInt(3, j.getTotTanConv());
		modifica.setLong(4, j.getIdjug());
		controlFun= modifica.executeUpdate();
		//Control del resultado de executeUpdate
		if (controlFun>0) {
			i=true;
		}else{
			i=false;
		}
		modifica.close();	
		//*this.cerrarConexion();	
		return i;
	}
	
	//Eliminar
	public int SentenciaEliminar(Jugador j) throws SQLException {
		//Controla el resultado de executeUpdate, cantidad de filas eliminadas
		int controlFun=0;
		String elimSql="Delete From jugador WHERE id_jugador=?";
		bd.crearConexion();
		modifica= bd.getConectar().prepareStatement(elimSql);
		modifica.setLong(1, j.getIdjug());
		controlFun= modifica.executeUpdate();
		/*Control del resultado de executeUpdate
		if (controlFun==1) {
			i=true;
		}else{
			i=false;
		}*/
		modifica.close();	
		//*this.cerrarConexion();	
		return controlFun;
	}	
	
	//Consulta Lista Jugador
	public List<Jugador> consultarJugador() throws SQLException {
		String sql= "SELECT * FROM jugador Order by id_jugador";
		ResultSet result=null;
		Jugador j=null;
		//subclase de la lista enlazada
		ArrayList<Jugador> liJ= new ArrayList<Jugador>();
		bd.crearConexion();
		consulta=bd.getConectar().createStatement();
		result=consulta.executeQuery(sql);
		//Evaluar contenido de la tupla
		if (!result.equals(null)) {
			while (result.next()) {
				j=new Jugador();
				j.setIdjug(result.getLong("id_jugador"));
				j.setNroDoc(result.getString("nro_documento"));
				j.setTipoDoc(result.getString("tipo_documento"));
				j.setNombre(result.getString("nombres"));
				j.setApellido(result.getString("apellidos"));
				j.setFechaNac(result.getString("fecha_nacimiento"));
				j.setTotTarRo(result.getInt("total_tarjetas_rojas"));
				j.setTotTarAm(result.getInt("total_tarjetas_amarillas"));
				j.setIdEqu(RecurperarEquipo(result.getInt("id_equipo")));
				j.setTotTanConv(result.getInt("total_tantos_convertidos"));
				liJ.add(j);
			}
			listaJug=liJ; //establecer la lista de Equipo
		}else {
			listaJug=null;
		}
		consulta.close();
		//System.out.println("Datos seleccionados correctamente");
		return listaJug;	
	}	
		

	private Equipo RecurperarEquipo(int codE) throws SQLException {
		String sql= "SELECT * FROM equipo where id="+codE;
		ResultSet result=null;
		Equipo e=null;
		bd.crearConexion();
		consulta=bd.getConectar().createStatement();
		result=consulta.executeQuery(sql);
		//Evaluar contenido de la tupla
		if (!result.equals(null)) {
			e=new Equipo();
			while (result.next()) {
				e.setIdEq(result.getInt("id"));
				e.setNombre(result.getString("nombre"));
				e.setLimJug(result.getInt("limitejudador"));
			}
		}else {
			e=null;
		}
		consulta.close();
		return e;	
	}

	//Consulta Lista Equipo
	public List<Equipo> consultarEquipo() throws SQLException {
		String sql= "SELECT * FROM equipo";
		ResultSet result=null;
		//Equipo e=null;
		//subclase de la lista enlazada
		ArrayList<Equipo> liE= new ArrayList<Equipo>();
		bd.crearConexion();
		consulta=bd.getConectar().createStatement();
		result=consulta.executeQuery(sql);
		//Evaluar contenido de la tupla
		if (!result.equals(null)) {
			//e=new Equipo();
			while (result.next()) {
				/*e.setIdEq(result.getInt("id"));
				e.setNombre(result.getString("nombre"));
				e.setLimJug(result.getInt("limitejudador"));*/
				liE.add(new Equipo(result.getInt("id"),result.getString("nombre"),result.getInt("limitejudador")));
			}
			listaEq=liE; //establecer la lista de Equipo
		}else {
			listaEq=null;
		}
		consulta.close();
		//System.out.println("Datos seleccionados correctamente");
		return listaEq;	
	}
	
		
		
}
