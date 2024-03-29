// Create a Persian Rug with patterns 

package recursivepatterns;

import java.awt.Color;
import sedgewick.*;

public class PersianRug {

	private static int getColor(int north, int east, int south, int west) {

		int index = 0; 
		if (north + east + south + west == 0) {
			index = 11;
		}
		if (north + east + south + west == 22) {
			index = 10;
		}
		if (north + east + south + west == 10) {
			index = 4;
		}
		
		return index;
	}

	/**
	 * 
	 * @param palette an array of Colors to choose from
	 * @param llx lower left x coordinate of this rug square
	 * @param lly lower left y coordinate of this rug square
	 * @param size width (and therefore also height) of this rug square
	 * @param north color index of the north side of this rug square
	 * @param east color index of the east side of this rug square
	 * @param south color index of the south side of this rug square
	 * @param west color index of the west side of this rug square
	 */
	private static void persianRug(
			Color[] palette, 
			double llx, double lly,
			double size, 
			int north, int east, int south, int west) {

		if (size < .005) {		
			return;  
		}

		int colorIndex = getColor(north,east,south,west);
		Color color = palette[colorIndex];
		StdDraw.setPenColor(color);

		StdDraw.line(llx, lly+size/2, llx+size, lly+size/2);
		StdDraw.line(llx+size/2, lly, llx+size/2, lly+size);
	
		persianRug(palette,llx,lly,size/2,colorIndex,colorIndex,south,west);
		persianRug(palette,llx,lly+size/2,size/2,north,colorIndex,colorIndex,west);
		persianRug(palette,llx+size/2,lly,size/2,colorIndex,east,south,colorIndex);
		persianRug(palette,llx+size/2,lly+size/2,size/2,north,east,colorIndex,colorIndex);


	}

	public static void main(String args[]) {

		StdDraw.show(10);  

		//
		// Generate a palette of colors
		//
		Color[] palette = { StdDraw.BLUE, StdDraw.CYAN, StdDraw.DARK_GRAY,
				StdDraw.GRAY, StdDraw.GREEN, StdDraw.LIGHT_GRAY,
				StdDraw.MAGENTA, StdDraw.ORANGE, StdDraw.PINK, StdDraw.RED,
				StdDraw.WHITE, StdDraw.YELLOW };
		//
		// Draw the outermost square as a special case
		// Use color 0 for that
		//
		StdDraw.setPenColor(palette[0]);
		StdDraw.line(0, 0, 1, 0);
		StdDraw.line(1, 0, 1, 1);
		StdDraw.line(1, 1, 0, 1);
		StdDraw.line(0, 1, 0, 0);

		//
		// Kick off the recursion
		// Lower left is point (0,0)
		// Size of the square is 1
		// The color index of each surrounding side is 0
		//
		persianRug(palette, 0, 0, 1, 0, 0, 0, 0);
		

		StdDraw.show(10);
		
	}

}
