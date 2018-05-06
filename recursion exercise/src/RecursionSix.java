import java.util.*;
public class RecursionSix {
	private static int count(int n){
		if(n==1)
			return 1;
		else if(n==2)
			return 2;
		return count(n-1)+count(n-2);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.print("Please enter the number of length: ");
		int n= in.nextInt();
		System.out.print("The number of way to arrange is "+(long)count(n));
		in.close();
	}

}
