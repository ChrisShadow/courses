package PRINCIPAL;

//Importar clase de scanner
import java.util.Scanner;

class PilaEntero {
	private int pila[]; // vector entero
	private int tope; // tope entero

	public PilaEntero(int capacidad) {
		this.pila = new int[capacidad]; // instanciar el vector según parámetro
		this.tope = -1; // iniciarlizar tope
	}

	public boolean estaVacia() {
		return this.tope == -1; // comparar y retornar el tope con -1
	}

	public void insertar(int i) {
		// Preguntar si la pila no está llena mediante la longitud de la pila
		if (tope + 1 < pila.length) {
			pila[++tope] = i; // Asignar elemento al vector
		}
	}

	public int eliminar() {
		// Preguntar si la pila está vaciá mediante el método booleano
		if (this.estaVacia()) {
			return 0; // Retornar 0
		}
		return pila[tope--]; // En caso contrario, eliminar elemento del vector
	}
	
	//Mostar elementos de la pila hasta el tope 
	public String toString() {
		String sms="Elemento: ";
		for (int i = 0; i < pila.length; i++) {
			if(i <= tope) {
				sms+=pila[i] +"\t";
			}
		}
		return sms ;
		/*return new String(pila.toString(), 0, tope + 1); // Convertir a cadena el vector tipo entero y el tope*/
	}
}

public class app {
	public static Scanner input = new Scanner(System.in); // Teclado por consola.

	public static void main(String[] args) {
	int capacidad,opcion,elemento,cont=0;
	
	//Ciclo para validar la capacidad
	do {
		System.out.println("Ingrese la capacidad de la pila: ");
		capacidad = input.nextInt();
		if (capacidad<0) {
			System.err.println("Vuelva a intentar");
		}
	}while(capacidad<0);
	
	//Instaciar la pila
	PilaEntero pila= new PilaEntero(capacidad);
	
	//Entrada del menú de operaciones con la pila
	do {
		System.out.println("\n\nEscoga la operación con la pila");
		System.out.println("══════ ══ ═════════ ═══ ══ ════");
		System.out.println();
		System.out.println("1- Insertar Elemento");
		System.out.println("2- Eliminar Elemento");
		System.out.println("3- Mostrar Pila");
		System.out.println("0- Salir del menu");
		System.out.println();
		System.out.println("Ingrese la opción: ");
		opcion = input.nextInt();
		switch (opcion) {
		case 1: 
			if(cont==capacidad) {
				System.out.println("La pila ya está llena. Error DESBORDAMIENTO");
			}else {
				System.out.println("Ingrese el elemento de la pila ");
				elemento = input.nextInt();
				pila.insertar(elemento);
				cont++;
			}
			break;
		case 2:
			if(pila.eliminar()==0) {
				System.out.println("La pila está vacía.Error SUBDESBORDAMIENTO");
			}else {
				System.out.println("El tope eliminado fue: "+ pila.eliminar());	
			}
			break;
		case 3:
			System.out.println(pila.toString());
			break;
		case 0:
			System.out.println("Abandonando Pila...");
			break;	
		default:
			System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
			break;
		}
	}while(opcion!=0);
	
	System.out.println("FIN DEL PROGRAMA");

	}
}
