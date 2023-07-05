package AlquilerBici;

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
	
	public static Scanner data = new Scanner(System.in);
	public static boolean banC=false;
	public static boolean banB=false;
	public static boolean banA=false;
	public static Bici regisBici[];
	public static Cliente cli;
	
	//"Atributos" alquiler
	public static double suamatoriaTotal;
	public static int cantDias;
	public static String mesDiaAlquiler;
	public static double impIVA;
	public static double senha;
	

	public static void main(String[] args) {
		
		MenuOperaciones();
		System.out.println("**FIN DEL PROGRAMA**");
		
		

	}

	private static void MenuOperaciones() {
		int opcion=3;
		do {
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println("1- Ingresar datos para el cliente");
			System.out.println("2- Ingresar datos para la bicicleta");
			System.out.println("3- Ingresar datos para el alquiler y mostrar la constancia ");
			System.out.println("4- Salir del menú");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1: 
				cli=CargarCliente();
				banC=true;
				break;
			case 2:
				if(banC) {
					//CargarBici(regisBici);
					System.out.println("Digite 3 para carga los datos de la bici y alquiler");
					banB=true;	
				}else {
					System.err.println("Debe ingresar los datos para el cliente");
				}
				break;
			case 3:
				if( banC && banB ) {
					CargarAlquiler(regisBici);
					banA=true;
				}else {
					System.err.println("Debe ingresar los datos para el cliente y para la bicileta");
				}
				break;
			/*case 4:
				if(banC && banB && banA) {
					StringBuilder reporte=Reporte(cli,regisBici,cantDias,mesDiaAlquiler,senha);
					System.out.println(reporte);
				}else {
					System.err.println("Debe ingresar los datos para el cliente , la bicicleta y el alquiler");
				}
				break;*/
			case 4:
				System.out.println("Finalizando menú...");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!=4);
	}
	
	//Opción 3
	private static void CargarAlquiler(Bici regisBici[]) {
		double acuMontos=0;
		try {
			if(banB) {
				//Obtenemos la dimensión del vector Bici
				int tamanho=0;
				do { 
					try {
						System.out.println("Ingrese la cantidad de bicicleta alquilada: ");
						tamanho= data.nextInt();
						
						if(tamanho<=0) {
							System.err.println("Cantidad no admitida. Vuelva a intentar.");
						}
					} catch (InputMismatchException e) {
						System.err.println("El valor ingresado no es númerico");
					}
					data.nextLine();
				}while(tamanho<=0);	
				
				//Asignamos dimesión
				regisBici=new Bici[tamanho];
				for (int i = 0; i < tamanho; i++) {
					regisBici[i]=ObtenerBici();
				}
			}
			//Recorremos previamente para calcular el monto total de los alquileres antes de ingresar seña
			for (int i = 0; i < regisBici.length; i++) {
				System.out.println("Monto de alquiler de la bici N° (" + (i+1) +"):  " + regisBici[i].getMontoAlq());
				acuMontos+=regisBici[i].getMontoAlq();
			}
			
			//Ingreso del día/mes del alquiler(0-31/Enero-Diciembre) 
			do {
				try {
					data.nextLine();
					System.out.println("Ingrese el día/mes del alquiler(0-31/Enero-Diciembre): ");
					mesDiaAlquiler= data.nextLine();
					mesDiaAlquiler=mesDiaAlquiler.trim();
					
					if(!ValidarDiaMesAlquiler(mesDiaAlquiler)) {
						System.err.println("Formato inválido. Vuelva a ingresar");
					}
					
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}while(mesDiaAlquiler.equals(null) || mesDiaAlquiler.isEmpty() || mesDiaAlquiler.isBlank() || !ValidarDiaMesAlquiler(mesDiaAlquiler));
			
			//Ingreso de la cantidad de días del alquiler
			do { 
				try {
					System.out.println("Ingrese la cantidad de días del alquiler: ");
					cantDias= data.nextInt();
					
					if(cantDias<=0) {
						System.err.println("Cantidad no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(cantDias<=0);		
			
			//Ingreso del importe abonado como adelanto
			do { 
				try {
					System.out.println("Ingrese la seña a abonar: ");
					senha= data.nextDouble();
					
					if(senha<(acuMontos*0.55)) {
						System.err.println("Cantidad ingresada no admitida, al menos el 55% de ("+acuMontos +"). Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(senha<(acuMontos*0.55));	
			
			//Sería como opción 4 , constancia del alquiler
			StringBuilder reporte=Reporte(cli,regisBici,cantDias,mesDiaAlquiler,senha);
			System.out.println(reporte);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
	}

	/*private static void CargarBici(Bici regisBici[]) {
		//Obtenemos la dimensión del vector Bici
		int tamanho=0;
		do { 
			try {
				System.out.println("Ingrese la cantidad de bicicleta alquilada: ");
				tamanho= data.nextInt();
				
				if(tamanho<=0) {
					System.err.println("Cantidad no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(tamanho<=0);	
		
		//Asignamos dimesión
		regisBici=new Bici[tamanho];
		for (int i = 0; i < tamanho; i++) {
			regisBici[i]=ObtenerBici();
		}
		
	}*/

	//Opción 2
	private static Bici ObtenerBici() {
		String marca="";
		int anho=0;
		String serie="";
		int nroAro=0;
		double montoAlq=0;
		int tipo=0;
		//Paseo
		int altura=0;
		String tipoManubrio="";
		String tipoCadena="";
		//Montaña
		double anchura=0;
		String resistencia="";
		//Carrera
		double peso=0;
		int cantMaxRevo=0;
		double cantKm=0;
		
		//SuperClase
		Bici bic=null;
		//Ingreso de la marca
		try {
			data.nextLine();
			System.out.println("Ingrese la marca de la bici: ");
			marca= data.nextLine();
			marca= marca.trim();
			while(marca=="" || marca==" ") {
				System.err.println("Marca no admitido. Vuelva a intentar.");
				System.out.println("Ingrese la marca de la bici: ");
				marca= data.nextLine();
				marca= marca.trim();
			}	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}		
		
		//Ingreso del año
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
		
		//Ingreso de la serie
		try {
			data.nextLine();
			System.out.println("Ingrese el nro de Serie: ");
			serie= data.nextLine();
			serie= serie.trim();
			while(serie=="" || serie==" ") {
				System.err.println("Nro. de serie no admitido. Vuelva a intentar.");
				System.out.println("Ingrese el nro de Serie: ");
				serie= data.nextLine();
				serie= serie.trim();
			}	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}		
		
		//Ingreso del Nro. de aro
		do { 
			try {
				System.out.println("Ingrese el Nro. de aro: ");
				nroAro= data.nextInt();
				
				if(nroAro<=0) {
					System.err.println("Nro. de aro no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(nroAro<=0);	
		
		//Ingreso del monto de alquiler
		do { 
			try {
				System.out.println("Ingrese el monto de alquiler: ");
				montoAlq= data.nextDouble();
				
				if(montoAlq<50000) {
					System.err.println("Monto no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(montoAlq<50000);	
		
		
		//Ingreso del tipo de bici
		do { 
			try {
				System.out.println("Ingrese el tipo de bici(1=paseo;2=montaña;3=carrera): ");
				tipo= data.nextInt();
				
				if(tipo<1 || tipo>3) {
					System.err.println("Tipo de bici no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(tipo<1 || tipo>3);	
		
		
		//Evaluar el tipo bici para el ingreso 
		if(tipo==1) {
			System.out.println("Ingrese los datos para la bici de paseo" );
			//Ingreso de la altura
			do { 
				try {
					System.out.println("Ingrese la altura de la bici(>15mm): ");
					altura= data.nextInt();
					
					if(altura<16) {
						System.err.println("Altura de la bici no admitido. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(altura<16);	
			
			//Ingreso del tipo del manubrio
			try {
				data.nextLine();
				System.out.println("Ingrese el tipo del manubrio: ");
				tipoManubrio= data.nextLine();
				tipoManubrio= tipoManubrio.trim();
				while(tipoManubrio=="" || tipoManubrio==" ") {
					System.err.println("Tipo del manubrio no admitido. Vuelva a intentar.");
					System.out.println("Ingrese el tipo del manubrio: ");
					tipoManubrio= data.nextLine();
					tipoManubrio= tipoManubrio.trim();
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}	
			
			//Ingreso del tipo de cadena
			try {
				data.nextLine();
				System.out.println("Ingrese el tipo de cadena: ");
				tipoCadena= data.nextLine();
				tipoCadena= tipoCadena.trim();
				while(tipoCadena=="" || tipoCadena==" ") {
					System.err.println("Tipo de cadena no admitido. Vuelva a intentar.");
					System.out.println("Ingrese el tipo de cadena: ");
					tipoCadena= data.nextLine();
					tipoCadena= tipoCadena.trim();
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}	
			
		}else if(tipo==2) {
			System.out.println("Ingrese los datos para la bici de montaña" );
			
			//Ingreso del ancho de la bici
			do { 
				try {
					System.out.println("Ingrese el ancho de la bici: ");
					anchura= data.nextDouble();
					
					if(anchura<=0) {
						System.err.println("Anchura de la bici no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(anchura<=0);	
			
			//Ingreso de la clasificaciónd de la resistencia
			do {
				try {
					data.nextLine();
					System.out.println("Ingrese la clasificaciónd de la resistencia(A;AA;AAA): ");
					resistencia = data.nextLine();
					resistencia=resistencia.toUpperCase();
					if(!resistencia.equals("A") && !resistencia.equals("AA") && !resistencia.equals("AAA")) {
						System.err.println("Caracter incorrecto. Vuelva a intentar");
					}
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}while(resistencia.isEmpty() || resistencia.isBlank() || (!resistencia.equals("A") && !resistencia.equals("AA") && !resistencia.equals("AAA")));
			
			
		}else {
			System.out.println("Ingrese los datos para la bici de carrera" );
			//Ingreso del peso  de la bicileta
			do { 
				try {
					System.out.println("Ingrese peso  de la bicileta: ");
					peso= data.nextDouble();
					
					if(peso<=0) {
						System.err.println("Peso de la bici no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(peso<=0);	
			
			//Ingreso de la cantidad máxima de revoluciones
			do { 
				try {
					System.out.println("Ingrese la cantidad máxima de revoluciones: ");
					cantMaxRevo= data.nextInt();
					
					if(cantMaxRevo<350) {
						System.err.println("Cantidad máxima de revoluciones no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(cantMaxRevo<350);	
			
			//Ingreso de la cantidad de Km
			do { 
				try {
					System.out.println("Ingrese la cantidad de Km: ");
					cantKm= data.nextDouble();
					
					if(cantKm<=0) {
						System.err.println("Cantidad de km no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(cantKm<=0);	
			
		}
		
		//Evaluar el tipo bici para el retorno de datos
		switch(tipo) {
		case 1:
			BiciPaseo bicP = new BiciPaseo(marca,anho,serie,nroAro,montoAlq,tipo,altura,tipoManubrio,tipoCadena);
			bic=(Bici) bicP;
			break;
		case 2:
			BiciMontanha bicM = new BiciMontanha(marca,anho,serie,nroAro,montoAlq,tipo,anchura,resistencia);
			bic=(Bici) bicM;
			break;
		default:
			BiciCarrera bicC = new BiciCarrera(marca,anho,serie,nroAro,montoAlq,tipo,peso,cantMaxRevo,cantKm);
			bic=(Bici) bicC;
			break;
		}
		
		return bic;
	}

	//Opción 1
	private static Cliente CargarCliente() {
		String nombre="";
		String apellido="";
		String tipoDoc="";
		int nroDoc=0;
		String email="";
		Cliente c=null;
		
		//Ingreso del nombre
		try {
			data.nextLine();
			System.out.println("Ingrese el nombre del Cliente: ");
			nombre= data.nextLine();
			nombre= nombre.trim();
			while(nombre=="" || nombre==" ") {
				System.err.println("Nombre no admitido. Vuelva a intentar.");
				System.out.println("Ingrese el nombre del Cliente: ");
				nombre= data.nextLine();
				nombre= nombre.trim();
			}	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}		
		
		//Ingreso del apellido
		try {
			data.nextLine();
			System.out.println("Ingrese el apellido del Cliente: ");
			apellido= data.nextLine();
			apellido=  apellido.trim();
			while(apellido=="" || apellido==" ") {
				System.err.println("Apellido no admitido. Vuelva a intentar.");
				System.out.println("Ingrese el apellido del Cliente: ");
				apellido= data.nextLine();
				apellido= apellido.trim();
			}	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		//Ingreso del Tipo de documento
		try {
			data.nextLine();
			System.out.println("Ingrese el Tipo de documento: ");
			tipoDoc= data.nextLine();
			tipoDoc= tipoDoc.trim();
			while(tipoDoc.isBlank() || tipoDoc.isEmpty()) {
				System.err.println("Tipo de documento no admitido. Vuelva a intentar.");
				System.out.println("Ingrese el Tipo de documento: ");
				tipoDoc= data.nextLine();
				tipoDoc= tipoDoc.trim();
			}	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}		
		
		//Ingreso del nro de documento
		do { 
			try {
				System.out.println("Ingrese el nro de documento: ");
				nroDoc= data.nextInt();
				
				if(nroDoc<100000 || nroDoc>9999999) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(nroDoc<100000 || nroDoc>10000000);
		
		//Ingreso del correo electrónico
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el correo electrónico(aaa..@aaa....aaa): ");
				email= data.nextLine();
				email=email.trim();
				
				if(!ValidarCorreo(email)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(email.equals(null) || email.isEmpty() || email.isBlank() || !ValidarCorreo(email));
		
		
		//Instanciar el objeto
		
		c=new Cliente(nombre, apellido, tipoDoc, nroDoc, email);
		return c;
	}
	
	//Constanacia del alquiler
	public static StringBuilder Reporte(Cliente cli,Bici regisBici[],int cantDias,String mesDiaAlquiler,double senha) {
		String cabecera="Detalle del alquiler\nTipo Bicicleta\t\tMarca\t\tAño\t\tSerie\n";
		double acuMontos=0;
		
		StringBuilder report=null;
		report= new StringBuilder();
		report.append("\t \t \t\t################ Bicycle S.A ################\n ").append(cli.toString()).append("\n"+cabecera);
		for (int i = 0; i <= regisBici.length-1; i++) {
			report.append(regisBici[i].toString()+"\r");
			acuMontos+=regisBici[i].getMontoAlq();
		}
		suamatoriaTotal=acuMontos*cantDias;
		impIVA=suamatoriaTotal*0.05;
		report.append("--- Facturación del alquiler ---\nDía/Mes alquiler: "+mesDiaAlquiler+"\nCantidad de dias: "+ cantDias+"\nImporte total: "+ suamatoriaTotal + "\nImporte total IVA: " + impIVA + "\nImporte abonado: "+ senha+"\nImporte restante: "+ (suamatoriaTotal-senha));
		return report;
	}
	
	
	public static boolean ValidarDiaMesAlquiler(String mesDiaAlquiler) {
		return mesDiaAlquiler.matches("[0-9]+/[A-Z][a-z]+");
	}
	
	
	public static boolean ValidarCorreo(String email) {
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}
}
