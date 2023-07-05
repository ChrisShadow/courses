
public class App {

	public static void main(String[] args) {
	
		Machine mac= new Machine();
		Car ca= new Car();
		
		System.out.println("Machine's object");
		mac.start();
		mac.stop(); 
		System.out.println("Car's object");
		ca.start();
		ca.WipeWindShield();
		ca.ShowInfo();
		ca.stop();
	}

}
