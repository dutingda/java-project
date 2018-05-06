
public class Challenging3 {
	private static void commonLetters(String fir, String sec){
		fir=fir.toLowerCase();
		sec=sec.toLowerCase();
		String aph="abcdefghijklmnopqrstuvwxyz";
		String str="";
		for(int i=0; i<26; i++){
			if(fir.indexOf(aph.charAt(i))!=-1&&sec.indexOf(aph.charAt(i))!=-1)
				str=str+aph.charAt(i);
		}
		System.out.println(str);
	}
	public static void main(String[] args) {
		commonLetters("Good Luck on this question","Plan your solution carefully");
		commonLetters("apple!","kiwi!");
		commonLetters("ABCD","calculate");

	}
}
