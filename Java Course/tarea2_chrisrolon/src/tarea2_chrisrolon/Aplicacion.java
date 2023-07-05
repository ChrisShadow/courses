package tarea2_chrisrolon;

import java.util.Scanner; //Importar el paquete util con la clase para las solicitud de entrada de dato

import javax.swing.JOptionPane; //Importar el paquete javax con la clase para las solicitud de entrada de dato mediante ventana de diálogo

public class Aplicacion {
	public static void main(String[] args) {
		//Ejemplo con tipos de datos pero resaltando el tipo Char o Caracter
		
		 String texto=JOptionPane.showInputDialog("Introduce un codigo de la tabla ASCII"); 
		 //Declaramos la variable tipo cadena y lo inicializamos instaciando como objeto de la clase importada con el mensaje para el usuario
		 
	        //Pasamos la variable al tipo de dato entero, declarando e inicializando la nueva variable
	        int codigo=Integer.parseInt(texto);
	 
	        //Pasamos la variable2 al tipo de dato caracter o char, declarando e inicializando la tercera variable
	        char caracter=(char)codigo;
	        
	        //Mostramos el valor que contiene la variable de tipo char
	        System.out.println(caracter);
		
		
		//Ejemplo con tipo de dato entero
		
		/*//Declaramos la variable tipo largo (solo para variar) y lo inicializamos a 0, será un acumulador
		long ex=0;
		
		//creamos el bloque de iteración, declarando la variable de tipo entero e inicializando a 0
		//comparamos la variable si es menor a límite para que incremente 1 cada vez que sea verdadero
		for (int chris=0; chris<5; chris++) {
			//System.out.println("Round number: " + chris);
			
			//Cada vez que se cumpla la condición, imprimir la variable tipo entero como indicador de ronda
			System.out.printf("Round number: %d\n" + " ", chris);
			
			//Acumular la variable tipo long con el valor de la variable tipo entero
			ex=ex+chris;
		}
		
		//Una vez la condición sea falsa, imprimir el valor del acumulador
		System.out.println("The consecutive sums from 0 to 4 is: " + ex);*/
		
		
		//Ejemplo con el tipo de dato booleano
		
		/*int dato; //declararamos la veriable tipo entero para la estructura repetitiva con condición final
        boolean todoCorrecto; //declaramos la variable de tipo booleana
        Scanner teclado = new Scanner(System.in); //instanciamos como objeto la variable de la clase Scanner para la solicitud de entrada de dato
 
        do //iniciamos el ciclo con la palabera reservada para que se ejecute al menos una vez la instrucción dentro del ciclo
        {
            System.out.print("Introduce un dato del 0 al 10: "); //solicitamos la entrada de dato al usuario estableciendo el rango
            dato = teclado.nextInt(); //inicializamos la variable para la entrada de dato
            todoCorrecto = (dato >= 0) && (dato <= 10); // inicializamos la variable boleana como verdadero estableciedo la condición, respetando el rango establecido
            if ( ! todoCorrecto )// Preguntamos si se cumple la negación del valor de la variable inicializada
                System.out.println("No es válido!");//mostramos el mensaje de error 
        }
        while ( ! todoCorrecto ); //establecemos la condición de fin 
        System.out.println("Es válido"); //mostramos el mensaje una vez la condición deje de cumplirse*/
		
		
		//Ejemplo con el tipo de dato cadena
		
		
		/*String text="HELL's"; //declaramos e inicializamos la variable de tipo cadena
		String blank= " "; //declaramos e inicializamos la variable de tipo cadena
		String descrip= "hot"; //declaramos e inicializamos la variable de tipo cadena
		String example= text + blank + descrip; //declaramos e inicializamos la variable de tipo cadena concatenando los valores de las variables anteriores
		
		System.out.println(example);//mostramos el valor de la variable contenedora de los valores de la previas variables
		System.out.println("Hell's" + " " +  "quite hot!");//Simplemente concatenamos las palabras a la hora de mostrar en pantalla*/
	}
}
