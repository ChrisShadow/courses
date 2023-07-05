package seventhclass;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		//Scanner object
		Scanner input= new Scanner(System.in); 
		//Output the prompt
		//System.out.println("Enter a line of text: ");
		System.out.println("Enter a double value: ");
		//Data entry
		//String line = input.nextLine();
		double val = input.nextDouble();
		//Show the entered valor
		System.out.println("You entered: " + val);
	}
}
