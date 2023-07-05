class Frog {
	public int id;
	public String name;
	
	//
	public Frog(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		//return id + ": " + name; 
		//Another way more efficiently
		
		/*StringBuilder sb = new StringBuilder();
		sb.append(id).append(": ").append(name);
		return sb.toString();*/
		
		//or
		return String.format("%-1d: %s", id, name);
	}
	
	
	
	
	
}


public class App {

	public static void main(String[] args) {
		Frog fr1= new Frog(01,"pete");
		Frog fr2= new Frog(02,"peter");
		
		
		System.out.println(fr1 + "\n" + fr2);
	}

}
