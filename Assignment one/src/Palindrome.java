//Tingda Du
//Date: Feb 19th
//Description: a Java program that finds the largest palindrome inside a given string
import java.io.*;
public class Palindrome  {
	//T(n)=O(n), S(n)=O(n)
	//Description: to find the longest palindrome String by using Manacher algorithm
	//Parameters: the original String
	//Return: /
	private static void longestPalindrome (String s1){
		//Making a char array to add soldier character at the start and the end also add pond between 
		//original character of the string in order to combine the even and odd cases.
		char[] t = new char[s1.length() * 2 + 3];
		t[0] = '$';
		t[t.length - 1] = '^';
		int track = 0;
		for (int i = 1; i < t.length - 1; i++){
			if(i % 2 != 0)
				t[i] = '#';
			else{
				t[i] = s1.charAt(track);
				track++;
			}
				
		}
		/* Making an auxiliary array with the same length as the char array to record the length of
		 * longest possible palindrome with a center of one character. The id is the center of the 
		 * palindrome which has the most distant right bound CURRENTLY, and the mx is the right bound of that palindrome (cannot reach the bound). 
		 * maxLen and index are for the longest palindrome's length and index. The corresponding initial value for a character 
		 * (except two soldier characters, for we only check the middle) in the new auxiliary array is 1, and 
		 * check both side of the character in char array and add 1 to the auxiliary array until the two sides' characters
		 * are not the same. It is interesting to notice that the length of palindrome with the center of the character is 
		 * actually equals to the corresponding value in the auxiliary array minus 1, because ponds are not in the original string,
		 * the corresponding value of it could be 1, if it is not 1, then it means the character on the both sides is the original 
		 * center of a palindrome. A important property of palindrome is its symmetry, so the corresponding values of the array for those next-checking characters  
		 * inside the bound of palindrome(not include the bound) with a center of a previous character can be calculate in more efficient way rather than check
		 * every two beside for them. The property is: the value of "these kind of characters" >=the minimum between the array value of left symmetric character 
		 * to the center of palindrome and the distance of the character to mx(the most distant right bound CURRENTLY). Thus, we are able to count these characters from 
		 * a larger number instead of always starting from 1 for every character. More specifically, the value might be bigger only when those two values in the property
		 * is the same, otherwise, when they are different values, the array values definitely equal to the minimum one of these two values, so no need to check further.
		 * For the next-checking characters that are on the bound or outside the bound, we have to make the array values to 1 and check every two beside it. 
		 * The reason why to capitalize the word "currently" is because the mx and id will move when a new record of "the most distant right bound" creates. 
		 */
		int id=0,mx=0;
		int [] p = new int[t.length];
		int maxLen = 0, index = 0;
		for(int i=1 ; i<t.length-1 ; i++){
			p[i] = mx>i ? Math.min(p[2*id-i], mx-i):1;
			if(mx <= i || (mx > i && p[2*id-i] == mx - i)){ 
				while(t[i+p[i]] == t[i-p[i]])
					p[i]++;
			}
			if(i + p[i] > mx){
				mx = i + p[i];
				id = i;
			}
			if(p[i] > maxLen)
			{
				maxLen = p[i];
				index = i;
			}
		}
		index=(index-p[index])/2;
		System.out.println("Finding the largest palindrome");
		System.out.println("Largest palindrome: "+s1.substring(index, index+maxLen-1));
		System.out.println("Starting position: "+(index+1));
		System.out.println("Length: "+(maxLen-1));
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
	
