package HabitacionReserva;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	
	public static Scanner data = new Scanner(System.in);
	public static boolean banC=false; 
	public static ClienteReserva vecFac[];
	public static void main(String[] args) {
		
		MenuOperaciones();
		System.out.println("**FIN DEL PROGRAMA**");
		
		

	}
	
	//menú de operaciones
	private static void MenuOperaciones() {
		ClienteReserva vecFac[]= new ClienteReserva[1];
		int opcion=3;
		do {
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println();
			System.out.println("1- Ingresar datos para la factura");
			System.out.println("2- Mostar detalles de la factura calculada");
			System.out.println("3- Salir");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1: 
				CargarFactura(vecFac);
				break;
			case 2:
				try {
					MostrarFactura(vecFac);
				}catch(ExceptionSalesSlip ex){
					System.err.println(ex.getMessage());
				}
				
				break;
			case 3:
				System.out.println("Finalizando programa...");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!=3);
	}
	
	private static void MostrarFactura(ClienteReserva vecFac[]) throws ExceptionSalesSlip {
		String err="";
		if(banC) {
			for (int i = 0; i < 1; i++) {
				if((vecFac[i].getTipoHabitacion()=='v' || vecFac[i].getTipoHabitacion()=='m') && vecFac[i].getNroDto()<90) {
					err="Monto calculado para el tipo " + vecFac[i].getTipoHabitacion().toString() + " no corresponde según política" ;
					throw new ExceptionSalesSlip(err);
				}else{
					if(vecFac[i].getNroDto()>75 && vecFac[i].getCantDias()>24) {
						err="Monto calculado para el tipo " + vecFac[i].getTipoHabitacion().toString() + " no corresponde según política" ;
						throw new ExceptionSalesSlip(err);
					}else {
						if(vecFac[i].getTipoHabitacion()=='c' && vecFac[i].getCantDias()<15 ) {
							err="Monto calculado para el tipo " + vecFac[i].getTipoHabitacion().toString() + " no corresponde según política" ;
							throw new ExceptionSalesSlip(err);
						}else {
							vecFac[i].CalularMontoFactura();
						}
					}
				}
				System.out.println(vecFac[i].toString());
				
			}
		}else {
			System.out.println("Debe ingresar los datos para la factura");
		}
		
		
	}

	private static void CargarFactura(ClienteReserva vecFac[]) {
		for (int i = 0; i < 1; i++) {
			vecFac[i]= DatosCliente();
		}
		banC=true;
	}

	//método para solicitar datos cliente
	public static ClienteReserva DatosCliente() {
		int idCliente=0 ;
		String razonSocial="";
		int nroEdificio=0;
		int nroPiso=0;
		int nroDto=0;
		String tipoHabitacion="";
		double precioBase=0;
		int cantDias=0;
		ClienteReserva cliR=null;
		
		//Carga de datos
		
		//Ingreso del ID
		do {
			try {
				System.out.println("Ingrese el ID: ");
				idCliente= data.nextInt();
				
				if(idCliente<=0) {
					System.err.println("ID no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				 System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(idCliente<=0);
		
		//Ingreso de la Razón Social
		System.out.println("Ingrese la Razón Social: ");
		razonSocial= data.nextLine();
		while(razonSocial=="") {
			System.err.println("Razón Social no admitida. Vuelva a intentar.");
			System.out.println("Ingrese la Razón Social: ");
			razonSocial= data.nextLine();
		}
		
		//Ingreso del Nro. edificio
		do {
			try {
				System.out.println("Ingrese el nro del edificio: ");
				nroEdificio= data.nextInt();
				
				if(nroEdificio<=0) {
					System.err.println("Nro. edificio no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(nroEdificio<=0);
		
		
		//Ingreso del Nro. piso
		do {
			try {
				System.out.println("Ingrese el nro de piso: ");
				nroPiso= data.nextInt();
				
				if(nroPiso<=0) {
					System.err.println("Nro. piso no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(nroPiso<=0);
		
		//Ingreso del Nro. Departamento
		do {
			try {
				System.out.println("Ingrese el  Nro. Departamento(77-100): ");
				nroDto = data.nextInt();
				
				if(nroDto<77 || nroDto>100) {
					System.err.println("Nro. Departamento no admitido. Vuelva a intentar");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(nroDto<77 || nroDto>100);
		
		//Ingreso del Tipo habitación
		do {
			System.out.println("Ingrese el tipo de habitación(s=simple;d=doble;c=confort;m=matrimonial;v=vip): ");
			tipoHabitacion = data.nextLine();
			tipoHabitacion.toLowerCase();
			if(!tipoHabitacion.equals("s") && !tipoHabitacion.equals("d") && !tipoHabitacion.equals("c") && !tipoHabitacion.equals("m") && !tipoHabitacion.equals("v")) {
				System.err.println("Caracter incorrecto. Vuelva a intentar");
			}
		}while(!tipoHabitacion.equals("s") && !tipoHabitacion.equals("d") && !tipoHabitacion.equals("c") && !tipoHabitacion.equals("m") && !tipoHabitacion.equals("v"));
		
		//Ingreso del precio base
		do {
			try {
				System.out.println("Ingrese el precio base: ");
				precioBase= data.nextDouble();
				
				if(precioBase<=0) {
					System.err.println("Precio base no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(precioBase<=0);
		
		//Ingreso de la cantidad de días
		do {
			try {
				System.out.println("Ingrese cantidad de días utilizadas: ");
				cantDias= data.nextInt();
				
				if(cantDias<=0) {
					System.err.println("Cantidad de días no admitidas. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(cantDias<=0);
		
		//instanciación del objeto
		cliR=new ClienteReserva();
		
		//Asignación de valores al objeto
		cliR.setIdCliente(idCliente);
		cliR.setRazonSocial(razonSocial);
		cliR.setNroEdificio(nroEdificio);
		cliR.setNroPiso(nroPiso);
		cliR.setNroDto(nroDto);
		cliR.setTipoHabitacion(tipoHabitacion.charAt(0));
		cliR.setPrecioBase(precioBase);
		cliR.setCantDias(cantDias);
		cliR.ObtenerRecargo();
		//cliR.CalularMontoFactura();
		
		return cliR;

	}
}

