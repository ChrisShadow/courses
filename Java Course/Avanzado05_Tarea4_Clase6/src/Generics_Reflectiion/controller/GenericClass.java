package Generics_Reflectiion.controller;

import java.util.ArrayList;

public class GenericClass<T> {

	
	 /*private ArrayList<T> listaG = new ArrayList<>();
	 
	 //A�adir
	 public void Add(T object){
		 //if (!listaG.isEmpty()){
	            listaG.add(object);
	        //} else {
	           // throw new RuntimeException("No se encontraron datos en la lista: " + object.getClass());
	        //}
	    }  
	 
	 // Solo para agregar la operaci�n contraria de a�adir
	 public <T> T Delete(int i){
		 T objec = null;
		 if (!listaG.isEmpty()){
			 objec=(T) listaG.remove(i);
	        } else {
	            throw new RuntimeException("No se encontraron datos en la lista.");
	        }
		 return (T) objec;
	 } */
	
	 
	 //Calcular el elemento m�nimo de una colecci�n
	 public  <E extends Comparable<E>> E Minimo(E[] lista) {
		 E minimo=lista[0];
		 for (int i = 1; i < lista.length; i++) {
				if (minimo.compareTo(lista[i]) > 0) {
					minimo = lista[i];
				}
			}
		 
		 /*try {
			 minimo = (T) listaG.get(0);
			  int posicion=1;
		        while (posicion <= listaG.size()) {
		        	T t = (T) listaG.get(posicion);
		        	 if (t.compareTo(minimo) < 0)
		        		 minimo = t;
		        	 	posicion++;
				}  
		          
		        /*No es compatible
		        for (T t : listaG) {
		        	 if (t.compareTo(minimo) < 0)
		        		 minimo = t;

				} 
		} catch (Exception e) {
			System.err.println("\nHubo un error de "+e.getMessage());
			minimo = (T) listaG.get(0);
		}*/
		 
	    return minimo;
	    
	    }
	 
	 //Calcular el promedio de una colecci�n
	 public  <T> T Promedio(T[] lista) {
		 	int acumulador=0;
		 	int contador=0;
		 	int resultado=0;
	        T promedio = lista[0];
	        int posicion=0; //puntero de la lista
	        while (posicion < lista.length) {
	        	acumulador+=posicion;
	        	contador++;
	        	posicion++;
			}
	        resultado= (int)(acumulador/contador);
	        promedio = lista[resultado];
	        return promedio;
	    }
	 
	 /*Imprima todos los datos que se encuentran en la colecci�n, excluyendo: 
		-los elementos duplicados
		-el menor elemento
		-el mayor elemento */
	 public <E extends Comparable<E>>  E BusquedaMayor(E[] lista) {
		 	
	        E maximo = lista[0];
	        int posicion=0;
			while (posicion < lista.length) {
	        	//T t = (T) listaG.get(posicion);
	        	 if (maximo.compareTo(lista[posicion]) < 0)
	        		 maximo = lista[posicion];
	        	 	posicion++;

			}
	        return maximo;
	    }
	 
