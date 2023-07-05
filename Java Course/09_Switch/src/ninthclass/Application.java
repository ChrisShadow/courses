package ninthclass;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.println("Enter an option (C,R,U or D): ");
		String text = input.nextLine();
		switch(text) {
		case "C":
			System.out.println("You chose the CREATE option");
			break;
		case "R":
			System.out.println("You chose the READ option");
			break;
		case "U":
			System.out.println("You chose the UPDATE option");
			break;
		case "D":
			System.out.println("You chose the DELETE option");
			break;
		default:
			System.out.println("Command not recognized");
		}
	}
}
