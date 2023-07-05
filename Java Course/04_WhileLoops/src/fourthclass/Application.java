package fourthclass;

public class Application {
	public static void main(String[] args) {
		int value = 12;
		 long exam = value;
		//boolean loops = value <24;
		
		//System.out.println(loops);
		while (value > 1) {
			System.out.println("Example of this while loops: " + value);
			value=value-1;
			exam=exam + value;
		}
		System.out.println("The consecutive sum from 12 to 2 is: " + (exam-1));
	}
}
