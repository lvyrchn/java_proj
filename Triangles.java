package lab6;

import java.awt.Color;

import sedgewick.StdDraw;

public class Triangles {



	public static void tri(double x, double y, double size) {

		if (size < .01) {		
			return;  // abandon recursion
		}

		StdDraw.setPenColor(Color.WHITE);
		double[] trix = {x, x-size/2, x+size/2};
		double[] triy = {y, y+size/2*Math.sqrt(3),y+size/2*Math.sqrt(3)};
		StdDraw.filledPolygon(trix, triy);
		
		tri(x-size/2, y,size/2);
		tri(x+size/2, y,size/2);
		tri(x,y+size/2*Math.sqrt(3),size/2);

	}

	public static void main(String[] args) {
		StdDraw.setPenColor(Color.BLACK);
		double[] trix = {0, 1, 0.5};
		double[] triy = {0, 0, Math.sqrt(3)/2};
		StdDraw.filledPolygon(trix, triy);
		
		tri(0.5,0,0.5);


	}


}


