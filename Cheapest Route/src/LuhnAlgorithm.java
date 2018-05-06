import java.io.*;
import java.util.StringTokenizer;
public class LuhnAlgorithm {
	private static int Luhn(String base){
		String str="";
		for(int i=base.length()-1; i>=0;i--){
			str=str+base.charAt(i);
		}
		int sum=0;
		String a="";
		for(int i=0; i<str.length(); i++){
			if(i%2==0){
				a=Integer.toString(2*Integer.parseInt(str.charAt(i)+""));
				for(int j=0;j<a.length();j++){
					sum=sum+Integer.parseInt(a.charAt(j)+"");
				}
			}
			else if(i%2==1){
				sum=sum+Integer.parseInt(str.charAt(i)+"");
			}
		}
		for(int i=0; i<=9;i++){
			if((i+sum)%10==0){
				return i;
			}
		}
		return 0;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("DATA21.txt"));
		String s="";
		while((s=in.readLine())!=null){
			StringTokenizer st = new StringTokenizer(s);
			for(int i=0; i<5; i++){	
				if(st.hasMoreTokens())
					System.out.print(Luhn(st.nextToken()));
			}
			System.out.println();
		}
		in.close();
	}
}
