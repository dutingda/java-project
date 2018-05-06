import java.util.*;
public class RecursionOne {
	private static int Fibonacci(int n){
		if(n==1)
			return 1;
		else if(n==2)
			return 1;
		return Fibonacci(n-1)+Fibonacci(n-2);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.print("Please enter the number of the term: ");
		int n= in.nextInt();
		System.out.print(Fibonacci(n));
		in.close();
	}

}
