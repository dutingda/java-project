//Tingda Du
//Mar 14th
//Description: a program that finds how many distinct substrings are contained in a given string
import java.util.*;
import java.io.*;
public class ExerciseOne {

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner (System.in);
		System.out.print("Enter where do you want to input: ");
		Scanner inFile=new Scanner(new File(in.nextLine()));
		int num = Integer.parseInt(inFile.nextLine());
		System.out.println("Finding th number of Substrings");
		for(int i=0; i<num; i++){
			TreeSet<String> ts = new TreeSet<String>();
			String s=inFile.nextLine();
			for(int j=0; j<s.length();j++){
				for(int k=j; k<=s.length();k++){
					ts.add(s.substring(j,k));
				}
			}
			System.out.println("String: "+s+ "\nNo. of Substrings: "+ ts.size());
		}
	}

}
