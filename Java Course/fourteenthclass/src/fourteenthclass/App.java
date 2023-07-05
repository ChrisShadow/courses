package fourteenthclass;

import thirteenthclass.Couple;
import thirteenthclass.Person;

//An example of creating class

class Person{
	//Instance variable (data or "state")
	String name;
	int age;
	
	//Class can contain: data, subroutiones (methods)
}

class Couple{
	String members;
	int age;
	Double currentYe;
}

//Basic body of a method
void speak() {
	System.out.println("Hello!");
}


public class App {
	public static void main(String[] args) {
		Person personO = new Person();
		personO.name="Chris Bene";
		personO.age=21;
		
		Person personT= new Person();
		personT.name="Ayelen Barua";
		personT.age=21;
		
		Couple lovely= new Couple();
		lovely.members="Chris and Ayelen";
		lovely.age= 2;
		lovely.currentYe= 2.021;
	}
}
