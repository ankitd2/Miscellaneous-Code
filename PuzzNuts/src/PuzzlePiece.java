/**
 * This class is used to make puzzle pieces which are to be used in class
 * Puzzle. In order to represent the value of each side of the piece, constants
 * are used to represent the suit (diamonds, spades, hearts, clubs) and whether
 * or not the side goes in or out. The pieces can then be rotated in order to
 * get all possibilities of orientation.
 * 
 * @author Ankit Datta & Andy Li
 *
 */
public class PuzzlePiece {
	// constants for suits (spades, hearts, clubs, diamonds = 1, 2, 3, 4)
	// positive for convex config, negative for concave config
	public static final int SPADES_OUT = 1;
	public static final int SPADES_IN = -1;
	public static final int HEARTS_OUT = 2;
	public static final int HEARTS_IN = -2;
	public static final int CLUBS_OUT = 3;
	public static final int CLUBS_IN = -3;
	public static final int DIAMONDS_OUT = 4;
	public static final int DIAMONDS_IN = -4;
	public static final int TOP = 0, RIGHT = 1, BOTTOM = 2, LEFT = 3;

	private int[] sides = new int[4];
	private int rotation = 0;

	// ctors
	public PuzzlePiece(int top, int right, int bottom, int left) {
		sides[0] = top;
		sides[1] = right;
		sides[2] = bottom;
		sides[3] = left;
	}

	// constructs a PuzzlePiece based on values in array sides
	public PuzzlePiece(int[] sides) {
		this.sides = sides;
	}

	/**
	 * getter for the array sides for a piece
	 * 
	 * @return int[] sides containing the values for each side of the piece
	 */
	public int[] getSides() {
		return sides;
	}

	/**
	 * gets the value of a side of a PuzzlePiece object
	 * 
	 * @param side
	 *            the side of the piece for which the value is being found
	 */
	public int getSide(int side) {
		return sides[side];
	}

	/**
	 * shifts values in sides array by 1 so that it is rotated clockwise 90
	 * degrees (true) or counterclockwise (false)
	 * 
	 * @param clockwise
	 *            if true then rotates clockwise, if false then rotates
	 *            counter-clockwise
	 */
	public void rotate(boolean clockwise) {
		if (clockwise) {
			int temp = sides[3];
			for (int i = 2; i >= 0; i--) {
				sides[i + 1] = sides[i];
			}
			sides[0] = temp;
			rotation++;
		} else {
			int temp = sides[0];
			for (int i = 0; i < 3; i++) {
				sides[i] = sides[i + 1];
			}
			sides[3] = temp;
			rotation += 3;
		}
		rotation = rotation % 4;
	}

	/**
	 * Getter for the number of rotations on a piece
	 * 
	 * @return number of rotations
	 */
	public int getRotation() {
		return rotation;
	}

	/**
	 * Sets the rotation of a PuzzlePiece
	 * 
	 * @param rotation
	 *            the number of rotations
	 */
	public void setRotation(int rotation) {
		for (int i = 0; i < rotation; i++) {
			this.rotate(true);
		}
	}

	/**
	 * prints the representation the PuzzlePiece objects by printing the values
	 * of each side given the value of the constants
	 */
	public String toString() {
		String str = "[";
		for (int val : sides) {
			str += val;
		}
		str += "]";
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PuzzlePiece test = new PuzzlePiece(1, 2, 3, 4);
		test.rotate(false);
		System.out.println(test.getRotation());
		System.out.println(test.toString());
		test.rotate(true);
		System.out.println(test.getRotation());
		System.out.println(test.toString());
		System.out.println(test.getSide(2));

	}

}