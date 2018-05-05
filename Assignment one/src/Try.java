import java.util.*;
import java.io.*;
public class Try {

	public static void main(String[] args) throws IOException {
		PrintWriter out =  new PrintWriter(new FileWriter("input.txt"));
		for(int i = 0; i < 0; i++){
			Random r = new Random();
			char c = (char) (r.nextInt(26) + 'a');
			out.print(c);
		}
		out.close();
		String s="laooooorei";
		String [] list = s.split("o");
		System.out.println(list[1]);
		System.out.println(Arrays.toString(list));
		}
	
}
