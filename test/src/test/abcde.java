package test;
import java.util.LinkedList;
public class abcde {
	private static String separate(String s){
		String v="aeiouAEIOU";
		String c="qwrtypsdfghjklzxcvbnmQWRTYPSDFGHJKLZXCVBNM";
		if(s.equals(""))
			return "";
		else if(v.indexOf(s.charAt(0))!=-1)
			return separate(s.substring(1))+s.charAt(0);
		else if(c.indexOf(s.charAt(0))!=-1)
			return s.charAt(0)+separate(s.substring(1));
		else
			return separate(s.substring(1));
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l = new LinkedList<Integer>();
		l.add(1);
		l.add(2);
		l.add(3);
		l.remove(1);
		System.out.println(separate("fjewioufkdlsIREJIow"));
	}

}
