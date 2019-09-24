// Implement Linear Regression

package regression;

import sedgewick.StdIn;

public class LinearRegression {
	
	public static double slope = 0;
	public static double intercept = 0;

	public static void learn() {
		double [] data = StdIn.readDoubles();
		double xsum = 0;
		double xy = 0;
		double ysum = 0;
		double x2 = 0;
		int n = data.length / 2;
		for (int i = 0; i < n; ++i) {
			xsum += data[i*2];
			ysum += data[i*2+1];
			x2 += Math.pow(data[i*2], 2);
			xy += data[i*2] * data[i*2+1];
		}
		double m = (xy/n-xsum/n*ysum/n)/(x2/n-Math.pow(xsum/n, 2));
		double b = ysum/n-m*xsum/n;
		slope = m;
		intercept = b;
	}
	/**
	 * This method should return the predicted value of a home of a given square footage.
	 * @param squareFeet the square footage of the house you want to predict the price of
	 * @return the estimated price of the house
	 */
	public static double predictPrice(double squareFeet) {
		return squareFeet*slope + intercept;
	}
}
