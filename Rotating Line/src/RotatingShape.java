/**
 * @author Shirley Xu
 * Created: 02/23/16
 */

/*
 * This class creates an abstract rotating shape
 */

abstract public class RotatingShape { 
	private int originX, originY;
	private double angle;
	
	//Getters and setters for the private data
	
	public int getOriginX() {
		return originX;
	}

	public void setOriginX(int originX) {
		this.originX = originX;
	}

	public int getOriginY() {
		return originY;
	}

	public void setOriginY(int originY) {
		this.originY = originY;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	
	//Constructor
	public RotatingShape(int originX, int originY, double angle){
		//Relative origin
		this.originX = originX;
		this.originY = originY;
		//Current angle of line
		this.angle = angle;
	}
	
	//Converts two given points to a polar coordinate relative to the second point
	public static double[] toPolar(int x, int y, int originX, int originY){
		double[] coords = {0,0};
		
		//Radius
		coords[0] = Math.sqrt((originX-x)*(originX-x)+(originY-y)*(originY-y));
		
		//Theta
		//if (x != 0) 
		coords[1] = Math.atan(y/x);
		
		return coords;
	}
	
	//Converts a point into a polar coordinate relative to (0,0)
	public static double[] toPolar(int x, int y){
		double[] coords = {0,0};
		
		//Radius
		coords[0] = Math.sqrt(x*x+y*y);
		
		//Theta
		//if (x != 0) 
		coords[1] = Math.atan(y/x);
		
		return coords;
	}
	
	//Converts the origin into a polar coordinate relative to the origin
	public double[] toPolar(){
		return toPolar(originX, originY);
	}
	
	//Converts the polar point into a Cartesian point with a specified degree of rotation
	/**
	 * @param length
	 * The length of line coming from origin
	 * @param theta
	 * The specified degree of rotation
	 * @return coords
	 * array of 2 ints
	 */
	public static int[] toCartesian(double length, double theta){
		int[] coords = {0,0};
		
		//X
		coords[0] = (int)(length * Math.cos(theta));
		
		//Y
		coords[1] = (int)(length * Math.sin(theta));
		
		return coords;
	}
	
	//Converts the polar point into a Cartesian point
	/**
	 * @param length
	 * The length of the line coming from origin
	 * @return
	 * The Cartesian coordinate of the point relative to the origin
	 */
	public int[] toCartesian(double length){
		return toCartesian(length, angle);
	}
	
	//Converts an array to a string
	/**
	 * @param js
	 * The array of values to be converted
	 * @return
	 * The array as a string
	 */
	public static String arrayToString(int[] js){
		String result = "";
		for(int i = 0; i < js.length; i++){
			result += js[i] + " ";
		}
		return result;
	}
	
	//Rotates the line
	/**
	 * @param radians
	 * The radians to rotate by
	 */
	public void rotate(double radians){
		angle += radians;
	}
	
	abstract int[] getCoords();

}
