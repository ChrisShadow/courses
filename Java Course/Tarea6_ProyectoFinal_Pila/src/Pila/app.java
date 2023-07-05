package Pila;

import java.util.InputMismatchException;
import java.util.Scanner;

public class app {

	public static Scanner data = new Scanner(System.in); // Teclado por consola.
	public static final Estado PEN = Estado.PENDIENTE; // Instancia del Enum Estado del valor pendiente
	public static final Estado REA = Estado.REALIZADA; // Instancia del Enum Estado del valor realizada
	public static boolean banP,banR = false; //Para el menú operaciones
	public static StackTarea tareaPendiente;
	public static StackTarea tareaRealizada;
	public static int caPila=0;
	
	
	public static void main(String[] args) {
		
		System.out.println("Control de Tareas pendientes o realizadas"+"\n----------------------------------------------");
		
		//Dimensionar los objetos de Pila para dimensionar el vector
		caPila=ObtenerDimensionTarea();
		if (caPila==0) {
			System.out.println("La capacidad de tareas será máximo 1");
			tareaPendiente=new StackTarea();
			tareaRealizada=new StackTarea();
		}else {
			tareaPendiente=new StackTarea(caPila);
			tareaRealizada=new StackTarea(caPila);
		}
		
		//Menú de operaciones
		System.out.flush(); //Limpiar pantalla
		MenuOperaciones(tareaPendiente,tareaRealizada); //Como parámetros los objetos estáticos de pila (a{adir o eliminar tarea)
		System.out.println("**APLICACIÖN DETENIDA POR EL USUARIO**");
		
	}

