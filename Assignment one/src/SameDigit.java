//Tingda Du
//Feb 20th
//Description: the program that find all n digit numbers that satisfy the property, which 
//is that when to multiply certain integer numbers by 3, the resulting product is made up 
//of the same digits as the original number.
import java.util.*;
public class SameDigit {
	//Description: the method is for finding the number with the same digit as its tripled result
	//Parameter: the number of the digit the number has
	//Return: /
	private static void SameDigitNumber(int digit){
		//to give the least possible start point
		int number = (int) Math.pow(10, digit - 1);
		int triple;
		//the loop condition will be confined to number*10/3.0
		for(int i=number; i<number*10/3.0; i++){
			triple = i*3;
			//to make the integer into a string and from string to char array
			String s1=Integer.toString(i);			
			char[]a1=s1.toCharArray();
			//to sort the array into order
			Arrays.sort(a1);
			String s2=Integer.toString(triple);
			char[]a2=s2.toCharArray();
			Arrays.sort(a2);
			//if the two have same digits, then when they are sorted, then two arrays will be the same
			if (Arrays.equals(a1, a2)==true){
				System.out.println(i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of digits for the number: ");
		int digit = Integer.parseInt(in.nextLine());
		SameDigitNumber(digit);
		in.close();
	}
	
}
