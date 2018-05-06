package perfectnumber;

public class PerfectNumber {
	public static void main(String[] args) {
		int i=1;
		while(i<1000000){
			int sum=1;
			for(int j=2; j<Math.sqrt(i);j++){
				if(i%j==0)
					sum=sum+i/j+j;
			}
			if(sum==i)
				System.out.print(i+" ");
			i++;
		}
	}
}
