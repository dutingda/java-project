import java.util.*;
public class Challenging1 {
	private static int[] insertElement(int a[], int insert){
		int [] newlist=new int[a.length+1];
		int count=0;
		while(a[count]<insert){
			newlist[count]=a[count];
			count++;
		}
		newlist[count]=insert;
		while(count<a.length){
			newlist[count+1]=a[count];
			count++;
		}
		return newlist;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int[] original={10,20,30,40,50,60,70};
		int newlist[]=insertElement(original,45);
		for(int i=0; i<newlist.length;i++){
			System.out.print(newlist[i]+" ");
		}
	}
}
