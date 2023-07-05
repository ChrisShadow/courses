package twelfthclass;

public class App {
	public static void main(String[] args) {
		//multi-dimensional arrays
		int[][] grid= {
				{0,1,2,3},
				{4,5,6},
				{7,8}
		};
		//System.out.println(grid[2][1]);
		
		
		//Another way
		/*String[][] texts = new String[3][2];
		texts[2][0]="This is a bit confusing"; 
		System.out.println(texts[2][0]);
		*/
		
		//With for loop
		for(int row=0; row<grid.length; row++) {
			for(int col=0; col < grid[row].length; col++) {
				System.out.print(grid[row][col] + "\t");//without the word "In" or System.out.println();
			}
			System.out.println();
		}
	}
}
