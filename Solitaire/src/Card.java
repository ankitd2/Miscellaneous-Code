
public class Card {
	private char suit;
	private int value;
	private int shade;// if black then shade 0, red shade 1
	// value
	public final int ace = 1;
	public final int two = 2;
	public final int three = 3;
	public final int four = 4;
	public final int five = 5;
	public final int six = 6;
	public final int seven = 7;
	public final int eight = 8;
	public final int nine = 9;
	public final int ten = 10;
	public final int jack = 11;
	public final int queen = 12;
	public final int king = 13;
	// suit
	

	public Card(int value, char suit) {
		if (suit=='d' || suit == 'h')
			shade = 1;
		else
			shade = 0;
		this.suit = suit;
		this.value = value;
	}
	public char getSuit(){return suit;}
	public int getValue(){return value;}
	public int getShade(){return shade;}
	
	public String getCard(){
		return "../src/Cards/"+ getValue()+getSuit()+ ".png";
	}
	
	public static void main(String[] args) {
		Card kh= new Card(13,'d');
		System.out.println(kh.getShade());
		System.out.println(kh.getCard());
		
	}
	

}
