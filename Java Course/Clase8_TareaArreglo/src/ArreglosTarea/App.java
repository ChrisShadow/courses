package ArreglosTarea;

import java.util.Scanner;

public class App {

	public static Scanner data = new Scanner(System.in);
	
	public static int d=-1; // Inicializar la varible para la dimsensión el array
	public static Factura talonario[]; //Inicializar la varible para el array
	
	public static void main(String[] args) {
		
		//Entrada del menú de operaciones
		MenuOperaciones();
		System.out.println("--PROGRAMA FINALIZADO--");
		
	}
	
	
	private static void MenuOperaciones() {
		int opcion=4;
		do {
			System.out.println("\n\nEscoga la operación a realizar con la Factura/s");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println();
			System.out.println("1- Ingrese la cantidad de facturas que desea almacenar");
			System.out.println("2- Almacenar los datos de cada factura");
			System.out.println("3- Mostar detalles de la factura");
			System.out.println("4- Salir del menú");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1: 
				d=CantidadFacturas(); // Asignar la dimensión retornada
				break;
			case 2:
				AlmacenarFacturas();
				
				break;
			case 3:
				MostarDetalle();
				break;
			case 4:
				System.out.println("Saliendo del menú...");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!=4);
		
	}
	
	private static int CantidadFacturas() {
		int n =0;
		System.out.println("Ingrese la cantidad de facturas(mínimo 1; máximo 500) : ");
		n= data.nextInt();
		while(n < 1 || n > 500 ) {
			System.err.println("Cantidad no admitida. Vuelva a intentar.");
			System.out.println("Ingrese la cantidad de facturas(mínimo 1; máximo 500) : ");
			n= data.nextInt();
		}
		return n;
	}
	
	private static void AlmacenarFacturas() {
		if(d==-1) {
			System.out.println("Debe definir la cantidad de facturas a almacenar.Intente de nuevo");
		}else {
			talonario= new Factura[d] ;
			for (int i = 0; i <= d-1; i++) {
				talonario[i]=NuevaFactura();
			}
		}
		
	}

	
	private static void MostarDetalle() {
		int canItem=0;
		int cantFac=0;
		int monTotGen=0;
		double montoIVAGen=0;
		if(d==-1) {
			System.out.println("Debe definir la cantidad de facturas a almacenar.Intente de nuevo");
		}else {
			System.out.println("***Detalle de Facturas*** \n");
			System.out.println("Período		Factura		Timbrado		Monto-Total		IVA		Monto-sin-IVA");
			System.out.println("------------------------------------------------------------------------------\n");
			for (Factura fac: talonario) {
				cantFac++;
				System.out.println(fac.toString());
				canItem+=fac.getCantItems();
				monTotGen+=fac.getMontoTot();
				montoIVAGen+=fac.getMontoIVA();
			}
			System.out.println("------------------------------------------------------------------------------\n");
			System.out.println("--Cantidad de ítems:"+canItem+"--\n--Cantidad de facturas: "+cantFac+"--\n--Monto total general: "+monTotGen+"--\n--Monto IVA General: "+montoIVAGen);
		}
		
	}


	//método para generar nueva factura
	public static Factura NuevaFactura() {
		int periodo=0;
		long rucVen=0;
		int nroFactura=0;
		String tipoDoc="";
		String timbrado="";
		int montoTot=0;
		int cantItems=0;
		long rucComp=0;
		Factura fac;
		int y=0;
		int m=0;
		
		
	//Carga de datos factura
		
		//Ingreso del año
		System.out.println("Ingrese el año : ");
		y= data.nextInt();
		while(y < 2011 || y > 2021 ) {
			System.err.println("Año no admitido. Vuelva a intentar.");
			System.out.println("Ingrese el año : ");
			y= data.nextInt();
		}
		
		//Ingreso del mes
		System.out.println("Ingrese el mes (1-12) : ");
		m= data.nextInt();
		while(m < 1 || m > 12 ) {
			System.err.println("Mes no admitido. Vuelva a intentar.");
			System.out.println("Ingrese el mes (1-12) : ");
			m= data.nextInt();
		}
		
		//RUC del vendedor
		System.out.println("Ingrese el RUC del vendedor(sin dígito verificador) : ");
		rucVen= data.nextInt();
		while(rucVen ==0) {
			System.err.println("RUC no admitido. Vuelva a intentar.");
			System.out.println("Ingrese el RUC del vendedor(sin dígito verificador) : ");
			rucVen= data.nextInt();
		}
		
		//Nro factura
		System.out.println("Ingrese el Nro. de factura : ");
		nroFactura= data.nextInt();
		while(nroFactura <=0) {
			System.err.println("Nro. factura no admitido. Vuelva a intentar.");
			System.out.println("Ingrese el Nro. de factura : ");
			nroFactura= data.nextInt();
		}
		
		//Ingreso del tipo de Documento
		do {
			System.out.println("Ingrese el tipo de documemto(C=crédito;D=débito): ");
			tipoDoc = data.nextLine();
			tipoDoc.toUpperCase();
			if(!tipoDoc.equals("C") && !tipoDoc.equals("D")) {
				System.err.println("Caracter incorrecto. Vuelva a intentar");
			}
		}while(!tipoDoc.equals("C") && !tipoDoc.equals("D")); 
		
		//Ingreso del timbrado
		System.out.println("Ingrese el timbrado: ");
		timbrado= data.nextLine();
		while(timbrado =="") {
			System.err.println("Timbrado no admitido. Vuelva a intentar.");
			System.out.println("Ingrese el timbrado: ");
			timbrado= data.nextLine();
		}
		
		//Ingreso del monto total
		System.out.println("Ingrese el monto total : ");
		montoTot= data.nextInt();
		while(montoTot <0) {
			System.err.println("Monto total no admitido. Vuelva a intentar.");
			System.out.println("Ingrese el monto total : ");
			montoTot= data.nextInt();
		}
		
		//Ingreso de la cantidad de items
		System.out.println("Ingrese la cantidad de items : ");
		cantItems= data.nextInt();
		while(cantItems <=0) {
			System.err.println("Cantidad de ítems no admitida. Vuelva a intentar.");
			System.out.println("Ingrese la cantidad de items : ");
			cantItems= data.nextInt();
		}
		
		//RUC del comprador
		System.out.println("Ingrese el RUC del comprador(sin dígito verificador) : ");
		rucComp= data.nextInt();
		while(rucComp == 0 || rucComp == rucVen ) {
			System.err.println("RUC no admitido. Vuelva a intentar.");
			System.out.println("Ingrese el RUC del comprador(sin dígito verificador) : ");
			rucComp= data.nextInt();
		}
		
		//instanciación del objeto
		fac= new Factura();
		
		//Asignación de valores al objeto
		periodo=(y*100)+m;
		fac.setPeriodo(periodo);
		fac.setRucVen(rucVen);
		fac.setNroFactura(nroFactura);
		fac.setTipoDoc(tipoDoc.charAt(0));
		fac.setTimbrado(timbrado);
		fac.setMontoTot(montoTot);
		fac.CalcularMontoIVA();
		fac.CalcularMontoSIVA();
		fac.setCantItems(cantItems);
		fac.setRucComp(rucComp);
		
		return fac;
	}
}
