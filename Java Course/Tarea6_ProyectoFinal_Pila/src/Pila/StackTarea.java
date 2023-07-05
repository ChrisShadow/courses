package Pila;

public class StackTarea {
	private Tareas pila[];
	private int tope; // tope entero
	
	//Constructor vacío
	public StackTarea() {
		this.pila = new Tareas[1]; //Asignación como máximo en caso de no dimesionar el vector tareas
		this.tope = -1; 
	}
	
	//Constructor para definir dimensión según parámetro 
	public StackTarea( int capacidad) {
		this.pila = new Tareas[capacidad];
		this.tope = -1; 
	}

	//Subdesbordamiento
	public boolean estaVacia() {
		return this.tope == -1; // comparar y retornar el tope con -1
	}

	//Desbordamiento
	public boolean pilaLlena() {
		return this.tope == pila.length-1; // comparar y retornar el tope 
	}
	
	public String insertar(Tareas i){
		String error="";
		// Preguntar si la pila no está llena mediante la longitud de la pila
		if(this.pilaLlena()) {
			error=("Pila llena - DESBORDAMIENTO") ;
		}else {
			if (tope  < pila.length) {
				/*tope+=1;
				pila[tope]=i;*/
				pila[++tope] = i; // Asignar elemento al vector
			}
			error="Se ha insertado correctamente: \n"+i.toString();
		}
		return error;
	}

	public Tareas eliminar() throws StackTareasException {
		// Preguntar si la pila está vaciá mediante el método booleano
		if (this.estaVacia()) {
			throw new StackTareasException("Pila vacía - SUBDESBORDAMIENTO") ;
		}
		return pila[tope--]; // En caso contrario, eliminar elemento del vector devolviendo el valor de la posición y decrementando
	}

	//Mostrar pila
	@Override
	public String toString() {
		String detalle="Elemento: \n";
		for (int i = 0; i < pila.length; i++) {
			if(i <= tope) {
				pila[i].CalcularDuracion();
				detalle+=(i+1)+"-) "+pila[i].toString().concat("\n"); // Mostrar atributos de la  tarea
			}
		}
		detalle=detalle.concat("Total de las tareas: " + (tope+1));
		
		return detalle;
	}
	
	//Obtner el ID para no ingresarlo
	public int ObtnerKey() { //Id independiente del puntero
		int key=0;
		if (tope==-1) {
			key=1;
		}else {
			key=pila[tope].IncrementarID();
		}
		
		return key;
	}

	//Getter, obtener la posición del puntero
	public int getTope() {
		return tope;
	}

	
}
