/*
 * This class can be used to compute basic arithmetic with fractions
 * such as addition, subtraction, multiplication, and division.
 * It can also be used to approximate fractions to a decimal and
 * prints the fraction in reduced form 
 * 
 * The objects in this class are all constructed using the numerator and denominators of
 * a numerical fraction
 */
public class Fraction {
/*
 * The private data fields are declared as integer numbers for the numerator and denominator of Fractions
 */
	private int num;
	private int den;
	
	//Getters and Setters declared for both the numerator and denominator of Fraction
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getDen() {
		return den;
	}
	public void setDen(int den) {
		this.den = den;
	}
	
	//constructors
	
	/*
	 * constructor for Fraction for an integer numerator and integer denominator not equal to 1
	 * constructs a Fraction based on the numerator and denominator
	 */
	public Fraction (int num, int den){
		this.num=num;
		this.den=den;	
	}
	/*
	 * constructor for Fraction for an integer numerator and a denominator equal to 1
	 */
	public Fraction (int num){
		this(num,1);
	}
	//This method converts the numerator and denominator integers into a Fraction form and returns them over
	//the greatest common denominator found from the various operations acting upon the 2 Fractions
	public String toString() {
		int gcd= gcd(num, den);
		String str = (num / gcd) + "/" + (den / gcd);
		;
		return str;
		
	}
	
	 // recursive implementation of finding the greatest common denominator for the result fractions
	    public static int gcd(int p, int q) {
	        if (q == 0) return p;
	        else return gcd(q, p % q);

	   
	    }
	//Add method takes in 2 Fractions and adds them together and returns the sum
	public Fraction add(Fraction frac1){
		int numfinal= (num * frac1.getDen()) + (frac1.getNum() * den);
		int denfinal = (den * frac1.getDen());
		Fraction FractionSum= new Fraction(numfinal,  denfinal);
		return FractionSum;
	}
	//Multiply method is used to multiply 2 fractions and return the product
	public Fraction multiply(Fraction frac1){
		int numfinal= (num * frac1.getNum());
		int denfinal= (den * frac1.getDen());
		Fraction FractionProduct= new Fraction (numfinal, denfinal);
		return FractionProduct;
	}
	//Subtract method is used to subtract 2 fractions and returns the difference
	public Fraction subtract(Fraction frac1){
		int numfinal= ((num * frac1.getDen()) - (den * frac1.getNum()));
		int denfinal= (den * frac1.getDen());
		Fraction FractionDiff= new Fraction (numfinal,denfinal);
		return FractionDiff;	
	}
	//Divide method takes two Fractions and divides the first Fraction by the second one
	//and returns the quotient
	public Fraction divide(Fraction frac1){
		int numfinal= num * frac1.getDen();
		int denfinal= den * frac1.getNum();
		Fraction FractionQuot= new Fraction (numfinal, denfinal);
		return FractionQuot;
	}
	//ToDecimal method takes in a Fraction returns its approximate decimal value by
	//dividing the numerator by the denominator
	public double toDecimal(){
		double DecimalApprox= (double)(num)/(double)(den);
		return DecimalApprox;	
	}
	//Reciprocal method takes Fraction and finds the reciprocal to print out a new reciprocal Fraction
	// by switching the numerator and denominator
	public Fraction reciprocal(){
		Fraction Reciprocal= new Fraction (this.den, this.num);
		return Reciprocal;
	}

	
}

