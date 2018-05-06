package ccc2017;
import java.util.*;
import java.io.*;
public class Mai {
			public static void main(String[] args) throws IOException {
				// TODO Auto-generated method stub
				BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
				int measures=Integer.parseInt(in.readLine());
				int arrayall[]=new int [measures];
				StringTokenizer strToken = new StringTokenizer(in.readLine());
				for(int i= 0; i<measures; i++){
					arrayall[i]=Integer.parseInt(strToken.nextToken());
				}
				Arrays.sort(arrayall);
				if(measures%2==0){
					for(int i=measures/2; i<measures; i++){
						System.out.print(arrayall[measures-i-1]+" ");
						System.out.print(arrayall[i]+" ");
					}
				}
				else{
					for(int j=measures/2+1; j<measures; j++ ){
						System.out.print(arrayall[measures-j]+" ");
						System.out.print(arrayall[j]+" ");
					}
					System.out.print(arrayall[0]);
				}
			}
}
