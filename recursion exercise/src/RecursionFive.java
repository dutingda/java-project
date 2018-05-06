import java.util.*;
public class RecursionFive {
	private static int countChar (String str,char c){
		if(str.toLowerCase().indexOf(c)==-1)
			return 0;
		return 1+ countChar(str.substring(str.indexOf(c)+1),c);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String s=in.nextLine();
		System.out.print("Please enter the character to find: ");
		char c=in.nextLine().charAt(0);
		System.out.print(countChar(s,c));
		in.close();
	}

}
