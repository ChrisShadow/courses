package Hospedaje;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	
	public static Scanner data = new Scanner(System.in);
	//Banderas para menú
	public static boolean banC=false;
	
	//Clases
	public static MenuOperaciones mU;
	public static Hospedaje h;	
	public static Archivo aR;
	

	public static void main(String[] args) {
		int banOpcion=0;
		mU = new MenuOperaciones();
		aR= new Archivo ();
		do {
			try {
				MenuOperaciones(banOpcion);
				banOpcion=1;
			} catch (InputMismatchException e) {
				System.err.println("La opción no es numérica.Intenta de nuevo");
				banOpcion=0;
				data.nextLine();
			}
		} while (banOpcion!=1);	
		System.err.println("**THE END OF FUCKING JAVA**");
	}


	private static void MenuOperaciones(int banOpcion) throws InputMismatchException {
		int opcion=0;
		do {
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println("1- Agregar Hospedaje");
			System.out.println("2- Consultar Hospedaje");
			System.out.println("3- Modificar Hospedaje");
			System.out.println("4- Mostrar información del Log");
			System.out.println("99- Salir del menú");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1: 
				AddHospedaje();
				banC=true;
				break;
			case 2:
				if(banC) {
					ConsultarHospedaje();
				}else {
					System.err.println("Debe ejecutar la opción 1.");
				}
				break;
			case 3:
				if(banC) {
					UpdHospedaje();
				}else {
					System.err.println("Debe ejecutar la opción 1.");
				}
				break;
			case 4:
				//if(banC) {
					MostarArchivo();
				/*}else {
					System.err.println("Debe ejecutar la opción 1.");
				}*/
				break;
			case 99:
				System.out.println("Finalizando menú...\n");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!=99);
	}

	//Opción 4
	private static void MostarArchivo() {
		try {
			StringBuilder reporte=aR.LeerrArchivo();
			System.out.println("\n"+reporte);
		} catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
			System.err.println("Ocurrió un error de "+e.getMessage());
		}
	}


	//Opción 3
	private static void UpdHospedaje() {
		int numH=0;
		int cantidad=0;
		Hospedaje o=null;
		boolean con;
		ArrayList<Hospedaje> liH= new ArrayList<Hospedaje>();
		try {
			do {
				liH=mU.consultarHospedaje();
				for (Hospedaje hospedaje : liH) {
					System.out.println("\n"+hospedaje.toString().concat("\n"));
				}
				
				//Ingresar num H
				do { 
					try {
						
						System.out.println("Ingrese el Nro. de hospedaje: ");
						numH= data.nextInt();
						
						if(numH<=0) {
							System.err.println("Identificador no admitido. Vuelva a intentar.");
						}
					} catch (InputMismatchException e) {
						System.err.println("El valor ingresado no es númerico");
					}
					data.nextLine();
				}while(numH<=0);
			
				//Devolución de la tupla según Id
				h=mU.BuscarHospedaje(numH);
			
				o=liH.get(numH-1);
			
		} while(h.equals(o)==true);
			
			
			//Ingreso de la cantidad de días de hospedajes
			 do {
				 try {
					System.out.println("Ingrese la cantidad de días de hospedajes: ");
					h.setCanDiasHos(data.nextInt());
					
					if(h.getCanDiasHos()<=0) {
						System.err.println("Cantidad no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(h.getCanDiasHos()<=0);
			
			//Ingreso monto total del hospedaje
			do { 
				try {
					System.out.println("Ingrese el monto total del hospedaje: ");
					h.setMontoTotal(data.nextInt());
					
					if(h.getMontoTotal()<0) {
						System.err.println("Cifra no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(h.getMontoTotal()<0);			
			
			//Ingreso el monto cancelado
			do { 
				try {
					System.out.println("Ingrese el monto cancelado: ");
					h.setMontoCan(data.nextInt());
					
					if(h.getMontoCan()<0) {
						System.err.println("Cifra no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(h.getMontoCan()<0);	
			
			//Ingreso del estado
			int e=0;
			do { 
				try {
					System.out.println("Ingrese el estado(1=Activo;2=Inactivo): ");
					e=data.nextInt();
					
					if(e<1 || e>2) {
						System.err.println("Estado no admitido. Vuelva a intentar.");
					}
				} catch (InputMismatchException r) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(e<1 || e>2);
			if (e==1) {
				h.setEst(Estado.ACTIVO);
			}else {
				h.setEst(Estado.INACTIVO);
			}
			
			cantidad=mU.SentenciaModificar(h);
			System.out.println("Cantidad de hospedaje actualzado: "+cantidad);
			if (cantidad>0) {
				aR.GuardarArchivo(h, "ACTUALIZACION"); //Añadir línea al archivo
			}
			
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage()); 	
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
		}finally {
			try {
				con=mU.cerrarConexion();
			} catch (SQLException e) {
				System.err.println("Error de "+e.getMessage());
			}
		}
	}

	//Opción 2
	private static void ConsultarHospedaje() {
		boolean con;
		ArrayList<Hospedaje> liH= new ArrayList<Hospedaje>();
		try {
			liH=mU.consultarHospedaje();
			for (Hospedaje hospedaje : liH) {
				System.out.println("\n"+hospedaje.toString().concat("\n"));
			}
		}catch (NullPointerException e) {
			System.err.println("Error de "+e.getMessage()); 	
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
		}finally {
			try {
				con=mU.cerrarConexion();
			} catch (SQLException e) {
				System.err.println("Error de "+e.getMessage());
			}
		}
	}


	//Opción 1
	private static void AddHospedaje() {
		boolean con;
		try {
			h=Cargar();
			con=mU.SentenciaInsertar(h);
			if (con) {
				System.out.println("\nHospedaje guardado correctamente\n");
			}
			aR.GuardarArchivo(h, "INSERCION");//Añadir línea al archivo
		}catch (NullPointerException e) {
				System.err.println("Error de "+e.getMessage()); 	
		} catch (SQLException e) {
			System.err.println("Error de "+e.getMessage()); 
		}finally {
			try {
				con=mU.cerrarConexion();
			} catch (SQLException e) {
				System.err.println("Error de "+e.getMessage());
			}
		}
	}


	private static Hospedaje Cargar()  {
		String nroDoc="";
		int canDiasHos=0;
		int nroPiso=0;
		int nroHabi=0;
		Pais pais=null;
		int montoTotal=0;
		int montoCan=0;
		Estado est=null;
		
		
		//Ingreso del Nro. Documento
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el Nro. Documento: ");
				nroDoc=data.next();
				nroDoc=nroDoc.trim();
				if(nroDoc.isBlank() || nroDoc.isEmpty()) {
					System.err.println("Dato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (nroDoc.isBlank() || nroDoc.isEmpty());
		
		//Ingreso de la cantidad de días de hospedajes
		do { 
			try {
				System.out.println("Ingrese la cantidad de días de hospedajes: ");
				canDiasHos=data.nextInt();
				
				if(canDiasHos<=0) {
					System.err.println("Cantidad no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(canDiasHos<=0);	 
		
		//Ingreso del Nro. piso
		do { 
			try {
				System.out.println("Ingrese el Nro. piso: ");
				nroPiso=data.nextInt();
				
				if(nroPiso<0) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(nroPiso<0);		
		
		//Ingreso del Nro. habitación
		do { 
			try {
				System.out.println("Ingrese el Nro. habitación: ");
				nroHabi=data.nextInt();
				
				if(nroHabi<0) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(nroHabi<0);	
		
		//Ingreso del país
		String p="";
		do { 
			try {
				System.out.println("Ingrese el país(B=Brasil;A=Argentina;P=Paraguay;C=Chile): ");
				p=data.next();
				p=p.toUpperCase();
				p=p.trim();
				if(!p.equals("B") && !p.equals("A") && !p.equals("P") && !p.equals("C") ) {
					System.err.println("Opción no admitida. Vuelva a intentar.");
				}
			} catch (Exception r) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(p.isBlank() && p.isEmpty() || (!p.equals("B") && !p.equals("A") && !p.equals("P") && !p.equals("C")));
		if (p.equals("B")) {
			pais=Pais.BRASIL;
		}else if (p.equals("A")) {
			pais=Pais.ARGENTINA;
		}else if (p.equals("P")) {
			pais=Pais.PARAGUAY;
		}else {
			pais=Pais.CHILE;
		}
		
		//Ingreso monto total del hospedaje
		do { 
			try {
				System.out.println("Ingrese el monto total del hospedaje: ");
				montoTotal=data.nextInt();
				
				if(montoTotal<0) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(montoTotal<0);			
		
		//Ingreso el monto cancelado
		do { 
			try {
				System.out.println("Ingrese el monto cancelado: ");
				montoCan=data.nextInt();
				
				if(montoCan<0) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(montoCan<0);	
		
		//Ingreso del estado
		int e=0;
		do { 
			try {
				System.out.println("Ingrese el estado(1=Activo;2=Inactivo): ");
				e=data.nextInt();
				
				if(e<1 || e>2) {
					System.err.println("Estado no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException r) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(e<1 || e>2);
		if (e==1) {
			est=Estado.ACTIVO;
		}else {
			est=Estado.INACTIVO;
		}
		
		return new Hospedaje( nroDoc,  canDiasHos,  nroPiso,  nroHabi,  pais,  montoTotal,  montoCan, est);
	}

}
