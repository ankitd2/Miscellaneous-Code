/*This is a basic board.
 * It can be used for any game.
 * 
 * It is important to note this functions in rows and cols, starting at the top left.
 * So for games, the rules must either 1) use rows and cols or 2) convert what they have into rows and cols for the Board to understand
 */
public class Board {

	private int[][] board;
	/* constructor that takes in two ints, first one for # rows, second one for # columns
	 * it creates a new matrix based on those two values 
	 */
	public Board(int rowNum, int colNum) {
		board = new int[rowNum][colNum];
	}
/*
 * constructors that takes in one integer and constructs a square board based on that value
 */
	public Board(int size) {
		board = new int[size][size];
	}
/*
 * constructor that takes in 2D array values and constructs a board based on those values
 */
	public Board(int[][] b) {
		board = b;
	}
//gets number of rows of the board
	public int getRows() {
		int numRows = board.length;
		return numRows;
	}
//gets number of columns of the board
	public int getCols() {
		int numCols = board[0].length;
		return numCols;
	}
//toString prints out the 2D array as a board
	public String toString() {
		String s = "";
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				s += " " + board[i][j];
			}
			s = s + "\n";
		}

		return s;
	}
// this method receives the coordinates of a piece on the board using the row number and column number, and returns the integer value of that piece
	public int getPiece(int rowNum, int colNum) {
			int piecevalue =board[rowNum][colNum];
			
			return piecevalue;
	}
//this void method clears the board and sets everything to equal 0
	public void clear() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				board[i][j] = 0;
			}
		}
	}
//this method receives the coordinates and a value of what to assign to the piece at the given coordinates, assigns the value to that piece, and returns the
//previous integer value of the piece
	public int addPiece(int rowNum, int colNum, int pieceValue) {
		int oldValue = board[rowNum ][colNum ];
		board[rowNum ][colNum ] = pieceValue;
		return oldValue;

	}
// this method receives the integer coordinates of a piece on the board and removes its value, while returning what the integer value was before it was removed
	public int removePiece(int rowNum, int colNum) {
		int oldValue = board[rowNum ][colNum ];
		board[rowNum ][colNum ] = 0;
		return oldValue;

	}
// this method receives the integer coordinates of a spot on the board and returns true boolean if that spot is occupied by a piece and false if it is not
	public boolean isOccupied(int rowNum, int colNum) {

		if (board[rowNum ][colNum ] == 0) {
			return false;
		} else
			return true;

	}
//this method receives the coordinates of a given piece and returns the boolean true if that place is a valid spot on the board and return false if it is not
	public boolean isValid(int rowNum, int colNum) {

		if (rowNum < board.length && colNum < board[0].length && rowNum > -1 && colNum > -1) {
			return true;
		}

		else
			return false;
	}

//	public static void main(String[] args) {
//
//		Board b = new Board(5, 10);
//		b.addPiece(4, 6, 9);
//		System.out.println(b.getRows());
//		System.out.println(b.getCols());
//		System.out.println(b.isValid(1, 0));
//		System.out.println(b.isOccupied(4, 8));
//		System.out.println(b.getPiece(4, 6));
//		System.out.println(b.toString());
//		System.out.println(b.removePiece(4, 6));
//		System.out.println(b);
//		b.addPiece(2, 1, 2);
//		b.addPiece(3, 5, 4);
//		System.out.println(b);
//
//	}

}
