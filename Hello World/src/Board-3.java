/* Board.java: One class of a two (or 3) part project to help us understand arrays.
 *
 * This is a basic board.
 * It can be used for any game.
 * 
 * It is important to note this functions in rows and cols, starting at the top left.
 * So for games, the rules must either 1) use rows and cols or 2) convert what they have into rows and cols for the Board to understand
 * 
 * Written by Nonu Bajaj
 * Period 4
 * November, 2013
 */

// my class
public class Board {
	// private data of a matrix called grid
	private int[][] grid;

	// getters for # of rows and columns
	public int getRow(){
		return grid.length;
	}

	public int getCol(){
		return grid[0].length;
	}
	
	/* constructor that takes in two ints, first one for # rows, second one for # columns
	 * it creates a new matrix based on those two values
	 * and then sets the private data to this
	 */
	public Board(int row, int col){
		int[][] matrix = new int[row][col];
		grid = matrix;
	}

	// sets an array that you want as the board to the private data
	public Board(int[][] input){
		grid = input;
	}
	
	/* isValid checks if the spot is valid
	 * given a row and col, it checks if the val is within both axes
	 * and if it is greater than 0
	 * if it is, then it is valid (returns true) else returns false
	 */
	public boolean isValid(int x, int y){
		if(x<grid.length && y<grid[0].length && x>-1 && y>-1) return true;
		else return false;
	}
	
	
	/* method set that takes in row, col, and a state (an int)
	 * and sets that spot to the state.
	 * If invalid, it returns 0 (and does nothing).
	 * If valid, it sets the spot and returns the state of which it set that spot to.
	 */
	public int set(int x, int y, int state){
		if(!isValid(x, y)) return 0;
		grid[x][y] = state;
		return state;
	}

	/* remove takes in row and col and sets the spot to 0 and returns what was removed
	 * if invalid, it returns 0 (and does nothing)
	 */
	public int remove(int x, int y){
		if(!isValid(x,y)) return 0;
		int temp = grid[x][y];
		grid[x][y]=0;
		return temp;
	}

	/* an optional method to move I thought was handy
	 * takes in two position sets (first: x rows, y cols. second: a rows, b cols)
	 * and sets the new pos to that, setting the old one to 0
	 * if not valid, it prints out "Move Invalid"
	 */
	public void move(int x, int y, int a, int b){
		if(!isValid(x,y) || !isValid(a,b)) System.out.println("Move invalid.");
		else{
			grid[a][b] = grid[x][y];
			grid[x][y]=0;
		}
	}
	
	// this clears the board by setting grid to an empty array the same size as it
	public void clear(){
		grid = new int[grid.length][grid[0].length];
	}

	/* get takes in row, col
	 * and returns the state of the cell
	 * if invalid, it returns 0 to make dealing with it easier (I'll just pretend it nothing is there)
	 */
	public int get(int x, int y){
		if(!isValid(x,y)) return 0;
		return grid[x][y];
	}

	/* my toString that prints out my array
	 * the commented lines have been replaced by the two following lines
	 * the new ones are for readability, while the old ones looked nicer
	 */
	public String toString(){
		String s = "";
		for(int row = 0; row<getRow();row++){
			for(int col = 0; col<getCol();col++){
				if(get(row, col)==1) s+="@ ";
				else s+="O ";
			}
			s += "\n";
		}
		return s;
	}
	
	// some test code where I made a new array, checked valid spots, moved cells, set spots, removed them, and saw the form of the output

//		public static void main(String[] args){
//			Board x = new Board(4,5);
//			x.set(1,2,1);
//			System.out.println(x);
//			x.move(1, 2, 2, 2);
//			System.out.println(x);
//			System.out.println("6,5 is "+x.isValid(6,5)+".");
//			System.out.println("2,3 is "+x.isValid(2,3)+".");
//			System.out.println(x.remove(2,2));
//			System.out.println(x);
//			System.out.println((char)164); // these characters look nice, but it's a bit hard to distinguish them so 0's and @'s are used
//			System.out.println((char)186);
//		}

}
