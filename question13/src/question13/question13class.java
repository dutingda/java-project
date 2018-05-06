package question13;
import java.util.*;
public class question13class {
	/* Description: find the factorial of a positive integer
	 * Parameter: a positive integer
	 * return: the product, that is the factorial of that integer
	 */
	private static int factorial(int x){
		int product=1;
		if(x>0){
			for (int a=x; a>0;a--){
				product = a*product;
			}
		}
		else if (x==0){
			product=1;
		}
		return product;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter a  number: ");
		int x = in.nextInt();
		while(x<0){
			System.out.print("The number cannot be negative!");
			System.out.print("Please enter again: ");
			x= in.nextInt();
		}
		int product = factorial(x);
		System.out.print("The answer to "+x+"! is "+product+".");
	}
}
