package Tarea3.Controlador;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;

import Tarea3.Modelo.Cancion;

public class OperacionesCancion {
	public  Scanner data = new Scanner(System.in);
	//Para el ordenamiento
	public PriorityQueue<Cancion> colaCanciones = new PriorityQueue<>();
	//Para la colecci�n original
	private Hashtable<String, Cancion> mapaCancion = new Hashtable<>();
	
	public void MenuOperaciones()  throws InputMismatchException {
		int opcion=0;
		boolean banC= false;
		do {
			data.nextLine();
			System.out.println("\n\nEscoga la operaci�n a realizar.");
			System.out.println("-------------------------------------");
			System.out.println("1- Agregar canci�n. ");
			System.out.println("2- Mostrar canciones seg�n artista elegido.");
			System.out.println("3- Eliminar una canci�n seg�n las claves.");
			System.out.println("4- Actualizar una canci�n seg�n las claves.");
			System.out.println("5- Salir del men�");
			System.out.println();
			System.out.println("Ingrese la opci�n: ");
			opcion = data.nextInt();
			switch (opcion) {
			case 1:
				AddSong();
				banC=true;
				break;
			case 2:
				if(banC) {
					ShowSongsbyA();
				}else {
					System.err.println("\nDebe ejecutar la opci�n 1.");
				}
				break;
			case 3:
				if(banC) {
					banC=DeleteSong();
				}else {
					System.err.println("\nDebe ejecutar la opci�n 1.");
				}
				break;
			case 4:
				if(banC) {
					UpdateSong();
				}else {
					System.err.println("\nDebe ejecutar la opci�n 1.");
				}
				break;
			case 5:
				System.out.println("\nSaliendo del men�...\n");
				break;
			default:
				System.err.println("\nOpci�n no valida " + opcion + ". Intente de nuevo.");
				break;
			}
		}while(opcion!=5);
		//return opcion.charAt(0);
	}

