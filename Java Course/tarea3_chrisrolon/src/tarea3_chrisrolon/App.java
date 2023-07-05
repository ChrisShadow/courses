package tarea3_chrisrolon;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		/*//Ejercicio con vector
		int acuElem =0;//declaramos e inicializamos el acumulador
		int valores[]= new int[5]; //declaramos y dimensionamos el vector
		Scanner teclado = new Scanner(System.in); //Declaramos la variable e instanciamos el objeto Scanner 
		
		System.out.println("Calcular la suma total de valores ingresados por teclado\n");//T�tulo del programa
		
		for(int i=0; i<valores.length; i++) { //declaramos el �dice, establecemos la condici�n para el incremento en la iteraci�n
			System.out.print("Introduce un valor num�rico"+"\n"+"(posici�n["+(i)+"]): "); //Solicitamos la entrada de datos al usuario y mostramos la posici�n de acuerdo al ciclo 
			valores[i] = teclado.nextInt(); //asignamos a la posici�n del vector el dato ingresado
		}
		for(int i=0; i<valores.length; i++) {//iteraci�n para mostrar los valores ingresados 
			System.out.println("Valor "+valores[i] +"; ");
			acuElem +=valores[i];//acumulamos los valores
		}
		System.out.println("La sumatoria de los valores ingresados del vector equivale: "+acuElem+"\n FIN DEL PROCESO");//mostramos el valor final del acumulador
		*/
		
		//Ejerciccio con matriz
		int valores[][]= new int[3][3];//declaramos y dimensionamos la matriz
		Scanner teclado = new Scanner(System.in);//Declaramos la variable e instanciamos el objeto Scanner 
		
		System.out.println("Imprimir elementos mayores a cero de una matriz\n");//T�tulo del programa
		
		for(int row=0; row<valores.length; row++) {//declaramos el �dice de la fila, establecemos la condici�n para el incremento en la iteraci�n
			for(int col=0; col < valores[row].length; col++) {////declaramos el �dice de la columna, establecemos la condici�n para el incremento en la iteraci�n
				System.out.print("Introduce un valor num�rico"+"\n"+"(posici�n["+(row)+","+ col +"]): ");//Solicitamos la entrada de datos al usuario y mostramos la posici�n de acuerdo al ciclo 
				valores[row][col] = teclado.nextInt();//asignamos a la posici�n de la matriz el dato ingresado
				if (valores[row][col]>0) {//Condicionamos si el valor de la posici�n es mayor que CERO
					System.out.println(valores[row][col]+" es mayor a CERO");//En caso de verdadero, mostramos el valor ingresado
				}
				//System.out.print(valores[row][col] + "\t");
				
			}
			//System.out.println();
		}
		System.out.println("\nLa matriz ingresada fue:\n");//Titulo
		for(int row=0; row<valores.length; row++) {//iteraci�n para mostrar la matriz ingresada
			for(int col=0; col < valores[row].length; col++) {
				System.out.print(valores[row][col] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("\n FIN DEL PROCESO");//t�tulo de fin
	}
}


