/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		StdDraw.setCanvasSize(700, 700);
		StdDraw.setXscale(0, 700);
        StdDraw.setYscale(0, 700);
		sierpinski(Integer.parseInt(args[0]));
			 
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(50, 50, 570, 50);
		StdDraw.line(50, 50, 310, 500);
		StdDraw.line(570, 50, 310, 500);

	sierpinski(n, 50, 310, 570, 50, 500, 50);
	}

	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {

	if( n == 0){
		return;
	}
	double cordinateX1 = x2;
	double cordinateY1 = y1;
	double cordinateX2 = (x1 + x2) /2;
	double cordinateY2 = (y2 + y1)/2;
	double cordinateX3 = (x3 + x2) /2;
	double cordinateY3 = (y2 + y1)/2;
	//StdDraw.setPenColor(StdDraw.BLACK);
	StdDraw.line(cordinateX1, cordinateY1, cordinateX3, cordinateY3);
	StdDraw.line(cordinateX1, cordinateY1, cordinateX2, cordinateY2);
	StdDraw.line(cordinateX3, cordinateY3, cordinateX2, cordinateY2);
	sierpinski(n-1, x1, cordinateX2,cordinateX1, y1, cordinateY2, cordinateY1);
	sierpinski(n-1, cordinateX2, x2, cordinateX3, cordinateY2, y2, cordinateY3);
	sierpinski(n-1, cordinateX1, cordinateX3, x3, cordinateY1,  cordinateY3, y3);

	}
}
