package Vacunacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





public class MenuOperaciones {
	//Atributos para sentencias
	private Statement consulta;
	private PreparedStatement modifica;			
	private DB db;	
		
	//Optimización de conexión 
	public MenuOperaciones() throws SQLException {
		
		db= new DB();
		boolean banEstado=db.crearConexion();
		if (banEstado) {
			System.out.println("Conexión a la base de datos con éxito.");
		}else {
			System.err.println("No se pudo establecer conexión a la base de datos.");
		}
	}	
	
	

	//Clases de la lista enlazada
	public ArrayList<GrupoUno> liG1= new ArrayList<GrupoUno>();	
	public ArrayList<GrupoDos> liG2= new ArrayList<GrupoDos>();	
	public ArrayList<GrupoTres> liG3= new ArrayList<GrupoTres>();
	
	
	TipoVacuna conv = TipoVacuna.COVAXIN;
	TipoVacuna pfi= TipoVacuna.PFIZER;
	TipoVacuna ast= TipoVacuna.ASTRAZENECA;
	TipoVacuna moder=TipoVacuna.MODERNA;
	TipoVacuna sput =TipoVacuna.SPUTNIKV;
	TipoVacuna haay = TipoVacuna.HAYATVAX;
	
	//FUNCIONES, Insertar
	public int SentenciaInsertar(Vacuna v) throws SQLException {
		int controlFun=0;
		boolean conex;
		String insertSql="INSERT INTO registro_vacunacion( dosis, documento, lugar_vacunacion, fecha_aplicacion, vacuna, fecha_hora_carga, es_donada, costo_vacuna, numero_lote) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		conex= db.crearConexion();
		if (conex) {
			modifica= db.getConectar().prepareStatement(insertSql);
			modifica.setInt(1, v.getDosis());
			modifica.setString(2, v.getDocumento());
			modifica.setString(3,v.getLugar_vacunacion());
			modifica.setString(4,v.getFecha_aplicacion());
			modifica.setString(5,v.getVacuna().name());
			modifica.setString(6, v.getFecha_hora_carga());
			if(v.getVacuna().equals(conv) || v.getVacuna().equals(pfi) ) {
				modifica.setString(7,((GrupoUno) v).getEs_donada().toString());
				modifica.setInt(8, 0);
				modifica.setString(9, "S/Nro");
			}else if(v.getVacuna().equals(moder) || v.getVacuna().equals(sput)) {
				modifica.setString(7,"N");
				modifica.setInt(8, ((GrupoDos) v).getCosto_vacuna());
				modifica.setString(9, "S/NroL");
			}else {
				modifica.setString(7,"N");
				modifica.setInt(8, 0);
				modifica.setString(9, ((GrupoTres) v).getNumero_lote());
			}
			controlFun= modifica.executeUpdate();
			modifica.close();
		}else {
			controlFun=0;
		}
		
		return controlFun;
	}
	
