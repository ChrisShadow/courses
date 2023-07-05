package Generics_Reflectiion.vista;

import java.util.Scanner;
import java.util.InputMismatchException;

import Generics_Reflectiion.controller.GenericClass;

public class App {
	
	private static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		
		Integer buscar = 0;
		Integer[] lista = {4,8,9,62,8,4,1};
		// Instanciar clase gen�rica para probar operaciones
		GenericClass<Integer> operaciones1 = new GenericClass<>();

		Integer nroMinimo = operaciones1.Minimo(lista);
		Integer nroMaximo = operaciones1.BusquedaMayor(lista);
		System.out.println("ELEMENTOS DE LA COLECCI�N\n");
		for (Integer puntero : lista) {
			System.out.print("\t" + puntero.toString());
		}
		
		System.out.println("\n\nEl elemento m�nimo es: " + nroMinimo.toString().concat("\nEl elemento m�ximo es: " + nroMaximo.toString()));

		Integer promedio = operaciones1.Promedio(lista);
		System.out.println("\nEl elemento situado en la posici�n media de la lista es: " + promedio.toString());

		operaciones1.ImpresionResultados(lista, nroMaximo, nroMinimo);

		int resultadoBusqueda = operaciones1.FiltroObjeto(lista, 8);
		System.out.println("\nLa posici�n del elemento 8 es: " + (resultadoBusqueda + 1));

		//System.out.println("\nValores de la lista inicial:");
		

		// Pedir a usuario que ingrese elemento a buscar
		do {
			try {
				System.out.println("\nIngrese elemento a buscar (nro. positivo): ");
				buscar = entrada.nextInt();

				if (buscar < 0)
					System.out.println("�Error! Ingrese de nuevo.");

			} catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				buscar = -1;
			}

		} while (buscar < 0);

		// Impresi�n b�squeda personalizada
		resultadoBusqueda = operaciones1.FiltroObjeto(lista, buscar);
		
		if (resultadoBusqueda == -1)
			System.out.println("\nResultado de la posici�n del elemnto ingresado por el usuario: " + (resultadoBusqueda));

		if (resultadoBusqueda != -1)
			System.out.println("\nResultado de la posici�n del elemnto ingresado por el usuario: " + (resultadoBusqueda + 1));
		
		System.out.println("\n***PROGRAMA FINALIZADO***");	
	}

}
