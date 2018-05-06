import java.util.*;
public class exercise1 {
	private static String conversion(int num){
		String [] number= {"zero","one","two","three","four","five","six","seven","eight","nine"};
		int i;
		String result="";
		while(num>0){
			i=num%10;
			num=num/10;
			result=result+" "+number[i];
		}
		
		return result;
	}
	public static void main(String[] args)  {
		Scanner in= new Scanner (System.in);
		System.out.print("Please enter a integer: ");
		int num=in.nextInt();
		String result=conversion(num);
		System.out.println(result.trim());	
		in.close();
	}
}
