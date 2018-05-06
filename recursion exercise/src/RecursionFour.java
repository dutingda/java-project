import java.util.*;
public class RecursionFour {
	private static String reverse(String str){
		String a="";
		if(str.length()==1)
			return str;
		a=str.charAt(str.length()-1)+"-"+reverse(str.substring(0,str.length()-1));
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.print("Please enter a string to reverse itselt with dash: ");
		String s=in.nextLine();
		System.out.print(reverse(s));
		in.close();
	}

}
