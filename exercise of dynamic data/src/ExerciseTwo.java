//Tingda Du
//Mar 14th
//Description: Find the original order of the cards in the deck
import java.util.*;
public class ExerciseTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		System.out.println("Please enter the number of cards: ");
		int n = Integer.parseInt(in.nextLine());
		LinkedList <Integer> deck = new LinkedList<Integer> ();
		for(int i=n; i>0;i--){
			deck.addFirst(i);
			if(i!=1)
				deck.addFirst(deck.removeLast());
		}
		System.out.print("Original Order of Cards (top card first): "+deck);

	}
	
}
