package clase6ChrisRolon;

import java.util.Scanner;

public class App {
	public static Scanner input = new Scanner(System.in); 
	
	static String nombre;
	static String apellido;
	static String tipoempleado;
	static int antiguedad;
	static double salario;
	
	public static void main(String[] args) {
		System.out.println("INGRESO DE DATOS DEL EMPLEADO");
		
		//Persona 1
		System.out.println("Ingrese el nombre del empleado: ");
		 nombre = input.nextLine();
		 
		System.out.println("Ingrese el apellido del empleado: ");
		apellido = input.nextLine();
		
		do {
			System.out.println("Ingrese el tipo de empleado(F=Funcionario; C=Contratado): ");
			tipoempleado = input.nextLine();
			tipoempleado.toUpperCase();
			if(!tipoempleado.equals("F") && !tipoempleado.equals("C")) {
				System.err.println("Caracter incorrecto. Vuelva a intentar");
			}
		}while(!tipoempleado.equals("F") && !tipoempleado.equals("C")); 
		
		
		do {
			System.out.println("Ingrese la antigüedad del empleado: ");
			antiguedad = input.nextInt();
			if(antiguedad <0) {
				System.err.println("No se admite valores negativos. Vuelva a intentar");
			}
		}while(antiguedad <0); 
		
		do {
			System.out.println("Ingrese el salario del empleado: ");
			salario = input.nextDouble();
			if(salario <=0) {
				System.err.println("No se admite valores negativos ni igual a 0. Vuelva a intentar");
			}
		}while(salario <=0);
		
		Empleado persona1 = new Empleado(nombre, apellido,tipoempleado.charAt(0),antiguedad,salario ); 
		System.out.println("Nombre=<"+ persona1.getNombre() + "> Nombre=<"+ persona1.getApellido() + "> Tipo=<" + persona1.getTipoempleado() + "> Antigüedad=<" + persona1.getAntiguedad() + "> Salario=<" +persona1.getSalario()+ ">");
		System.out.println("Aumento del salario a un 26,3%: " + persona1.AumentarSalario(26.3));
		
		//Persona 2
		Empleado persona2 = new Empleado( ); 
		
		System.out.println("\nIngrese el nombre del empleado: ");
		persona2.setNombre(input.nextLine());
		
		System.out.println("Ingrese el apellido del empleado: ");
		persona2.setApellido(input.nextLine());
		
		do {
			System.out.println("Ingrese el tipo de empleado(F=Funcionario; C=Contratado): ");
			tipoempleado = input.nextLine();
			tipoempleado.toUpperCase();
			if(!tipoempleado.equals("F") && !tipoempleado.equals("C")) {
				System.err.println("Caracter incorrecto. Vuelva a intentar");
			}
		}while(!tipoempleado.equals("F") && !tipoempleado.equals("C")); 
		persona2.setTipoempleado(tipoempleado.charAt(0));
		
		do {
			System.out.println("Ingrese la antigüedad del empleado: ");
			persona2.setAntiguedad(input.nextInt());
			if(persona2.getAntiguedad() <0) {
				System.err.println("No se admite valores negativos. Vuelva a intentar");
			}
		}while(persona2.getAntiguedad() <0);
		
		do {
			System.out.println("Ingrese el salario del empleado: ");
			persona2.setSalario(input.nextDouble()); 
			if(persona2.getSalario() <=0) {
				System.err.println("No se admite valores negativos ni igual a 0. Vuelva a intentar");
			}
		}while(persona2.getSalario() <=0);
		
		System.out.println("Nombre=<"+ persona2.getNombre() + "> Nombre=<"+ persona2.getApellido() + "> Tipo=<" + persona2.getTipoempleado() + "> Antigüedad=<" + persona2.getAntiguedad() + "> Salario=<" +persona2.getSalario()+ ">");
		System.out.println("Aumento del salario a un 28%: " + persona2.AumentarSalario(28));
		
		//Persona 3
		Empleado persona3 = new Empleado( ); 
		
		System.out.println("\nIngrese el nombre del empleado: ");
		 nombre = input.nextLine();
		 
		System.out.println("Ingrese el apellido del empleado: ");
		apellido = input.nextLine();
		
		do {
			System.out.println("Ingrese el tipo de empleado(F=Funcionario; C=Contratado): ");
			tipoempleado = input.nextLine();
			tipoempleado.toUpperCase();
			if(!tipoempleado.equals("F") && !tipoempleado.equals("C")) {
				System.err.println("Caracter incorrecto. Vuelva a intentar");
			}
		}while(!tipoempleado.equals("F") && !tipoempleado.equals("C")); 
		
		do {
			System.out.println("Ingrese la antigüedad del empleado: ");
			antiguedad = input.nextInt();
			if(antiguedad <0) {
				System.err.println("No se admite valores negativos. Vuelva a intentar");
			}
		}while(antiguedad <0); 
		
		do {
			System.out.println("Ingrese el salario del empleado: ");
			salario = input.nextDouble();
			if(salario <=0) {
				System.err.println("No se admite valores negativos ni igual a 0. Vuelva a intentar");
			}
		}while(salario <=0);
		
		persona3.setNombre(nombre);
		persona3.setApellido(apellido);
		persona3.setTipoempleado(tipoempleado.charAt(0));
		persona3.setAntiguedad(antiguedad);
		persona3.setSalario(salario);
		
		System.out.println("Nombre=<"+ persona3.getNombre() + "> Nombre=<"+ persona3.getApellido() + "> Tipo=<" + persona3.getTipoempleado() + "> Antigüedad=<" + persona3.getAntiguedad() + "> Salario=<" +persona3.getSalario()+ ">");
		System.out.println("Aumento del salario a un 35%: " + persona3.AumentarSalario(35));
		System.out.println("--FIN DEL PROGRAMA--");
	}

}
