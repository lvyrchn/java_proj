package lab4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class BumpingBalls {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Enter the number of balls: ");
		//int I = ap.nextInt("Enter the number of iterations: ");

		StdDraw.setXscale(-1.0, 1.0);
		StdDraw.setYscale(-1.0, 1.0);

		double r = 0.05;

		double[][] position = new double[N][2];

		for (int i = 0 ; i < N ; i = i + 1) {
			position[i][0] = (2*Math.random()-1);
			position[i][1] = (2*Math.random()-1);
			//StdDraw.setPenColor(Color.PINK);
			//StdDraw.filledCircle(position[i][0],position[i][1], r);
		}

		double[][] velocity = new double[N][2];

		for (int i = 0 ; i < N ; i = i + 1) {
			velocity[i][0] = 0.025;
			velocity[i][1] = 0.025;
		}


		double[][] distance = new double[N][N];




		for (int i = 0 ; i < N ; i = i + 1) {

			for (int j = 0 ; j < N ; j = j + 1) {

			}
		}



		while (true) {
			StdDraw.clear();
			for (int i = 0 ; i < N ; i = i + 1) {

				if((Math.abs(position[i][0] + velocity[i][0]) > 1.0 - r)){
					velocity[i][0] = -velocity[i][0];
				}
				if((Math.abs(position[i][1] + velocity[i][1]) > 1.0 - r)){
					velocity[i][1] = -velocity[i][1];
				}


				for (int a = 0 ; a < N ; a = a + 1) {
					for (int b = 0 ; b < N ; b = b + 1) {
						if (a != b) {
						double xDist = position[a][0]+velocity[a][0]-position[b][0]-velocity[b][0];
						double yDist = position[a][1]+velocity[a][1]-position[b][1]-velocity[b][1];
						distance[a][b] = Math.pow(xDist*xDist + yDist*yDist, 0.5);

						if (distance[a][b] < 2*r) {
							velocity[i][0] = -velocity[i][0];
							velocity[i][1] = -velocity[i][1];
						}}
					}
				}
			
				
		

				position[i][0] = position[i][0] + velocity[i][0];		
				position[i][1] = position[i][1] + velocity[i][1];

				StdDraw.setPenColor(Color.PINK);
				StdDraw.filledCircle(position[i][0],position[i][1], r);

			}
			StdDraw.show(20); 


			//StdDraw.clear();

			//	StdDraw.setPenColor(StdDraw.GRAY);
			//	StdDraw.filledSquare(0, 0, 1.0);



		}




		/*
		double rx1 = 2*Math.random()-1;
		double ry1 = 2*Math.random()-1;

		double rx2 = 2*Math.random()-1;
		double ry2 = 2*Math.random()-1;

		double vx1 = 0.1;
		double vy1 = 0.1;

		double vx2 = 0.05;
		double vy2 = 0.05;


		while (true) {

			double dx = Math.abs(rx1-rx2);
			double dy = Math.abs(ry1-ry2);


			if (Math.abs(rx1 + vx1) > 1.0 - r || (dx <= 2*r && dy <= 2*r ) ) {
				vx1 = -vx1;
			}
			if (Math.abs(ry1 + vy1) > 1.0 - r || (dx <= 2*r && dy <= 2*r )) {
				vy1 = -vy1;
			}

			if (Math.abs(rx2 + vx2) > 1.0 - r || (dx <= 2*r && dy <= 2*r)) {
				vx2 = -vx2;
			}
			if (Math.abs(ry2 + vy2) > 1.0 - r || (dx <= 2*r && dy <= 2*r)) {
				vy2 = -vy2;
			}


			// update position
			rx1 = rx1 + vx1; 
			ry1 = ry1 + vy1; 


			rx2 = rx2 + vx2; 
			ry2 = ry2 + vy2; 


			StdDraw.clear();

			StdDraw.setPenColor(Color.PINK);
			StdDraw.filledCircle(rx1,ry1, r);
			StdDraw.filledCircle(rx2,ry2, r);
			StdDraw.show(200); 


			//double[] histX = new double[N];
			//double[] histY = new double[N];
		}
		 */
	}
}

