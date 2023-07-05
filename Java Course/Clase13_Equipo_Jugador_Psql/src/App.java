import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

	public static Scanner data = new Scanner(System.in);
	//Banderas para menú
	public static boolean banC=false;
	
	//Clases
	public static BD b;
	public static MenuOperaciones mU;
	public static Jugador j;
	
	//Para la consulta
	public static List<Jugador> liJ;
	public static List<Equipo> liE;
	
	public static void main(String[] args) {
		
		
		b=null;
		
		MenuOperaciones();
		System.out.println("**FIN DEL PROGRAMA**");
		
	}


	private static void MenuOperaciones() {
		int opcion=0;
		do {
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println("1- Establecer conexión a la base de datos");
			System.out.println("2- Agregar un jugador a un Equipo");
			System.out.println("3- Consultar jugadores agrupados por Equipo");
			System.out.println("4- Modificar un jugador de un Equipo");
			System.out.println("5- Eliminar un jugador de un Equipo");
			System.out.println("6- Salir del menú");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1: 
				banC=VerificarConexion();
				if (banC) {
					System.out.println("Conexión exitosa al PostgreSql.");
				}else {
					System.err.println("Error al establecer la conexión.");	
				}
				break;
			case 2:
				AddJugador();
				break;
			case 3:
				ConsultarJugador();
				break;
			case 4:
				UpdJugador();
				break;
			case 5:
				DelJugador();
				break;
			case 6:
				System.out.println("Finalizando menú...\n");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!=6);
	}
	
	
	//Op 5
	private static void DelJugador() {
		long idJ=0;
		String ms="Jugador eliminado correctamente, cantidad eliminada: ";
		if (banC) {
			try {
				mU=new MenuOperaciones(b);
				//Lista de las tuplas
				liJ= mU.consultarJugador();
				for (Jugador jug : liJ) {
					System.out.println(jug.toString());
				}
				//Ingreso del IdJugador
				do { 
					try {
						System.out.println("Ingrese el IdJugador: ");
						idJ= data.nextLong();
						
						if(idJ<=0) {
							System.err.println("Identificador no admitido. Vuelva a intentar.");
						}
					} catch (InputMismatchException e) {
						System.err.println("El valor ingresado no es númerico");
					}
					data.nextLine();
				}while(idJ<=0);	
				j=new Jugador();
				j.setIdjug(idJ);
				System.out.println(ms+mU.SentenciaEliminar(j));
			} catch (SQLException e) {
				System.err.println("Error al modificar.");
			}finally {
				try {
					b.cerrarConexion();
				} catch (SQLException eSq) {
					System.err.println("Error de "+eSq.getMessage());
				}
			}
		}else {
			System.err.println("Debe ejecutar la opción 1. "); 
		}
	}


	//Op 4
	private static void UpdJugador() {
		//estado de la act
		boolean eA;
		if (banC) {
			try {
				mU=new MenuOperaciones(b);
				Actualizar(mU);
				eA=mU.SentenciaModificar(j);
				if (eA) {
					System.out.println("\nJugador actualizado correctamente.");
				}else {
					System.err.println("Error al modificar.");
				}
			} catch (SQLException e) {
				System.err.println("Error de "+e.getMessage()); 
			}finally {
				try {
					b.cerrarConexion();
				} catch (SQLException eSq) {
					System.err.println("Error de "+eSq.getMessage());
				}
			}
		}else {
			System.err.println("Debe ejecutar la opción 1. "); 
		}		
				
	}

	//Subfun de la op4
	private static void Actualizar(MenuOperaciones mU) {
		//Atrib
		int totTanConv=0;
		int totTarRo=0;
		int totTarAm=0;
		long idJ=0;
		//Lista de las tuplas
		try {
			liJ= mU.consultarJugador();
			for (Jugador jug : liJ) {
				System.out.println(jug.toString().concat("\n"));
			}
			//Ingreso del IdJugador
			do { 
				try {
					System.out.println("\nIngrese el IdJugador: ");
					idJ= data.nextLong();
					
					if(idJ<=0) {
						System.err.println("Identificador no admitido. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(idJ<=0);	
			/*Actualización de datos
			 Ingreso de la cantidad de tarjetas amarillas*/
			do { 
				try {
					System.out.println("Ingrese la cantidad de tarjetas amarillas: ");
					totTarAm= data.nextInt();
					
					if(totTarAm<0) {
						System.err.println("Cantidad no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(totTarAm<0);	
			
			//Ingreso de la cantidad de tarjetas rojas
			do { 
				try {
					System.out.println("Ingrese la cantidad de tarjetas rojas: ");
					totTarRo= data.nextInt();
					
					if(totTarRo<0) {
						System.err.println("Cantidad no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(totTarRo<0);	
			
			//Ingreso de la cantidad de tantos convertidos
			do { 
				try {
					System.out.println("Ingrese la cantidad de tantos convertidos: ");
					totTanConv= data.nextInt();
					
					if(totTanConv<0) {
						System.err.println("Cantidad no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(totTanConv<0);
			
			j=new Jugador();
			j.setIdjug(idJ);
			j.setTotTarAm(totTarAm);
			j.setTotTarRo(totTarRo);
			j.setTotTanConv(totTanConv);
			
		} catch (SQLException eA) {
			System.err.println("Error de "+eA.getMessage());
		}
	}


	//Op 3
	private static void ConsultarJugador() {
		if (banC) {
			try {
				mU=new MenuOperaciones(b);
				liJ= mU.consultarJugador();
				for (Jugador jug : liJ) {
					System.out.println("\n"+jug.toString().concat("\n"));
				}
			} catch (SQLException e) {
				System.err.println("Error de "+e.getMessage()); 
			}finally {
				try {
					b.cerrarConexion();
				} catch (SQLException eSq) {
					System.err.println("Error de "+eSq.getMessage());
				}
			}
		}else {
			System.err.println("Debe ejecutar la opción 1. "); 
		}	
	}

	//Op 2
	private static void AddJugador() {
		//estado de la inser
		boolean eI;
		if (banC) {
			try {
				mU=new MenuOperaciones(b);
				j=Añadir(mU);
				eI=mU.SentenciaInsertar(j);
				if (eI) {
					System.out.println("\nJugador guardado correctamente.");
				}else {
					System.err.println("Error al añadir.");
				}
			} catch (SQLException e) {
				System.err.println("Error de "+e.getMessage()); 
			}finally {
				try {
					b.cerrarConexion();
				} catch (SQLException eSq) {
					System.err.println("Error de "+eSq.getMessage());
				}
			}
		}else {
			System.err.println("Debe ejecutar la opción 1. "); 
		}	
		
	}

	//Subfun de la op2
	private static Jugador Añadir(MenuOperaciones mO) {
		//Atrib
		String nroDoc="";
		String tipoDoc="";
		String nombre="";
		String apellido="";
		String fechaNac="";
		int idEqu=0;
		
		//
		Equipo e=null;
		
		//Ingreso del Tipo de documento
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el Tipo de documento(CI= cédula identidad;RUC= razón social[99-9]): ");
				tipoDoc= data.nextLine();
				tipoDoc= tipoDoc.trim();
				tipoDoc=tipoDoc.toUpperCase();
				if(tipoDoc.isBlank() || tipoDoc.isEmpty() || (!tipoDoc.equals("CI") && !tipoDoc.equals("RUC"))) {
					System.err.println("Tipo de documento no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (tipoDoc.isBlank() || tipoDoc.isEmpty() || (!tipoDoc.equals("CI") && !tipoDoc.equals("RUC")));		
		
		//Ingreso del nro de Documento
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el nro de Documento: ");
				nroDoc= data.nextLine();
				nroDoc=nroDoc.trim();
				
				if(!ValidarNroDoc(nroDoc,tipoDoc)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}while(nroDoc.equals(null) || nroDoc.isEmpty() || nroDoc.isBlank() || (!ValidarNroDoc(nroDoc,tipoDoc)));		
		
		//Ingreso del nombre
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el nombre: ");
				nombre= data.nextLine();
				nombre= nombre.trim();
				if(nombre.isBlank() || nombre.isEmpty()) {
					System.err.println("Nombre no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (nombre.isBlank() || nombre.isEmpty());	
		
		
		//Ingreso del apellido
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el apellido: ");
				apellido= data.nextLine();
				apellido= apellido.trim();
				if(apellido.isBlank() || apellido.isEmpty()) {
					System.err.println("Apellido no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (apellido.isBlank() || apellido.isEmpty());	
		
		//Ingreso de la fecha nacimiento
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la fecha de nacimiento(AAAA/MM/DD): ");
				fechaNac= data.nextLine();
				fechaNac=fechaNac.trim();
				
				if(!ValidarFecha(fechaNac)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}while(fechaNac.equals(null) || fechaNac.isEmpty() || fechaNac.isBlank() || !ValidarFecha(fechaNac));		
		
		
		try {
			liE= mO.consultarEquipo();
			for (Equipo equ : liE) {
				System.out.println("\nDatos del equipo \n"+equ.toString());
			}
			//Ingreso del IdEquipo
			do { 
				try {
					System.out.println("\nIngrese el Id del Equipo para asignar al jugador: ");
					idEqu= data.nextInt();
					
					if(idEqu<=0) {
						System.err.println("Identificador no admitido. Vuelva a intentar.");
					}
				} catch (InputMismatchException eX) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(idEqu<=0);
			e=new Equipo(idEqu);
		} catch (SQLException eE) {
			System.err.println("Error de "+eE.getMessage());
		}
		
		return new Jugador(nroDoc, tipoDoc, nombre,  apellido,  fechaNac, e);
	}


	//Op 1
	private static boolean VerificarConexion() {
		boolean conex=false;
		try {
			b=new  BD();
			conex=b.crearConexion();
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
			conex=false;
		}
		return conex;
	}
	
	
	//Ex. Regular para la fecha
	private static boolean ValidarNroDoc(String nroDoc,String tipoDoc) {
		if (tipoDoc.equals("CI")) {
			return nroDoc.matches("[0-9]+");
		}else {
			return nroDoc.matches("[0-9]+-[0-9]");
		}	
	}
	
	//Ex. Regular para la fecha
	public static boolean ValidarFecha(String fecha) {
		return fecha.matches("[0-9]+/[0-9]+/[0-9]+");
	}
}
