package seventeenthclass;

class Frog{
	/*private*/ String name;
	/*private*/ int age;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	//encapsulation
	public void setName(String newName) {
		//name=newName;
		this.name=newName;
	}
	public void setAge(int newAge) {
		//age=newAge;
		this.age=newAge;
	}
	public void setInfo(String name, int age) {
		setName(name);
		setAge(age);
		System.out.println("Her name is " + name + " and her age " + age);
	} 
}



public class App {
	public static void main(String[] args) {
		Frog frogO = new Frog();
		frogO.name="Pepe";
		frogO.age=12;
		//System.out.println(frogO.getName() + "\n" + frogO.getAge());
		
		frogO.setAge(12);
		frogO.setName("Pop");
		
		frogO.setInfo("Els",5);
	}
}
