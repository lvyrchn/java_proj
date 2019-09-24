package arrays;
import cse131.ArgsProcessor;

public class PascalsTriangle {

	public static void main(String[] args) {
		
		// extension to 25 DEMO
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Enter the number of rows of the triangle: ");

		int[][] pascal = new int[N][N];

		for (int r = 0 ; r < N ; r = r + 1) {
			for (int c = 0 ; c < N ; c = c + 1 ) {
				if (c == 0 || c == r) {
					pascal[r][c] = 1;
				}
				else if (r < 0 || c < 0 || c > r) {
					pascal[r][c] = 0;
				}
				else {
					pascal[r][c] = pascal[r-1][c] + pascal[r-1][c-1];
				}	}   }

		System.out.println("        column");
		System.out.print("       ");
		for (int i = 0 ; i < N ; i = i + 1) {
			if(i > 9) {
				System.out.print(i + "  ");

			}
			else {
				System.out.print(" " + i + "  ");
			}}
		System.out.println();
		System.out.println("row");
		for (int r = 0 ; r < N ; r = r + 1) {
			if ( r > 9) {
				System.out.print(r + "     ");
			}
			else {
				System.out.print(" " + r + "     ");
			}
			for (int c = 0 ; c < N ; c = c + 1 ) {
				if(pascal[r][c] != 0) {
					if(pascal[r][c] > 9) {
						System.out.print(pascal[r][c] + "  ");
					}
					else {
						System.out.print(" " + pascal[r][c] + "  ");
					}
				}
			}
			System.out.println();
		}
	}

}
