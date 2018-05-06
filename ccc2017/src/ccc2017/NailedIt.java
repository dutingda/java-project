package ccc2017;
import java.util.*;
import java.io.*;
public class NailedIt {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
	    int length=Integer.parseInt(in.readLine());
	    int array[]=new int[length];
	    StringTokenizer strToken = new StringTokenizer(in.readLine());
	    for(int i= 0; i<length; i++){
			array[i]=Integer.parseInt(strToken.nextToken());
		}
		Arrays.sort(array);
	    int sum;
		int count=0;
		int max=0;
		int temp=0;
		int sumtemp;
		int left;
		int right;
		for(sum=array[0]+array[1]; sum<=array[length-2]+array[length-1]; sum++){
			left = 0; 
			right = length -1; 
			while(left < right){  
				sumtemp = array[left] + array[right]; 
				if(sumtemp == sum){ 
					count++; 
					left = left + 1; 
					right = right -1; 
				}
				else if(sumtemp < sum) 
					left = left +1; 
				
				else if (sumtemp > sum)  
					right = right -1;
			} 

			if(count>max){
				 max=count;
				 temp=1;
			}
			else if(count==max)
				 temp++;
			
			count=0;
		}
		System.out.println(max+" "+temp);
	}

}
