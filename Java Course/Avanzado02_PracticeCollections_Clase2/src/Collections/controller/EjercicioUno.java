package Collections.controller;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import Collections.model.*;

public class EjercicioUno {
	
	public static List<Vehicle> listVehiculo = new ArrayList<Vehicle>() ;
	
	//Agregar a la lista
	public void agregarElementos(Vehicle v) {
		listVehiculo.add(v);
	}
	
	//Cantidad de vehículos introducidos.
	public void cantidadVehiculos() {
		System.out.println("\nCantidad de vehículos ingresados: "+listVehiculo.size());	
	}
	
	//Cantidad de coches
	public void vehiculosCoche() {
		List<Vehicle> listVehicoche = new ArrayList<Vehicle>() ;
		if(!listVehiculo.isEmpty()) {
			if(listVehiculo.size()>1) {
			//Sintaxis de inicialización 
			 Iterator<Vehicle> iteratorV = listVehiculo.iterator();
		        while (iteratorV.hasNext()) {
		        	Vehicle cO= iteratorV.next();
		            if (cO.getTipo().equalsIgnoreCase("coche"))
		            	listVehicoche.add(cO);
		        }
		        if(listVehicoche.isEmpty()) {
		        	System.out.println("No se encontró COCHE");
		        }else {
		        	System.out.println("\nMostrando datos de los Vehículos tipo Coche.");
		        	 for (Vehicle coche : listVehicoche)
		                 System.out.printf("%s ", coche.toString());
		        }
			}else{
				System.out.println("\nSolo hay un registro: ");
				for (Vehicle coche : listVehiculo)
	                 System.out.printf("%s ", coche.toString());
			}
		}else {
			System.err.println("No se han registrados vehículos de tipo coche");
		}
		
	}
	
	//Cantidad de vehículos por km
	public void vehiculosKm(int km) {
		List<Vehicle> listVhKm = new ArrayList<Vehicle>() ;
		//Sintaxis de inicialización 
		if (!listVehiculo.isEmpty()) {
			if (listVehiculo.size()>1) {
			 Iterator<Vehicle> iteratorV = listVehiculo.iterator();
		        while (iteratorV.hasNext()) {
		        	Vehicle kiM= iteratorV.next();
		            if (kiM.getKm()<=km)
		            	listVhKm.add(kiM);
		        }
		        if(listVhKm.isEmpty()) {
		        	System.out.println("No se encontró vehículo con kilometraje menor a " + km + " kilómetros." );
		        }else {
		        	System.out.println("\nMostrando datos del vehículo según kilometraje");
		        	 for (Vehicle coche : listVhKm)
		                 System.out.printf("%s ", coche.toString());
		        }
			}else{
				System.out.println("\nSolo hay un registro: ");
				for (Vehicle coche : listVehiculo)
	                 System.out.printf("%s ", coche.toString());
			}
		}else {
			System.err.println("No se han registrados vehículos. ");
		}
		      
	}
	
	//Cantidad de vehículos por marca
	public void vehiculosMarca(String marca) {
		if (!listVehiculo.isEmpty()) {
			if (listVehiculo.size()>1) {	
				List<Vehicle> listMarca = new ArrayList<Vehicle>() ;
				//Sintaxis de inicialización 
				 Iterator<Vehicle> iteratorV = listVehiculo.iterator();
			        while (iteratorV.hasNext()) {
			        	Vehicle mA= iteratorV.next();
			            if (mA.getMarca().equalsIgnoreCase(marca))
			            	listMarca.add(mA);
			        }
			        if(listMarca.isEmpty()) {
			        	System.out.println("No se encontró vehículo con la marca " + marca + " dada." );
			        }else {
			        	System.out.println("\nMostrando datos del vehículo según la marca");
			        	 for (Vehicle coche : listMarca)
			                 System.out.printf("%s ", coche.toString());
			        }
			}else{
				System.out.println("\nSolo hay un registro: ");
				for (Vehicle coche : listVehiculo)
	                 System.out.printf("%s ", coche.toString());
			}
		}else {
			System.err.println("No se han registrados vehículos. ");
		}
	}	
	
	//Cantidad de camionetas por Km de < a >
	public void camionetasKm() {
		int max= 250; 
		List<Vehicle> listCam = new ArrayList<Vehicle>() ;
		List<Vehicle> listCamMax = new ArrayList<Vehicle>() ;
		if (!listVehiculo.isEmpty()) {
			if (listVehiculo.size()>1) {
			//Sintaxis de inicialización 
			 Iterator<Vehicle> iteratorV = listVehiculo.iterator();
		        while (iteratorV.hasNext()) {
		        	Vehicle cKM= iteratorV.next();
		            if (cKM.getTipo().equalsIgnoreCase("camioneta"))
		            	listCam.add(cKM);
		        }
		        if(listCam.isEmpty()) {
		        	System.out.println("No se encontró CAMIONETA");
		        }else {
		        	if(listCam.size()>1) {
		        		Iterator<Vehicle> iteratorC = listCam.iterator();
			        	while (iteratorC.hasNext()) {
			        		Vehicle cKM2= iteratorV.next();
			 	            if (cKM2.getKm()<=max)
			 	            	listCamMax.add(cKM2);
			 	        }
			        	Collections.sort(listCamMax, Collections.reverseOrder());
			        	System.out.println("\nMostrando datos del vehículo tipo CAMIONETA según kilometraje");
			        	 for (Vehicle camio : listCamMax)
			                 System.out.printf("%s ", camio.toString());
		        	}else {
		        		System.out.println("\nMostrando datos del vehículo tipo CAMIONETA según kilometraje");
		        		 for (Vehicle camio : listCam)
			                 System.out.printf("%s ", camio.toString());
		        	}
		        	 
		        }
			}else{
				System.out.println("\nSolo hay un registro: ");
				for (Vehicle coche : listVehiculo)
	                 System.out.printf("%s ", coche.toString());
			}
		}else {
			System.err.println("No se han registrados vehículos. ");
		}
		
	}
	
	
}
