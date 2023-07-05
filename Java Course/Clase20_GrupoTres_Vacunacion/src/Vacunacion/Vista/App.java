package Vacunacion.Vista;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import Vacunacion.Controlador.MenuOperaciones;
import Vacunacion.Modelo.*;

public class App {

	public static Scanner data = new Scanner(System.in);
	//Banderas para menú
	public static boolean banC=false; //Para conexión
	public static boolean banU=false; //Para usuario
	public static boolean banV=false; //Para vacuna
	
	//Menu Operaciones
	public static MenuOperaciones mO;
	
	public static void main(String[] args) {
		
		int op=0;
		do {
			try {
				
				MenuOperacionesPrincipal(op);
				//data.nextLine();
				op=1;
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico. Debe ser numérico");
				op=0;
				data.nextLine();
			}
		} while (op!=1);
		System.out.println("\n**FIN DEL PROGRAMA**");	
	}

	private static void MenuOperacionesPrincipal(int p) throws InputMismatchException {
		mO= new MenuOperaciones();
		int opcion=0;
		
		/*if (p==0) {
			System.out.println("Press enter to access the main menu");
		}else {
			p=1;
		}*/
		
		do {
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("═════════════════════════════════════");
			System.out.println("1- Establecer conexión a la base de datos");
			System.out.println("2- MANTENER REGISTRO USUARIO");
			System.out.println("3- MANTENER REGISTRO VACUNA");
			System.out.println("4- Salir del menú");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1: 
				VerificarConexion(mO);
				break;
			case 2:
				if(banC) {
					mO=CRUDUser(mO);
				}else {
					System.err.println("Debe ejecutar la opción 1.");
				}
				
				break;
			case 3:
				if(banC) {
					mO=CRUDVaccine(mO);
				}else {
					System.err.println("Debe ejecutar la opción 1.");
				}
				break;
			case 4:
				System.out.println("\nFinalizando menú...\n");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}	
			
		}while(opcion!=4);
	}

	

	//Opción 3
	private static MenuOperaciones CRUDVaccine(MenuOperaciones mO) {
		int idU=0;
		String opcion="";
		
		Usuario u; //Clase
		Vacuna v;
		data.nextLine();
		do {
			System.out.println("\n\nMantenimiento para VACUNA.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println("A- Añadir una nueva vacuna");
			System.out.println("B- Modificar la vacuna");
			System.out.println("C- Eliminar vacuna");
			System.out.println("D- Consultar vacuna");
			System.out.println("X- Salir del menú");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextLine();
			opcion=opcion.toUpperCase();
			switch (opcion) {
			case "A": 
				v=CreateV();
				//Asignar vacuna dependiendo del id
				/*if(mO.getoU().getListaUs().isEmpty()) { //Verificar para la consulta por primera vez
					mO.SelectUsers();
				}*/
				mO.SelectUsers();
				//Ingresar Id Usuario
				do { 
					try {
						System.out.println("\nIngrese el Identificador del Usuario para añadir vacuna: ");
						idU= data.nextInt();
						
						if(idU<=0) {
							System.err.println("Identificador no admitido. Vuelva a intentar.");
						}
					} catch (InputMismatchException e) {
						System.err.println("El valor ingresado no es númerico");
						idU=0;
					}
					data.nextLine();
				}while(idU<=0);	
				//Devolución de la tupla según Id
				try {
					u=mO.getoU().ReadRow(idU);
					v.setId(u);
				} catch (SQLException e1) {
					System.err.println("Error de "+e1.getMessage()); 
				}
				mO.setV(v);
				mO.InsertVaccine();
				banV=true;
				break;
				
			case "B":
				if(banV) {
					/*if(mO.getoV().getListaVc().equals(null) || mO.getoV().getListaVc().isEmpty()) { //Verificar para la consulta por primera vez
						mO.SelectVaccine();
					}*/
					mO.SelectVaccine();
					//Ingresar Id
					do { 
						try {
							System.out.println("\nIngrese el Identificador del Usuario: ");
							idU= data.nextInt();
							
							if(idU<=0) {
								System.err.println("Identificador no admitido. Vuelva a intentar.");
							}
						} catch (InputMismatchException e) {
							System.err.println("El valor ingresado no es númerico");
							idU=0;
						}
						data.nextLine();
					}while(idU<=0);	
					
					try {
						//Devolución de la tupla según Id
						u=mO.getoU().ReadRow(idU);
						v=CreateV(); //Inserción datos nuevos, recursión indirecta
						v.setId(u);
					
						//Seteo y actualización
						mO.setV(v);
						mO.UpdateVaccine();
						
					} catch (SQLException e) {
						System.err.println("Error de "+e.getMessage()); 
					}
					
				}else {
					System.err.println("Debe ejecutar la opción A.");
				}
				break;
				
			case "C":
				if(banV) {
					/*if(mO.getoV().getListaVc().equals(null) || mO.getoV().getListaVc().isEmpty()) { //Verificar para la consulta por primera vez
						mO.SelectVaccine();
					}*/
					mO.SelectVaccine();
					//Ingresar Id
					do { 
						try {
							System.out.println("\nIngrese el Identificador del Usuario: ");
							idU= data.nextInt();
							
							if(idU<=0) {
								System.err.println("Identificador no admitido. Vuelva a intentar.");
							}
						} catch (InputMismatchException e) {
							System.err.println("El valor ingresado no es númerico");
							idU=0;
						}
						data.nextLine();
					}while(idU<=0);	
					
					//Devolución de la tupla según Id
					try {
						u=mO.getoU().ReadRow(idU);
						System.out.println("Eliminando registro de la vacuna perteneciente al usuario con ID: "+u.getId()+", "+u.getNombre().concat("\n"));
						//seteo y eliminación
						int nroDosis=mO.getDosis(u); // Obtner el nro dosis para eliminar 
						v=new Vacuna(u,nroDosis);
						mO.setV(v);
						mO.DeleteVaccine();
					} catch (SQLException e) {
						System.err.println("Error de "+e.getMessage()); 
					}
				}else {
					System.err.println("Debe ejecutar la opción A.");
				}
				break;
				
			case "D":
				if (banV) {
					/*if(mO.getoV().getListaVc().equals(null)) { //Verificar para la consulta por primera vez
						mO.SelectVaccine();
					}*/
					mO.SelectVaccine();
				}else {
					System.err.println("Debe ejecutar la opción A.");
				}
				break;
				
			case "X":
				System.out.println("\nRetornando al menú principal...\n");
				break;
				
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion=="X" || opcion=="x");
		
		return mO;
	}

	//Opción A
	private static Vacuna CreateV() {
		//Atributos
		int nroDosis=0;
		String vacuna="";
		String lote="";
		String fechaAp="";
		int nroDep=0;
		String distrito="";
		
		//Ingreso del Nro. Dosis
		do { 
			try {
				System.out.println("Ingrese el Nro. Dosis: ");
				nroDosis= data.nextInt();
				
				if(nroDosis<0) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
				nroDosis=-1;
			}
			data.nextLine();
		}while(nroDosis<0);	
		
		//Ingreso del nombre de la vacuna
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el nombre de la vacuna: ");
				vacuna= data.nextLine();
				vacuna= vacuna.trim();
				if(vacuna.isBlank() || vacuna.isEmpty()) {
					System.err.println("Dato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (vacuna.isBlank() || vacuna.isEmpty());		
		
		//Ingreso del nro Lote
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el Nro. Lote(9A_AAAA-99): ");
				lote= data.nextLine();
				lote=lote.trim();
				
				if(!ValidarNroLote(lote)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}while(lote.equals(null) || lote.isEmpty() || lote.isBlank() || (!ValidarNroLote(lote)));	
		
		//Ingreso de la fecha de aplicación
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la fecha de aplicación(AAAA/MM/DD): ");
				fechaAp= data.nextLine();
				fechaAp=fechaAp.trim();
				
				if(!ValidarFecha(fechaAp)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}while(fechaAp.equals(null) || fechaAp.isEmpty() || fechaAp.isBlank() || !ValidarFecha(fechaAp));	
		
		//Ingreso del Nro. Depósito
		do { 
			try {
				System.out.println("Ingrese el Nro. Departamento: ");
				nroDep= data.nextInt();
				
				if(nroDep<0) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
				nroDep=-1;
			}
			data.nextLine();
		}while(nroDep<0);	
		
		//Ingreso del distrito
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el nombre del distrito: ");
				distrito= data.nextLine();
				distrito= distrito.trim();
				if(distrito.isBlank() || distrito.isEmpty()) {
					System.err.println("Dato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (distrito.isBlank() || distrito.isEmpty());			
		
		
		return new Vacuna( nroDosis,  vacuna,  lote,  fechaAp,  nroDep,  distrito);
	}

	//Opción 2
	private static MenuOperaciones CRUDUser(MenuOperaciones mO) {
		int idU=0;
		String opcion="";
		
		Usuario u; //Clase
		data.nextLine();
		do {
			System.out.println("\n\nMantenimiento para USUARIO.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println("A- Añadir un nuevo usuario");
			System.out.println("B- Modificar el usuario");
			System.out.println("C- Eliminar usuario");
			System.out.println("D- Consultar usuario");
			System.out.println("X- Salir del menú");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextLine();
			opcion=opcion.toUpperCase();
			switch (opcion) {
			case "A": 
				u=CreateU();
				mO.setU(u);
				mO.InsertUser();
				banU=true;
				break;
				
			case "B":
				if(banU) {
					/*if(mO.getoU().getListaUs().equals(null) || mO.getoU().getListaUs().isEmpty()) { //Verificar para la consulta por primera vez
						mO.SelectUsers();
					}*/
					mO.SelectUsers();
					//Ingresar Id
					do { 
						try {
							System.out.println("\nIngrese el Identificador del Usuario: ");
							idU= data.nextInt();
							
							if(idU<=0) {
								System.err.println("Identificador no admitido. Vuelva a intentar.");
							}
						} catch (InputMismatchException e) {
							System.err.println("El valor ingresado no es númerico");
							idU=0;
						}
						data.nextLine();
					}while(idU<=0);	
					
					try {
						//Devolución de la tupla según Id
						u=mO.getoU().ReadRow(idU);
						
						//Ingreso del nombre
						do {
							try {
								data.nextLine();
								System.out.println("Ingrese el nombre: ");
								u.setNombre(data.nextLine().trim());
								if(u.getNombre().isBlank() || u.getNombre().isEmpty()) {
									System.err.println("Nombre no admitido. Vuelva a intentar.");
								}	
							} catch (Exception eL) {
								System.err.println(eL.getMessage());
							}	
						} while (u.getNombre().isBlank() || u.getNombre().isEmpty());	
						
						//Ingreso del distrito
						do {
							try {
								data.nextLine();
								System.out.println("Ingrese el distrito: ");
								u.setDistrito(data.nextLine().trim());
								if(u.getDistrito().isBlank() || u.getDistrito().isEmpty()) {
									System.err.println("Dato no admitido. Vuelva a intentar.");
								}	
							} catch (Exception eL) {
								System.err.println(eL.getMessage());
							}	
						} while (u.getDistrito().isBlank() || u.getDistrito().isEmpty());	
						
						//Ingreso del Nro. Registro
						do { 
							try {
								System.out.println("Ingrese el Nro. Registro: ");
								u.setNroReg(data.nextInt());
								if(u.getNroReg()<0) {
									System.err.println("Cifra no admitida. Vuelva a intentar.");
								}
							} catch (InputMismatchException e) {
								System.err.println("El valor ingresado no es númerico");
								u.setNroReg(-1);
							}
							data.nextLine();
						}while(u.getNroReg()<0);	
						
						//Ingreso del correo electrónico
						do {
							try {
								data.nextLine();
								System.out.println("Ingrese el correo electrónico(aaa..@aaa....aaa): ");
								u.setCorreo(data.nextLine().trim());
								
								if(!ValidarCorreo(u.getCorreo())) {
									System.err.println("Formato inválido. Vuelva a ingresar");
								}
								
							} catch (Exception e) {
								System.err.println(e.getMessage());
							}
						}while(u.getCorreo().equals(null) || u.getCorreo().isEmpty() || u.getCorreo().isBlank() || !ValidarCorreo(u.getCorreo()));	
						
						//Ingreso del Estado
						do {
							try {
								data.nextLine();
								System.out.println("Ingrese el estado(A=activo;I=inactivo): ");
								u.setEstado(data.nextLine().trim());
								u.setEstado(u.getEstado().toUpperCase());
								
								if(u.getEstado().isBlank() || u.getEstado().isEmpty() || (!u.getEstado().equals("A") && !u.getEstado().equals("I"))) {
									System.err.println("Estado no admitido. Vuelva a intentar.");
								}	
							} catch (Exception eL) {
								System.err.println(eL.getMessage());
							}	
						} while (u.getEstado().isBlank() || u.getEstado().isEmpty() || (!u.getEstado().equals("A") && !u.getEstado().equals("I")));	
						
						//Seteo y actualización
						mO.setU(u);
						mO.UpdateUser();
						
						
					} catch (SQLException e) {
						System.err.println("Error de "+e.getMessage()); 
					}
					
				}else {
					System.err.println("Debe ejecutar la opción A.");
				}
				break;
				
			case "C":
				if(banU) {
					/*if(mO.getoU().getListaUs().equals(null) || mO.getoU().getListaUs().isEmpty()) { //Verificar para la consulta por primera vez
						mO.SelectUsers();
					}*/
					mO.SelectUsers();
					//Ingresar Id
					do { 
						try {
							System.out.println("\nIngrese el Identificador del Usuario: ");
							idU= data.nextInt();
							
							if(idU<=0) {
								System.err.println("Identificador no admitido. Vuelva a intentar.");
							}
						} catch (InputMismatchException e) {
							System.err.println("El valor ingresado no es númerico");
							idU=0;
						}
						data.nextLine();
					}while(idU<=0);	
					
					//Devolución de la tupla según Id
					try {
						u=mO.getoU().ReadRow(idU);
						System.out.println("Elimando registro: \n"+u.toString());
						//seteo y eliminación
						mO.setU(u);
						mO.DeleteUser();
					} catch (SQLException e) {
						System.err.println("Error de "+e.getMessage()); 
					}
				}else {
					System.err.println("Debe ejecutar la opción A.");
				}
				break;
				
			case "D":
				if (banU) {
					/*if(mO.getoU().getListaUs().equals(null)) { //Verificar para la consulta por primera vez
						mO.SelectUsers();
					}*/
					mO.SelectUsers();
				}else {
					System.err.println("Debe ejecutar la opción A.");
				}
				break;
				
			case "X":
				System.out.println("\nRetornando al menú principal...\n");
				break;
				
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion=="X" || opcion=="x" );
		
		return mO;
	}
	
	//Opción A
	private static Usuario CreateU() {
		//Atributos
		String nombre="";
		String distrito="";
		int nroReg=0;
		String correo="";
		String estado="";
		
		//Ingreso del nombre
		do {data.nextLine();
			try {
				System.out.println("Ingrese el nombre: ");
				nombre= data.nextLine();
				nombre= nombre.trim();
				if(nombre.isBlank() || nombre.isEmpty()) {
					System.err.println("Dato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (nombre.isBlank() || nombre.isEmpty());	
		
		//Ingreso del distrito
		do {data.nextLine();
			try {
				System.out.println("Ingrese el distrito: ");
				distrito= data.nextLine();
				distrito= distrito.trim();
				if(distrito.isBlank() || distrito.isEmpty()) {
					System.err.println("Dato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (distrito.isBlank() || distrito.isEmpty());	
		
		//Ingreso del Nro. Registro
		do { 
			try {
				System.out.println("Ingrese el Nro. Registro: ");
				nroReg= data.nextInt();
				
				if(nroReg<0) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
				nroReg=-1;
			}
			data.nextLine();
		}while(nroReg<0);	
		
		//Ingreso del correo electrónico
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el correo electrónico(aaa..@aaa....aaa): ");
				correo= data.nextLine();
				correo=correo.trim();
				
				if(!ValidarCorreo(correo)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(correo.equals(null) || correo.isEmpty() || correo.isBlank() || !ValidarCorreo(correo));	
		
		//Ingreso del Estado
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el estado(A=activo;I=inactivo): ");
				estado= data.nextLine();
				estado= estado.trim();
				estado=estado.toUpperCase();
				if(estado.isBlank() || estado.isEmpty() || (!estado.equals("A") && !estado.equals("I"))) {
					System.err.println("Estado no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (estado.isBlank() || estado.isEmpty() || (!estado.equals("A") && !estado.equals("I")));		
		
		
		return new Usuario(nombre,  distrito,  nroReg,  correo,  estado);
	}
	

	//Opción 1
	private static void VerificarConexion(MenuOperaciones mO) {
		String resul=mO.EstablecerConexion();
		System.out.println("\n"+resul);
		if (resul.equals("Base de datos establecida con éxito.")) {
			banC=true;
		}else {
			banC=false;
		}
		
	}
	
	
	//Expresión regular para el correo
	public static boolean ValidarCorreo(String email) {
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}	
	
	//Expresión regular para el Nro. Lote
	public static boolean ValidarNroLote(String lote) {
		return lote.matches("[0-9][A-Z]_[A-Z]+-[0-9]+");
	}
	
	//Ex. Regular para la fecha
	public static boolean ValidarFecha(String fecha) {
		return fecha.matches("^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$");
	}	
}
