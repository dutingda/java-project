import java.util.*;
public class bonusexercise1 {
	private static void removeFromArray(int []numbers,int r) {
		int temp=0,j=0;
		for(int i=0;i<numbers.length;i++){
			if(numbers[i]==r){
				temp++;
			}
		}
		int[] newNumbers = new int[numbers.length-temp]; 
		for(int i=0;i<numbers.length;i++){
			if(numbers[i]!=r){
				newNumbers[j++]=numbers[i];		
			}
		}				
		for(int k=0;k<newNumbers.length;k++){
			System.out.print(newNumbers[k]+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner (System.in);
		System.out.print("Please enter how many numbers you want to type in: ");
		int l=Integer.parseInt(in.nextLine());
		int[]numbers=new int[l];
		System.out.println("Please enter these numbers: ");
		for(int i=0; i<l;i++){
			numbers[i]=Integer.parseInt(in.nextLine());
			}
		System.out.print("Please enter the number you want to remove: ");
		int r=Integer.parseInt(in.nextLine());
		removeFromArray(numbers,r);
		in.close();
	}

}
