/**
 * This class is used to make a basic board which games can be played on. 
 * 
 *  It is important to note this functions in rows and cols, starting at the top left.
 * So for games, the rules must either 1) use rows and cols or 2) convert what
 * they have into rows and cols for the Board to understand
 * 
 * @author Ankit Datta & Andy Li
 *
 */
public class Board {

	private PuzzlePiece[][] board;
/*
 * constructs a board of dimensions row by col
 */
	public Board(int row, int col) {
		board = new PuzzlePiece[row][col];
	}

	/*
	 * constructs a square board of dimension size by size
	 */
	public Board(int size) {
		board = new PuzzlePiece[size][size];
	}

	/**
	 * Clears the board by removing all of the PuzzlePieces that are on it and
	 * setting the values of the board to null
	 */
	public void clear() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j < getCols(); j++) {
				board[i][j] = null;
			}
		}
	}

	/**
	 * Gets the PuzzlePiece at location (row,col) on the board
	 * 
	 * @param row
	 *            Row number for location on the board
	 * @param col
	 *            Column number for location on the board
	 * @return the PuzzlePiece that is at the location (row,col) on the board,
	 *         or null if the spot is empty
	 */
	public PuzzlePiece getPiece(int row, int col) {
		return board[row][col];
	}

	/**
	 * Adds a PuzzlePiece at location (row,col) on the board
	 * 
	 * @param row
	 *            Row number for location on the board
	 * @param col
	 *            Column number for location on the board
	 * @param add
	 *            PuzzlePiece that is to be added at location (row,col)
	 */
	public void addPiece(int row, int col, PuzzlePiece add) {
		board[row][col] = add;
	}

	/**
	 * Removes the PuzzlePiece at location (row, col) from the board and returns
	 * the old piece
	 * 
	 * @param row
	 *            Row number for location on the board
	 * @param col
	 *            Column number for location on the board
	 * @return The Puzzle Piece that was previously at the location (row,col)
	 *         before it was removed
	 */
	public PuzzlePiece removePiece(int row, int col) {
		PuzzlePiece oldPiece = board[row][col];
		board[row][col] = null;
		return oldPiece;
	}

	/**
	 * Determines whether a location is within the bounds of the board
	 * 
	 * @param row
	 *            Row number for the location on the board
	 * @param col
	 *            Column number for the location on the board
	 * @return true if the location is within the bounds of the board, false if
	 *         it is outside
	 */
	public boolean isValid(int row, int col) {
		if (row < board.length && col < board[0].length && row > -1 && col > -1) {
			return true;
		} else
			return false;

	}

	/**
	 * Checks to see if there is any piece occupying the board at location
	 * (row,col) if the location is a valid location on the board given its
	 * dimensions
	 * 
	 * @param row
	 *            Row number for the location
	 * @param col
	 *            Column number for the location
	 * @return true if the location is occupied, false if the location is not
	 *         occupied
	 */
	public boolean isOccupied(int row, int col) {
		if (this.isValid(row, col)) {
			if (board[row][col] == null) {
				return false;
			} else
				return true;
		}
		return false;
	}

	/**
	 * getter for number of rows in the puzzle board
	 * 
	 * @return number of rows in the puzzle board
	 */
	public int getRows() {
		return board.length;
	}

	/**
	 * getter for number of columns in the puzzle board
	 * 
	 * @return number of columns in the puzzle board
	 */
	public int getCols() {
		return board[0].length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PuzzlePiece piece1 = new PuzzlePiece(4, 3, -3, -4);
		PuzzlePiece piece2 = new PuzzlePiece(3, 2, -4, -3);
		PuzzlePiece piece3 = new PuzzlePiece(1, 4, -1, -2);
		PuzzlePiece piece4 = new PuzzlePiece(2, 1, -1, -3);
		PuzzlePiece piece5 = new PuzzlePiece(2, 4, -3, -3);
		PuzzlePiece piece6 = new PuzzlePiece(1, 1, -2, -3);
		PuzzlePiece piece7 = new PuzzlePiece(2, 4, -4, -2);
		PuzzlePiece piece8 = new PuzzlePiece(1, 4, -2, -4);
		PuzzlePiece piece9 = new PuzzlePiece(3, 2, -1, -2);
		Board test = new Board(3);
		test.addPiece(0, 0, piece1);
		System.out.println(test.isOccupied(0, 0));
		System.out.println(test.isValid(1, 2));
		System.out.println(test.isValid(3, 3));

	}

}