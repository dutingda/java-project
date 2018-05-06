package ccc2017;
import java.io.*;
import java.util.*;
public class Main {
			private static int sum(int [] array, int j){
				int sum=0;
				for(int i=j; i>=0; i--){
					sum=sum+array[i];
				}
				return sum;
			}
			public static void main(String[] args) throws IOException {
				// TODO Auto-generated method stub
				BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
				int length=Integer.parseInt(in.readLine());
				int [] Swifts = new int [length];
				int [] Semaphores = new int [length];
				int temp=0;
			    StringTokenizer strToken1 = new StringTokenizer(in.readLine());
				for(int i=0; i<length; i++){
					Swifts[i]=Integer.parseInt(strToken1.nextToken());
				}
				strToken1 = new StringTokenizer(in.readLine());
				for(int i=0; i<length; i++){
					Semaphores[i]=Integer.parseInt(strToken1.nextToken());
				}
				for(int i=length-1; i>=0; i--){
					if(sum(Swifts,i)==sum(Semaphores,i)){
						System.out.println(i+1);
						break;
					}
					else
						temp++;
				}
				if(temp==length){
					System.out.println(0);
				}
				
			}

		}
	


