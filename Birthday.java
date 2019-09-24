// Calculate the probability of people born on exactly the same month / day with random birthday

package arrays;
import cse131.ArgsProcessor;

public class Birthday {

	public static void main(String[] args) {

		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Enter the number of people that will enter the room: ");

		int[][] birthday = new int [12][31];

		for (int i = 0 ; i < N ; i = i + 1) {
			int month = (int)(12*Math.random()+1);
			int day = (int)(31*Math.random()+1);
			birthday[month-1][day-1] = birthday[month-1][day-1] + 1;
		}

		// print out the result & format
		System.out.print("  ");
		for (int i = 0; i < 31 ; i = i + 1) {
			if (i <= 8) {
				System.out.print("   " + (i+1));
			}
			else {
				System.out.print("  " + (i+1));

			}			
		}
		System.out.println();
		for (int i = 0; i < 12 ; i = i + 1) {
			if (i <= 8) {
				System.out.print(" " + (i+1) + "  ");
			}
			else {
				System.out.print((i+1) + "  ");

			}
			for (int j = 0; j < 31 ; j = j + 1) {
				if (birthday[i][j] <= 9) {
					System.out.print(" " + birthday[i][j] + "  ");
				}
				else {
					System.out.print(birthday[i][j] + "  ");
				}
			}
			System.out.println();
		}

		System.out.println();

		// the percentage of people born in that month
		double averagePeople = 0.0;
		for (int i = 0; i < 12 ; i = i + 1) {
			int sumPeople = 0;
			for (int j = 0; j < 31 ; j = j + 1) {
				sumPeople = sumPeople + birthday[i][j];
			}

			double fractionPeople = sumPeople*100.0/N;
			System.out.println(fractionPeople + "% of people born in month " + (i+1));
			averagePeople = averagePeople + fractionPeople;
		}
		System.out.println();
		System.out.println("On average, " + averagePeople/12 + "% of people born in each month.");
		System.out.println();

		// the percentage of people born in that day
		double averagePeople1 = 0.0;
		for (int i = 0; i < 31 ; i = i + 1) {
			int sumPeople = 0;
			for (int j = 0; j < 12 ; j = j + 1) {
				sumPeople = sumPeople + birthday[j][i];
			}
			double fractionPeople = sumPeople*100.0/N;
			System.out.println(fractionPeople + "% of people born in day " + (i+1));
			averagePeople1 = averagePeople1 + fractionPeople;
		}
		System.out.println();
		System.out.println("On average, " + averagePeople1/31 + "% of people born in each day.");
		System.out.println();

		// the percentage of people born with same month and day

		double shareTotal = 0.0;
		for (int i = 0 ; i < 12 ; i = i + 1) {
			for (int j = 0 ; j < 31 ; j = j + 1) {
				if (birthday[i][j] > 1 ) {
					double share = (birthday[i][j]-1) * 100.0 / (N-1);
					shareTotal = shareTotal + share;
					System.out.println(share + "% of people born in month " + (i+1) + " day " + (j+1));
				}
			}
		}
		System.out.println();
		System.out.println("On Average, " + shareTotal / 372 + "% of people born on exactly the same day");

	}
}
