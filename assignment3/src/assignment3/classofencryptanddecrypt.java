//Tingda Du
//Date: Nov 8th
//This program is for encrypting and decrypting, you can make a command in a text file in your computer and encrypt it or you can decrypt a certain line of unknown signals to the original code
package assignment3;
import java.io.*;
import java.util.*;
public class classofencryptanddecrypt {
	 public static void main(String[] args)throws IOException{
		 Scanner in= new Scanner(System.in);
		 Scanner inp;
		 int key;
		 PrintWriter out;
		 String c,filenamein,filenameout="",yn;
		 do
		 {
		 String text="";
		 String str1="AEIJOPRSTVX ";
		 String str2="@=!?*#&$+^%_";
		 System.out.println("Please enter you want to encrypt or decrypt(enter encrypting or decrypting)");
		 c=in.nextLine(); 
		 while(!(c.equalsIgnoreCase("encrypting")||c.equalsIgnoreCase("decrypting")))
		 {
			 System.out.println("No such command! Please enter encrypting or decrypting!");
			 System.out.println("Please enter you want to encrypt or decrpt(enter encrypting or decrypting)");
			 c=in.nextLine();
		 }//error check of typing the command
		 System.out.println("please enter the key number(0-11)");
		 key=Integer.parseInt(in.nextLine());
		 while(key<0||key>11)
		 {
			 System.out.println("Wrong key number! Please enter 0 to 11 !");
			 System.out.println("please enter the key number(0-11)");
			 key=Integer.parseInt(in.nextLine());
			 System.out.println();
		 }//key enter error check
		 str2=str2.substring(key)+str2.substring(0, key);//change the corresponding method
		 if(c.equalsIgnoreCase("encrypting"))
		 {
			System.out.println("Please enter the file name you want to input from");
			filenamein=in.nextLine();
			System.out.println("Please enter the file name you want to output to");
			filenameout=in.nextLine();
			inp= new Scanner(new File(filenamein));//make a input text file source and a output print writer
			while(inp.hasNextLine())
			{
			text=inp.nextLine().trim().toUpperCase();
			for(int i=0;  i<str1.length();i++)
			{
				while (text.indexOf(str1.charAt(i))!=-1)
					text=text.substring(0,text.indexOf(str1.charAt(i)))+str2.charAt(i)+text.substring(text.indexOf(str1.charAt(i))+1);
			}
			text=text.substring((int)Math.round(text.length()/2.0))+text.substring(0,(int)Math.round(text.length()/2.0));
			text=text.substring(text.length()-2)+text.substring(2,text.length()-2)+text.substring(0,2);
			if(text.length()%2==1)
				text=text.substring(0,text.length()/2-2)+text.substring(text.length()/2,text.length()/2+2)+text.substring(text.length()/2-2,text.length()/2)+text.substring(text.length()/2+2);
			else
				text=text.substring(0,text.length()/2-3)+text.substring(text.length()/2-1,text.length()/2+1)+text.substring(text.length()/2-3,text.length()/2-1)+text.substring(text.length()/2+1);
			 out = new PrintWriter(new FileWriter(filenameout, true));
			 out.println(text);	
			 out.close();
			}//encrypting every line in steps
			inp.close();
		 }
		 else if(c.equalsIgnoreCase("decrypting"))
		 {
			System.out.println("Please enter the file name you want to input from");
			filenamein=in.nextLine();
			System.out.println("Please enter the file name you want to output to");
			filenameout=in.nextLine();
			inp= new Scanner(new File(filenamein));
			while(inp.hasNextLine())
			{
				text=inp.nextLine();
				if(text.length()%2==1)
					text=text.substring(0,text.length()/2-2)+text.substring(text.length()/2,text.length()/2+2)+text.substring(text.length()/2-2,text.length()/2)+text.substring(text.length()/2+2);
				else
					text=text.substring(0,text.length()/2-3)+text.substring(text.length()/2-1,text.length()/2+1)+text.substring(text.length()/2-3,text.length()/2-1)+text.substring(text.length()/2+1);
				text=text.substring(text.length()-2)+text.substring(2,text.length()-2)+text.substring(0,2);
				text=text.substring(text.length()/2)+text.substring(0,text.length()/2);
				for(int i=0;  i<str2.length();i++)
				{
					while (text.indexOf(str2.charAt(i))!=-1)
						text=text.substring(0,text.indexOf(str2.charAt(i)))+str1.charAt(i)+text.substring(text.indexOf(str2.charAt(i))+1);
				}
				out = new PrintWriter(new FileWriter(filenameout, true));
				out.println(text);	
				out.close();
			}//decrypting every line in sequence
			inp.close();
		 }
		 System.out.print("Do again?  (Enter Y/N):  ");
		 yn=in.nextLine();
			while(!(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("n")))
				{
				System.out.println("No such command! Please enter Y or N!");
				System.out.print("Do again?  (Enter Y/N):  ");
				yn=in.nextLine();
				System.out.println();
				}//error check
		}while(yn.equalsIgnoreCase("y"));//exit when user want, to loop again the program
		System.out.println("Thank you for using my program!");
		in.close();
	 }
}
