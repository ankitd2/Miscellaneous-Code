import java.util.Random;
/*
 * this class defines the rules of Conway's Game of Life. The game is comprised of cells on a board which are either dead based on the number of living 
 * cells surrounding it. If a cell is alive and is surrounded by less than 2 or more than 3 living cells, it dies. If a cell is dead and is surrounded by 
 * exactly 3 living cells, it comes to life. The class has private data board which uses the Board class and its methods in order to make a game board to 
 * play on. The other private data is the generation number which tracks how many runs of the Game of Life have occurred.
 * 
 */
public class GameOfLifeRules {
	private Board game;
	private int gen;

	/*
	 * constructors for making the GameOfLifeRules boards
	 */
	// board based on number of rows and columns
	public GameOfLifeRules(int numRows, int numCols) {
		game = new Board(numRows, numCols);
		gen = 0;
	}

	// board based on number of rows and columns
	public GameOfLifeRules(int[][] board) {
		game = new Board(board);
		gen = 0;
	}

	// square board
	public GameOfLifeRules(Board board) {
		game = board;
		gen = 0;

	}

	// this toString method prints out the generation number and the board of
	// that generation based on the GameOfLifeRules
	public String toString() {
		String str = "";
		str += "Generation Number: " + gen + "\n";
		str += game.toString() + "\n";

		return str;

	}

	/*
	 * getters for number of rows and columns of the board
	 * 
	 */
	public int getRows() {
		int numRows = game.getRows();
		return numRows;
	}

	public int getCols() {
		int numCols = game.getCols();
		return numCols;
	}

	/*
	 * this method receives the coordinates of a piece on the board, looks at
	 * all of the adjacent pieces, and if it is a valid spot on the board,
	 * counts the number of alive cells and returns that value
	 */
	public int getNeighbors(int rowNum, int colNum) {
		int alive = 0;
		for (int i = rowNum - 1; i <= (rowNum + 1); i++) {
			for (int j = colNum - 1; j <= (colNum + 1); j++) {
				if (game.isValid(i, j) == true) {
					if (isAlive(i, j) == true) {
						alive++;
						if (i == rowNum && j == colNum) {
							alive--;
						}
					}
				}
			}
		}
		return alive;
	}

	/*
	 * this method receives the coordinates of a cell and evaluates whether or
	 * not the cell is currently dead or alive based on the integer value if it
	 * is dead it returns a false boolean and if it is alive it returns a true
	 * boolean.
	 */
	public boolean isAlive(int rowNum, int colNum) {
		if (getCell(rowNum, colNum) == 1)
			return true;
		else
			return false;
	}

	/*
	 * this method randomizes the board
	 */
	public void randomize() {

		for (int row = 0; row < getRows(); row++) {
			for (int col = 0; col < getCols(); col++) {
				game.addPiece(row, col, Math.random() < 0.1 ? 1 : 0);
			}
		}

	}

	/*
	 * this method receives coordinates of a cell and based on the number of
	 * living neighbors, determines whether or not that cell will be alive in
	 * the next generation. It returns true if the cell will be alive, and
	 * returns false if it will be dead.
	 */
	public boolean cellFate(int rowNum, int colNum) {
		if (getNeighbors(rowNum, colNum) == 3)
			return true;
		if (getNeighbors(rowNum, colNum) == 2 && isAlive(rowNum, colNum) == true)
			return true;
		if (getNeighbors(rowNum, colNum) == 2 && isAlive(rowNum, colNum) == false)
			return false;

		return false;
	}

	// this method takes in the coordinates of a cell and the state to set it
	// to, and sets the cell to that value
	public void setCell(int rowNum, int colNum, int state) {
		game.addPiece(rowNum, colNum, state);
	}

	/*
	 * this method runs the simulation based on the previous rules and makes the
	 * next generation based on that
	 */
	public void nextGen() {
		Board tempBoard = new Board(getRows(), getCols());
		for (int row = 0; row < getRows(); row++) {
			for (int col = 0; col < getCols(); col++) {
				if (cellFate(row, col) == true)
					tempBoard.addPiece(row, col, 1);
				else
					tempBoard.addPiece(row, col, 0);

			}
		}
		gen++;
		game = tempBoard;

	}

	// this method receives the coordinates of a cell and returns the integer
	// value of it. 1 means it is alive and 0 means it is dead
	public int getCell(int rowNum, int colNum) {
		return this.game.getPiece(rowNum, colNum);
	}
	
/*
 * this main method was used to test the various methods in this class
 */
//	public static void main(String[] args) {
//		Board test1 = new Board(6, 7);
//		GameOfLifeRules test = new GameOfLifeRules(test1);
//		 System.out.println(test);
//		 test.setCell(1, 2, 1);
//		 test.setCell(2, 3, 1);
//		 test.setCell(3, 1, 1);
//		 test.setCell(3, 2, 1);
//		 test.setCell(3, 3, 1);
//		 test.setCell(4, 2, 1);
//		System.out.println(test);
//		test.randomize();
//		System.out.println(test);
//		System.out.println(test.getNeighbors(2, 3));
//		System.out.println(test.cellFate(4, 2));
//		System.out.println(test);
//		test.nextGen();
//		System.out.println(test);
//		test.nextGen();
//		System.out.println(test);
//		test.nextGen();
//		System.out.println(test);
//		test.nextGen();
//		System.out.println(test);
//
//	}

}
