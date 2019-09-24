// Record how the mouse moves 

package mousefollower;

import sedgewick.StdDraw;

public class FollowTheMouse {

	/**
	 * 
	 * @return the x and y coordinate of the mouse currently
	 */
	public static double[] getMousePosition() {
		return new double[] { StdDraw.mouseX(), StdDraw.mouseY() };   
	}
	/**
	 * Draw a ball of radius r at the specified location
	 * @param location the x and y coordinate for the ball
	 * @param r the radius of the ball
	 */
	public static void drawBall(double[] location, double r) {
		StdDraw.filledCircle(location[0], location[1], r);
	}
	/**
	 * 
	 * @param currentBallPosition the location of the ball currently
	 * @param mousePosition the location of the mouse currently
	 * @param speed the speed with which the ball should move toward the mouse
	 * @return the next location of the ball given its current position, the mouse's position, and the speed
	 */
	public static double[] changePosition(double[] currentBallPosition, double[] mousePosition, double speed) {
		double dx = mousePosition[0] - currentBallPosition[0];
		double dy = mousePosition[1] - currentBallPosition[1];		
		double d = Math.sqrt(dx*dx + dy*dy);

		return new double[] {currentBallPosition[0]+speed/d*dx, currentBallPosition[1]+speed/d*dy};
	}

	public static void main(String[] args) {

		double[] oldPosition = new double[] {0.5,0.5};

		while (true) {

			double[] mousePosition = getMousePosition();
			double[] newPosition = changePosition(oldPosition, mousePosition, 0.01);
			drawBall(newPosition,0.02);

			oldPosition = newPosition;

			StdDraw.show(10); 

		}

	}}
