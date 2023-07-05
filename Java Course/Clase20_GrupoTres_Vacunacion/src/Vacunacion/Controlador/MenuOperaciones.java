package Vacunacion.Controlador;

import java.sql.SQLException;

import Vacunacion.Modelo.Usuario;
import Vacunacion.Modelo.Vacuna;
import Vacunacion.Modelo.DB.OperacionesBD;
import Vacunacion.Modelo.DB.OperacionesBD_Usuario;
import Vacunacion.Modelo.DB.OperacionesBD_Vacuna;

public class MenuOperaciones extends OperacionesBD{ //Para la conexión
	//Objetos de la BD
	private Vacuna v;
	private Usuario u;
	private OperacionesBD_Usuario oU = new OperacionesBD_Usuario();
	private OperacionesBD_Vacuna oV = new OperacionesBD_Vacuna();
	
	//
	public MenuOperaciones() {
		
	}
	
	public MenuOperaciones(Vacuna v, Usuario u) {
		this.v = v;
		this.u = u;
	}

	//
	public Vacuna getV() {
		return v;
	}

	public void setV(Vacuna v) {
		this.v = v;
	}

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}
	
	public OperacionesBD_Usuario getoU() {
		return oU;
	}


	public OperacionesBD_Vacuna getoV() {
		return oV;
	}


	/*Funciones para submenú
	Insertar Usuario*/
	public void InsertUser() {
		boolean estado=false;
		try {
			oU.setUser(u); //Establecer como parámetro desde menú operación para insertar un nuevo usuario
			estado=oU.CreateRow();
			if (estado) {
				System.out.println("\nUsuario guardado correctamente.");
			}else {
				System.err.println("\nError al añadir.."+u.toString());
			}
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage()); 
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
		}finally {
			System.out.println("\n"+oU.DesconectarConexion());
		}
	}
	
	//Actualizar Usuario
	public void UpdateUser() {
		boolean estado=false;
		try {
			oU.setUser(u); //Establecer como parámetro desde menú operación para insertar un nuevo usuario
			estado=oU.UpdateRow();
			if (estado) {
				System.out.println("\nUsuario modificado correctamente.");
			}else {
				System.err.println("\nError al modificar.."+u.toString());
			}
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage()); 
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
		}finally {
			System.out.println("\n"+oU.DesconectarConexion());
		}
	}
	
	//Eliminar Usuario
	public void DeleteUser() {
		boolean estado=false;
		try {
			oU.setUser(u); //Establecer como parámetro desde menú operación para insertar un nuevo usuario
			estado=oU.DeleteRow();
			if (estado) {
				System.out.println("\nUsuario eliminado correctamente.");
			}else {
				System.err.println("\nError al eliminar.."+u.toString());
			}
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage()); 
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
		}finally {
			System.out.println("\n"+oU.DesconectarConexion());
		}
	}	
	
	
	//Consultar usuario
	public void SelectUsers() {
		try {
			oU.ReadRow();
			for (Usuario uS : oU.getListaUs()) { //recorre la lista 
				System.out.println(uS.toString().concat("\n")); 
			}
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage()); 
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
		}finally {
			System.out.println("\n"+oU.DesconectarConexion());
		}	
	}
	
	/*Funciones para submenú
	Insertar Vacuna*/
	public void InsertVaccine() {
		boolean estado=false;
		try {
			oV.setVacu(v); //Establecer como parámetro desde menú operación para insertar una nueva vacuna
			estado=oV.CreateRow();
			if (estado) {
				System.out.println("\nVacuna guardada correctamente.");
			}else {
				System.err.println("\nError al añadir.."+v.toString());
			}
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage()); 
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
		}finally {
			System.out.println("\n"+oV.DesconectarConexion());
		}
	}
	
	//Actualizar Vacuna
	public void UpdateVaccine() {
		boolean estado=false;
		try {
			oV.setVacu(v); //Establecer como parámetro desde menú operación para insertar una nueva vacuna
			estado=oV.UpdateRow();
			if (estado) {
				System.out.println("\nVacuna modificada correctamente.");
			}else {
				System.err.println("\nError al modificar.."+v.toString());
			}
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage()); 
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
		}finally {
			System.out.println("\n"+oV.DesconectarConexion());
		}
	}	
	
	//Eliminar vacuna
	public void DeleteVaccine() {
		boolean estado=false;
		try {
			oV.setVacu(this.getV()); //Establecer como parámetro desde menú operación para insertar una nueva vacuna
			estado=oV.DeleteRow();
			if (estado) {
				System.out.println("\nVacuna eliminada correctamente.");
			}else {
				System.err.println("\nError al eliminar.."+v.toString());
			}
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage()); 
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
		}finally {
			System.out.println("\n"+oV.DesconectarConexion());
		}
	}	
	
	//Consultar vacuna
	public void SelectVaccine() {
		try {
			oV.ReadRow();
			for (Vacuna vC : oV.getListaVc()) { //recorre la lista 
				System.out.println(vC.toString().concat("\n"));
			}
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage()); 
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage());
		}finally {
			System.out.println("\n"+oV.DesconectarConexion());
		}	
	}

	//Obtener el segundo pk de vacuna
	public int getDosis(Usuario u2) {
		//Vacuna vA;
		int dos=0;
		try {
			//vA=oV.ReadRow(u2.getId());
			for (Vacuna vC : oV.getListaVc()) { //recorre la lista 
				if (vC.getId().getId()==u2.getId()) {
					dos=vC.getNroDosis();
				}
			}
			//dos=vA.getNroDosis();
		/*} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
			dos=0;*/
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage()); 
			dos=0;
		}finally {
			System.out.println("\n"+oV.DesconectarConexion());
		}	
		return dos;
	}	
	
	
}
