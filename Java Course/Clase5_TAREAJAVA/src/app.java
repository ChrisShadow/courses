
import java.util.Scanner;

public class app {
	public static Scanner input = new Scanner (System.in); // Teclado por consola. 
	
	public static void main(String[] args) {
		//Entrada de Datos
		
		//LONGITUD
		System.out.println("Ingrese la longitud(en metros): ");
		double longitud = input.nextDouble();
		
		//Área
		System.out.println("Ingrese el área(en kilómetros cuadrados): ");
		double area = input.nextDouble();
		
		//Volumen
		System.out.println("Ingrese el volumen(en mililitros): ");
		double volu = input.nextDouble();
		
		//Tiempo
		System.out.println("Ingrese el tiempo(en horas): ");
		int tiempo = input.nextInt();
		
		//Masa
		System.out.println("Ingrese la masa(en kilogramos): ");
		double masa = input.nextDouble();
		
		
		//Cálculos
		System.out.println("...RESULTADO DE LAS IMPRESIONES...");
		
		//LONGITUD
		double resullongitud= longitud/100;
		System.out.println("\n"+longitud+" metros --> "+resullongitud+" hectómetros");
		
		//Área
		double resultadoarea= area*100;
		System.out.println("\n"+area+" km^2 --> "+resultadoarea+" hectáreas");	
		
		//Volumen
		double resulvolum=volu/1000;
		System.out.println("\n"+volu+" mililitros --> "+resulvolum+" litros");	
		
		//Tiempo
		int resultiempo=tiempo*3600;
		System.out.println("\n"+tiempo+" horas --> "+resultiempo+" segundos");
		
		////Masa
		double resulmasa=masa*1000;
		System.out.println("\n"+masa+" kilogramos --> "+resulmasa+" gramos \n FIN DEL PROGRAMA");
	}
}
