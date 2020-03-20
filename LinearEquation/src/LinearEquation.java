/*
 * LinearEquation.java
 * 
 * Objects of this class represent mathematical linear equations
 * in the form of y = mx + b from the Cartesian coordinate system. 
 * Any oblique or horizontal line can be represented, but not 
 * vertical lines.
 *
 * A LinearEquation can be constructed by either using the slope 
 * and y-intercept or two distinct, non-vertical points. Should a 
 * user of this class give two points with the same x-value to the
 * 4-parameter constructor, he/she may get unpredictable results, 
 * possibly resulting in a slope or y-intercept of 'infinity' or 
 * getting an exception.
 *
 * Created 9/17/2015
 * updated 9/22/2015
 */
public class LinearEquation {

	// data fields
	private double slope;
	private double yIntercept;
	
	// constructors
	
	/*
	 * Constructs a Linearequation based on a slope and y-intercept
	 * 
	 * Parameters:
	 *   double m = the slope of the line
	 *   double b = the y-intercept of the line
	 */
	public LinearEquation(double slope, double yInt){
		this.slope = slope;
		yIntercept = yInt;
	}
	
	/*
	 * Default ctor which creates the line y = x
	 */
	public LinearEquation(){
		slope = 1;
		yIntercept = 0;
	}
	
	/*
	 * Constructs a LinearEquation based on 2 sets of ordered pairs
	 * 
	 * Parameters:
	 *   double x1 = the x-coordinate of the first ordered pair
	 *   double y1 = the y-coordinate of the first ordered pair
	 *   double x2 = the x-coordinate of the second ordered pair
	 *   double y2 = the y-coordinate of the second ordered pair
	 */
	public LinearEquation(double x1, double y1, double x2, double y2){
		slope = (y2 - y1) / (x2 - x1);
		yIntercept = y1 - slope * x1;
	}
	
	
	/*
	 * Creates a String representation of the LinearEquation object
	 * 
	 * Returns: String in "y = mx + b" form
	 */
	public String toString(){
		String str = "y = ";
		
		str = str + slope;
		str += "x + "; // equivalent to: str = str + "x + ";
		str += yIntercept;
		
		return str;
		
		// or: return "y = " + slope + "x + " + yIntercept;
	}
	
	/*
	 * Finds the y-value of an ordered pair given an x-value
	 * 
	 * Parameter:
	 *   double x = the x-coordinate of the point
	 *   
	 * Returns: double representing the y-coordinate
	 */
	public double getY(double x){
		double y = slope * x + yIntercept;
		return y;
	}
	
	/*
	 * Finds the x-value of an ordered pair given a y-value
	 * 
	 * Parameter:
	 *   double y = the y-coordinate of the point
	 *   
	 * Returns: double representing the x-coordinate
	 */
	public double getX(double y){
		return (y - yIntercept) / slope;
	}
	
	/*
	 * Calculates the inverse function of this Linearequation object
	 * 
	 * Returns: a LinearEquation representing the inverse
	 */
	public LinearEquation inverse(){
		double invSlope = 1 / slope;
		double invYInt = -yIntercept / slope;
		LinearEquation inv = new LinearEquation(invSlope, invYInt);
		return inv;
	}
	
	/*
	 * Calculates the mathematical composition of this LinearEquation object
	 * composed with the explicit parameter. A composition is of the form
	 * f(g(x)), where 'f' represents the implicit parameter and 'g' is the
	 * explicit parameter.
	 * 
	 * Parameters:
	 *   LinearEquation inner = the inside function of the composition
	 * 
	 * Returns: a LinearEquation representing the composition
	 */
	public LinearEquation composition(LinearEquation inner){
		double compSlope = this.slope * inner.slope;
		double compYInt = this.slope * inner.yIntercept + this.yIntercept;
		LinearEquation comp = new LinearEquation(compSlope, compYInt);
		return comp;
	}

	/**
	 * @return the slope
	 */
	public double getSlope() {
		return slope;
	}

	/**
	 * @param slope the slope to set
	 */
	public void setSlope(double slope) {
		this.slope = slope;
	}

	/**
	 * @return the yIntercept
	 */
	public double getyIntercept() {
		return yIntercept;
	}

	/**
	 * @param yIntercept the yIntercept to set
	 */
	public void setyIntercept(double yIntercept) {
		this.yIntercept = yIntercept;
	}
	
	
}















