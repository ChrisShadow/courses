package thirteenthclass;

//An example of creating class

class Person{
	//Instance variable (data or "state")
	String name;
	int age;
	void speak() {
		System.out.println("Hello! My name is " + name + " and I am " + age + " years old");
	}	
	//Class can contain: data, subroutiones (methods)
}

class Couple{
	String members;
	int age;
	Double currentYe;
	void countmyage() {
		System.out.println("We are " + members + ". This year we have been married for " + age +" years.");
	}
}


public class App {
	public static void main(String[] args) {
		Person personO = new Person();
		personO.name="Chris Bene";
		personO.age=21;
		personO.speak();
		
		Person personT= new Person();
		personT.name="Ayelen Barua";
		personT.age=21;
		personT.speak();
		
		Couple lovely= new Couple();
		lovely.members="Chris and Ayelen";
		lovely.age= 2;
		lovely.currentYe= 2.021;
		lovely.countmyage();
	}
}
