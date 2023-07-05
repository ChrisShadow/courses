package fifteenthclass;

class Person{
	String name;
	int age;
	void talk() {
		System.out.println("Hi, It's me " + name);
	}
	//method that returns a value
	int yearsto30() {
		int thirty=30 - age;
		return thirty;
	}
	
	//Get Method
	int getAge() {
		return age;
	}
	String getName() {
		return name;
	}
}

public class App {
	public static void main(String[] args) {
		Person personO = new Person();
		personO.name="Chris";
		personO.age=21;
		//personO.talk();
		int years=personO.yearsto30();
		System.out.println("I'm " + years + " short of 30 years old HAHA");	
		int age = personO.getAge();
		String name = personO.getName();
		System.out.println("My name is " + name + " and I am " + age + " years old.");
	}
}
