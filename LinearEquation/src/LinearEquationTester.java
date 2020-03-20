/*
 * Tests the functionality of the LinearEquation class
 */

public class LinearEquationTester {

	public static void main(String[] args) {
		
		LinearEquation line = new LinearEquation(2, 5);
		
		System.out.println("A line with slope 2 and y-intercept 5: " +
				line.toString());
		
		LinearEquation line2 = new LinearEquation(1, 2, 2, 3);
		System.out.println(line2);
		
		double x = 2;
		System.out.print("When x = " + x + " in the equation ");
		System.out.println(line + ", y = " + line.getY(x));
		
		double y = 2;
		System.out.print("When y = " + y + " in the equation ");
		System.out.println(line + ", x = " + line.getX(y));
		
		
		System.out.println("The inverse of " + line + " is " + line.inverse());
		
		System.out.println("The composition of " + line + " and " + line2
				+ " is " + line.composition(line2));
		
		System.out.println("The composition of " + line + " and " + line.inverse()
				+ " is " + line.composition(line.inverse()));
		
		LinearEquation line3 = new LinearEquation();
	}

}










