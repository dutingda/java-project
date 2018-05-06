//Tingda Du
//Date: Feb 19th
//Description: a Java program that finds the largest palindrome inside a given string
import java.io.*;
public class Palindrome2 {
	//T(n)=O(n^2), S(n)=O(1)
	//Description: to find the longest palindrome String by using helper method and record the longest one and index of it
	//Parameters: the original input String
	//Return: /
	public  static void longestPalindrome(String s) {  
        String longest = s.substring(0, 1);  
        int index = 0;
        for (int i = 0; i < s.length(); i++) {  
            // get longest palindrome with center of i  
            String tmp = helper(s, i, i);  
            if (tmp.length() > longest.length()) {  
                longest = tmp; 
                index=i-(tmp.length()-1)/2;
            }  
  
            // get longest palindrome with center of i, i+1  
            tmp = helper(s, i, i + 1);  
            if (tmp.length() > longest.length()) {  
                longest = tmp;  
                index=i-(tmp.length()-1)/2;
            }  
        }  
		System.out.println("Finding the largest palindrome");
		System.out.println("Largest palindrome: "+longest);
		System.out.println("Starting position: "+(index+1));
		System.out.println("Length: "+longest.length());

    }  
  
    // Description: Given a center, either one letter or two letter, find longest palindrome
	// Parameters: the input String, the begin index and the end index
	// return: the longest palindrome
    public static String helper(String s, int b, int e) {  
        while (b >= 0 && e <= s.length() - 1  && s.charAt(b) == s.charAt(e)) {  
            b--;  
            e++;  
        }  
        String subString = s.substring(b + 1, e);  
        return subString;  
    }  
    public static void main(String[] args) throws IOException{
		try{
			BufferedReader inFile = new BufferedReader(new FileReader("input.txt"));
			String s="";
			while (s!=null){
				s=inFile.readLine();
				longestPalindrome(s);
				break;
			}
			inFile.close();
		}catch(FileNotFoundException e){
			System.out.println("Error occurs!!");
		}			
	}
}