	//Modificar
	public int SentenciaModificar(Vacuna v) throws SQLException {
		//Controla el resultado de executeUpdate
		int controlFun=0;
		boolean conex;
		String modtSql="UPDATE registro_vacunacion SET lugar_vacunacion=?, fecha_hora_carga=?  WHERE dosis=? and documento=?";
		conex= db.crearConexion();
		if (conex) {
			modifica= db.getConectar().prepareStatement(modtSql);
			modifica.setString(1,v.getLugar_vacunacion());
			modifica.setString(2, v.getFecha_hora_carga());
			modifica.setInt(3, v.getDosis());
			modifica.setString(4, v.getDocumento());
			controlFun= modifica.executeUpdate();
			modifica.close();
		}	
		
		return controlFun;
	}
	
	
	public boolean SentenciaEliminar(Vacuna v) throws SQLException {
		//Controla el resultado de executeUpdate, cantidad de filas eliminadas
		int controlFun=0;
		boolean i,conex;
		String elimSql="Delete From registro_vacunacion WHERE dosis=? and documento=?";
		conex=db.crearConexion();
		if (conex) {
			modifica= db.getConectar().prepareStatement(elimSql);
			modifica.setInt(1, v.getDosis());
			modifica.setString(2, v.getDocumento());
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
	
	
	//Bucar por dosis y tipovacuna
	public Vacuna BuscarVacuna(int dosis, String tipoV) throws SQLException {
		String sql= "SELECT dosis, documento, lugar_vacunacion, fecha_aplicacion, fecha_hora_carga FROM registro_vacunacion WHERE dosis="+ dosis + " and vacuna='" + tipoV.toUpperCase()+"'";
		ResultSet result=null;
		Vacuna v=null;
		boolean conex;
		conex=db.crearConexion();
		if (conex) {
			consulta=db.getConectar().createStatement();
			result=consulta.executeQuery(sql);
			//Evaluar contenido de la tupla
			if (!result.equals(null)) {
				v=new Vacuna();
				while (result.next()) {
					v.setDosis(result.getInt("dosis"));
					v.setDocumento(result.getString("documento"));
					v.setLugar_vacunacion(result.getString("lugar_vacunacion"));
					v.setFecha_aplicacion(result.getString("fecha_aplicacion"));
					v.setFecha_hora_carga(result.getString("fecha_hora_carga"));
				}
				if (tipoV.equals(conv.name())) {
					v.setVacuna(conv);
				}else if(tipoV.equals(pfi.name())) {
					v.setVacuna(pfi);
				}else if(tipoV.equals(moder.name())) {
					v.setVacuna(moder);
				}else if(tipoV.equals(sput.name())) {
					v.setVacuna(sput);
				}else if(tipoV.equals(ast.name())) {
					v.setVacuna(ast);
				}else{
					v.setVacuna(haay);
				}
			}
			consulta.close();			
		}
		
		return v;
	}
	
	//Consultar los datos para generar archivo
	public ResultSet LeerVacuna() throws SQLException {
		String sql= "SELECT  documento, lugar_vacunacion, fecha_aplicacion,vacuna,dosis,fecha_hora_carga FROM registro_vacunacion";
		ResultSet result=null;
		boolean conex;
		conex=db.crearConexion();
		if (conex) {
			consulta=db.getConectar().createStatement();
			result=consulta.executeQuery(sql);
			//consulta.close();
		}
		
		return result;
	}
	
	//Consultar registros Grupo1
	public void consultarVAcunaGrupo1() throws SQLException {
		String sql= "SELECT documento, lugar_vacunacion, fecha_aplicacion, vacuna, dosis, fecha_hora_carga, es_donada FROM registro_vacunacion WHERE vacuna IN ('COVAXIN','PFIZER')";
		ResultSet result=null;
		GrupoUno gU=null;
		boolean conex;
		String tipoV="";
		conex=db.crearConexion();
		if (conex) {
			consulta=db.getConectar().createStatement();
			result=consulta.executeQuery(sql);
			if (!result.equals(null)) {
				while (result.next()) {
					gU=new GrupoUno();
					gU.setDocumento(result.getString("documento"));
					gU.setLugar_vacunacion(result.getString("lugar_vacunacion"));
					gU.setFecha_aplicacion(result.getString("fecha_aplicacion"));
					tipoV=result.getString("vacuna");
					if (tipoV.equals(conv.name())) {
						gU.setVacuna(conv);
					}else{
						gU.setVacuna(pfi);
					}
					gU.setDosis(result.getInt("dosis"));
					gU.setFecha_hora_carga(result.getString("fecha_hora_carga"));
					gU.setEs_donada(result.getString("es_donada").charAt(0));
					liG1.add(gU);
				}
			}
			consulta.close();
		}
	}
	
	//Consultar registros Grupo2
	public void consultarVAcunaGrupo2() throws SQLException {
		String sql= "SELECT documento, lugar_vacunacion, fecha_aplicacion, vacuna, dosis, fecha_hora_carga, costo_vacuna FROM registro_vacunacion WHERE vacuna IN ('MODERNA','SPUTNIKV')";
		ResultSet result=null;
		GrupoDos gD=null;
		boolean conex;
		String tipoV="";
		conex=db.crearConexion();
		if (conex) {
			consulta=db.getConectar().createStatement();
			result=consulta.executeQuery(sql);
			if (!result.equals(null)) {
				while (result.next()) {
					gD=new GrupoDos();
					gD.setDocumento(result.getString("documento"));
					gD.setLugar_vacunacion(result.getString("lugar_vacunacion"));
					gD.setFecha_aplicacion(result.getString("fecha_aplicacion"));
					tipoV=result.getString("vacuna");
					if (tipoV.equals(moder.name())) {
						gD.setVacuna(moder);
					}else{
						gD.setVacuna(sput);
					}
					gD.setDosis(result.getInt("dosis"));
					gD.setFecha_hora_carga(result.getString("fecha_hora_carga"));
					gD.setCosto_vacuna(result.getInt("costo_vacuna"));
					liG2.add(gD);
				}
			}
			consulta.close();
		}
	}
	
	//Consultar registros Grupo2
	public void consultarVAcunaGrupo3() throws SQLException {
		String sql= "SELECT documento, lugar_vacunacion, fecha_aplicacion, vacuna, dosis, fecha_hora_carga, numero_lote FROM registro_vacunacion WHERE vacuna IN ('ASTRAZENECA','HAYATVAX')";
		ResultSet result=null;
		GrupoTres gT=null;
		boolean conex;
		String tipoV="";
		conex=db.crearConexion();
		if (conex) {
			consulta=db.getConectar().createStatement();
			result=consulta.executeQuery(sql);
			if (!result.equals(null)) {
				while (result.next()) {
					gT=new GrupoTres();
					gT.setDocumento(result.getString("documento"));
					gT.setLugar_vacunacion(result.getString("lugar_vacunacion"));
					gT.setFecha_aplicacion(result.getString("fecha_aplicacion"));
					tipoV=result.getString("vacuna");
					if (tipoV.equals(ast.name())) {
						gT.setVacuna(ast);
					}else{
						gT.setVacuna(haay);
					}
					gT.setDosis(result.getInt("dosis"));
					gT.setFecha_hora_carga(result.getString("fecha_hora_carga"));
					gT.setNumero_lote(result.getString("numero_lote"));
					liG3.add(gT);
				}
			}
			consulta.close();
		}
	}

	public DB getDB() {
		
		return this.db;
	}		
	
	
	
	
	
}
