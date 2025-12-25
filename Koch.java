/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

		/* 
        StdDraw.setCanvasSize(500, 500);
		StdDraw.setXscale(0, 500);
        StdDraw.setYscale(0, 500);

		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if( n == 0){
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(x1, y1, x2, y2);
		return;
	}
	    StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(x1, y1, x2, y2);
		double p3X = (Math.sqrt(3)/6.0)*(y1 - y2) + 0.5 * (x1 + x2);
		double p3Y = (Math.sqrt(3)/6.0)*(x2 - x1) + 0.5 * (y1 + y2);
		double p4X = (2*x1 + x2) /3.0;
		double p4Y = (2*y1 +y2) /3.0;
		double p5X = (x1 + 2*x2) /3.0;
		double p5Y = (y1 + 2*y2) /3.0;
		StdDraw.line(p4X, p4Y, p3X, p3Y);
		StdDraw.line(p5X, p5Y, p3X, p3Y);
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.line(p4X, p4Y, p5X, p5Y);
		curve(n-1, x1, y1, p4X, p4Y);
		curve(n-1,p4X, p4Y, p3X, p3Y);
		curve(n-1,p3X, p3Y, p5X, p5Y);
		curve(n-1,p5X, p5Y, x2, y2);
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		// Draws a Koch snowflake of depth n
		double x1 = 0.2;
		double y1 = 0.8;
		double x2 = 0.8;
		double y2 = 0.8;
		double x3 = 0.5;
		double height = 0.6 * Math.sqrt(3) / 2.0;
		double y3 = 0.8 - height;
		curve(n, x1, y1, x2, y2);
		curve(n, x2, y2, x3, y3);
		curve(n, x3, y3, x1, y1);
	}
}
