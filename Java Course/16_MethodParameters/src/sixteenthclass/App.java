package sixteenthclass;
 //method that need input variables as parameters
class Robot{
	public void speak(String text) {
		System.out.println(text);
	}
	public void jump(int value) {
		System.out.println("I am jumping: " + value + " meters");
	}
	//WIth multiple parameters
	public void move (String direction, double distance) {
		System.out.println("Moving " + distance + " meters, towards " + direction);
	}
}

public class App {
	public static void main(String[] args) {
		Robot sam = new Robot();
		sam.speak("Hey!");
		sam.jump(8);
		sam.move("north", 12.87);
		String chain = "HEy hey";
		sam.speak(chain);
		int val = 87;
		sam.jump(val);
	}
}
