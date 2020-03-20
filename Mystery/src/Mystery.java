/* Figure out the functionality of this class.
 * Change the output to be meaningful.
 * Give the variables names appropriate to their usage.
 */

import java.util.Random;
import java.util.Scanner;

public class Mystery {
	public static void main(String[] args) {
		System.out.println("Welcome to Guess The Number\n");
		int answer;
		int range = 1000;
		boolean c = true;
		int guess;
		Scanner e = new Scanner(System.in);
		Random f = new Random((int)(Math.random()*100));
		while(c){
			answer = f.nextInt(range+1);
			boolean g = false;
			for(int i = 0; i < 10 && !g; i++){
				do{
					System.out.println("Guess a number between 0 and " + range);
					guess = e.nextInt();
					if(guess < 0 || guess > range)
						System.out.println("Error: exceeded boundaries");
				}while(guess < 0 || guess > range);
				if(guess == answer){
					System.out.println("YAYYYYYY GOOD JOB YOU WIN LIFE!!!");
					g = true;
				}
				else{
					if(guess < answer)
						System.out.println("Hint: too low");	
					else
						System.out.println("Hint: too high");
				}
			}
			if(!g){
				System.out.println("Game Over");
				System.out.println("The answer was " + answer);
			}
			System.out.println("Nice Try");
			String h;
			while( true ){
				h = e.nextLine();
				if( h.equalsIgnoreCase("yes")|| h.equalsIgnoreCase("no"))
					break;
				System.out.println("Would you like to play again?");
			}
			if(h.equalsIgnoreCase("no"))
				c = false;
		}
	}
}
