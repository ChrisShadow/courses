package AlquilerMoto;

import java.util.InputMismatchException;
import java.util.Scanner;


public class App {
	
	public static Scanner data = new Scanner(System.in);
	public static boolean banC=false;
	public static MotoCicleta regisMoto[];
	
	public static void main(String[] args) {
		
		MenuOperaciones();
		System.out.println("**FIN DEL PROGRAMA**");

	}
	
	private static void MenuOperaciones() {
		MotoCicleta regisMoto[]= new MotoCicleta[1];
		int opcion=2;
		do {
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println(regisMoto.length);
			System.out.println("1- Ingresar datos para la motocileta");
			System.out.println("2- Mostar Informe");
			System.out.println("3- Salir");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1: 
				CargarMoto(regisMoto);
				
				break;
			case 2:
				if(banC) {
					StringBuilder reporte=Reporte(regisMoto);
					System.out.println(reporte);
				}else {
					System.err.println("Debe ingresar los datos para la moto");
				}
				break;
			case 3:
				System.out.println("Finalizando menú...");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!=3);
		
	}

	private static void CargarMoto(MotoCicleta regisMoto[]) {
		for (int i = 0; i <= regisMoto.length-1; i++) {
			regisMoto[i]=IngresarDatosMoto();
		}
		banC=true;
	}

	public static MotoCicleta IngresarDatosMoto() {
		String marca="";
		int anho=0;
		String chasis="";
		int cantCilin=0;
		double montoAlq=0;
		String tipoMoto="";
		String descrp="";
		MotoCicleta motoC=null; 
		
		//Ingreso de la marca
		try {
			data.nextLine();
			System.out.println("Ingrese la marca: ");
			marca= data.nextLine();
			marca= marca.trim();
			marca=marca.toUpperCase();
			while(marca=="" || marca==" ") {
				System.err.println("Marca no admitida. Vuelva a intentar.");
				System.out.println("Ingrese la Marca: ");
				marca= data.nextLine();
				marca= marca.trim();
				marca=marca.toUpperCase();
			}	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		//Ingreso deL Año 
		do { 
			try {
				System.out.println("Ingrese el Año: ");
				anho= data.nextInt();
				
				if(anho<=1899) {
					System.err.println("Año no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(anho<=1899);						
		
		//Ingreso del Nro. Chasis
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el Nro. Chasis (9A_AAAA-99A9_9AAA): ");
				chasis= data.nextLine();
				chasis=chasis.toUpperCase();
				chasis=chasis.trim();
				
				if(!ValidarChasis(chasis)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(chasis.equals(null) || chasis.isEmpty() || chasis.isBlank() || !ValidarChasis(chasis));		
		
		//Ingreso del Cilindrada
		do {
			try {
				System.out.println("Ingrese la cantidad de cilindros(3-11): ");
				cantCilin= data.nextInt();
				
				if(cantCilin<=2 || cantCilin>=12) {
					System.err.println("Cantidad no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(cantCilin<=2 || cantCilin>=12);
		
		//Ingreso del Monto alquiler
		do {
			try {
				System.out.println("Ingrese el monto del alquiler: ");
				montoAlq= data.nextDouble();
				
				if(montoAlq<500000) {
					System.err.println("Monto no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(montoAlq<500000);
		
		
		//Ingreso del tipo de motocicleta
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el tipo de motocicleta(TIPO_E=eléctrica;TIPO_S=sport;TIPO_T=trail): ");
				tipoMoto = data.nextLine();
				if(!tipoMoto.equals("TIPO_E") && !tipoMoto.equals("TIPO_S") && !tipoMoto.equals("TIPO_T")) {
					System.err.println("Caracter incorrecto. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(tipoMoto.isEmpty() || tipoMoto.isBlank() || (!tipoMoto.equals("TIPO_E") && !tipoMoto.equals("TIPO_S") && !tipoMoto.equals("TIPO_T")));
		
		//Ingreso de la descripción 
		try {
			data.nextLine();
			System.out.println("Ingrese la descripción: ");
			descrp= data.nextLine();
			descrp= descrp.trim();
			descrp=descrp.toUpperCase();
			while(descrp=="" || descrp==" ") {
				System.err.println("Descripción no admitida. Vuelva a intentar.");
				System.out.println("Ingrese la Descripción: ");
				descrp= data.nextLine();
				descrp= descrp.trim();
				descrp=descrp.toUpperCase();
			}	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		//Reemplazar valores en la descripción
		
		descrp= descrp.replace("#", " ");
		descrp=descrp.replace("_", " ");
		descrp=descrp.replace("|", " ");
		descrp=descrp.toLowerCase();
		
		motoC= new MotoCicleta(marca,  anho,  chasis,  cantCilin,  montoAlq,  tipoMoto, descrp);
		return motoC;
	}
	
	
	public static StringBuilder Reporte(MotoCicleta regisMoto[]) {
		double acuMontos=0;
		StringBuilder report=null;
		report= new StringBuilder();
		report.append("\t \t \t___Moto S.A___ \n ").append("##################################################################################################").append("\nLinea			CHASIS		TIPO MOTO		MARCA		AÑO		MONTO ALQUILER		DESCRIPCIÓN\n "); 
		for (int i = 0; i <= regisMoto.length-1; i++) {
			report.append((i+1)).append(regisMoto[i].toString()+"\n\r");
			acuMontos+=regisMoto[i].getMontoAlq();
		}
		report.append("##################################################################################################\n").append("##################################################################################################\n");
		report.append("Monto total de los alquileres: "+acuMontos+"\nIVA 5%: " + acuMontos*0.05);
		
		return report;
	}

	public static boolean ValidarChasis(String chasis) {
		return chasis.matches("[0-9][A-Z]_[A-Z]+-[0-9]+[A-Z][0-9]_[0-9][A-Z]+");
	}
}
