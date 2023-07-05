	
class Thing{
		public final static int LUCKY_AGE=36; // las constantes nunca pierden su valor ni pueden ser reasignadas
		public String name; 
		public static String description;
		public static int count=0;
		public int id;
		
		public Thing() { //Constructor que se ejecuta cada vez que se instancie un objeto
			id=count;
			count++;
		}

		public void showName() {
			System.out.println("My id is: "+ id + " and " + description + ": " + name); //Podemos combinar los atributos de la clase
		}
		
		public static void showInfo() {
			System.out.println("Names: ");
		}
	}



public class App {

	public static void main(String[] args) {
		
		Thing.description="I am an object";     //No necesitamos instanciar el objeto para que el atributo pueda ser utilizado mediante la clase directamente
		//System.out.println(Thing.description);
		Thing.showInfo();
		System.out.println("**Before creating the object, the count is: "+ Thing.count +"**");
		
		Thing th = new Thing();
		Thing td = new Thing();
		
		
		th.name="Chris";
		td.name="Cris";
		
		
		//System.out.println(th.name + "\n" + td.name);
		
		//This is another way to display using the method
		th.showName();
		td.showName();
		System.out.println("**After creating the object, the count is: "+ Thing.count+"**");
		System.out.println(Math.PI + " an example of a constant");
		System.out.println("We are both "+ Thing.LUCKY_AGE +" years old(another example but using a static constant)" );

	}

}
