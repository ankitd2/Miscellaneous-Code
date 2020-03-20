
/*This class will show examples of the for, while, and do-while loops in the java language.
 * It can find factorials of positive integers, print out a table of areas of rectangles based
 * on the lengths and widths provided by the user, and also show the displacement of a cannonball
 * based on a simulation and the theoretical values.
 */


import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class LoopExamples {

	// This static method takes in an integer parameter which is used to calculate the factorial of any positive integer based on user input. It returns the calculation as a long.
	public static long factorialCalc(int number) {
		long calculation = 1;
		while (number > 0) {
			calculation = calculation * number--;
		}
		return calculation;
	}
	//this static method uses a scanner to ask for user input and is later used in other methods whenever user input is needed.
	//It returns an integer.
	public static int enterNum() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	//This static method asks the user if they would like to find a factorial of another number and then goes back to the factorialCalc() method to find 
	//another factorial if yes. If no, then the method ends. This does not return anything.
	public static void playAgain() {
		boolean prompt = false;
		String response;
		do {
			System.out.println("Would you like to find another factorial? Please enter yes or no:");
			Scanner playagain = new Scanner(System.in);
			response = playagain.nextLine();
			boolean again;
		} while (!(response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("no")));
		if (response.equalsIgnoreCase("yes")) {
			System.out.println("Please enter a non-negative number for which you wish to find the factorial");
			System.out.println(LoopExamples.factorialCalc(enterNum()));
			LoopExamples.playAgain();
		}

	}
	//This static method asks for user input for the minimum and maximum lengths and widths of rectangles and multiplies them together to print
	//the length, width, and area in a table. It does not return anything.
	public static void table() {
		System.out.print("Dimensions for the table of areas of rectangles: ");
		System.out.println("Please enter the desired minimum width");
		int minwidth = enterNum();
		System.out.println("Please enter the desired maximum width:");
		int maxwidth= enterNum();
		System.out.println("Please enter the desired minimum length:");
		int minlength= enterNum();
		System.out.println("Please enter the desired maximum height:");
		int maxlength= enterNum();
		System.out.println("AREAS OF RECTANGLES");
		System.out.println(" Width  " + " Length " + " Area ");
		System.out.println("---------------------");
		for (int i=minwidth; i <=maxwidth; i++) {
			for (int j= minlength; j <= maxlength; j++) {
				System.out.println("   " + i + "   " + "   " + j + "   " + "   " + i * j + "   ");
			}

		}

	}

	//This  static method takes in a double initialvelocity that is plugged into the simulation equations given and then
	//it runs nested for loops and prints a table based on the values given based on the initialvelocity . It does not return anything.

	public static void projectileSimulation(double initialvelocity) {
		double v= initialvelocity;
		double deltaT = 0.01;
		double g = 9.81;
		double s1 = 0.0;
		double t=0.0;
		System.out.println("Time" + "        " + "Simulation Position" + "       " + "Formula Position");

		for(;v>-initialvelocity;){
			for(int i=0; i!=100;i++ ){
				v = v - g * deltaT;
				s1 = s1 + v * deltaT;
				t+=0.01;
			}
			if(s1>0){
				System.out.println((int)t+"s" + "             "+s1+"m" + "         " + LoopExamples.projectileFormula( t, initialvelocity) +"m");
			}
		}	
	}
	//this static method takes in two parameters: time and initialvelocity which are both double values. It then inserts the two parameters into the 
	//formula for finding the position of a cannonball shot into the air and returns the position after t time.
	public static double projectileFormula(double t, double initialvelocity ) {
		double v= initialvelocity;
		double g = 9.81;
		double s = 0;
		s= (-.5* g)*(t*t) + (v*t);
		return s;
	}


	//this main method is used to test all the static methods from the LoopExamples class
	public static void main(String[] args) {
		System.out.println("Please enter a non-negative number for which you wish to find the factorial:");
		System.out.println(LoopExamples.factorialCalc(enterNum()));
		LoopExamples.playAgain();
		LoopExamples.table();
		LoopExamples.projectileSimulation(100);
	}

}
//
//Please enter a non-negative number for which you wish to find the factorial:
//7
//5040
//Would you like to find another factorial? Please enter yes or no:
//YES
//Please enter a non-negative number for which you wish to find the factorial
//5
//120
//Would you like to find another factorial? Please enter yes or no:
//yEs
//Please enter a non-negative number for which you wish to find the factorial
//11
//39916800
//Would you like to find another factorial? Please enter yes or no:
//yes
//Please enter a non-negative number for which you wish to find the factorial
//19
//121645100408832000
//Would you like to find another factorial? Please enter yes or no:
//no
//Dimensions for the table of areas of rectangles: Please enter the desired minimum width
//2
//Please enter the desired maximum width:
//6
//Please enter the desired minimum length:
//3
//Please enter the desired maximum height:
//7
//AREAS OF RECTANGLES
// Width   Length  Area 
//---------------------
//   2      3      6   
//   2      4      8   
//   2      5      10   
//   2      6      12   
//   2      7      14   
//   3      3      9   
//   3      4      12   
//   3      5      15   
//   3      6      18   
//   3      7      21   
//   4      3      12   
//   4      4      16   
//   4      5      20   
//   4      6      24   
//   4      7      28   
//   5      3      15   
//   5      4      20   
//   5      5      25   
//   5      6      30   
//   5      7      35   
//   6      3      18   
//   6      4      24   
//   6      5      30   
//   6      6      36   
//   6      7      42   
//Time        Simulation Position       Formula Position
//1s             95.04594999999989m          95.09500000000007m
//2s             180.28189999999952m         180.3800000000001m
//2s             255.70784999999898m         255.8549999999986m
//3s             321.3237999999982m          321.5199999999975m
//4s             377.12974999999716m         377.3749999999968m
//5s             423.12569999999596m         423.4199999999966m
//6s             459.31164999999436m         459.6549999999967m
//7s             485.6875999999931m          486.07999999999726m
//8s             502.25354999999144m         502.69499999999823m
//9s             509.00949999999017m         509.49999999999966m
//10s            505.9554499999886m          506.49500000000137m
//11s            493.0913999999873m          493.6800000000036m
//12s            470.41734999998596m         471.05500000000643m
//13s            437.93329999998457m         438.6200000000093m
//14s            395.63924999998306m         396.37500000001296m
//15s            343.5351999999814m          344.320000000017m
//16s            281.62114999997954m         282.4550000000095m
//18s            209.89709999997729m         210.77999999999884m
//19s            128.36304999997483m         129.29499999998507m
//20s            37.018999999972216m         37.99999999996862m
//
