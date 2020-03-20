/*
 * This class tests the functionality of the Fraction class
 */
public class FractionTester { 
	public static void main(String[] args) {
	
	Fraction test1 = new Fraction(2,5);
	Fraction test2 = new Fraction (1,4);
	Fraction test3 = new Fraction (-2,5);
	Fraction test4= new Fraction (7,8);
	Fraction test5 = new Fraction (12,20);
	Fraction test6=  new Fraction (1,1);
	Fraction test7 = new Fraction (0,1);
	int num=1;
	
	System.out.println();
	
	//testing toString method and GCD method
	System.out.println(test1.toString());
	System.out.println(test5.toString());
	
	
	/*
	 * testing add method
	 */
	//positive fraction
	System.out.println(test1 + " plus " + test2 + " = " + test1.add(test2));
	System.out.println(test2 + " plus " + test4 + " = " + test2.add(test4));
	System.out.println(test4 + " plus " + test1 + " = " + test4.add(test1));
	System.out.println(test3 + " plus " + test4 + " = " + test3.add(test4));
	//negative fraction
	System.out.println(test1 + " plus (" + test3 + ") = " + test1.add(test3));
	System.out.println(test5 + " plus (" + test3 + ") = " + test5.add(test3));
	
	/*
	 * testing multiply method
	 */
	//positive fraction
	System.out.println(test1 + " times " + test2 + " = " + test1.multiply(test2));
	//negative fraction
	System.out.println(test1 + " times (" + test3 + ") = " + test1.multiply(test3));
	
	/*
	 * testing subtract method
	 */
	//positive
	System.out.println(test1 + " minus " + test2 + " = " + test1.subtract(test2));
	//negative
	System.out.println(test1 + " minus " + test3 + " = " + test1.subtract(test3));
	
	/*
	 * testing divide method
	 */
	
	//positive
	System.out.println(test1 + " divided by " + test2 + " = " + test1.divide(test2));
	//negative
	System.out.println(test1 + " divided by " + test3 + " = " + test1.divide(test3));
	
	/*
	 * testing decimal approx
	 */
	System.out.println(test1 + " is approximately equal to " + test1.toDecimal());
	System.out.println(test2  + " is approximately equal to " + test2.toDecimal());
	System.out.println(test3  + " is approximately equal to " + test3.toDecimal());
	System.out.println(test4 + " is approximately equal to " + test4.toDecimal());
	
	/*
	 * testing reciprocal
	 */
	
	System.out.println("The reciprocal of " + test1 + " is " + test1.reciprocal());
	System.out.println("The reciprocal of " + test3 + " is " + test3.reciprocal());  
	System.out.println("The reciprocal of " + test7 + " is " + test7.reciprocal());
	
	

}}
