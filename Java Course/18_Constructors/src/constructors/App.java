package constructors;

class Machine{
	private String name;
	private int code;
	
	//A constructor is executed each time the object is instantiated.
	public Machine(){
		System.out.println("The name of the constructor must always be the same as the object name");
		name= "Ferrari";
	}
	public Machine(String name) {
		this.name=name;
		System.out.println("This is an example of constructor that can contains parameters. The name is " + name);
	}
	public Machine(String name, int code) {
		this.name=name;
		this.code=code;
		System.out.println("The name is "+ name + " and its code is " + code);
	}
}

public class App {
	public static void main(String[] args) {
		Machine machineO= new Machine();
		Machine machineT= new Machine("Lamborghini");
		Machine machineTh= new Machine("JOn",9);
	}
}
