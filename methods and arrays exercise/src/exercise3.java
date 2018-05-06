import java.util.*;
public class exercise3 {
	public static String sentencemaking(){
		String [ ] n= {" the panda "," the person "," the sun "," the turtle "," the snail "," the pig "," the cat "," the puppy "," Dennis Deng "," Ivan Yu "};
		String [ ] v= {"walked ","swam ","climbed ","played ", "sneak ","danced ","sumbled ","ran ","hopped ","slept "};
		String [ ] prep={"into","onto","upon","over","towards","under","beside","around","below","beneath"};
		String s=((n[(int)(Math.random()*10)])+(v[(int)(Math.random()*10)])+(prep[(int)(Math.random()*10)])+(n[(int)(Math.random()*10)])).trim();
		System.out.println(s);
		return s;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String yn;
		do{
			sentencemaking();
			System.out.print("Countinue?(Enter Y/N): ");
			yn=in.nextLine();
			while(!(yn.equalsIgnoreCase("y")||yn.equalsIgnoreCase("n")))
			{
			System.out.println("No such command! Please enter Y or N!");
			System.out.print("Countinue?(Enter Y/N):  ");
			yn=in.nextLine();
			System.out.println();
			}//error check
		}while(yn.equalsIgnoreCase("y"));
		System.out.println("the end!");
		in.close();
	}

}
