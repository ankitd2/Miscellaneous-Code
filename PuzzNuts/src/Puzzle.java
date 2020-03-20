import java.util.ArrayList;
import java.util.Arrays;

/**
 * This provides all of the actions that can be used to solve a puzzle based on
 * PuzzlePiece objects on a Board. It includes a solve method which
 * automatically solve the puzzle on the Board regardless of the current state
 * of the board.
 * 
 * @author Ankit Datta & Andy Li
 *
 */
public class Puzzle {
	private Board board;
	private ArrayList<PuzzlePiece> puzzlePieces;

	public Puzzle() {

	}

	/*
	 * constructs a Puzzle by making a board of dimensions (rows,cols) and uses
	 * the array of PuzzlePiece pieces
	 */
	public Puzzle(int rows, int cols, PuzzlePiece[] pieces) {
		board = new Board(rows, cols);
//		PuzzlePiece piece1 = new PuzzlePiece(PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.CLUBS_OUT, PuzzlePiece.CLUBS_IN,
//				PuzzlePiece.DIAMONDS_IN);
//		PuzzlePiece piece2 = new PuzzlePiece(PuzzlePiece.CLUBS_OUT, PuzzlePiece.HEARTS_OUT, PuzzlePiece.DIAMONDS_IN,
//				PuzzlePiece.CLUBS_IN);
//		PuzzlePiece piece3 = new PuzzlePiece(PuzzlePiece.SPADES_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.SPADES_IN,
//				PuzzlePiece.HEARTS_IN);
//		PuzzlePiece piece4 = new PuzzlePiece(PuzzlePiece.HEARTS_OUT, PuzzlePiece.SPADES_OUT, PuzzlePiece.SPADES_IN,
//				PuzzlePiece.CLUBS_IN);
//		PuzzlePiece piece5 = new PuzzlePiece(PuzzlePiece.HEARTS_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.CLUBS_IN,
//				PuzzlePiece.CLUBS_IN);
//		PuzzlePiece piece6 = new PuzzlePiece(PuzzlePiece.SPADES_OUT, PuzzlePiece.SPADES_OUT, PuzzlePiece.HEARTS_IN,
//				PuzzlePiece.CLUBS_IN);
//		PuzzlePiece piece7 = new PuzzlePiece(PuzzlePiece.HEARTS_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.DIAMONDS_IN,
//				PuzzlePiece.HEARTS_IN);
//		PuzzlePiece piece8 = new PuzzlePiece(PuzzlePiece.SPADES_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.HEARTS_IN,
//				PuzzlePiece.DIAMONDS_IN);
//		PuzzlePiece piece9 = new PuzzlePiece(PuzzlePiece.CLUBS_OUT, PuzzlePiece.HEARTS_OUT, PuzzlePiece.SPADES_IN,
//				PuzzlePiece.HEARTS_IN);
//		PuzzlePiece[] puzzPiece = { piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8, piece9 };
		this.puzzlePieces = new ArrayList<PuzzlePiece>(Arrays.asList(pieces));
		// puzzlePieces.clear();
		// for(int i = 0; i < pieces.length; i++){
		// puzzlePieces.add(pieces[i]);
		// }
	}

	/*
	 * constructs a Puzzle by making a square board of dimensions (size,size)
	 * and uses the array of PuzzlePiece pieces
	 */
	public Puzzle(int size, PuzzlePiece[] pieces) {
		board = new Board(size);
//		PuzzlePiece piece1 = new PuzzlePiece(PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.CLUBS_OUT, PuzzlePiece.CLUBS_IN,
//				PuzzlePiece.DIAMONDS_IN);
//		PuzzlePiece piece2 = new PuzzlePiece(PuzzlePiece.CLUBS_OUT, PuzzlePiece.HEARTS_OUT, PuzzlePiece.DIAMONDS_IN,
//				PuzzlePiece.CLUBS_IN);
//		PuzzlePiece piece3 = new PuzzlePiece(PuzzlePiece.SPADES_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.SPADES_IN,
//				PuzzlePiece.HEARTS_IN);
//		PuzzlePiece piece4 = new PuzzlePiece(PuzzlePiece.HEARTS_OUT, PuzzlePiece.SPADES_OUT, PuzzlePiece.SPADES_IN,
//				PuzzlePiece.CLUBS_IN);
//		PuzzlePiece piece5 = new PuzzlePiece(PuzzlePiece.HEARTS_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.CLUBS_IN,
//				PuzzlePiece.CLUBS_IN);
//		PuzzlePiece piece6 = new PuzzlePiece(PuzzlePiece.SPADES_OUT, PuzzlePiece.SPADES_OUT, PuzzlePiece.HEARTS_IN,
//				PuzzlePiece.CLUBS_IN);
//		PuzzlePiece piece7 = new PuzzlePiece(PuzzlePiece.HEARTS_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.DIAMONDS_IN,
//				PuzzlePiece.HEARTS_IN);
//		PuzzlePiece piece8 = new PuzzlePiece(PuzzlePiece.SPADES_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.HEARTS_IN,
//				PuzzlePiece.DIAMONDS_IN);
//		PuzzlePiece piece9 = new PuzzlePiece(PuzzlePiece.CLUBS_OUT, PuzzlePiece.HEARTS_OUT, PuzzlePiece.SPADES_IN,
//				PuzzlePiece.HEARTS_IN);
//		PuzzlePiece[] puzzPiece = { piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8, piece9 };
		this.puzzlePieces = new ArrayList<PuzzlePiece>(Arrays.asList(pieces));
		// puzzlePieces.clear();
		// for(int i = 0; i < pieces.length; i++){
		// puzzlePieces.add(pieces[i]);
		// }
	}

