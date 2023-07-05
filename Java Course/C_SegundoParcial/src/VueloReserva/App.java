package VueloReserva;

import java.util.Scanner;


public class App {

	public static Scanner data = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		MenuOperaciones();
		System.out.println("PROGRAMA FINALIZADO");
	}

	//Menú de operaciones
	private static void MenuOperaciones() {
		int opcion=4;
		Pasajero pass =null;
		ReservaVuelo rv=null; 
		boolean flagPass=false;
		boolean flagRes=false;
		do {
			System.out.println("\n\nEscoga la operación a realizar de la cuenta de ahorro");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println();
			System.out.println("1- Cargar datos del Pasajero Principal");
			System.out.println("2- Cargar datos de la reserva del Vuelo");
			System.out.println("3- Mostrar información del Pasajero principal/reserva del Vuelo");
			System.out.println("4- Salir del menu");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1: 
				pass=CargarDatosPasajero();
				if(!pass.equals(null)) {
					flagPass=true;
				}
				break;
			case 2:
				if(flagPass) {
					rv=CargarDatosReserva();
					if(!rv.equals(null)) {
						flagRes=true;
					}
				}else {
					System.err.println("Debe cargar datos al pasajero principal.");
				}
				break;
			case 3:
				if(flagPass && flagRes) {
					MostarInformacionPasajero(pass,rv);
				}else {
					System.err.println("Debe cargar los datos Pasajero/Reserva");
				}
				break;
			case 4:
				System.out.println("Saliendo del menú, fin del proceso de operaciones");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!=4);
	}

	//Método de cálculo e impresión de datos
	
	private static void MostarInformacionPasajero(Pasajero pass, ReservaVuelo rv) {
		double precioBase=rv.ObtenerPrecioBase(pass.getEdad());
		double montoAbonar=rv.ObtenerMontoTotal(pass.getCategoria());
		
		System.out.println(pass.toString()+"\n"+rv.toString());
		System.out.println("El precio base es: "+ precioBase +"\nEl monto a abonar es: "+ montoAbonar);
		
	}
	
	//Cargas de Datos
	
	private static ReservaVuelo CargarDatosReserva() {
		 String ciudadOrigen="";
		 String ciudadDestino="";
		 String tipoReserva="";
		 String fechaSalida=""; //cambiar a Date
		 String fechaVuelta=""; //cambiar a Date
		 int cantidadPasaj=0;
		 String tipoCabina="";
		 ReservaVuelo rrvv= null;
		 
		 //instanciación del objeto
		 rrvv= new ReservaVuelo(); 
		 
		 //Ingreso del Tipo de reserva
		 do {
				System.out.println("Ingrese el tipo de reserva(I=ida, V=ida y vuelta, M=múltiple destino): ");
				tipoReserva = data.nextLine();
				tipoReserva.toUpperCase();
				if(!tipoReserva.equals("I") && !tipoReserva.equals("V") && !tipoReserva.equals("M")) {
					System.err.println("Caracter incorrecto. Vuelva a intentar");
				}
			}while(!tipoReserva.equals("I") && !tipoReserva.equals("V") && !tipoReserva.equals("M")); 
		
		 //Ingreso cantidad padajero
		 System.out.println("Ingrese la cantidad de pasajero(>=1 y <=6): ");
		 cantidadPasaj= data.nextInt();
			while(cantidadPasaj <1  || cantidadPasaj >6) {
				System.err.println("Cantidad no admitida. Vuelva a intentar.");
				System.out.println("Ingrese la cantidad de pasajero(>=1 y <=6): ");
				cantidadPasaj= data.nextInt();
			}
		 
		//Ingreso del tipo de cabina
			 do {
					System.out.println("Ingrese el tipo de cabina(E=económica, N=normal, P=premium): ");
					tipoCabina = data.nextLine();
					tipoCabina.toUpperCase();
					if(!tipoCabina.equals("E") && !tipoCabina.equals("N") && !tipoCabina.equals("P")) {
						System.err.println("Caracter incorrecto. Vuelva a intentar");
					}
				}while(!tipoCabina.equals("E") && !tipoCabina.equals("N") && !tipoCabina.equals("P")); 
		
			 
		//Ingreso de ciudad de origen
			System.out.println("Ingrese la ciudad de origen (Obligatorio): ");
			ciudadOrigen= data.nextLine();
			ciudadOrigen.toUpperCase();
			while(ciudadOrigen=="") {
				System.err.println("Debe ingresar una ciudad. Vuelva a intentar.");
				System.out.println("Ingrese la ciudad de origen (Obligatorio): ");
				ciudadOrigen= data.nextLine();
			}
			
		//Ingreso ciudad de destino
			System.out.println("Ingrese la ciudad de destino (Obligatorio): ");
			ciudadDestino= data.nextLine();
			ciudadDestino.toUpperCase();
			while(ciudadDestino=="") {
				System.err.println("Debe ingresar una ciudad. Vuelva a intentar.");
				System.out.println("Ingrese la ciudad de destino (Obligatorio): ");
				ciudadDestino= data.nextLine();
			}
			
		//Ingreso fecha salidad
			System.out.println("Ingrese la fecha de salida (Obligatorio): ");
			fechaSalida= data.nextLine();
			while(fechaSalida=="") {
				System.err.println("Debe ingresar una fecha. Vuelva a intentar.");
				System.out.println("Ingrese la fecha de salida (Obligatorio): ");
				fechaSalida= data.nextLine();
			}
		
		//Ingreso fecha vuelta
			System.out.println("Ingrese la fecha de regreso (Obligatorio): ");
			fechaVuelta= data.nextLine();
			while(fechaVuelta=="") {
				System.err.println("Debe ingresar una fecha. Vuelva a intentar.");
				System.out.println("Ingrese la fecha de regreso (Obligatorio): ");
				fechaVuelta= data.nextLine();
			}
			
			
		 //Asignación de los atributos las variables
		 rrvv.setCiudadOrigen(ciudadOrigen);
		 rrvv.setCiudadDestino(ciudadDestino);
		 rrvv.setTipoReserva(tipoReserva.charAt(0));
		 rrvv.setFechaSalida(fechaSalida);
		 rrvv.setFechaVuelta(fechaVuelta);
		 rrvv.setCantidadPasaj(cantidadPasaj);
		 rrvv.setTipoCabina(tipoCabina.charAt(0));
		 
		return rrvv;
	}
	

	private static Pasajero CargarDatosPasajero() {
		 int nrodoc =0;
		 String tipodoc="";
		 int categoria=0;
		 int edad=0;
		 String gmail="";
		 
		//Ingreso del tipo de documento
			do {
				System.out.println("Ingrese el tipo de documento(c=cedula;p=pasaporte): ");
				tipodoc = data.nextLine();
				tipodoc.toLowerCase();
				if(!tipodoc.equals("c") && !tipodoc.equals("p")) {
					System.err.println("Caracter incorrecto. Vuelva a intentar");
				}
			}while(!tipodoc.equals("c") && !tipodoc.equals("p")); 
		 
		//Ingreso de la edad
		System.out.println("Ingrese la edad(>20 y <=60): ");
		edad= data.nextInt();
		while(edad <=20  || edad >60) {
			System.err.println("Edad no admitida. Vuelva a intentar.");
			System.out.println("Ingrese la edad(>20 y <=60): ");
			edad= data.nextInt();
		}
				
		 
		 //Ingreso de la categoría
		 do {
				System.out.println("Ingrese la categoría del pasajero(111:turista;222=normal): ");
				categoria = data.nextInt();
				if(categoria!=111 && categoria!=222) {
					System.err.println("Cifra incorrecta. Vuelva a intentar");
				}
			}while(categoria!=111 && categoria!=222); 
		 
			
		//Ingreso del nro documento
			System.out.println("Ingrese el número de documenteo(cifra válida: ");
			nrodoc= data.nextInt();
				while(nrodoc <100000  || nrodoc >9999999) {
					System.err.println("Nro de documento no admitido. Vuelva a intentar.");
					System.out.println("Ingrese el número de documenteo(cifra válida: ");
					nrodoc= data.nextInt();
				}
				
		//Ingreso del email
		System.out.println("Ingrese el email (Opcional: ");
		gmail= data.nextLine();
		
		 
		return new Pasajero(nrodoc, tipodoc.charAt(0),  categoria,  edad,  gmail);
	}
}
