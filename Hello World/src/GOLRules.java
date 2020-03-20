/* GOLRules.java: One class of a two (or 3) part project to help us understand arrays.
 *
 * These are the rules for the Game of Life.
 * 
 * The Game of Life is as follows: given a grid filled with cells that are either alive or dead,
 * 	if a cell has three neighbors, it comes to life
 * 	if a cell has two neighbors and is alive, it stays alive
 * 	any other case will end up in the cell or dying or staying dead
 * 		(0 or 1 neighbors, the cell will die from loneliness or 3+ will result in death from overcrowding)
 * This can lead to interesting patterns and it is fun to see what happens in the Game of Life (NOTE: NOT REAL LIFE)
 * 
 * This class has everything needed to emulate the Game of Life in Java.
 * 
 * Written by Nonu Bajaj
 * Period 4
 * November, 2013
 */

// my class
public class GOLRules {
	
	// private data board (making a new board object using our board class)
	private Board board;

	// a constructor so that if given a board, it will set the private data in GOLRules to it
	public GOLRules(Board x){
		board = x;
	}

	//getters for # of rows and columns
	public int getRows(){
		return board.getRow();
	}

	public int getCols(){
		return board.getCol();
	}

	// given a row, col, it returns the state of the cell (remember: if invalid, does nothing)
	public int getCell(int x, int y){
		return board.get(x,y);
	}

	// sets the cell (given row, col) to a state (remember: if invalid, does nothing)
	public void setCell(int x, int y, int state){
		board.set(x,y,state);
	}

	/* getOccupiedNeighbors receives a spot (with a row, col)
	 * it then uses a for loop to calculate the number of neighbors
	 * it starts at one above and one to the left of the cell, counting three
	 * and then moving down, counting three, moving down, counting three
	 * 
	 * If any of those cells that it goes through is alive (state=1) it adds one 
	 * to the sum. At the end, sum (int) is returned
	 * 
	 * if the cell itself was alive, to prevent it being counted as a neighbor, one is subtracted
	 * from the sum before returning it
	 */
	public int getOccupiedNeighbors(int x, int y){
		int sum = 0;
		for(int row = x-1; row<x+2; row++){
			for(int col = y-1; col<y+2; col++){
				if(getCell(row, col)==1) sum++;
			}
		}
		if(getCell(x, y)==1) sum-=1;
		return sum;
	}

	
	/* isAlive receives a row, col
	 * and determines what WILL HAPPEN to a cell
	 * 
	 * It does this by counting the number of neighbors
	 * if they match certain values (see the class description for the requirements)
	 * the cell will either: stay alive, come to life, or stay dead/become dead
	 * returns a boolean if cell WILL BE alive (true) or dead (false)
	 */
	public boolean isAlive(int x, int y){
		if(getOccupiedNeighbors(x,y)==3) return true;
		if(getOccupiedNeighbors(x,y)==2 && getCell(x,y)==1) return true;
		else return false;
	}

	/* nextGen requires nothing, and simply advances the Game of Life
	 * it creates a temp board the same size as the current board
	 * and it determines what isAlive says about a cell (since isAlive says what will happen to a cell in the future)
	 * if a cell is dead, it sets the state to dead in the new board
	 * if the cell is alive, it sets the state to alive in the new board
	 * THIS IS DONE TO PREVENT BUGGY NEXT GEN (changing the board itself will affect the values of later neigbors)
	 * at the end, it sets the new board to the old one
	 */
	public void nextGen(){
		Board tempBoard = new Board(getRows(), getCols());
		for(int row = 0; row<getRows();row++){
			for(int col = 0; col<getCols();col++){
				if(isAlive(row, col)) tempBoard.set(row, col, 1);
			}
		}
		board = tempBoard;
	}

	 /* a method I made after doing display
	  * I think it could be interesting to see a random display and see how nextGen affects it
	  * so I included the method here
	 */
	public void randomize(){
		Board tempBoard = new Board(getRows(), getCols());
		for(int row = 0; row<getRows();row++){
			for(int col = 0; col<getCols();col++){
				tempBoard.set(row, col, Math.random()<0.1?1:0);
			}
		}
		board = tempBoard;
	}
		
	public String toString(){
		return board.toString();
	}
	
	/* my test code (an example from the book, actually)
	 the method calls were because the code was not working, 
	 but now they return the correct things
	*/
	
	// the test works now (matches book's solution)

		public static void main(String[] args){
			Board grid = new Board(6, 7);
			GOLRules test = new GOLRules(grid);
			System.out.println(test);
			test.setCell(1, 2, 1);
			test.setCell(2, 3, 1);
			test.setCell(3, 1, 1);
			test.setCell(3, 2, 1);
			test.setCell(3, 3, 1);
			System.out.println(test);
			System.out.println(test.getOccupiedNeighbors(2,3));
			System.out.println(test.isAlive(4,2));
			System.out.println(test.isAlive(2,1));
			System.out.println(test.isAlive(2,11)+"\n");
			System.out.println(test);
			test.nextGen();
			System.out.println(test);
			test.nextGen();
			System.out.println(test);
			test.nextGen();
			System.out.println(test);
			test.nextGen();
			System.out.println(test);
		}
}
