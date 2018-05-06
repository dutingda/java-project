package question8;
import java.util.*;
public class question8class {
	/* Description:to calculate the sum of the numbers between two integer numbers including the two numbers.
	 * Parameters: one integer and the other integer
	 * return: return the value of sum of these numbers
	 */
	private static int sumOfNumberBetween(int number1, int number2){
		int sum;
		if (number1>number2)
			sum = (number1+number2)*(number1-number2+1)/2;
		else
			sum = (number1+number2)*(number2-number1+1)/2;
		return sum;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num1, num2;
		System.out.print("Please enter the first number: ");
		num1 = in.nextInt();
		System.out.print("Please enter the second number: ");
		num2 = in.nextInt();
		int sum = sumOfNumberBetween(num1,num2);
		System.out.println("The sum from "+ num1 +" to "+num2+" is "+sum+".");
		in.close();
	}

}
