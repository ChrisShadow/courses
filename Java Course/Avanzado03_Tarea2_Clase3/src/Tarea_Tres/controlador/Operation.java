package Tarea_Tres.controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

import Tarea_Tres.modelo.*;

public class Operation {
	public  Scanner data = new Scanner(System.in);
	public List<Hotel> listHotel = new ArrayList<Hotel>();
	public PriorityQueue<Hotel> hoteles = new PriorityQueue<>();
	// public SortedSet<Hotel> listaHoteles = new TreeSet<>();
	
	public void MenuOperaciones()  throws InputMismatchException {
		int opcion=0;
		boolean banC= false;
		do {
			data.nextLine();
			System.out.println("\n\nEscoga la operación a realizar.");
			System.out.println("-------------------------------------");
			System.out.println("1- Cargar datos para 7 Hoteles ");
			System.out.println("2- Mostrar los datos ordenados");
			System.out.println("3- Salir del menú");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1:
				CargarHoteles();
				banC=true;
				break;
			case 2:
				if(banC) {
					OrdenarHoteles();
				}else {
					System.err.println("\nDebe ejecutar la opción 1.");
				}
				break;
			case 3:
				System.out.println("\nSaliendo del menú...\n");
				break;
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!=3);
		//return opcion.charAt(0);
	}

	private void OrdenarHoteles() {
		//Ya que esto se ejecutar en un menú
		if (!hoteles.isEmpty())
			hoteles.clear();
		
		Collections.sort(listHotel);
		Iterator<Hotel> iteratorH = listHotel.iterator();
        while (iteratorH.hasNext()) {
        	Hotel h= iteratorH.next();
        	hoteles.offer(h);
        }
		
		 //Control interno
	       if (!hoteles.isEmpty()) {
	    	   //Recorrer e imprimir 
	           System.out.println("\nDatos del hotel: \n");
	           for (Hotel hotel : hoteles) {
	   			System.out.println(hotel.toString().concat("\n"));
	   		}
	       }	
		
		
		/*//contador de posición
		int cont=1;
		Iterator<Hotel> iteratorH = listHotel.iterator();
		Hotel hPosterior= listHotel.get(1);
        while (iteratorH.hasNext()) {
        	Hotel hAnterior= iteratorH.next();
        	while(cont<listHotel.size()) {
	        	//Ordenación según la función compareTo (por precio ascendentemente, oredenación natural)
	            if (hPosterior.compareTo(hAnterior)==-1)
	            	hoteles.offer(hPosterior);
	            else if(hPosterior.compareTo(hAnterior)==1){
	            	hoteles.offer(hAnterior);
	            	//Hotel hotelAux=iteratorH.next();
	            	//hoteles.offer(hotelAux);
	            }else {
	            	hoteles.offer(hAnterior);
	            }
	            hPosterior= listHotel.get(cont);
	            cont++;
        	}
        }*/
		
      
	}

	private void CargarHoteles() {
		Hotel h=null;
		//Para la carga de 7 veces
		for (int i = 0; i < 7; i++) {
			//Operación
			System.out.println("\n---Dato para el hotel N° "+(i+1)+"---\n");
			h=cargarDatos();
			listHotel.add(h);
		}
		
	}
	
	private Hotel cargarDatos() {
		Hotel hT = new Hotel();
		//Ingreso del Cód. Hotel
		do { 
			try {
				System.out.println("\nIngrese el Cód. para el hotel (Sólo número mayor a 0): ");
				hT.setCodHotel(data.nextInt());
				
				if(hT.getCodHotel()<=0) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
				hT.setCodHotel(0);
			}
			data.nextLine();
		}while(hT.getCodHotel()<=0);			
		
		
		//Ingreso del nombre 
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el nombre para el hotel: ");
				hT.setNombre(data.nextLine());
				hT.setNombre(hT.getNombre().trim().toUpperCase());
				if(hT.getNombre().isBlank() || hT.getNombre().isEmpty()) {
					System.err.println("Dato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (hT.getNombre().isBlank() || hT.getNombre().isEmpty());	
		
		//Ingreso de la zona
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese la zona para el hoterl (Playa, montaña o rural): ");
				hT.setZona(data.nextLine());
				hT.setZona(hT.getZona().trim().toUpperCase());
				if(hT.getZona().isBlank() || hT.getZona().isEmpty() || (!hT.getZona().equalsIgnoreCase("playa") && !hT.getZona().equalsIgnoreCase("montaña") && !hT.getZona().equalsIgnoreCase("rural"))) {
					System.err.println("Dato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (hT.getZona().isBlank() || hT.getZona().isEmpty() || (!hT.getZona().equalsIgnoreCase("playa") && !hT.getZona().equalsIgnoreCase("montaña") && !hT.getZona().equalsIgnoreCase("rural")));			
		
		//Ingreso del precio
		do { 
			try {
				System.out.println("\nIngrese el precio (Puede contener decimales pero en dólares): ");
				hT.setPrecio(data.nextDouble());
				
				if(hT.getPrecio()<1) {
					System.err.println("Cifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("El valor ingresado no es númerico");
				hT.setCodHotel(0);
			}
			data.nextLine();
		}while(hT.getPrecio()<1);		
		
		
		
		return hT;
	}
	
}
