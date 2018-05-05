import java.io.*;
public class fjdsklfdjks {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try{
		BufferedReader in=new BufferedReader(new FileReader("input.txt"));
		String s=in.readLine();
		double a=Integer.parseInt(s);
		}catch(IOException e){
			System.out.println("abc!");
		}
		catch(NumberFormatException e){
			System.out.println("cnm!");
		}
	}

}
