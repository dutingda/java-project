import java.util.*;
import java.io.*;
public class Ceaser {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("DATA21.txt"));
		String s="";
		while(!in.readLine().equals("***")){
			s=s+in.readLine();
		}
		s=s.toUpperCase();
		int max=0;
		char maxChar='A';
		String aph="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int []count=new int[26];
		for(int i=0; i<26; i++){
			if(s.indexOf(aph.charAt(i))!)
				
		}
			
	}

}