	//Case 4
	private boolean DeleteSong() {
		boolean respuesta = false;
		if (mapaCancion.isEmpty()) {
			System.out.println("�Error! No se encuentran canciones en el mapa.");
			respuesta = false;
		} else {

			String tituloCanFi = "";

			// Ingresar t�tulo de filtro
			do {
				try {
					data.nextLine();
					System.out.println("\nIngrese t�tulo de canci�n a usarse como filtro: ");
					tituloCanFi = data.nextLine();
					tituloCanFi = tituloCanFi.trim().toUpperCase();

					if (tituloCanFi.isBlank() || tituloCanFi.isEmpty()) {
						System.err.println("\n�Error! No puede ingresar nombre vac�o. Vuelva a intentar.");
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} while (tituloCanFi.isBlank() || tituloCanFi.isEmpty());

			Integer anioFi = 0;

			// Ingresar a�o de filtro
			do {
				try {

					System.out.println("\nIngrese a�o de canci�n a usarse como filtro: ");
					anioFi = data.nextInt();

					if (anioFi <= 1899) {
						System.out.println("\n�Error! N�mero inv�lido. Vuelva a intentar.");
					}

				} catch (InputMismatchException e) {
					System.err.println("\n�Error! El valor ingresado no es num�rico.");
					anioFi = 0;
				}
				data.nextLine();
			} while (anioFi <= 1899);

			Cancion auxCancion = null;
			String claveFiltro = tituloCanFi.concat(anioFi.toString());

			// Encontrar canci�n a eliminar
			Enumeration<String> enuClaves = mapaCancion.keys();
			while (enuClaves.hasMoreElements()) {
				Cancion auxCa = mapaCancion.get(enuClaves.nextElement());
				if (auxCa.getTituloC().equals(tituloCanFi) && auxCa.getAnho()== anioFi )
					auxCancion = mapaCancion.get(claveFiltro);
			}
			
			
			if (auxCancion != null) {
				
				// Eliminar
				System.out.println("\nEliminando " + auxCancion.toString());	
				if (mapaCancion.containsValue(auxCancion)) {
					
					auxCancion = mapaCancion.remove(claveFiltro);
					respuesta=true;
					System.out.println("\nCanci�n eliminada con �xito.\nPREES ENTER");
				}				
				
			} else {
				System.err.println("\nNo se encontr� canci�n a eliminar.");
				respuesta=false;
			}
			
		}
		
		return respuesta;
	}

	//Case 4
	private void UpdateSong() {
		String titulo = ""; 
		//Ingreso del titulo
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el titulo de la canci�n: ");
				titulo=data.nextLine();
				titulo=titulo.trim().toUpperCase();
				if(titulo.isBlank() || titulo.isEmpty()) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (titulo.isBlank() || titulo.isEmpty());		
		
		Integer anho = 0; 
		//Ingreso del a�o
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el a�o: ");
				anho=data.nextInt();
				if(anho<=1899) {
					System.err.println("\nCifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("\nEl valor ingresado no es n�merico");
				anho=1;
			}
		} while (anho<=1899);		
		
		//Concatenar las claves
		String clavesC=titulo.concat(anho.toString());
		
		String[] clavesA = mapaCancion.keySet().toArray(new String[0]);
		Cancion auxCan=null;
        for (String objetoClaves: clavesA) {
        	//Asignarle a c el valor seg�n el filtro 
            if(objetoClaves.equalsIgnoreCase(clavesC)) {
            	auxCan=mapaCancion.get(clavesC);
            }
        } 
        
        if (auxCan != null) {

			// Ingresar estado
			String estado = "";
			do {
				System.out.println("\nIngrese estado (A = activa, I = inactiva): ");
				estado = data.nextLine();
				estado=estado.toUpperCase();

				if (!estado.equals("A") && !estado.equals("I") && !estado.equals("a") && !estado.equals("i")) {
					System.err.println("Caracter inv�lido. Intente de nuevo.");
				}
			} while (!estado.equals("A") && !estado.equals("I") && !estado.equals("a") && !estado.equals("i"));
			auxCan.setEstado(estado.charAt(0));

			// Ingresar si es Hit
			String hit = "";
			do {
				System.out.println("\nIngrese si canci�n es Hit (S = si, N = no): ");
				hit = data.nextLine();
				hit=hit.toUpperCase();

				if (!hit.equals("S") && !hit.equals("N") && !hit.equals("s") && !hit.equals("n")) {
					System.err.println("Caracter inv�lido. Intente de nuevo.");
				}
			} while (!hit.equals("S") && !hit.equals("N") && !hit.equals("s") && !hit.equals("n"));
			auxCan.setEsHit(hit.charAt(0));

			// Ingreso de duraci�n
			do {
				try {
					System.out.println("\nIngresar duraci�n: ");
					auxCan.setDuracion(data.nextInt());

					if (auxCan.getDuracion() <= 0) {
						System.err.println("Error! Valor no permitido. Vuelva a intentar.");
					}

				} catch (InputMismatchException e) {
					System.out.println("El valor ingresado no es n�merico");
					auxCan.setDuracion(-1);
				}
				data.nextLine();
			} while (auxCan.getDuracion() <= 0);

			// Se vuelve a a�adir canci�n con campos modificados
			mapaCancion.put(clavesC, auxCan);

		} else {

			System.out.println("\n�Error! No se encontr� canci�n a ser modificada.");

		}
		
	}

	//Case 2
	private void ShowSongsbyA() {
		String nombre = ""; 
		
		//Ingreso del nombre del artista
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el nombre del artista el cual desea buscar: ");
				nombre=data.nextLine();
				nombre=nombre.trim().toUpperCase();
				if(nombre.isBlank() || nombre.isEmpty()) {
					System.err.println("Dato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (nombre.isBlank() || nombre.isEmpty());		
		
		//Recorriendo valores del mapa, tipo canci�n
		Cancion c = null;
		System.out.println("\nBuscando la canci�n del artista...\n");
        Cancion[] canciones = mapaCancion.values().toArray(new Cancion[0]);
        for (Cancion objetoC: canciones) {
        	//Asignarle a c el valor seg�n el filtro 
            if(objetoC.getNombreArt().equalsIgnoreCase(nombre))
            	c=objetoC;
        }
        if(c!=null){
        	System.out.println("\n"+c.toString()+ "\nPRESS ENTER");
        }else {
        	System.out.println("\nCanci�n del artista no encontrado\nPRESS ENTER");
        }

		
	}

	//Case 1
	private void AddSong() {
		String clave= "";
		Cancion newSong = cargarDatos();
		Integer auxAnho= newSong.getAnho();
		//DEPRECADO YA
		clave= newSong.getTituloC().concat(auxAnho.toString());
		mapaCancion.put(clave, newSong);
		System.out.println("\n�CANCI�N AGREGADA CORRECTAMENTE!\nPRESS ENTER");
	}

	//1.1
	private Cancion cargarDatos() {
		Cancion objCancion= new Cancion();
		//Ingreso del t�tulo
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el t�tulo de la canci�n: ");
				objCancion.setTituloC(data.nextLine());
				objCancion.setTituloC(objCancion.getTituloC().trim().toUpperCase());
				if(objCancion.getTituloC().isBlank() || objCancion.getTituloC().isEmpty()) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (objCancion.getTituloC().isBlank() || objCancion.getTituloC().isEmpty());			
		
		//Ingreso del nombre del artista
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el nombre del artista: ");
				objCancion.setNombreArt(data.nextLine());
				objCancion.setNombreArt(objCancion.getNombreArt().trim().toUpperCase());
				if(objCancion.getNombreArt().isBlank() || objCancion.getNombreArt().isEmpty()) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (objCancion.getNombreArt().isBlank() || objCancion.getNombreArt().isEmpty());	
		
		//Ingreso del nombre del artista
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el �lbum: ");
				objCancion.setAlbum(data.nextLine());
				objCancion.setAlbum(objCancion.getAlbum().trim().toUpperCase());
				if(objCancion.getAlbum().isBlank() || objCancion.getAlbum().isEmpty()) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (objCancion.getAlbum().isBlank() || objCancion.getAlbum().isEmpty());	
		
		//Ingreso del g�nero
		do {
			try {
				data.nextLine();
				System.out.println("\nIngrese el g�nero(rock, folclorico, cl�sica, electr�nica o pop): ");
				objCancion.setGenero(data.nextLine());
				objCancion.setGenero(objCancion.getGenero().trim().toUpperCase());
				if(objCancion.getGenero().isBlank() || objCancion.getGenero().isEmpty() || (!objCancion.getGenero().equalsIgnoreCase("rock") && !objCancion.getGenero().equalsIgnoreCase("folclorico") && !objCancion.getGenero().equalsIgnoreCase("cl�sica") && !objCancion.getGenero().equalsIgnoreCase("electr�nica") && !objCancion.getGenero().equalsIgnoreCase("pop"))) {
					System.err.println("\nDato no admitido. Vuelva a intentar.");
				}	
			} catch (Exception eL) {
				System.err.println(eL.getMessage());
			}	
		} while (objCancion.getGenero().isBlank() || objCancion.getGenero().isEmpty() || (!objCancion.getGenero().equalsIgnoreCase("rock") && !objCancion.getGenero().equalsIgnoreCase("folclorico") && !objCancion.getGenero().equalsIgnoreCase("cl�sica") && !objCancion.getGenero().equalsIgnoreCase("electr�nica") && !objCancion.getGenero().equalsIgnoreCase("pop")));
		
		//Ingreso del a�o
		do { 
			try {
				System.out.println("\nIngrese el a�o: ");
				objCancion.setAnho(data.nextInt());
				
				if(objCancion.getAnho()<=1899) {
					System.err.println("\nCifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("\nEl valor ingresado no es n�merico");
				objCancion.setAnho(1);
			}
			data.nextLine();
		}while(objCancion.getAnho()<=1899);	
		
		
		//Ingreso de la duraci�n
		do { 
			try {
				System.out.println("\nIngrese la duraci�n(En Segundos): ");
				objCancion.setDuracion(data.nextInt());
				
				if(objCancion.getDuracion()<=0) {
					System.err.println("\nCifra no admitida. Vuelva a intentar.");
				}
			} catch (InputMismatchException e) {
				System.err.println("\nEl valor ingresado no es n�merico");
				objCancion.setDuracion(0);
			}
			data.nextLine();
		}while(objCancion.getDuracion()<=0);	
		
		// Ingresar estado
		String estado="";
		do {
			try {
				data.nextLine();
				System.out.println("Ingrese el estado(A=activa, I=inactiva): ");
				estado = data.nextLine();
				estado=estado.toUpperCase();
				if(!estado.equals("A") && !estado.equals("I")) {
					System.err.println("\nCaracter incorrecto. Vuelva a intentar");
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}while(estado.isEmpty() || estado.isBlank() || (!estado.equals("A") && !estado.equals("I")));
		objCancion.setEstado(estado.charAt(0));		

		// Ingresar si es Hit
		String hit = "";
		do {
			System.out.println("\nIngrese si canci�n es Hit (S = si, N = no): ");
			hit = data.nextLine();
			hit=hit.toUpperCase();
			if (!hit.equals("S") && !hit.equals("N")) {
				System.err.println("\nCaracter inv�lido. Intente de nuevo.");
			}
		} while (hit.isEmpty() || hit.isBlank() || (!hit.equals("S") && !hit.equals("N")));		
		objCancion.setEsHit(hit.charAt(0));	
		
		return objCancion;
	}
	
}
