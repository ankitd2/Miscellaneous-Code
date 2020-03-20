import java.util.Scanner;

/*
 * this class is used to display the board and Game of life generations. It runs the game of life and prompts the user of the program for the dimensions
 * of their desired board and the number of generations they wish to run.
 */
public class Display {
	private Board game;
	private int gen;

	// this method runs the game of life based on a board created by user input
	// for rows and cols.
	public static void runGame() {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the Game of Life"
				+ "\nPlease enter the number of rows you wish the board to be (number must be greater than 0): ");
		int rowNum = input.nextInt();
		System.out.println(
				"Please enter the number of columns you wish the board to be (number must be greater than 0):");
		int colNum = input.nextInt();
		GameOfLifeRules test = new GameOfLifeRules(rowNum, colNum);
		test.randomize();
		System.out.println(test);
		System.out.println("How many generations of the game do you wish to run?");
		int generationRuns = input.nextInt();
		for (int i = 0; i < generationRuns; i++) {
			test.nextGen();
			System.out.println(test);
		}
		System.out.println("Would you like to play again?");
		input.nextLine();
		String response = input.nextLine();
		if (response.equalsIgnoreCase("yes"))
			Display.runGame();
		else
			System.out.println("Thanks for Playing!");

	}

	public static void main(String[] args) {
		runGame();
	}

}
