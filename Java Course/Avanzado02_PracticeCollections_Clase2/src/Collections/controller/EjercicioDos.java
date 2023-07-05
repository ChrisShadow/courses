package Collections.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import Collections.model.Vehicle;

public class EjercicioDos {

public static Set<Vehicle> listVehiculo = new HashSet<Vehicle>() ;
	
	//Agregar a la lista
	public void agregarElementos(Vehicle v) {
		listVehiculo.add(v);
	}
	
	//Cantidad de veh�culos introducidos.
	public void cantidadVehiculos() {
		System.out.println("\nCantidad de veh�culos ingresados: "+listVehiculo.size());	
	}
	
	//Cantidad de coches
	public void vehiculosCoche() {
		Set<Vehicle> listVehicoche = new HashSet<Vehicle>() ;
		if (!listVehiculo.isEmpty()) {
			if (listVehiculo.size()>1) {
				Iterator<Vehicle> iteratorV =  listVehiculo.iterator();
		        while (iteratorV.hasNext()) {
		        	Vehicle cO= iteratorV.next();
		            if (cO.getTipo().equalsIgnoreCase("coche"))
		            	listVehicoche.add(cO);
		        }
		        if(listVehicoche.isEmpty()) {
		        	System.out.println("No se encontr� COCHE");
		        }else {
		        	System.out.println("\nMostrando datos de los Veh�culos tipo Coche.");
		        	 for (Vehicle coche : listVehicoche)
		                 System.out.printf("%s ", coche.toString());
		        }
			}else{
				System.out.println("\nSolo hay un registro: ");
				for (Vehicle coche : listVehiculo)
	                 System.out.printf("%s ", coche.toString());
			}
		}else {
			System.err.println("No se han registrados veh�culos de tipo coche");
		}
		 
	}
	
	//Cantidad de veh�culos por km
	public void vehiculosKm(int km) {
		Set<Vehicle> listVhKm = new HashSet<Vehicle>() ;
		if (!listVehiculo.isEmpty()) {
			if (listVehiculo.size()>1) {
			 Iterator<Vehicle> iteratorV = listVehiculo.iterator();
		        while (iteratorV.hasNext()) {
		        	Vehicle kM= iteratorV.next();
		            if (kM.getKm()<=km)
		            	listVhKm.add(kM);
		        }
		        if(listVhKm.isEmpty()) {
		        	System.out.println("No se encontr� veh�culo con kilometraje menor a " + km + " kil�metros." );
		        }else {
		        	System.out.println("\nMostrando datos del veh�culo seg�n kilometraje");
		        	 for (Vehicle coche : listVhKm)
		                 System.out.printf("%s ", coche.toString());
		        } 
			}else{
				System.out.println("\nSolo hay un registro: ");
				for (Vehicle coche : listVehiculo)
	                 System.out.printf("%s ", coche.toString());
			}
		}else {
			System.err.println("No se han registrados veh�culos.");
		}
		
	}
	
	//Cantidad de veh�culos por marca
	public void vehiculosMarca(String marca) {
		Set<Vehicle> listMarca = new HashSet<Vehicle>() ;
		if (!listVehiculo.isEmpty()) {
			if (listVehiculo.size()>1) {
			 Iterator<Vehicle> iteratorV = listVehiculo.iterator();
		        while (iteratorV.hasNext()) {
		        	Vehicle mC= iteratorV.next();
		            if (mC.getMarca().equalsIgnoreCase(marca))
		            	listMarca.add(mC);
		        }
		        if(listMarca.isEmpty()) {
		        	System.out.println("No se encontr� veh�culo con la marca " + marca + " dada." );
		        }else {
		        	System.out.println("\nMostrando datos del veh�culo seg�n la marca");
		        	 for (Vehicle coche : listMarca)
		                 System.out.printf("%s ", coche.toString());
		        }  
			}else{
				System.out.println("\nSolo hay un registro: ");
				for (Vehicle coche : listVehiculo)
	                 System.out.printf("%s ", coche.toString());
			}
		}else {
			System.err.println("No se han registrados veh�culos.");
		}
		
		
	}	
	
	//Cantidad de camionetas por Km de < a >
	public void camionetasKm() {
		int max= 250; 
		Set<Vehicle> listCam = new HashSet<Vehicle>() ;
		Set<Vehicle> listCamMax = new HashSet<Vehicle>() ;
		List<Vehicle> listCamMax2 = new ArrayList<Vehicle>();
		if (!listVehiculo.isEmpty()) {
			if (listVehiculo.size()>1) {
				Iterator<Vehicle> iteratorV =  listVehiculo.iterator();
		        while (iteratorV.hasNext()) {
		        	Vehicle cKM= iteratorV.next();
		            if (cKM.getTipo().equalsIgnoreCase("camioneta"))
		            	listCam.add(cKM);
		        }
		        if(listCam.isEmpty()) {
		        	System.out.println("No se encontr� CAMIONETA");
		        }else {
		        	if(listCam.size()>1) {
		        		
			        	Iterator<Vehicle> iteratorC =  listCam.iterator();
			        	while (iteratorC.hasNext()) {
			        		Vehicle cKM2= iteratorV.next();
			 	            if (cKM2.getKm()<=max)
			 	            	listCamMax.add(cKM2);
			 	        }
			        	//listCamMax2 = null;
			        	Iterator<Vehicle> iterator = listCamMax.iterator();
			        	while (iterator.hasNext()) {
			        		Vehicle v=iteratorV.next();
			        		listCamMax2.add(v);
				        }
						Collections.sort(listCamMax2, Collections.reverseOrder());
						System.out.println("\nMostrando datos del veh�culo tipo CAMIONETA seg�n kilometraje");
			        	for (Vehicle camio : listCamMax)
			                 System.out.printf("%s ", camio.toString());
		        	}else {
		        		System.out.println("\nMostrando datos del veh�culo tipo CAMIONETA seg�n kilometraje");
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
			System.err.println("No se han registrados veh�culos.");
		}
		 
	}
}
