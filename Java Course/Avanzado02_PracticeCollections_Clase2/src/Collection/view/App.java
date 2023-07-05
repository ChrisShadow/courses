package Collection.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import Collections.controller.*;
import Collections.model.Vehicle;

public class App {

	
	public static Scanner data = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("EJECICIO DE PRÁCTICA CLASE 2 - COLLECTIONS");
		EjercicioUno ej1 = new EjercicioUno();
		EjercicioDos ej2 = new EjercicioDos();
		
		//CARGA 1
		System.err.println("\nEjercicio 1 - ArrayList\n\nIngresando datos del Vehículo");
		int resp=0;
		do {
			try {
				ej1.agregarElementos(CargarDatosV());
				System.out.println("\nPresione 1 si desea continua agregando vehículo. Presione 0 para salir.");
				resp=data.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		} while (resp!=0);
		
		//FUNCIONES EJERCICIOS 1
		
		ej1.cantidadVehiculos();
		ej1.vehiculosCoche();
		int km=0;
		//Ingreso del Km
		do {
			try {
				System.out.println("\nIngrese el kilometraje a buscar: ");
				km=data.nextInt();
				if(km<=-1) {
					System.err.println("Dato inválido. Vuelva a intentar");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(km<=-1);		
		ej1.vehiculosKm(km);
		String m="";
		//Ingreso de la marca
		do { 
			try {
				System.out.println("\nIngrese la marca a buscar: ");
				m=data.nextLine();
				
				if(m.isEmpty()) {
					System.err.println("Dato incompleto. Vuelva a intentar.");
				}
			} catch (Exception e) {
				System.err.println("El valor ingresado: " + e.getMessage().concat(" no corresponde."));
			}
			data.nextLine();
		}while(m.isEmpty());			
		ej1.vehiculosMarca(m);
		
		ej1.camionetasKm();
		
		//CARGA 2
		System.err.println("\nEjercicio 1 - HashSett\n\nIngresando datos del Vehículo");
		do {
			try {
				ej2.agregarElementos(CargarDatosV());
				System.out.println("\nPresione 1 si desea continua agregando vehículo. Presione enter para salir.");
				resp=data.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		} while (resp!=0);
		
		
		//FUNCIONES EJERCICIOS 2
		
		ej2.cantidadVehiculos();
		ej2.vehiculosCoche();
		int km2=0;
		//Ingreso del Km
		do {
			try {
				System.out.println("\nIngrese el kilometraje a buscar: ");
				km2=data.nextInt();
				if(km2<=-1) {
					System.err.println("Dato inválido. Vuelva a intentar");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(km2<=-1);		
		ej2.vehiculosKm(km2);
		String m2="";
		//Ingreso de la marca
		do { 
			try {
				System.out.println("\nIngrese la marca a buscar: ");
				m2=data.nextLine();
				
				if(m2.isEmpty()) {
					System.err.println("Dato incompleto. Vuelva a intentar.");
				}
			} catch (Exception e) {
				System.err.println("El valor ingresado: " + e.getMessage().concat(" no corresponde."));
			}
			data.nextLine();
		}while(m2.isEmpty());			
		ej2.vehiculosMarca(m2);
		
		ej2.camionetasKm();
		
		System.out.println("**\nFIN DEL PROGRAMA**");
	}

	public static Vehicle CargarDatosV() {
		Vehicle v= new Vehicle();
		//Ingreso de la matricula
		do { 
			try {
				System.out.println("\nIngrese la matricula: ");
				v.setMatricula(data.nextLine());
				
				if(v.getMatricula().isEmpty()) {
					System.err.println("Dato incompleto. Vuelva a intentar.");
				}
			} catch (Exception e) {
				System.err.println("El valor ingresado: " + e.getMessage().concat(" no corresponde."));
			}
			data.nextLine();
		}while(v.getMatricula().isEmpty());		
		
		//Ingreso de la marca
		do { 
			try {
				System.out.println("\nIngrese la marca: ");
				v.setMarca(data.nextLine());
				
				if(v.getMarca().isEmpty()) {
					System.err.println("Dato incompleto. Vuelva a intentar.");
				}
			} catch (Exception e) {
				System.err.println("El valor ingresado: " + e.getMessage().concat(" no corresponde."));
			}
			data.nextLine();
		}while(v.getMarca().isEmpty());		
		
		
		//Ingreso del tipo vehículo
		do { 
			try {
				System.out.println("\nIngrese el tipo vehículo (coche-camioneta-bici): ");
				v.setTipo(data.nextLine());
				
				if(v.getTipo().isEmpty() || (!v.getTipo().equalsIgnoreCase("coche") && !v.getTipo().equalsIgnoreCase("camioneta") &&  !v.getTipo().equalsIgnoreCase("bici"))) {
					System.err.println("Error. Vuelva a intentar.");
				}
			} catch (Exception e) {
				System.err.println("El valor ingresado: " + e.getMessage().concat(" no corresponde."));
			}
			data.nextLine();
		}while(v.getTipo().isEmpty() || (!v.getTipo().equalsIgnoreCase("coche") && !v.getTipo().equalsIgnoreCase("camioneta") &&  !v.getTipo().equalsIgnoreCase("bici")));		
		
		//Ingreso del Km
		do {
			try {
				System.out.println("Ingrese el kilometraje: ");
				v.setKm(data.nextInt());
				if(v.getKm()<=-1) {
					System.err.println("Dato inválido. Vuelva a intentar");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(v.getKm()<=-1);
		
		return v;
	}
}
