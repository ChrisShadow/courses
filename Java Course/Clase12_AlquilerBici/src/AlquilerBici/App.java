package AlquilerBici;

import Cliente.*;
import Bicicleta.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static Scanner data = new Scanner(System.in);
	//Banderas para menú
	public static boolean banC=false;
	public static boolean banA=false;
	
	//subclases de cliente
	public static Extranjero ex ;	
	public static Nativo nat;
	public static final TipoDocumento CI= TipoDocumento.CI;
	public static final TipoDocumento PAS = TipoDocumento.PAS;
	
	//subclases de bicicleta
		//Hermanos
	public static Carrera car;
	public static Montanha mon;
		//subclases de Paseo
	public static char tipoPas;
	public static Ninhos children;
	public static Adulto adults;
	
	// Alquiler
	public static Alquiler alq;
	
	
	public static void main(String[] args) {
		
		MenuOperaciones();
		System.out.println("**FIN DEL PROGRAMA**");
		
	}

	private static void MenuOperaciones() {
		Cliente cli=null;
		int opcion=0;
		do {
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println("1- Ingresar datos para el cliente");
			System.out.println("2- Ingresar datos para el alquiler y para la bicicleta");
			System.out.println("3- Mostrar datos de la constancia del alquiler");
			System.out.println("4- Salir del menú");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1: 
				//Cargar superclase para luego las subclases
				cli=CargarCliente();
				if(cli.getTipoDoc()==CI) {
					nat=CargarClienteNacional(cli);
				}else{
					ex=CargarClienteExtranjero(cli);
				}
				banC=true;
				break;
			case 2:
				if(banC) {
					//Instanciar el objeto Alquiler
					alq= new Alquiler();
					//Cargar  Bici
					alq.setAlqui(CargarBiciletas());
					//Cargar Alquiler
					alq.setFechaAlq(CargarFecha("fa"));
					alq.setFechaDev(CargarFecha("fd"));
					alq.CalcularImporteAlquiler();
					System.out.println("El monto total del importe es: " + alq.getImporte() + "\nEl IVA correspondiente es: "+alq.getIVA());
					banA=true;	
				}else {
					System.err.println("Debe ingresar los datos para el cliente");
				}
				break;
			case 3:
				if( banC && banA ) {
					Cliente cl;
					if(!ex.equals(null)) {
						cl= ex;
					}else {
						cl=nat;
					}
					StringBuilder reporte=Reporte(cl,alq);
					System.out.println(reporte);
				}else {
					System.err.println("Debe ingresar los datos para el cliente y para el alquiler de la bicileta");
				}
				break;
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
	private static StringBuilder Reporte(Cliente cli, Alquiler alq2) {
		String cabecera="--------Detalle del alquiler--------\nTipo Bicicleta\t\tMarca\t\tModelo\t\tSerie\t\tDatos adicionales\n";
		String lineafactura="";
		StringBuilder report=null;
		report= new StringBuilder();
		//Evaluación para el casteo
		if (cli.getTipoDoc().equals(CI)) {
			nat=(Nativo) cli;
			report.append("\t \t \t \t############Bicycle S.A############\n").append(nat.toString()).append("\n"+cabecera);
			
		}else {
			ex=(Extranjero) cli;
			report.append("\t \t \t \t############Bicycle S.A############\n").append(ex.toString()).append("\n"+cabecera);
		}
		for (int i = 0; i < alq2.getAlqui().length; i++) {
			if (alq2.getAlqui()[i].getTipo().equals("MON")) {
				mon=(Montanha) alq2.getAlqui()[i];
				lineafactura+=mon.getTipo()+"\t\t"+mon.getMarca()+"\t\t"+mon.getSerie()+"\t\t("+mon.getMaterialPed()+","+mon.getTipoSusp()+","+mon.getPeso()+").\n";
			}else if(alq2.getAlqui()[i].getTipo().equals("CAR")) {
				car=(Carrera) alq2.getAlqui()[i];
				lineafactura+=car.getTipo()+"\t\t"+car.getMarca()+"\t\t"+car.getSerie()+"\t\t("+car.getCantVeloc()+","+car.getTipoFre()+","+car.getMaterBic()+").\n";
			}else {
				//String t=(Paseo) alq2.getAlqui()[i],getTipoPaseo();
				//Paseo Adulto
				if (alq2.getAlqui()[i].getTipo().equals("PAS") && tipoPas=='A') {
					adults=(Adulto) alq2.getAlqui()[i];
					lineafactura+=adults.getTipo()+"\t\t"+adults.getMarca()+"\t\t"+adults.getSerie()+"\t\t("+adults.getGrososrRueda()+", Adulto["+adults.getAltura()+"]).\n";	
				//Paseo niño
				}else if(alq2.getAlqui()[i].getTipo().equals("PAS") && tipoPas=='N'){
					children=(Ninhos) alq2.getAlqui()[i];
					lineafactura+=children.getTipo()+"\t\t"+children.getMarca()+"\t\t"+children.getSerie()+"\t\t("+children.getGrososrRueda()+", Niño["+children.getTipoAsiento()+"]).\n";
				}
			}
		}
		report.append(lineafactura).append(alq2.toString());
		
		return report;
	}

	//Opción 2
	private static Bicicleta[] CargarBiciletas() {
		//Asignamos dimesión
		Bicicleta regisBici[]=null;
		for (int i = 0; i < 15; i++) {
			regisBici[i]=CargarDatosBici();
		}		
		
		return regisBici;
	}
	
	//Subfunción Opción 2 para bici
	private static Bicicleta CargarDatosBici() {
		//Atributos de la bici
		String marca="";
		String modelo="";
		String serie="";
		int nroAro=0;
		double montoAlq=0;
		String tipo="";
		
		//Subclase Paseo
		double grososrRueda=0;
		String tipoPaseo="";
		
		//Subclases de paseo, Niños y adultos
		String tipoAsiento="";
		 double altura=0;
		
		//Subclase Montaña
		String materialPed="";
		String tipoSusp="";
		double peso=0;
		
		//Subclase Carrera
		int cantVeloc=0;
		String tipoFre="";
		String materBic="";
		
		Bicicleta b=null;
		
		//Carga superclase, Ingreso de la marca
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la marca de la bici: ");
				marca= data.nextLine();
				marca= marca.trim();
				if(marca=="" || marca==" ") {
					System.err.println("Marca no admitida. Vuelva a intentar.");
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while (marca=="" || marca==" ");
		
		//Ingreso del modelo
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el modelo de la bici: ");
				modelo= data.nextLine();
				modelo= modelo.trim();
				if(modelo=="" || modelo==" ") {
					System.err.println("Modelo no admitido. Vuelva a intentar.");
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while (modelo=="" || modelo==" ");
		
		//Ingreso de la serie
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la serie de la bici: ");
				serie= data.nextLine();
				serie= serie.trim();
				if(serie=="" || serie==" ") {
					System.err.println("Serie no admitido. Vuelva a intentar.");
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}	
		} while (serie=="" || serie==" ");
		
		//Ingreso del nroAro
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
		
		//Ingreso del monto de alquiler montoAlq
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
		
		//Ingreso del tipo bici
		do { 
			try {
				data.nextLine();
				System.out.println("Ingrese el tipo de bici(PAS=paseo;MON=montaña;CAR=carrera): ");
				tipo= data.nextLine();
				tipo=tipo.toUpperCase();
			
				if(!tipo.equals("PAS") && !tipo.equals("MON") && !tipo.equals("CAR")) {
					System.err.println("Tipo de bici no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println(e.getMessage());
			}
		}while(tipo.isEmpty() || tipo.isBlank() || tipo.equals(null) || (!tipo.equals("PAS") && !tipo.equals("MON") && !tipo.equals("CAR")));
		
		//Evalucaión del tipo bici
		if (tipo.equals("PAS")) {
			//CargarDatosPaseo, Ingreso del grosor de la rueda
			do { 
				try {
					System.out.println("Ingrese el grosor de la rueda en mm: ");
					grososrRueda= data.nextDouble();
					
					if(grososrRueda<0 || grososrRueda>100) {
						System.err.println("Grosor no admitido. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(grososrRueda<0 || grososrRueda>100);	
			
			//Ingreso del tipo paseo
			do { 
				try {
					data.nextLine();
					System.out.println("Ingrese el tipo de paseo(A=adulto;N=niño): ");
					tipoPaseo= data.nextLine();
					tipoPaseo=tipoPaseo.trim();
					tipoPaseo=tipoPaseo.toUpperCase();
				
					if(!tipoPaseo.equals("N") && !tipoPaseo.equals("A")) {
						System.err.println("Tipo de paseo no admitido. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println(e.getMessage());
				}
			}while(tipoPaseo.isEmpty() || tipoPaseo.isBlank() || tipoPaseo.equals(null) || (!tipoPaseo.equals("N") && !tipoPaseo.equals("A")));
			
			//Evaiuación del tipo paseo
			if (tipoPaseo.equals("N")) {
				//Cargar Datos Niños, Ingreso del tipo de asiento tipoAsiento
				do {
					try {
						data.nextLine();
						System.out.println("Ingrese el tipo de asiento: ");
						tipoAsiento= data.nextLine();
						tipoAsiento= tipoAsiento.trim();
						if(tipoAsiento=="" || tipoAsiento==" " ) {
							System.err.println("Tipo de asiento no admitido. Vuelva a intentar.");
						}	
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}	
				} while (tipoAsiento=="" || tipoAsiento==" ");
				
				
				b= new Ninhos(marca, modelo, serie, nroAro, montoAlq, tipo, grososrRueda, tipoPaseo,tipoAsiento);//pasar atributos
				
			}else {
				//Cargar Datos Adultos, Ingreso de la altura
				do { 
					try {
						System.out.println("Ingrese la altura en metros: ");
						altura= data.nextDouble();
						
						if(altura<0 || altura>150) {
							System.err.println("Altura no admitida. Vuelva a intentar.");
						}
					} catch (InputMismatchException e) {
						System.err.println("El valor ingresado no es númerico");
					}
					data.nextLine();
				}while(altura<0 || altura>150);	
				
				
				b= new Adulto(marca, modelo, serie, nroAro, montoAlq, tipo, grososrRueda, tipoPaseo,altura);//pasar atributos
				
			}
		}else if(tipo.equals("MON")) {
			//CargarDatosMontaña, ingreso del material de los pedales
			do {
				try {
					data.nextLine();
					System.out.println("Ingrese el material de los pedales: ");
					materialPed= data.nextLine();
					materialPed= materialPed.trim();
					if(materialPed=="" || materialPed==" " ) {
						System.err.println("Dato no admitido. Vuelva a intentar.");
					}	
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}	
			} while (materialPed=="" || materialPed==" ");
			
			//Ingreso del tipo de suspensión tipoSusp
			do {
				try {
					data.nextLine();
					System.out.println("Ingrese el material de los pedales: ");
					tipoSusp= data.nextLine();
					tipoSusp= tipoSusp.trim();
					if(tipoSusp=="" || tipoSusp==" " ) {
						System.err.println("Dato no admitido. Vuelva a intentar.");
					}	
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			} while (tipoSusp=="" || tipoSusp==" ");
			
			//Ingreso del peso
			do { 
				try {
					System.out.println("Ingrese el peso en kg: ");
					peso= data.nextDouble();
					
					if(peso<0 || peso>5) {
						System.err.println("Peso no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(peso<0 || peso>5);	
			
			b=new Montanha(marca, modelo, serie, nroAro, montoAlq, tipo,materialPed,tipoSusp,peso);//pasar atributos
			
		}else {
			//CargarDatosCarrera, ingreso de la cantidad de velocidades cantVeloc
			do { 
				try {
					System.out.println("Ingrese la cantidad de velocidades: ");
					cantVeloc= data.nextInt();
					
					if(cantVeloc<=0 || cantVeloc>9) {
						System.err.println("Cantidad de velocidades no admitida. Vuelva a intentar.");
					}
				} catch (InputMismatchException e) {
					System.err.println("El valor ingresado no es númerico");
				}
				data.nextLine();
			}while(cantVeloc<=0 || cantVeloc>9);
			
			//Ingreso del tipo de freno
			do {
				try {
					data.nextLine();
					System.out.println("Ingrese el tipo de freno: ");
					tipoFre= data.nextLine();
					tipoFre= tipoFre.trim();
					if(tipoFre=="" || tipoFre==" " ) {
						System.err.println("Dato no admitido. Vuelva a intentar.");
					}	
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}	
			} while (tipoFre=="" || tipoFre==" ");
			
			//Ingreso del material de la bici 
			do {
				try {
					data.nextLine();
					System.out.println("Ingrese el material de la bici: ");
					materBic= data.nextLine();
					materBic= materBic.trim();
					if(materBic=="" || materBic==" " ) {
						System.err.println("Dato no admitido. Vuelva a intentar.");
					}	
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}	
			} while (materBic=="" || materBic==" ");
			
			b=new Carrera(marca, modelo, serie, nroAro, montoAlq, tipo,cantVeloc,tipoFre,materBic); //pasar atributos
		}
		
		
		return b;
	}
	
	//Subfunción Opción 2 para fecha alquiler o devolción
	private static String CargarFecha(String tipoFecha) {
		//Ingreso de la fecha
		String fecha="";
		do {
			try {
				data.nextLine();
				if (tipoFecha.equals("fa")) {
					System.out.println("Ingrese la fecha de alquiler (AAAA/MM/DD)");
				}else {
					System.out.println("Ingrese la fecha de devolución (AAAA/MM/DD)");
				}
				fecha= data.nextLine();
				fecha=fecha.trim();
				
				if(!ValidarFecha(fecha)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(fecha.equals(null) || fecha.isEmpty() || fecha.isBlank() || !ValidarFecha(fecha));
		
		return fecha;
	}
	

	//Opción 1
	private static Cliente CargarCliente() {
		//Atributos
		String nombre="";
		String apellido="";
		TipoDocumento tipoDoc=null;
		String nroDoc="";
		String email="";
		
		//Ingreso del nombre
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el nombre del Cliente: ");
				nombre= data.nextLine();
				nombre= nombre.trim();
				if(nombre=="" || nombre==" ") {
					System.err.println("Nombre no admitido. Vuelva a intentar.");
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}	
		} while (nombre=="" || nombre==" ");
		
		
		//Ingreso del Apellido
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el apellido del Cliente: ");
				apellido= data.nextLine();
				apellido=  apellido.trim();
				if(apellido=="" || apellido==" ") {
					System.err.println("Apellido no admitido. Vuelva a intentar.");
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while (apellido=="" || apellido==" ");
		
		//Ingreso del Tipo de documento
		String tipo="";
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el Tipo de documento: ");
				tipo= data.nextLine();
				tipo= tipo.trim();
				tipo=tipo.toUpperCase();
				if(tipo.isBlank() || tipo.isEmpty() || (!tipo.equals("CI") && !tipo.equals("PAS"))) {
					System.err.println("Tipo de documento no admitido. Vuelva a intentar.");
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}	
		} while (tipo.isBlank() || tipo.isEmpty() || (!tipo.equals("CI") && !tipo.equals("PAS")));
		//Asignación a las constantes
		if (tipo.equals("CI")) {
			tipoDoc=CI;
		}else {
			tipoDoc=PAS;
		}
		
		//Ingreso del Nro de documento
		do {
			try {
				data.nextLine();
				if (tipo.equals("CI")) {
					System.out.println("Ingrese el Nro de documento de la CI: ");
				}else {
					System.out.println("Ingrese el Nro de documento del pasaporte: ");
				}
				nroDoc= data.nextLine();
				nroDoc=nroDoc.trim();
				nroDoc=nroDoc.toUpperCase();
				
				if(!ValidarNroDoc(nroDoc,tipo)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(nroDoc.equals(null) || nroDoc.isEmpty() || nroDoc.isBlank() || !ValidarNroDoc(nroDoc,tipo));
		
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
		
		
		return new Cliente (nombre, apellido, tipoDoc, nroDoc, email);
	}			
	
	

	//Subfunción Opción 1
	private static Extranjero CargarClienteExtranjero(Cliente cli) {
		//Atributos
		String paisOrig="";
		String telefCont="";
		
		//Ingreso del país de origen
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el país de origen: ");
				paisOrig= data.nextLine();
				paisOrig= paisOrig.trim();
				if(paisOrig=="" || paisOrig==" ") {
					System.err.println("Valor no admitido. Vuelva a intentar.");
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while (paisOrig=="" || paisOrig==" ");
		
		//Ingreso del teléfono de contacto
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el teléfono de contacto : ");
				telefCont= data.nextLine();
				telefCont= telefCont.trim();
				if(telefCont=="" || telefCont==" ") {
					System.err.println("Valor no admitido. Vuelva a intentar.");
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} while (telefCont=="" || telefCont==" ");
		
		//Instancia del hijo
		Extranjero e= new Extranjero();
		//Superclase
		e.setNombre(cli.getNombre());
		e.setApellido(cli.getApellido());
		e.setTipoDoc(cli.getTipoDoc());
		e.setNroDoc(cli.getNroDoc());
		e.setEmail(cli.getEmail());
		//Subclase
		e.setPaisOrig(paisOrig);
		e.setTelefCont(telefCont);
		
		return e;
	}

	//Subfunción Opción 1
	private static Nativo CargarClienteNacional(Cliente cli) {
		//Atributos
		String ciudadOrig="";
		String direccion="";
		
		//Ingreso de la ciudad de Origen
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la ciudad de origen: ");
				ciudadOrig= data.nextLine();
				ciudadOrig= ciudadOrig.trim();
				if(ciudadOrig=="" || ciudadOrig==" ") {
					System.err.println("Valor no admitido. Vuelva a intentar.");
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}	
		} while (ciudadOrig=="" || ciudadOrig==" ");
		
		//Ingreso de la dirección 
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la ciudad de origen: ");
				direccion= data.nextLine();
				direccion= direccion.trim();
				if(direccion=="" || direccion==" ") {
					System.err.println("Valor no admitido. Vuelva a intentar.");
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}	
		} while (direccion=="" || direccion==" ");
		
		//Instancia del hijo
		Nativo n = new Nativo();
		//Superclase
		n.setNombre(cli.getNombre());
		n.setApellido(cli.getApellido());
		n.setTipoDoc(cli.getTipoDoc());
		n.setNroDoc(cli.getNroDoc());
		n.setEmail(cli.getEmail());
		//Subclase
		n.setCiudadOrig(ciudadOrig);
		n.setDireccion(direccion);
		
		return n;
	}
	
	//Expresión regular para el Nro Doc
	private static boolean ValidarNroDoc(String nroDoc,String tipo) {
		if (tipo.equals("CI")) {
			return nroDoc.matches("[0-9]+");
		}else {
			return nroDoc.matches("[0-9]A-Z]+[0-9]+");
		}	
	}
	
	//Expresión regular para las fechas
	public static boolean ValidarFecha(String fecha) {
		return fecha.matches("[0-9]+/[0-9]+/[0-9]+");
	}
		
	//Expresión regular para el correo
	public static boolean ValidarCorreo(String email) {
		return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}		
}