	/**
	 * Getter for ArrayList<PuzzlePiece> puzzlePieces
	 * 
	 * @return the puzzlePieces ArrayList
	 */
	public ArrayList<PuzzlePiece> getPuzzlePieces() {
		return puzzlePieces;
	}

	/**
	 * This method is used to make a copy of an ArrayList made up of PuzzlePiece
	 * objects by making a new ArrayList copy and copying the elements of list
	 * into copy
	 * 
	 * @param list
	 *            Receives an ArrayList of type PuzzlePiece
	 * @return ArrayList<PuzzlePiece> copy of list
	 */
	public static ArrayList<PuzzlePiece> copyArrayList(ArrayList<PuzzlePiece> list) {
		ArrayList<PuzzlePiece> copy = new ArrayList<PuzzlePiece>();
		for (int i = 0; i < list.size(); i++) {
			copy.add(list.get(i));
		}
		return copy;
	}

	/**
	 * This method solves the puzzle by first clearing the board and then delegating to a helper solve(row,col)
	 * method
	 */
	public void solvePuzzle() {
		board.clear(); // clears the board so no problems with random pieces in
		// the board

		solve(0, 0);

	}

	/**
	 *This helper method solves the puzzle recursively by stepping through the positions on the puzzle
	 *and testing if pieces fit at the location. If there is no fit at the location, the method removes the 
	 *previous piece and continues stepping through the puzzle pieces and their rotations to find a fit.
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean solve(int row, int col) {
		if (isSolved()){
			return true;
		}
		if (col == 3) {
			col = 0;
			row++; 
		}
		for (int i = 0; i < puzzlePieces.size(); i++) {
			for (int j = 0; j < 4; j++) {
				if (canFit(row, col, puzzlePieces.get(i))) {
					addPiece(row, col, puzzlePieces.get(i));
//					System.out.println(board.toString());
					if (solve(row, col + 1)){
						return true;
					}
					removePiece(row, col, i);
//					System.out.println(board.toString());
				}
				puzzlePieces.get(i).rotate(true);
			}
		}
		return false;
	}


	/**
	 * checks to see if the puzzle is solved
	 * 
	 * @return true if the puzzle is solved, false if the puzzle is not solved
	 */
	public boolean isSolved() {
		return puzzlePieces.size() == 0;
//		for (int row = 0; row < board.getRows(); row++) {
//			for (int col = 0; col < board.getCols(); col++) {
//				if (board.getPiece(row, col) == null || !this.canFit(row, col,
//						board.getPiece(row, col))) {
//					return false;
//				}
//			}
//		}
//		return true;
	}

	/**
	 * Checks to see if a PuzzlePiece can fit at a location (row,col) by
	 * checking if the location is unoccupied and then comparing the sides of
	 * the piece that is being added to the corresponding sides of the other
	 * pieces already on the board
	 * 
	 * @param row
	 *            Row number for location on the board
	 * @param col
	 *            Column number for location on the board
	 * @param place
	 *            PuzzlePiece which is to checked to see if it can fit at
	 *            (row,col)
	 * @return
	 */
	public boolean canFit(int row, int col, PuzzlePiece place) {
		if (board.isOccupied(row, col) == false) {
			if (board.isOccupied(row - 1, col) == true) {
				if (place.getSide(0) + board.getPiece(row - 1, col).getSide(2) != 0) {
					return false;
				}
			}

			if (board.isOccupied(row, col + 1) == true) {
				if (place.getSide(1) + board.getPiece(row, col + 1).getSide(3) != 0) {
					return false;
				}
			}

			if (board.isOccupied(row + 1, col) == true) {
				if (place.getSide(2) + board.getPiece(row + 1, col).getSide(0) != 0) {
					return false;
				}
			}
			if (board.isOccupied(row, col - 1) == true) {
				if (place.getSide(3) + board.getPiece(row, col - 1).getSide(1) != 0) {
					return false;
				}
			}
			return true;
		}
		return false;
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
		return board.getPiece(row, col);
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
		board.addPiece(row, col, add);
		if (puzzlePieces.contains(add)) {
			puzzlePieces.remove(add);
		}
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
		return board.removePiece(row, col);
	}

