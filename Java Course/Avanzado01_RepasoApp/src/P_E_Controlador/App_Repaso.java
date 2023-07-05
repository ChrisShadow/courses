package P_E_Controlador;

import java.util.InputMismatchException;
import java.util.Scanner;

import P_E_Modelo.Empleado;
import P_E_Modelo.Persona;

public class App_Repaso {

	public static Scanner data = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		System.out.println("Hi, world");
		
		//Primer objeto empleado
		Persona p1= new Persona();
		//Segunndo
		Persona p2= new Persona("3249465", "Ivan", "Putin", 40);
		//Tercero
		Persona p3= new Persona("3249465", "Pame", "Ferreira", 15, 'F',"soltera");
		
		System.out.println(p1.toString()+"\n"+p2.toString()+"\n"+p3.toString().concat("\nINGRESO DE NUEVOS DATOS A LA PRIMERA PERSONA...\n"));
		
		//Ingreso del NroCi
		do { 
			try {
				System.out.println("\nIngrese el número de cédula: ");
				p1.setNroCi(data.nextLine());
				
				if(p1.getNroCi().isEmpty() || p1.getNroCi().length()<5) {
					System.err.println("Dato incompleto. Vuelva a intentar.");
				}
			} catch (Exception e) {
				System.err.println("El valor ingresado: " + e.getMessage().concat(" no corresponde."));
			}
			data.nextLine();
		}while(p1.getNroCi().isEmpty() || p1.getNroCi().length()<5);	
		
		
		//Ingreso del Nombre
		do { 
			try {
				System.out.println("\nIngrese el nombre: ");
				p1.setNombre(data.nextLine());
				
				if(p1.getNombre().isEmpty() || p1.getNombre().length()<3) {
					System.err.println("Dato incompleto. Vuelva a intentar.");
				}
			} catch (Exception e) {
				System.err.println("El valor ingresado: " + e.getMessage().concat(" no corresponde."));
			}
			data.nextLine();
		}while(p1.getNombre().isEmpty() || p1.getNombre().length()<3);
		
		//Ingreso del Apellido.
		do { 
			try {
				System.out.println("\nIngrese el apellido: ");
				p1.setApellido(data.nextLine());
				
				if(p1.getApellido().isEmpty() || p1.getApellido().length()<3) {
					System.err.println("No debe estar vacío. Vuelva a intentar.");
				}
			} catch (Exception e) {
				System.err.println("El valor ingresado: " + e.getMessage().concat(" no corresponde."));
			}
			data.nextLine();
		}while(p1.getApellido().isEmpty() || p1.getApellido().length()<3);
		
		//Ingreso de la edad
		do {
			try {
				System.out.println("Ingrese la edad: ");
				p1.setEdad(data.nextInt());
				if(p1.getEdad()<=0) {
					System.err.println("Dato inválido. Vuelva a intentar");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(p1.getEdad()<=0);
		
		//Ingreso del Sexo
		String sexo="";
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el sexo(M-F): ");
				sexo = data.nextLine();
				sexo=sexo.toUpperCase();
				if(!sexo.equals("M") && !sexo.equals("F")) {
					System.err.println("Caracter incorrecto. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(sexo.isEmpty() || sexo.isBlank() || (!sexo.equals("M") && !sexo.equals("F")));
		p1.setSexo(sexo.charAt(0));		
		
		//Ingreso del Estado Civil
		do { 
			try {
				System.out.println("\nIngrese el estado civil: ");
				p1.setEstadoCivil(data.nextLine());
				
				if(p1.getEstadoCivil().isEmpty() || (!p1.getEstadoCivil().equalsIgnoreCase("soltero") && !p1.getEstadoCivil().equalsIgnoreCase("casado") &&  !p1.getEstadoCivil().equalsIgnoreCase("divorciado"))) {
					System.err.println("Error. Vuelva a intentar.");
				}
			} catch (Exception e) {
				System.err.println("El valor ingresado: " + e.getMessage().concat(" no corresponde."));
			}
			data.nextLine();
		}while(p1.getEstadoCivil().isEmpty() || (!p1.getEstadoCivil().equalsIgnoreCase("soltero") && !p1.getEstadoCivil().equalsIgnoreCase("casado") && !p1.getEstadoCivil().equalsIgnoreCase("divorciado")));
		
		//Punto 9
		System.out.println("\nDATOS NUEVOS DE LA PERSONA 1\n"+p1.toString()+"\n");
		
		//Primer objeto empleado
		Empleado e1= new Empleado();
		
		//Segunndo
		Empleado e2= new Empleado(p2.getNroCi(), p2.getNombre(), p2.getApellido(), p2.getEdad());
		//Tercero
		Empleado e3= new Empleado(p3.getNroCi(), p3.getNombre(), p3.getApellido(), p3.getEdad(), p3.getSexo(), p3.getEstadoCivil(), 1500000);
		
		
		System.out.println(e1.toString()+"\n"+e2.toString()+"\n"+e3.toString().concat("\nCalculando salario del EXTRAVAGANTE ERMITAÑO...\n")+"\nSalario del empleado ("+e1.getNombre().concat(", ").concat(e1.getApellido())+" ): "+e1.CalcularSalario()+"\nSalario del empleado ("+e2.getNombre().concat(", ").concat(e2.getApellido())+" ): "+e2.CalcularSalario()+"\nSalario del empleado ("+e3.getNombre().concat(", ").concat(e3.getApellido())+" ): "+e3.CalcularSalario());
		System.out.println("\n**FIN DEL REPASO-CLASE 1**");
		
	}

}
