package sixthclass;

public class Application {
	public static void main(String[] args) {
		//boolean cond = 3 != 2;
		//boolean cond = 3 == 2;
		//int me=21;
		//if(me>30) {
			//System.out.println("Correct and 4-4: "+ (4-4));
		//}
		//when both clauses are true, it only enters the first clause to the exclusion of the following clauses
		//else {
		//else if(me<2) {
			//System.out.println("They're different");
		//}
		//else {
			//System.out.println("none of the above");
		//}
		//System.out.println(cond);
		int loop=0;
		while(true) { //infinite loop
			System.out.println("Looping: " + loop);
			if(loop==5) { //here is the condition
				break;
			}
			loop++;
			System.out.println("Running");
		}
	}
}
