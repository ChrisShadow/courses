package fifthclass;

public class Application {
	public static void main(String[] args) {
		long ex=0;
		for (int chris=0; chris<5; chris++) {
			//System.out.println("Round number: " + chris);
			System.out.printf("Round number: %d\n" + " ", chris);
			ex=ex+chris;
		}
		System.out.println("The consecutive sums from 0 to 4 are: " + ex);
	}
}