	/**
	 * Removes the PuzzlePiece at location (row, col) from the board and returns
	 * the old piece and adds it back to ArrayList puzzlePieces at given indexÏ
	 * 
	 * @param row
	 *            Row number for location on the board
	 * @param col
	 *            Column number for location on the board
	 * @param index
	 *            index in the ArrayList puzzlePieces where the old piece at the
	 *            location is to be added after it is removed
	 * 
	 * @return The Puzzle Piece that was previously at the location (row,col)
	 *         before it was removed
	 */
	public PuzzlePiece removePiece(int row, int col, int index) {
		PuzzlePiece temp = board.removePiece(row, col);
		puzzlePieces.add(index, temp);
		return temp;

	}

	/**
	 * Clears the board by removing all of the PuzzlePieces that are on it and
	 * storing the pieces back in the ArrayList
	 */
	public void clear() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (board.isOccupied(row, col)) {
					puzzlePieces.add(removePiece(row, col));
				}
			}
		}
	}

	/**
	 * toString representation of the puzzle by printing the board and then an
	 * array for each PuzzlePiece object with values based on the piece
	 */
	public String toString() {
		String str = "";
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				str += "[";
				if (board.getPiece(i, j) != null) {
					for (int val : board.getPiece(i, j).getSides()) {

						str += val + " ";
					}
				}
				str += "]";
			}
			str = str + "\n";
		}

		return str;
	}

	/**
	 * getter for number of rows in the puzzle board
	 * 
	 * @return number of columns in the puzzle board
	 */
	public int getRows() {
		return board.getRows();
	}

	/**
	 * getter for number of columns in the puzzle board
	 * 
	 * @return number of columns in the puzzle board
	 */
	public int getCols() {
		return board.getCols();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<PuzzlePiece> pls = new ArrayList<PuzzlePiece>();
		PuzzlePiece piece1 = new PuzzlePiece(PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.CLUBS_OUT, PuzzlePiece.CLUBS_IN,
				PuzzlePiece.DIAMONDS_IN);
		PuzzlePiece piece2 = new PuzzlePiece(PuzzlePiece.CLUBS_OUT, PuzzlePiece.HEARTS_OUT, PuzzlePiece.DIAMONDS_IN,
				PuzzlePiece.CLUBS_IN);
		PuzzlePiece piece3 = new PuzzlePiece(PuzzlePiece.SPADES_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.SPADES_IN,
				PuzzlePiece.HEARTS_IN);
		PuzzlePiece piece4 = new PuzzlePiece(PuzzlePiece.HEARTS_OUT, PuzzlePiece.SPADES_OUT, PuzzlePiece.SPADES_IN,
				PuzzlePiece.CLUBS_IN);
		PuzzlePiece piece5 = new PuzzlePiece(PuzzlePiece.HEARTS_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.CLUBS_IN,
				PuzzlePiece.CLUBS_IN);
		PuzzlePiece piece6 = new PuzzlePiece(PuzzlePiece.SPADES_OUT, PuzzlePiece.SPADES_OUT, PuzzlePiece.HEARTS_IN,
				PuzzlePiece.CLUBS_IN);
		PuzzlePiece piece7 = new PuzzlePiece(PuzzlePiece.HEARTS_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.DIAMONDS_IN,
				PuzzlePiece.HEARTS_IN);
		PuzzlePiece piece8 = new PuzzlePiece(PuzzlePiece.SPADES_OUT, PuzzlePiece.DIAMONDS_OUT, PuzzlePiece.HEARTS_IN,
				PuzzlePiece.DIAMONDS_IN);
		PuzzlePiece piece9 = new PuzzlePiece(PuzzlePiece.CLUBS_OUT, PuzzlePiece.HEARTS_OUT, PuzzlePiece.SPADES_IN,
				PuzzlePiece.HEARTS_IN);
		PuzzlePiece[] puzzPiece = { piece1, piece2, piece3, piece4, piece5, piece6, piece7, piece8, piece9 };
		Puzzle test = new Puzzle(3, puzzPiece);
		// pls.add(piece1);
		// pls.add(piece2);
		// pls.add(piece3);
		// pls.add(piece4);
		// pls.add(piece5);
		// pls.add(piece6);
		// pls.add(piece7);
		// pls.add(piece8);
		// pls.add(piece9);
		// System.out.println(pls.toString());
		// ArrayList<PuzzlePiece> copy = copyArrayList(pls);
		// System.out.println(copy.toString());

		// Board test = new Board(3);
		test.addPiece(2, 0, piece3);
		test.addPiece(1, 1, piece4);
		test.addPiece(1, 2, piece5);
		test.addPiece(2, 1, piece6);
		test.addPiece(2, 2, piece7);
		test.addPiece(0, 1, piece8);
		test.addPiece(0, 2, piece9);
		System.out.println(test.toString());
		test.clear();
		// System.out.println(test.isSolved());
		// System.out.println(test.getPiece(0, 0) == null);
		System.out.println(test.toString());
		test.addPiece(0, 0, piece1);
		System.out.println(test.toString());
		System.out.println();
		System.out.println(test.canFit(0, 1, piece2));
		test.clear();
		System.out.println(test.getPuzzlePieces().size());
		test.solvePuzzle();
		System.out.println(test.toString());
	}
}