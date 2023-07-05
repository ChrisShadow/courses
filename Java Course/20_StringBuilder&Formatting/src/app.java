import java.util.Iterator;

public class app {

	public static void main(String[] args) {
		//Not always optimal, most of the time it is inefficient.
		String info= "";
		info +="My name is bob.";
		info +=" ";
		info += "I am a builder inefficient";
		
		//System.out.println(info);  
		
		//A more efficient way
		StringBuilder sb= new StringBuilder("");
		sb.append("My name is Pac.");
		sb.append(" ");
		sb.append("I am a shortcut to the efficiency.");		
		
		//System.out.println(sb.toString());
		
		///Formattting ///
		System.out.print("Here goes this letter 'B'\t And below here\n 'C'. ");
		System.out.println("Do you notice?");
		
		System.out.printf("Total cost %d; quantify is %d\n", 5,120);   // la letra d es para números y la cifra para el espacio
		
		for (int i = 0; i < 5; i++) {
			System.out.printf("%s  %-5d \n", "Round: ", i); //la s para cadenas
		}
		
		System.out.printf("Total value with decimals: %20.5f\n", 8.45621478); // la f para decimales y el dígito acompañadoe del punto define la cantidad de decimales a mostrar;
		//mientras que antes del punto, el dígito negativo define el espacio del último dígito a la derecha y el positico del primero a la izquierda
	}

}
