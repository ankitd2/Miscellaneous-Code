
public class PythagTriple {

	// find a,b,c pythagorean triplet for which a+b+c=1000

	public static void main(String[] args) {
		double a=0;
		double b=0;
		double c=0;
		double sum=a+b+c;
		boolean is1000=false;
		for(a=0; a<1000;a++) {
			for(b=0;b<1000;b++) {
				c=Math.hypot(a, b);
				if(a+b+c==1000) {
					is1000=true;
					System.out.println("a: "+ a + "b: "+b+ "c: "+c);
					System.out.println(a*b*c);
					break;
				}
			}
			
		}
		
		

	}
}