	 public <E> void ImpresionResultados(E[] lista, E minimo, E maximo) {
		 
		 /*E maxi =  maximo;
		 E mini = minimo;*/
		 ArrayList<E> ListaNoDuplicada = new ArrayList<>();
		 int posicion=0;
		 E punteroAnterior = lista[0]; 
		 E punteroSiguiente = null;
		 int listasize=lista.length;
		 
		 Integer arrayBanderasFiltro[][] = new Integer[lista.length][lista.length]; //Matriz 
		
		 
		//Arreglo a cero
		 for (int i = 0; i < arrayBanderasFiltro.length; i++) {
			 for (int j = 0; j < arrayBanderasFiltro.length; j++) {
				 arrayBanderasFiltro[i][j] = 0;
				 
			 }
		 }
		 
		// Proceso para eliminaci�n de valores duplicados
		 while (posicion < lista.length) {

				for (int i = posicion + 1; i < (lista.length - 1); i++) {

					if (posicion < (listasize - 1) && i < (listasize - 1))
						punteroSiguiente = lista[i];

					if (punteroSiguiente.equals(punteroAnterior)) {
						arrayBanderasFiltro[posicion][i] = 1; //Elemento duplicado
						arrayBanderasFiltro[i][posicion]=1;
					}
					/*else {
						arrayBanderasFiltro[contadorBanderas] = 0;
					}*/

				}

				/*if (contadorBanderas == listasize) {
					contadorBanderas = 0;

				} else {
					++contadorBanderas;

				}*/
				
				posicion++;

				if (posicion < listasize)
					punteroAnterior = lista[posicion]; // Actualizar el puntero

			}	
		 posicion= 0;
		 for (int i = 0; i < arrayBanderasFiltro.length; i++) {
			 for (int j = 0; j < arrayBanderasFiltro.length; j++) {
				if(arrayBanderasFiltro[i][j] == 0)
					ListaNoDuplicada.add(lista[posicion]);
				/*
				  * La opci�n para que no se dupliquen los elementos ni devuelva las 49 posiciones, 
				  * en simult�neo, recorrer inversamente las filas. O utilizar Set, hashSet.
				  */
			 }
			 posicion++;
		 }
		 
		// Proceso de eliminaci�n del m�nimo y m�ximo, e IMPRESI�N
		 System.out.println("\nElementos no duplicado, ni elemento m�nimo ni m�ximo de la colecci�n: ");
			listasize = ListaNoDuplicada.size();
			while (posicion < ListaNoDuplicada.size()) {

				punteroSiguiente = ListaNoDuplicada.get(posicion);

				if (punteroSiguiente.equals(maximo))
					ListaNoDuplicada.remove(posicion);

				if (punteroSiguiente.equals(minimo))
					ListaNoDuplicada.remove(posicion);

				if (posicion != listasize) {
					if(!punteroSiguiente.equals(maximo) || !punteroSiguiente.equals(minimo))
						System.out.print("\t" + punteroSiguiente.toString());
				}
				
				posicion++;

			}	
		 /*T punteroSiguiente=null;
		 while (posicion <= listaG.size()) {
			 	if(posicion==listasize)
			 		punteroSiguiente = (T) listaG.get(posicion+1); 
	        	if(!punteroSiguiente.equals(punteroAnterior))
	        		ListaNoDuplicada.add((T) listaG.get(posicion));
	        	posicion++;
	        	punteroAnterior = (T) listaG.get(posicion); //Actualizar el puntero
	        	

			}*
		 
		posicion=0;
		System.out.println("Elementos no duplicado, ni elemento m�nimo ni m�ximo:");
		 while (posicion <= ListaNoDuplicada.size()) {
			 punteroSiguiente = (T) ListaNoDuplicada.get(posicion);
			 if(punteroSiguiente.equals(maximo))
	        		ListaNoDuplicada.remove((T) ListaNoDuplicada.get(posicion));
		
			 if(punteroSiguiente.equals(minimo))
	        		ListaNoDuplicada.remove((T) ListaNoDuplicada.get(posicion));
			 
			 System.out.println(punteroSiguiente.toString());
			 posicion++;
		 }*/
		 
		 
	 }
	 
	/* Buscar un Objeto en una colecci�n, que tenga el siguiente comportamiento:
		 -devolver la posici�n de la primera aparici�n del Objeto en la colecci�n
		 -devolver -1 si no existe*/
	 
	 public <E> int FiltroObjeto(E[] lista, E object) {
		int posicionO=-1;
		int index=0;
		E punteroSiguiente= null;
		int listasize= lista.length;
		
		while (index <= lista.length) {
		 	if(index !=listasize)
		 		punteroSiguiente =  lista[index]; 
        	if(punteroSiguiente.equals(object)) {
        		posicionO= index;
        		break;
        	}
        	index++; 
		}
		
		//posicionO -> {(posicionO= listaG.indexOf(object))};
		 
		return posicionO;
	 }
}
