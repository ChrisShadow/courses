package Tarea3.Vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import Tarea3.Controlador.*;

public class App {
	public static Scanner data = new Scanner(System.in);

	public static void main(String[] args) {
		OperacionesCancion oP = new OperacionesCancion();
		int op=0;
		System.out.println("Press Enter");
		do {
			try {
				//System.out.println("Press Enter");
				oP.MenuOperaciones();
				//data.nextLine();
				op=1;
			} catch (InputMismatchException e) {
				//String opE= op  RETO DE PODER CAPTUAR LA OPCION LETRA Y MOSTRAR
				System.err.println("\nEl valor ingresado("+op+ ")no es n�merico. Debe ser num�rico");
				op=0;
				data.nextLine();
			}
		} while (op!=1);
		System.out.println("\n**FIN DEL PROGRAMA**");	
		
	}

}