	private static int ObtenerDimensionTarea() {
		int dim=0;
		
		do { 
			try {
				System.out.println("Ingrese la capacidad máxima de tareas: ");
				dim= data.nextInt();
				
				if(dim<0 || dim>2) {
					System.err.println("Capacidad no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(dim<0 || dim>2);	
		
		
		return dim;
	}

	private static void MenuOperaciones(StackTarea tareaPendiente2, StackTarea tareaRealizada2) {
		char opcion=' ';
		do {
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println("a- Ingresar datos de la tarea");
			System.out.println("b- Actualizar estado de la tarea");
			System.out.println("c- Mostar detalles de las tareas pendientes ");
			System.out.println("d- Mostar detalles de las tareas realizadas ");
			System.out.println("e- Mostar resumen de todas las tareas");
			System.out.println("x- Terminar menú ");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextLine().toLowerCase().trim().charAt(0);
			switch (opcion) {
			case 'a': 
				try {
					System.out.println("Cargando tarea pendiente(Enter)...");
					System.out.println(tareaPendiente2.insertar(CargarTareas(tareaPendiente2)));
					banP=true;  //Se cargó la pila
				}catch( ArrayIndexOutOfBoundsException e) {
					System.err.println(e.getMessage());
					banP=false; // No se cargó la pila de tareas pendientes
				}
				break;
			case 'b':
				if (banP) {
					try {
						
						System.out.println("Cargando tarea realizada(Enter)...");
						tareaRealizada2.insertar(ActualizarTareaPendientes(tareaPendiente2));
						banR=true;  //Se cargó la pila de tareas realizadas
					} catch (StackTareasException e) {
						System.err.println(e.getMessage());
						banR=false;
					}
					
				}else {
					System.err.println("Debe ingresar datos a la Tarea");
				}
				
				break;
			case 'c':
				if (banP) {
					System.out.println("Mostrando tareas pendientes...\n"+ tareaPendiente2.toString());
				}else {
					System.err.println("Debe ingresar datos a la Tarea");
				}
				break;
			case 'd':
				if (banR) {
					System.out.println("Mostrando tareas realizadas...\n"+ tareaRealizada2.toString());
				}else {
					System.err.println("Debe actualizar datos de la Tarea");
				}
				break;
			case 'e':
				if(banP && banR) {
					StringBuilder reporte=Reporte(tareaPendiente2, tareaRealizada2);
					System.out.println(reporte);	
				}else {
					System.err.println("Debe ingresar los datos de ambas tareas");
				}
				break;
			case 'x':
				System.out.println("Finalizando menú...");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;	
			}
		}while(opcion!='x');
		
	}


	//Subfunción opción a
	private static Tareas CargarTareas(StackTarea tareaPendiente2) { 
		int idTarea;
		String name="";
		String fechaInicio="";
		int horaInicio=0;
		int horaioFin=0;
		Tareas tarea=null;
		
		//ID autogenerado
		idTarea=tareaPendiente2.ObtnerKey();
		
		//Ingreso del nombre
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el título a la tarea: ");
				name= data.nextLine();
				name= name.trim();
				if(name.isEmpty()) { //null o " "
					System.err.println("Dato no admitido.Vuelva a intentar.");
				}	
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
		} while (name.isEmpty());
		
		//Ingreso de la Fecha de Inicia
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la fecha de inicio(AAAA/MM/DD): ");
				fechaInicio= data.nextLine();
				fechaInicio=fechaInicio.trim();
				
				if(!ValidarFecha(fechaInicio)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(fechaInicio.equals(null) || fechaInicio.isEmpty() || fechaInicio.isBlank() || !ValidarFecha(fechaInicio));
		
		//Ingreso de la hora de inicio
		do { 
			try {
				System.out.println("Ingrese la hora de inicio(HHMM): ");
				horaInicio= data.nextInt();
				
				if(horaInicio<100|| horaInicio>2459) {
					System.err.println("Formato no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(horaInicio<100 || horaInicio>2459);	
		
		//Ingreso de la hora fin
		do { 
			try {
				System.out.println("Ingrese la hora de finalización(HHMM): ");
				horaioFin= data.nextInt();
				
				if(horaioFin<100|| horaioFin>2459) {
					System.err.println("Formato no admitido. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
			}
			data.nextLine();
		}while(horaioFin<100 || horaioFin>2459);			
		
		Estado estado= PEN;
		
		
		tarea=new Tareas( idTarea,  name,  fechaInicio,  horaInicio,  horaioFin,  estado);
		
		return tarea;
	}
	
	//Subfunción opción b
	private static Tareas ActualizarTareaPendientes(StackTarea tareaPendiente2) throws StackTareasException {
		int contRealizada=0;
		Tareas tr=null;
		String fechaFin="";
		
		//Actualizar la Fecha fin
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese la fecha de finalización(AAAA/MM/DD): ");
				fechaFin= data.nextLine();
				fechaFin=fechaFin.trim();
				
				if(!ValidarFecha(fechaFin)) {
					System.err.println("Formato inválido. Vuelva a ingresar");
				}
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(fechaFin.equals(null) || fechaFin.isEmpty() || fechaFin.isBlank() || !ValidarFecha(fechaFin));		
		
		//Visualización de la tarea a eliminar
		System.out.println(tareaPendiente2.toString().concat("\nEliminando la última tarea de la pila de tareas pendientes")); 
		
		
		//Eliminamos la última tarea encontrada
		tr=tareaPendiente2.eliminar();
		contRealizada++;
		
		//Validar que el objeto no sea nulo
		if (!tr.equals(null)) {
			tr.setFechaFin(fechaFin);
			tr.setEstado(REA);	  //Modificar estado
			//Visualización de la tarea eliminada
			System.out.println(tr.toString().concat("\n Total de tareas actualizadas: " + contRealizada));
		}
		
		return tr;
	}
	
	//Opción e
	private static StringBuilder Reporte(StackTarea tareaPendiente2, StackTarea tareaRealizada2) {
		StringBuilder report=null;
		report= new StringBuilder();
		
		report.append("-------------------DATOS GENERALES DE LAS TAREAS------------------\n").append("\n\t---TAREAS PENDIENTES---\n");
		report.append(tareaPendiente2.toString().concat("\n\n")).append("\t---TAREAS REALIZADAS---\n").append(tareaRealizada2).toString().concat("\n");
		
		
		return report;
	}


	//Expresión regular las fechas
	public static boolean ValidarFecha(String fecha) {
		return fecha.matches("[0-9]+/[0-9]+/[0-9]+");
	}	

}
