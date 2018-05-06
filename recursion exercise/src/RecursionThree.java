import java.util.*;
public class RecursionThree {
	private static String repeatStr(String a, int i){
		if(i==1)
			return a;
		if(i<1)
			return "";
		return a+ repeatStr(a,i-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.print("Please enter the the string: ");
		String s=in.nextLine();
		System.out.print("Please enter the times to repeat: ");
		int i= Integer.parseInt(in.nextLine());
		System.out.print(repeatStr(s,i));
		in.close();
	}

}
