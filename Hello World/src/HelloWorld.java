import java.util.Arrays;

public class HelloWorld 
{
	
	static String doit(String a,String b){
        if (a.length() > b.length()){
            String c = a; // TODO: set c to a
            a=b; b=c;}
        String r = (a.equals(b)) ? "" : ""; // I love the ternary operator!
        /*
         * For loop with i
         */
        for (int i = 0; i < a.length(); i++) { for (int j = a.length() - i; j > 0; j--) {
                for (int k = 0; k < b.length()- j; k++) {
                    r = (a.regionMatches(i, b, k, j) && j >r.length()) ? a.substring(i,i + j) : r; // Do it!
                        }} // Ah yeah
        } return r; }
	public static void main(String[] args){
		char[] example = {'1','2'};
		String str= new String(example);
		System.out.println(example);
		
	}
	

}
