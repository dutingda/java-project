import java.util.*;
public class RecursionTwo {
	private static int multiplication(int f,int s){
		if(f==0)
			return 0;
		if(f>0)
			return s+multiplication(f-1,s);
		else
			return -s+multiplication(f+1,s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int f= 0,s = 0;
		boolean p=false;
		do{
		try{
		System.out.print("Please enter the first number: ");
		f= Integer.parseInt(in.nextLine());
		System.out.print("Please enter the second number: ");
		s= Integer.parseInt(in.nextLine());
		p=true;
		}catch(NumberFormatException e){
			System.out.println("Enter valid number!!");
		}
		}while(p==false);
		System.out.print(multiplication(f,s));
		in.close();
	}

}
