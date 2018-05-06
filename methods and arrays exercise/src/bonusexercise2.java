import java.util.*;
public class bonusexercise2 {
	private static void rollOfTwoDice(){
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter the number of times the dice should be rolled: ");
		int temp=in.nextInt();
		int [] roll=new int[temp];
		for(int m=0; m<roll.length; m++){
			roll[m]=(int)(Math.random()*6+1)+(int)(Math.random()*6+1);
		}
		int [] sum={2,3,4,5,6,7,8,9,10,11,12};
		int [] frequency=new int[11];
		double [] percentage=new double[11];
		for(int i=0; i<roll.length;i++){
			for(int j=0;j<sum.length; j++){
				if (sum[j]==roll[i]){
					frequency[j]++;
				}
			}
		}
		for(int k=0; k<frequency.length;k++){
			percentage[k]=frequency[k]*1.0/temp;
		}
		System.out.println("\t\t Dice Roll Simulation");
		System.out.println("\t\t Number of Rolls - "+temp);
		System.out.print("Roll       ");
		for(int r=2;r<=12;r++){
			System.out.printf("%-10d", r);
		}
		System.out.println();
		System.out.print("Frequency  ");
		for(int l=0;l<frequency.length;l++){
			System.out.printf("%-10d", frequency[l]);
		}
		System.out.println();
		System.out.print("Percentage ");
		for(int n=0;n<percentage.length;n++){
			System.out.printf("%-10f", percentage[n]);
		}
		in.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		rollOfTwoDice();
	}
}
