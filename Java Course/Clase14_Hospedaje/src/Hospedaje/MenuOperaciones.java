package Hospedaje;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MenuOperaciones extends DB {
		
	//Atributos para sentencias
	private Statement consulta;
	private PreparedStatement modifica;		
				
	
	
	public MenuOperaciones() {
		super();
	}
	

	//Clases de la lista enlazada
	private ArrayList<Hospedaje> liH= new ArrayList<Hospedaje>(); 
	
	//Clases de los valores posibles de Enum
	Pais arg= Pais.ARGENTINA;
	Pais bra= Pais.BRASIL;
	Pais py= Pais.PARAGUAY;
	Pais chi= Pais.CHILE;
	
	Estado act= Estado.ACTIVO;
	Estado inac= Estado.INACTIVO;
	
	//Funciones para hospedaje
	
	//Insertar
	public boolean SentenciaInsertar(Hospedaje h) throws SQLException {
		//Controla el resultado de executeUpdate
		int controlFun=0;
		boolean i,conex;
		String insertSql="insert into hospedaje (num_hospedaje,documento_cliente, can_dias_hospedaje, nro_piso, nro_habitacion, pais, monto_total,monto_cancelado,estado) VALUES ( nextval('hospedaje_num_hospedaje_seq'::regclass),?, ?, ?, ?, ?, ?,?,?)";
		conex=crearConexion();
		if (conex) {
			modifica= getConectar().prepareStatement(insertSql);
			modifica.setString(1, h.getNroDoc());
			modifica.setInt(2, h.getCanDiasHos());
			modifica.setInt(3, h.getNroPiso());
			modifica.setInt(4, h.getNroHabi());
			modifica.setString(5, h.getPais().name());
			modifica.setInt(6, h.getMontoTotal());
			modifica.setInt(7, h.getMontoCan());
			modifica.setString(8, h.getEst().name());
			controlFun= modifica.executeUpdate();
			//Control del resultado de executeUpdate
			if (controlFun>0) {
				i=true;
			}else{
				i=false;
			}
			modifica.close();
		}else {
			i=false;
		}	
		return i;
	}
		

	//Modificar
	public int SentenciaModificar(Hospedaje h) throws SQLException {
		//Controla el resultado de executeUpdate
		int controlFun=0;
		boolean conex;
		String modtSql="UPDATE hospedaje SET  can_dias_hospedaje=?, monto_total=?, monto_cancelado=?, estado=? WHERE num_hospedaje=?";
		conex=crearConexion();
		if (conex) {
			modifica= getConectar().prepareStatement(modtSql);
			modifica.setInt(1, h.getCanDiasHos());
			modifica.setInt(2, h.getMontoTotal());
			modifica.setInt(3, h.getMontoCan());
			modifica.setString(4, h.getEst().name());
			modifica.setInt(5, h.getNroHos());
			controlFun= modifica.executeUpdate();
			modifica.close();	
		}else {
			controlFun=0;
		}
		return controlFun;
	}			
		
	//Eliminar
	public boolean SentenciaEliminar(Hospedaje h) throws SQLException {
		//Controla el resultado de executeUpdate, cantidad de filas eliminadas
		int controlFun=0;
		boolean i,conex;
		String elimSql="Delete From hospedaje WHERE num_hospedaje=?";
		conex=crearConexion();
		if (conex) {
			modifica= getConectar().prepareStatement(elimSql);
			modifica.setInt(1, h.getNroHos());
			controlFun= modifica.executeUpdate();
			//Control del resultado de executeUpdate
			if (controlFun==1) {
				i=true;
			}else{
				i=false;
			}
			modifica.close();
		}else {
			i=false;
		}		
		return i;
	}				
		
	//Consulta Lista Hospedaje
	public ArrayList<Hospedaje> consultarHospedaje() throws SQLException {
		String sql= "SELECT * FROM hospedaje Order by num_hospedaje";
		ResultSet result=null;
		Hospedaje h=null;
		String pais="";
		String estado="";
		boolean conex;
		conex=crearConexion();
		if (conex) {
			consulta=getConectar().createStatement();
			result=consulta.executeQuery(sql);
			//Evaluar contenido de la tupla
			if (!result.equals(null)) {
				while (result.next()) {
					h=new Hospedaje();
					h.setNroHos(result.getInt("num_hospedaje"));
					h.setNroDoc(result.getString("documento_cliente"));
					h.setCanDiasHos(result.getInt("can_dias_hospedaje"));
					h.setNroPiso(result.getInt("nro_piso"));
					h.setNroHabi(result.getInt("nro_habitacion"));
					pais=result.getString("pais");
					h.setMontoTotal(result.getInt("monto_total"));
					h.setMontoCan(result.getInt("monto_cancelado"));
					estado=result.getString("estado");
					//Pais
					if(pais.equals("ARGENTINA")) {
						h.setPais(arg);
					}else if(pais.equals("BRASIL")) {
						h.setPais(bra);
					}else if(pais.equals("PARAGUAY")) {
						h.setPais(py);
					}else {
						h.setPais(chi);
					}
					
					//Estado
					if(estado.equals("ACTIVO")) {
						h.setEst(act);
					}else{
						h.setEst(inac);
					}
					//Añadir a la lista
					liH.add(h);
				}
			}else {
				liH=null;
			}
			consulta.close();
		}else {
			liH=null;
		}
		return liH;	
	}


	public Hospedaje BuscarHospedaje(int numH) throws SQLException {
		String sql= "SELECT * FROM hospedaje where num_hospedaje="+numH+ "Order by num_hospedaje ";
		ResultSet result=null;
		Hospedaje h=null;
		String pais="";
		String estado="";
		boolean conex;
		conex=crearConexion();
		if (conex) {
			consulta=getConectar().createStatement();
			result=consulta.executeQuery(sql);
			//Evaluar contenido de la tupla
			if (!result.equals(null)) {
				h=new Hospedaje();
				while (result.next()) {
					h.setNroHos(result.getInt("num_hospedaje"));
					h.setNroDoc(result.getString("documento_cliente"));
					h.setCanDiasHos(result.getInt("can_dias_hospedaje"));
					h.setNroPiso(result.getInt("nro_piso"));
					h.setNroHabi(result.getInt("nro_habitacion"));
					pais=result.getString("pais");
					h.setMontoTotal(result.getInt("monto_total"));
					h.setMontoCan(result.getInt("monto_cancelado"));
					estado=result.getString("estado");
					//Pais
					if(pais.equals("ARGENTINA")) {
						h.setPais(arg);
					}else if(pais.equals("BRASIL")) {
						h.setPais(bra);
					}else if(pais.equals("PARAGUAY")) {
						h.setPais(py);
					}else {
						h.setPais(chi);
					}
					
					//Estado
					if(estado.equals("ACTIVO")) {
						h.setEst(act);
					}else{
						h.setEst(inac);
					}
				}
			}else {
				h=null;
			}
			consulta.close();
		}else {
			h=null;
		}
		
		return h;
	}				
		
}
