import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class Regionals {

	public static void main(String[] args) throws IOException{
//		Scanner in = new Scanner(new File("DATA21.TXT"));
		for(int i = 0; i < 4; i ++){
//			int days = in.nextInt();
			BigInteger num = new BigInteger("0");
			BigInteger two = new BigInteger("2");
			for(int x = 0; x <99; x ++){
				num =  num.add(two.pow(x));
					
			}
			System.out.println(num);
		}

	}

}
