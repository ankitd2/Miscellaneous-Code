/**
 * @author 16xus
 *
 */

/*
 * This class generates a line that rotates. 
 * It inherits the origin coordinates and angle from the abstract RotatingShape class.
 */
public class RotatingLine extends RotatingShape {
	
	private double length;
	
	//Getters and setters
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	//Constructors
	/*
	 * A rotating line can be made from a length, an origin, and an angle; if length is not given, the default is 10
	 * If no parameters are given, the default constructor makes a line of length 10 at (40,40)
	 */
	public RotatingLine(int originX, int originY, double angle) {
		super(originX, originY, angle);
		this.length = 10;
		// TODO Auto-generated constructor stub
	}
	
	public RotatingLine(double length, int originX, int originY, double angle){
		super(originX, originY, angle);
		this.length = length;
	}
	
	public RotatingLine(){
		this(10, 40, 40, Math.PI);
	}

	/*
	 * ToString that allows printing of length, origin coordinates, and angle (in radians)
	 */
	
	@Override
	public String toString() {
		return "Length: " + length + ", X-origin: " + getOriginX() + ", Y-origin: " + getOriginY() + ", Angle: " + getAngle();
	}
	
	//Gets the coordinates of the endpoints of the line via the origin and the line's properties.
	public int[] getCoords(){
		int[] coords = {0,0,0,0};
		int[] cartesian = toCartesian(length);
		coords[0] = getOriginX() - cartesian[0];
		coords[1] = getOriginY() - cartesian[1];
		coords[2] = getOriginX() + cartesian[0];
		coords[3] = getOriginY() + cartesian[1];
		return coords;
	}
	
	//Main to test code
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotatingLine test = new RotatingLine();
		RotatingLine test2 = new RotatingLine(0,5,5,0);
		RotatingLine test3 = new RotatingLine(10*Math.sqrt(2),5,5,Math.PI / 2);
		System.out.println("Line 1");
		System.out.println(test);
		System.out.println(arrayToString(test.toCartesian(test.length)));
		System.out.println(arrayToString(test.getCoords()));
		System.out.println("\nLine 2");
		System.out.println(test2);
		System.out.println(arrayToString(test2.toCartesian(test2.length)));
		System.out.println(arrayToString(test2.getCoords()));
		System.out.println("\nLine 3");
		System.out.println(test3);
		System.out.println(arrayToString(test3.toCartesian(test3.length)));
		System.out.println(arrayToString(test3.getCoords()));
		test.rotate(Math.PI);
		System.out.println("\nLine 1 rotated by 1 radian");
		System.out.println(test);
		System.out.println(arrayToString(test.toCartesian(test.length)));
		System.out.println(arrayToString(test.getCoords()));
		test.rotate(Math.PI/2);
		System.out.println("\nLine 1 rotated by 1/2 radian");
		System.out.println(test);
		System.out.println(arrayToString(test.toCartesian(test.length)));
		System.out.println(arrayToString(test.getCoords()));
		System.out.println(test.getCoords()[1]);
	}

}
