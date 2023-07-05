package Famosos;

import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;


public class App {

	public static Scanner data = new Scanner(System.in);
	public static boolean banO=false;
	public static InfoFamosos fam[];
	//public static int anhoActual= new Date(2021,11,05).getYear();
	
	public static void main(String[] args) {
		fam=new InfoFamosos[10];
		
		//Prueba del pinche cálculo de la edad
		/*InfoFamosos inf = new InfoFamosos();
		inf.setFechaNac(20001001);
		inf.setedadc(anhoActual);
		System.out.println("\t2000\n-");
		System.out.println("\t"+anhoActual);
		System.out.println(inf.getedad());
		System.out.println(anhoActual);*/
		
		
		MenuOperaciones();
		System.out.println("**FIN DEL PROGRAMA**");
	}

	private static void MenuOperaciones() {
		
		char opcion=' ';
		do {
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println("a- Ingresar datos para el famoso");
			System.out.println("b- Mostrar información de los famosos");
			System.out.println("c- Salir");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextLine().toLowerCase().trim().charAt(0);
			switch (opcion) {
			case 'a': 
				fam=CargarFamosos();
				banO=true;
				break;
			case 'b':
				if(banO) {
					StringBuilder reporte=Reporte(fam);
					System.out.println(reporte);	
				}else {
					System.err.println("Debe ingresar los datos para el famoso");
				}
				break;
			case 'c':
				System.out.println("Finalizando menú...");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!='c');
	}

	//Opción b
	private static StringBuilder Reporte(InfoFamosos[] fam2) {
		StringBuilder report=null;
		report= new StringBuilder();
		
		report.append("-------------------DATOS GENERAL DEL FAMOSO------------------\n");
		for (int i = 0; i <= fam2.length-1; i++) {
			report.append(fam2[i].toString().concat("\n")).append("\t\tTipo: " + fam2[i].getTipoFam() + "\n");
			switch (fam2[i].getTipoFam()) {
			case 1:
				//Conductor de TV
				FamosoConductor famTV= (FamosoConductor) fam2[i];
				report.append("\tPeso: "+famTV.getPeso()+" kg\n\tInicio de su carrera: "+famTV.getAnhoIniCar()+"\n\tTipo de programa que conduce: "+famTV.getTipoProg()+"\n\tDistinciones recibida:\n");
				for (int j = 0; j <= famTV.getDist().length-1; j++) {
					report.append(famTV.getDist()[j].trim().concat(","));
				}
				report.append("\n");
				break;
			case 2:
				//Cantante
				FamosoCantante famCan= (FamosoCantante) fam2[i];
				report.append("\tGenero musical: "+famCan.getGenMus()+"\n\tCantidad de followers on Twitter: "+famCan.getCantTwitt()+"\n\tTop 4 de sus mejores álbumes:\n ");
				for (int z = 0; z <= famCan.getTopMejAlb().length-1; z++) {
					report.append("#"+(z+1)+": " + famCan.getTopMejAlb()[z].trim().concat("\n"));
				}
				report.append("\tInstrumentos que ejecuta: \n");
				for (int e = 0; e <= famCan.getCantInst().length-1; e++) {
					report.append(famCan.getCantInst()[e].trim().concat(","));
				}
				report.append("\n");
				break;
			default:
				//Actor
				FamosoActor famAct= (FamosoActor) fam2[i];
				report.append("\tAltura: "+famAct.getAltura()+" cm\n\tComida favorita: "+famAct.getTipoCom()+"\n\tTop 5 de sus mejores películas:\n ");
				for (int d = 0; d <= famAct.getTopMejPeli().length-1; d++) {
					report.append("#"+(d+1)+": " + famAct.getTopMejPeli()[d].trim().concat("\n"));
				}
				report.append("\tTop 3 de sus mejores nominaciones: \n");
				for (int r = 0; r <= famAct.getTopMejNomi().length-1; r++) {
					report.append("#"+(r+1)+": " + famAct.getTopMejNomi()[r].trim().concat("\n"));
				}
				break;
			}
		}
		
		return report;
	}

	//Opción a
	private static InfoFamosos[] CargarFamosos() {
		InfoFamosos[] fama= new InfoFamosos[10];
		
		//Recorrido y carga
		for (int i = 0; i <= fama.length-1; i++) {
			fama[i]=TraerDatosFamoso();
		}
		
		
		return fama;
		
	}

	//Carga de datos
	private static InfoFamosos TraerDatosFamoso() {
		//Año actual
		int anhoActual= new Date(2021,11,05).getYear();
		//Bandera Excepción
		boolean banEx=false;
		//Superclase
		String nombreApellido="";
		String sexo="";
		int fechaNac=0;
		String keyFamoso="";
		int tipoFam=0;
		InfoFamosos famous=null;
		
		/*Superclase
		Carga del Nombre y apellido*/
		try {
			data.nextLine();
			System.out.println("Ingrese el nombre completo del famoso: ");
			nombreApellido= data.nextLine();
			nombreApellido= nombreApellido.trim();
			while(nombreApellido.isEmpty()) { //null o " "
				System.err.println("Datos no admitidos.Vuelva a intentar.");
				System.out.println("Ingrese el nombre completo del famoso: ");
				nombreApellido= data.nextLine();
				nombreApellido= nombreApellido.trim();
			}	
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}		
		//Evaluar y eliminar caracteres especiales -@#”
		if (nombreApellido.indexOf("-")>-1) {
			nombreApellido=nombreApellido.replaceAll("-", " ");
		}
		if (nombreApellido.indexOf("@")>-1) {
			nombreApellido=nombreApellido.replaceAll("@", " ");
		}
		if (nombreApellido.indexOf("#")>-1) {
			nombreApellido=nombreApellido.replaceAll("#", " ");
		}
		
		
		//Ingreso del sexo
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
		
		
		//Ingreso de la fecha de nacimiento
		do { 
			try {
				System.out.println("Ingrese la fecha de nacimiento(AAAAMMDD): ");
				fechaNac= data.nextInt();
				
				if(fechaNac<10000000 || fechaNac>99999999) {
					System.err.println("Formato no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(fechaNac<10000000 || fechaNac>99999999);	
		
		//Ingreso del ID
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese un identificador al famoso(xX99_x9x99): ");
				keyFamoso= data.nextLine();
				keyFamoso=keyFamoso.trim();
				
				if(!ValidarKeyFamoso(keyFamoso)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(keyFamoso.equals(null) || keyFamoso.isEmpty() || keyFamoso.isBlank() || !ValidarKeyFamoso(keyFamoso));
		
		//Ingreso del tipo famoso
		do {
			try {
				System.out.println("Ingrese el tipo del famoso(1:Conductor de TV;2:Cantante;3: Actor): ");
				tipoFam = data.nextInt();
				if(tipoFam<=0 || tipoFam>=4) {
					System.err.println("Opción inválida. Vuelva a intentar");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(tipoFam<=0 || tipoFam>=4);
		
		
		//Evaluar el tipo del famoso
		switch(tipoFam) {
		case 1:
			System.out.println("Ingrese los datos para el Conductor de TV:\n" );
			//CASTEO
			do {
				try {
					famous=(InfoFamosos)CargarConductor(nombreApellido, sexo,  fechaNac,  keyFamoso,  tipoFam, anhoActual);
					banEx=false;
				} catch (ExceptionFamous e) {
					System.err.println(e.getMessage());
					banEx=true;
				}
			} while (banEx);
			
			break;
		case 2:
			System.out.println("Ingrese los datos para el Cantante:\n" );
			//CASTEO
			do {
				try {
					famous=(InfoFamosos)CargarCantante(nombreApellido, sexo,  fechaNac,  keyFamoso,  tipoFam);
					banEx=false;
				} catch (ExceptionFamous e) {
					System.err.println(e.getMessage());
					banEx=true;
				}
			} while (banEx);
			
			break;
		default:
			System.out.println("Ingrese los datos para el Actor:\n" );
			//CASTEO
			do {
				try {
					famous=(InfoFamosos)CargarActor(nombreApellido, sexo,  fechaNac,  keyFamoso,  tipoFam);
					banEx=false;
				} catch (ExceptionFamous e) {
					System.err.println(e.getMessage());
					banEx=true;
				}
			} while (banEx);
			
			break;
		}
		
		//Cargar de la edad
		famous.setedad(anhoActual);
		
		return famous;
	}
	
	private static FamosoActor CargarActor(String nombreApellido, String sexo, int fechaNac, String keyFamoso,
			int tipoFam) throws ExceptionFamous {
		//Actor
		double altura=0;
		String tipoCom="";
		String topMejPeli="";
		String topMejNomi="";		
		
		//Ingreso de la altura
		do {
			try {
				System.out.println("Ingrese la altura del Actor en cm: ");
				altura = data.nextDouble();
				if(altura<=0) {
					System.err.println("Cifra inválida. Vuelva a intentar");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(altura<=0);
		
		//Ingreso del tipo de comida
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el tipo comida favorita del Actor(mexicana, italiana, china, española): ");
				tipoCom = data.nextLine();
				tipoCom=tipoCom.toLowerCase();
				if(!tipoCom.equals("mexicana") && !tipoCom.equals("italiana")  && !tipoCom.equals("china") && !tipoCom.equals("española")) {
					System.err.println("Opción inválida. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(tipoCom.isEmpty() || tipoCom.isBlank() || (!tipoCom.equals("mexicana") && !tipoCom.equals("italiana")  && !tipoCom.equals("china") && !tipoCom.equals("española")));
		
		//Ingreso del top 5 de sus mejores películas
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el top 5 de sus mejores películas(separadas por coma): ");
				topMejPeli = data.nextLine();
				topMejPeli=topMejPeli.toLowerCase();
				if(topMejPeli.isEmpty()) {
					System.err.println("Debe ingresar algún comentario. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(topMejPeli.isEmpty() || topMejPeli.isBlank());
		
		//Ingreso del top 3 de sus mejores nominaciones.
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el top 3 de sus mejores nominaciones(separados por coma): ");
				topMejNomi = data.nextLine();
				topMejNomi=topMejNomi.toLowerCase();
				if(topMejNomi.isEmpty()) {
					System.err.println("Debe ingresar algún comentario. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(topMejNomi.isEmpty() || topMejNomi.isBlank());
		
		
		//Excepción Altura
		if (altura>230) {
			throw new ExceptionFamous("La altura del actor no cumple con la política de la empresa.");
		}
		
		return new FamosoActor(nombreApellido, sexo.charAt(0), fechaNac, keyFamoso, tipoFam,altura,tipoCom,topMejPeli,topMejNomi);
	}

	//Caso Famoso Cantante
	private static FamosoCantante CargarCantante(String nombreApellido, String sexo, int fechaNac, String keyFamoso,
			int tipoFam) throws ExceptionFamous {
		//Cantante
		String genMus="";
		int cantTwitt=0;
		String topMejAlb="";
		String cantInst="";
		
		//Ingreso del género musical
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el género musical(pop, rock,dance, jazz): ");
				genMus = data.nextLine();
				genMus=genMus.toLowerCase();
				genMus=genMus.trim();
				if(!genMus.equals("pop") && !genMus.equals("rock")  && !genMus.equals("dance") && !genMus.equals("jazz")) {
					System.err.println("Opción inválida. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(genMus.isEmpty() || genMus.isBlank() || (!genMus.equals("pop") && !genMus.equals("rock")  && !genMus.equals("dance") && !genMus.equals("jazz")));
		
		//Ingreso de la cantidad seguidores en twitter
		do {
			try {
				System.out.println("Ingrese la cantidad seguidores en twitter: ");
				cantTwitt = data.nextInt();
				if(cantTwitt<=0) {
					System.err.println("Cifra inválida. Vuelva a intentar");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(cantTwitt<=0);
		
		//Ingreso del top 4 de sus mejores álbumes
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el top 4 de sus mejores álbumes(separados por coma): ");
				topMejAlb = data.nextLine();
				topMejAlb=topMejAlb.toLowerCase();
				if(topMejAlb.isEmpty()) {
					System.err.println("Debe ingresar algún comentario. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(topMejAlb.isEmpty() || topMejAlb.isBlank());
		
		//Ingreso de los instrumentos
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese los instrumentos que ejecuta(separados por coma): ");
				cantInst = data.nextLine();
				cantInst=cantInst.toLowerCase();
				if(cantInst.isEmpty()) {
					System.err.println("Debe ingresar algún comentario. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(cantInst.isEmpty() || cantInst.isBlank());
		
		//Excepción Twitter y Rock
		if (cantTwitt<100000 && genMus.equals("rock")) {
			 throw new ExceptionFamous("La cantidad de seguidores en Twitter del género rock no cumple con la política de la empresa.");
		}
		
		return new FamosoCantante(nombreApellido, sexo.charAt(0), fechaNac, keyFamoso, tipoFam,genMus,cantTwitt,topMejAlb,cantInst);
	}

	//Caso Famoso Conductor TV
	private static FamosoConductor CargarConductor(String nombreApellido, String sexo, int fechaNac, String keyFamoso,
			int tipoFam , int anhoActual) throws ExceptionFamous {
		//Conductor
		double peso=0;
		int anhoIniCar=0;
		String tipoProg="";
		String dist="";
		int anhoCarr=((fechaNac/10000)-((fechaNac%10000)/10000)); //Año de anacimito recibido como parámetro de la superclase
		
		
		
		//Ingreso del peso
		do {
			try {
				System.out.println("Ingrese el peso del conductor en Kg: ");
				peso = data.nextDouble();
				if(peso<=0) {
					System.err.println("Cifra inválida. Vuelva a intentar");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(peso<=0);
		
		//Ingreso del año en el que inició su carrea
		do {
			try {
				System.out.println("Ingrese el año en el que se inició  como conductor de TV profesionalmente: ");
				anhoIniCar = data.nextInt();
				if(anhoIniCar<=anhoCarr || anhoIniCar>=anhoActual) { //anhoActual
					System.err.println("Año inválido. Vuelva a intentar");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(anhoIniCar<=anhoCarr || anhoIniCar>=anhoActual);
		
		//Ingreso del tipo de programa
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el tipo del programa(concurso,debate,educativo): ");
				tipoProg = data.nextLine();
				tipoProg=tipoProg.toLowerCase();
				if(!tipoProg.equals("concurso") && !tipoProg.equals("debate")  && !tipoProg.equals("educativo")) {
					System.err.println("Opción inválida. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(tipoProg.isEmpty() || tipoProg.isBlank() || (!tipoProg.equals("concurso") && !tipoProg.equals("debate")  && !tipoProg.equals("educativo")));
		
		//Ingreso de las distinciones
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese las distinciones que ha recibido como profesional(separadas por coma): ");
				dist = data.nextLine();
				dist=dist.toLowerCase();
				if(dist.isEmpty()) {
					System.err.println("Debe ingresar algún comentario. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(dist.isEmpty() || dist.isBlank());
		
		
		//Excepción Peso
		if (peso <30 || peso>130) {
			throw new ExceptionFamous("El peso del conductor no cumple con la política de la empresa.");
		}
		
		return new FamosoConductor(nombreApellido, sexo.charAt(0), fechaNac, keyFamoso, tipoFam, peso, anhoIniCar, tipoProg, dist);
	}

	//Expresión regular para el Key
	public static boolean ValidarKeyFamoso(String keyFamoso) {
		return keyFamoso.matches("[a-z][A-Z][0-9]+_[a-z][0-9][a-z][0-9]+");
	}
}
