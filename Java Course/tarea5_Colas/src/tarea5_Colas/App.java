package tarea5_Colas;

//Importar clase de scanner
import java.util.Scanner;

class ColaEntero {
	private int cola[]; // vector entero
	private int numax; // numax entero
	private int fondo; // fondo entero
	private int frente; // numax entero
	

	public ColaEntero(int capacidad) {
		this.cola = new int[capacidad]; // instanciar el vector según parámetro
		this.numax = capacidad; // iniciarlizar la dimensión del vector con el máximo nro de elementos
		this.fondo=0;
		this.frente=0;
	}

	public boolean estaVacia() {
		boolean ban = false; // Inicializar variable booleana
		if(this.frente==0){
			ban=true;
		}
		return ban;
	}

	public boolean estaLlena() {
		boolean ban = false; // Inicializar variable booleana
		if(this.fondo==this.numax){
			ban=true;
		}
		return ban;
	}	

	public void insertar(int data) {
		// Preguntar si existe espacio en la cola
		if (this.fondo < this.numax) {
			this.cola[this.fondo] = data; // Asignar elemento al vector
			this.fondo++;
			if(this.fondo==0){     //Verificar si es el primer elemento 
				this.frente=0;
			}
		}else{
			System.err.println("DESBORDAMIENTO en la Cola, ya se encuentra llena");
		}
	}

	public int eliminar() {
		int data =0;
		// Preguntar si tiene elemento la cola
		if (this.frente != 0) {
			data=this.cola[this.frente]; // Asignar elemento
			if(this.frente==this.fondo){  // Reiniciar Cola
				this.fondo=0;
				this.frente=0;
			}else{
				this.frente++;
			}
		}else{
			System.err.println("SUBDESBORDAMIENTO en la Cola, se encuentra vacía");
		}
		return data;
	}
	
	// Mostar elementos de la cola hasta el tope 
	public String toString() {
		String sms="Elemento: ";
		for (int i = 0; i < cola.length; i++) {
			if(i <= this.numax) {
				sms+=cola[i] +"\t";
			}
		}
		return sms ;
		/*return new String(pila.toString(), 0, tope + 1); // Convertir a cadena el vector tipo entero y el tope*/
	}
}


public class App {

	public static Scanner input = new Scanner(System.in); // Teclado por consola.
	
	public static void main(String[] args) {
		
		
		int capacidad,opcion,elemento;
		
		capacidad= InsertarCapacidad();
		
		//Instaciar la cola
		ColaEntero q= new ColaEntero(capacidad);
		
		//Entrada del menú de operaciones con la cola
		do {
			System.out.println("\n\nEscoga la operación con la cola");
			System.out.println("══════ ══ ═════════ ═══ ══ ════");
			System.out.println();
			System.out.println("1- Insertar Elemento");
			System.out.println("2- Eliminar Elemento");
			System.out.println("3- Mostrar Elemento");
			System.out.println("0- Salir del menu");
			System.out.println();
			System.out.println("Ingrese la opción: ");
			opcion = input.nextInt();
			switch (opcion) {
			case 1: 
				if(q.estaLlena()) {
					System.out.println("La cola ya está llena. Error DESBORDAMIENTO");
				}else {
					System.out.println("Ingrese el elemento a la cola ");
					elemento = input.nextInt();
					q.insertar(elemento);
				}
				break;
			case 2:
				if(q.estaVacia()) {
					System.out.println("La cola está vacía.Error SUBDESBORDAMIENTO");
				}else {
					System.out.println("El frente fue eliminado: "+ q.eliminar());	
				}
				break;
			case 3:
				System.out.println(q.toString());
				break;
			case 0:
				System.out.println("Abandonando cola...");
				break;	
			default:
				System.err.println("Opción no valida " + opcion+ ". Intente de nuevo.");
				break;
			}
		}while(opcion!=0);
		
		System.out.println("FIN DEL PROGRAMA");

		}
		
		public static int InsertarCapacidad(){
			int capacidad=0;
			//Ciclo para validar la capacidad
			do {
				System.out.println("Ingrese la capacidad de la pila: ");
				capacidad = input.nextInt();
				if (capacidad<0) {
					System.err.println("Vuelva a intentar");
				}
			}while(capacidad<0);
			return capacidad;
		}
	}
