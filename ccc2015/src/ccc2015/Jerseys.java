package ccc2015;
import java.util.*;
public class Jerseys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		int jerseyLength = Integer.parseInt(in.nextLine());
		int athleteLength = Integer.parseInt(in.nextLine());
		int [] jersey = new int[jerseyLength];
		int [] athleteSize = new int[athleteLength];
		int [] athleteNumber = new int[athleteLength];
		char c=' ';
		String s="";
		int count=0;
		for(int i = 0; i< jerseyLength; i++){
			c=in.nextLine().charAt(0);
			if(c=='S'){
				jersey[i]=1;
			}
			else if(c=='M'){
				jersey[i]=2;
			}
			else if(c=='L'){
				jersey[i]=3;
			}
		}
		for(int j=0; j< athleteLength; j++){
			s=in.nextLine();
			if(s.charAt(0)=='S'){
				athleteSize[j]=1;
			}
			else if(s.charAt(0)=='M'){
				athleteSize[j]=2;
			}
			else if(s.charAt(0)=='L'){
				athleteSize[j]=3;
			}
			athleteNumber[j]=Character.getNumericValue(s.charAt(2));
		}
		for(int k=0; k<jerseyLength; k++){
			for(int m=0; m<athleteLength;m++){
				if(jersey[k]>=athleteSize[m] && athleteNumber[m]==k+1){
					count++;
					break;
				}
			}
		}
		System.out.println(count);
		in.close();
	}

}
