package ExamenFinal;

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
	
	public DB getDB() {
		
		return this.db;
	}	
		
	//Optimización de conexión 
	public MenuOperaciones() throws SQLException {
		
		db= new DB();
		boolean banEstado=db.crearConexion();
		if (banEstado) {
			System.out.println("Conexión a la base de datos con éxito.PRESS ENTER");
		}else {
			System.err.println("No se pudo establecer conexión a la base de datos.");
		}
	}	
	
	//Clases de la lista enlazada
	public ArrayList<Grupo1> liG1= new ArrayList<Grupo1>();	
	public ArrayList<Grupo2> liG2= new ArrayList<Grupo2>();	
	public ArrayList<Estadistica> liEs= new ArrayList<Estadistica>();
	
	Vacuna conv = Vacuna.COVAXIN;
	Vacuna pfi= Vacuna.PFIZER;
	Vacuna ast= Vacuna.ASTRAZENECA;
	Vacuna moder=Vacuna.MODERNA;
	
	
	//FUNCIONES, Insertar Registro
	public int SentenciaInsertarReg(Registro r) throws SQLException {
		int controlFun=0;
		boolean conex;
		String insertSql="INSERT INTO registro_vacunacion(documento, departamento_donde_vive, sexo, vacuna, dosis, fecha_aplicacion, estado, es_donada, numero_lote, fecha_compra, fecha_vencimiento, costo_vacuna, intervalo_siguiente_dosis, dias_restante_vencimiento)";
		insertSql=insertSql	+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		conex= db.crearConexion();
		if (conex) {
			modifica= db.getConectar().prepareStatement(insertSql);
			modifica.setString(1, r.getDocumento());
			modifica.setInt(2, r.getDepartamento_donde_vive());
			modifica.setString(3, r.getSexo());
			modifica.setString(4,r.getVacuna().name());
			modifica.setInt(5, r.getDosis());
			modifica.setString(6,r.getFecha_aplicacion());
			modifica.setInt(7,r.getEstado());
			modifica.setString(8, new Character (r.getEs_donada()).toString());
			if (r.getEs_donada()=='N' && (r.getVacuna().equals(conv) || r.getVacuna().equals(ast))) {
				modifica.setString(9,((Grupo1) r).getNumero_lote());
				modifica.setString(10,((Grupo1) r).getFecha_compra());
				modifica.setString(11,((Grupo1) r).getFecha_vencimiento());
				modifica.setInt(12,0);
				modifica.setInt(13,0);
				modifica.setInt(14,0);
			}else if (r.getEs_donada()=='N' && (r.getVacuna().equals(pfi) || r.getVacuna().equals(moder))){
				modifica.setString(9,"NoData");
				modifica.setString(10,"NoData");
				modifica.setString(11,"NoData");
				modifica.setInt(12,((Grupo2) r).getCosto_vacuna());
				modifica.setInt(13,((Grupo2) r).getIntervalo_siguiente_dosis());
				modifica.setInt(14,((Grupo2) r).getDias_restante_vencimiento());
			}else if(r.getEs_donada()=='S' && (r.getVacuna().equals(conv) || r.getVacuna().equals(ast))) {
				modifica.setString(9,"0=u0u/0U#U00U");
				modifica.setString(10,"0000/00/00");
				modifica.setString(11,"0001/00/00 r");
				modifica.setInt(12,0);
				modifica.setInt(13,0);
				modifica.setInt(14,0);
			}else if(r.getEs_donada()=='S' && (r.getVacuna().equals(pfi) || r.getVacuna().equals(moder))) {
				modifica.setString(9,"NoData");
				modifica.setString(10,"NoData");
				modifica.setString(11,"NoData");
				modifica.setInt(12,0);
				modifica.setInt(13,4);
				modifica.setInt(14,30);
			}
			controlFun= modifica.executeUpdate();
			modifica.close();
		}else {
			controlFun=0;
		}
		
		return controlFun;
	}
	
	
	//FUNCIONES, Insertar Estadística
	public int SentenciaInsertarEst(Estadistica es) throws SQLException {
		int controlFun=0;
		boolean conex;
		//No funciona la sentencia
		String insertSql="INSERT INTO estadistica_geografica_vacunacion (sexo, departamento, vacuna, dosis, cantidad) VALUES (?, ?, ?, ?, 1) ON CONFLICT (sexo, departamento, vacuna, dosis)"
				+ " DO UPDATE SET cantidad = (select cantidad from estadistica_geografica_vacunacion "
				+ " WHERE sexo = ? "
				+ " AND departamento = ? "
				+ " AND vacuna = ? "
				+ " AND dosis = ? ) + 1  ";
		conex= db.crearConexion();
		if (conex) {
			modifica= db.getConectar().prepareStatement(insertSql);
			modifica.setString(1, es.getSexo());
			modifica.setInt(2,es.getDepartamento());
			modifica.setString(3,es.getVacuna().name());
			modifica.setInt(4,es.getDosis());
			modifica.setString(5, es.getSexo());
			modifica.setInt(6,es.getDepartamento());
			modifica.setString(7,es.getVacuna().name());
			modifica.setInt(8,es.getDosis());
			controlFun= modifica.executeUpdate();
			modifica.close();
		}else {
			controlFun=0;
		}
		return controlFun;
	}
	
	////Modificar Registro
	public boolean SentenciaModificarReg(Registro r) throws SQLException {
		//Controla el resultado de executeUpdate. OBservación, omitpi el estado pues el parte del PK
		int controlFun=0;
		boolean conex;
		boolean resul=false;
		String modtSql="UPDATE registro_vacunacion SET  departamento_donde_vive=?, sexo=?,estado=? WHERE documento=? and dosis=? and fecha_aplicacion=?";	
		conex= db.crearConexion();
		if (conex) {
			modifica= db.getConectar().prepareStatement(modtSql);
			modifica.setInt(1,r.getDepartamento_donde_vive());
			modifica.setString(2,r.getSexo());
			modifica.setString(4,r.getDocumento());
			modifica.setInt(5, r.getDosis());
			modifica.setString(6, r.getFecha_aplicacion());
			modifica.setInt(3, r.getEstado());
			controlFun= modifica.executeUpdate();
			if(controlFun>0) {
				resul=true;
			}else {
				resul=false;
			}
			modifica.close();
		}
			
		return resul;
	}
	
	//Consultar los datos para generar archivo
	public ResultSet LeerEstadistica() throws SQLException {
		String sql=	"SELECT departamento, vacuna, dosis, count(*) cantidad FROM estadistica_geografica_vacunacion GROUP BY departamento, vacuna, dosis";
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
	
	//Select Estadística
	public void ConsultarEstadistica() throws SQLException {
		if(!liEs.isEmpty()) {
			liEs.clear();
		}
		String sql=	"SELECT sexo, departamento, vacuna, dosis, cantidad FROM public.estadistica_geografica_vacunacion order by departamento, dosis";
		ResultSet result=null;
		String tipoVac;
		Estadistica e=null;
		boolean conex;
		conex=db.crearConexion();
		if (conex) {
			consulta=db.getConectar().createStatement();
			result=consulta.executeQuery(sql);
			if (!result.equals(null)) {
					while(result.next()) {
						e=new Estadistica();
						e.setSexo(result.getString("sexo"));
						e.setDepartamento(result.getInt("departamento"));
						tipoVac=result.getString("vacuna");
						e.setDosis(result.getInt("dosis"));
						e.setCantidad(result.getInt("cantidad"));
						if(tipoVac.equals(conv.name())) {
							e.setVacuna(conv);
						}else if(tipoVac.equals(pfi.name())) {
							e.setVacuna(pfi);
						}else if(tipoVac.equals(ast.name())) {
							e.setVacuna(ast);
						}else {
							e.setVacuna(moder);
						}
						//Añadir a la lista
						liEs.add(e);
						
					}
				}
			consulta.close();
		}
		
	}
	
	//Select Grupo1
	public void consultarVAcunaGrupo1() throws SQLException {
		if(!liG1.isEmpty()) {
			liG1.clear();
		}
		String sql= "SELECT documento, departamento_donde_vive, vacuna, dosis, fecha_aplicacion, estado, es_donada, numero_lote, fecha_compra, fecha_vencimiento"
				+ " FROM registro_vacunacion WHERE vacuna IN ('COVAXIN','ASTRAZENECA') AND estado = 1";
		ResultSet result=null;
		Grupo1 gU=null;
		boolean conex;
		String tipoV="";
		conex=db.crearConexion();
		if (conex) {
			consulta=db.getConectar().createStatement();
			result=consulta.executeQuery(sql);
			if (!result.equals(null)) {
				while (result.next()) {
					gU=new Grupo1();
					gU.setDocumento(result.getString("documento"));
					gU.setDepartamento_donde_vive(result.getInt("departamento_donde_vive"));
					tipoV=result.getString("vacuna");
					gU.setDosis(result.getInt("dosis"));
					gU.setFecha_aplicacion(result.getString("fecha_aplicacion"));
					gU.setEstado(result.getInt("estado"));
					gU.setEs_donada(result.getString("es_donada").charAt(0));
					gU.setNumero_lote(result.getString("numero_lote"));
					gU.setFecha_compra(result.getString("fecha_compra"));
					gU.setFecha_vencimiento(result.getString("fecha_vencimiento"));
					if (tipoV.equals(conv.name())) {
						gU.setVacuna(conv);
					}else{
						gU.setVacuna(ast);
					}
					liG1.add(gU);
				}
			}
			consulta.close();
		}
	}
	
	//Select Grupo2
	public void consultarVAcunaGrupo2() throws SQLException {
		if(!liG2.isEmpty()) {
			liG2.clear();
		}
		String sql= "SELECT documento, departamento_donde_vive, vacuna, dosis, fecha_aplicacion, estado, es_donada, costo_vacuna, intervalo_siguiente_dosis, dias_restante_vencimiento"
				+ " FROM registro_vacunacion WHERE vacuna IN ('PFIZER', 'MODERNA') AND estado = 1";
		ResultSet result=null;
		Grupo2 gU=null;
		boolean conex;
		String tipoV="";
		conex=db.crearConexion();
		if (conex) {
			consulta=db.getConectar().createStatement();
			result=consulta.executeQuery(sql);
			if (!result.equals(null)) {
				while (result.next()) {
					gU=new Grupo2();
					gU.setDocumento(result.getString("documento"));
					gU.setDepartamento_donde_vive(result.getInt("departamento_donde_vive"));
					tipoV=result.getString("vacuna");
					gU.setDosis(result.getInt("dosis"));
					gU.setFecha_aplicacion(result.getString("fecha_aplicacion"));
					gU.setEstado(result.getInt("estado"));
					gU.setEs_donada(result.getString("es_donada").charAt(0));
					gU.setCosto_vacuna(result.getInt("costo_vacuna"));
					gU.setIntervalo_siguiente_dosis(result.getInt("intervalo_siguiente_dosis"));
					gU.setDias_restante_vencimiento(result.getInt("dias_restante_vencimiento"));
					if (tipoV.equals(pfi.name())) {
						gU.setVacuna(pfi);
					}else{
						gU.setVacuna(moder);
					}
					liG2.add(gU);
				}
			}
			consulta.close();
		}
	}

	//Búsqueda por PK
	public Registro BuscarVacuna(String documento, int dosis, String fecha_aplicacion, int estado) throws SQLException {
		String sql="SELECT documento, departamento_donde_vive, sexo, vacuna, dosis, fecha_aplicacion, estado, es_donada FROM registro_vacunacion Where documento='"+ documento+"' and dosis="+dosis+" and fecha_aplicacion='"+fecha_aplicacion+"' and estado="+estado;
		ResultSet result=null;
		Registro r=null;
		boolean conex;
		String tipoV="";
		conex=db.crearConexion();
		if (conex) {
			consulta=db.getConectar().createStatement();
			result=consulta.executeQuery(sql);
			if (!result.equals(null)) {
				r =new Registro();
				while (result.next()) {
					r.setDocumento(result.getString("documento"));
					r.setDepartamento_donde_vive(result.getInt("departamento_donde_vive"));
					r.setSexo(result.getString("sexo"));
					tipoV=result.getString("vacuna");
					r.setDosis(result.getInt("dosis"));
					r.setFecha_aplicacion(result.getString("fecha_aplicacion"));
					r.setEstado(result.getInt("estado"));
					r.setEs_donada(result.getString("es_donada").charAt(0));
					
				}
				if(tipoV.equals(conv.name())) {
					r.setVacuna(conv);
				}else if(tipoV.equals(pfi.name())) {
					r.setVacuna(pfi);
				}else if(tipoV.equals(ast.name())) {
					r.setVacuna(ast);
				}else {
					r.setVacuna(moder);
				}	
			}
			consulta.close();	
		}
		return r;
	}	
	
		
}
			
