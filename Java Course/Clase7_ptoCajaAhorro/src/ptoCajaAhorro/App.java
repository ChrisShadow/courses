package ptoCajaAhorro;


import java.util.Scanner;

public class App {
	
	public static Scanner data = new Scanner(System.in);
	
	static double montoTotal; 
	static double tasa; 
	static int categoria;
	static String mercado;
	static int anhoApertura;
	static int mesAper;
	static int plazo;
	static int salario;
	static String catCli;
	
	public static void main(String[] args) {
		System.out.println("INGRESO DE DATOS DE LA CAJA DE AHORRO");
		
		try {
		//Objeto Cuenta Corriente
		CajaAhorro ctaAhr= new CajaAhorro();
		
		//Entrada del menú de operaciones
		MenuOperaciones(ctaAhr);
		}catch (NullPointerException ex) {
			System.err.println(ex.getMessage());
		}
	}

	private static void MenuOperaciones(CajaAhorro ctaAhr) {
		int opcion=3;
		do {
			System.out.println("\n\nEscoga la operación a realizar de la cuenta de ahorro");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println();
			System.out.println("1- Cargar datos de la Caja de Ahorro");
			System.out.println("2- Mostrar información del Cliente/Caja de Ahorro");
			System.out.println("3- Salir del menu");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1: 
				CrearCuenta(ctaAhr);
				break;
			case 2:
				MostarInfoCuenta(ctaAhr);
				break;
			case 3:
				System.out.println("FIN DEL PROGRAMA");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!=3);
	}

	private static void MostarInfoCuenta(CajaAhorro ctaAhr) {
		//Control del objeto
		if(ctaAhr.equals(null)==true) {
			System.out.println("No es posible mostrar datos de la Caja de ahorro. Intente de vuelta medainte opción 1 en el menú");
		}else {
			//Ingreso del plazo
			do {
				System.out.println("Ingrese el salario: ");
				salario= data.nextInt();
				if(salario <=499999) {
					System.err.println("Error en el monto. Vuelva a intentar");
				}
			}while(salario <=499999);
			
			//Generar los valores para el ingreso y monto interes
			double is = ctaAhr.ObtnerIngresoNeto(salario);
			double sn= ctaAhr.ObtenerMontoInteres(salario);
			
			System.out.println(ctaAhr.toString()); 
			System.out.println("El ingreso neto es: "+ is +"\nMonto interés es: "+ sn);
		}
	}

	private static void CrearCuenta(CajaAhorro ctaAhr)  {
		
		//Ingreso del monto total montoTotal
		System.out.println("Ingrese el monto total(>=45000000 y <=105000000): ");
		montoTotal= data.nextDouble();
		while(montoTotal <=45000000 || montoTotal >=105000000) {
			System.err.println("Monto no admitido. Vuelva a intentar.");
			System.out.println("Ingrese el monto total(>=45000000 y <=105000000): ");
			montoTotal= data.nextDouble();
		}
		
		//Ingreso de la tasa
		System.out.println("Ingrese la tasa(>=1.11 y <=4.87): ");
		tasa= data.nextDouble();
		while(tasa <=1.11  || tasa >=4.87) {
			System.err.println("Tasa no admitida. Vuelva a intentar.");
			System.out.println("Ingrese la tasa(>=1.11 y <=4.87): ");
			tasa= data.nextDouble();
		}
		
		//Ingreso de la categoría del ahorro
		do {
			System.out.println("Ingrese la categoría del ahorro(101=Personal;102=Pymes): ");
			categoria = data.nextInt();
			if(categoria!=101 && categoria!=102) {
				System.err.println("Cifra incorrecta. Vuelva a intentar");
			}
		}while(categoria!=101 && categoria!=102); 
		
		
		//	Ingreso de marcado
		do {
			System.out.println("Ingrese el tipo de mercado(A=Público;B=Privado;C=Particular): ");
			mercado = data.nextLine();
			mercado.toUpperCase();
			if(!mercado.equals("A") && !mercado.equals("B") && !mercado.equals("C")) {
				System.err.println("Caracter incorrecto. Vuelva a intentar");
			}
		}while(!mercado.equals("A") && !mercado.equals("B") && !mercado.equals("C")); 
		
		//Ingreso de categoría de cliente
		do {
			System.out.println("Ingrese la categorías del cliente (A=Asalariado;I=Independiente): ");
			catCli = data.nextLine();
			catCli.toUpperCase();
			if(!catCli.equals("A") && !catCli.equals("I")) {
				System.err.println("Caracter incorrecto. Vuelva a intentar");
			}
		}while(!catCli.equals("A") && !catCli.equals("I")); 
		
		//Ingreso de Año de apetura
		do {
			System.out.println("Ingrese el año de apertura: ");
			anhoApertura= data.nextInt();
			if(anhoApertura <1950 && anhoApertura>2021) {
				System.err.println("Error en el año. Vuelva a intentar");
			}
		}while(anhoApertura <1950 || anhoApertura>2021);
		
		//Ingreso del mes mesAper
		System.out.println("Ingrese el mes de apertura(1 al 12): ");
		mesAper= data.nextInt();
		while(mesAper <=0  || mesAper >=13) {
			System.err.println("Mes inexistente. Vuelva a intentar.");
			System.out.println("Ingrese el mes de apertura(1 al 12): ");
			mesAper= data.nextInt();
		}
		
		//Ingreso del plazo
				do {
					System.out.println("Ingrese el plazo: ");
					plazo= data.nextInt();
					if(plazo <=0) {
						System.err.println("Error en el plazo. Vuelva a intentar");
					}
				}while(plazo <=0);
		
		//Asignación de valores al objeto
		//ctaAhr = new CajaAhorro();
		ctaAhr.setAnhoApertura(anhoApertura);
		ctaAhr.setMesApertura(mesAper);
		ctaAhr.setMontoTotal(montoTotal);
		ctaAhr.setTasa(tasa);
		ctaAhr.setPlazo(plazo);
		ctaAhr.setCatAhorro(categoria);
		ctaAhr.setCatCliente(catCli.charAt(0));
		ctaAhr.setMercado(mercado.charAt(0));
	}

}
