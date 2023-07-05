
public class Car extends Machine { //para extender todo el contenido de Machine a Car
	/*public void start() { //tambi�n es posible sobreescribir un m�todo, coicidiendo la parte m�s alta del nombre entre ambas clases. 
		System.out.println("Car Started");
	}*/
	
	@Override
	public void start() { //Tambi�n es posible utilizando la opci�n source y overrides
		System.out.println("Car Started");
	}

	public void WipeWindShield() {
		System.out.println("Now it is cleaner");
	}
	
	/*public void ShowInfo() {
		System.out.println("Car's name: " + name);
	}*/ //El atributo nombre es privado
	
	public void ShowInfo() {
	System.out.println("Car's name: " + name);
	}
}
