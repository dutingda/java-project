
public class Challenging2 {
	private static String encryptMessage(String str, int pos){
		String aph="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		str=str.toUpperCase();
		int a;
		for(int i=0; i<str.length(); i++){
			a=aph.indexOf(str.charAt(i));
			if(a!=-1){
				str=str.substring(0, i)+aph.charAt((a+pos)%26)+str.substring(i+1,str.length());
			}
		}
		return str;
	}
     private static String decryptMessage(String str, int pos){
    	 String aph = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
    	 str=str.toUpperCase();  
    	 int a;
 		for(int i=0; i<str.length(); i++){
 			a=aph.indexOf(str.charAt(i));
 			if(a!=-1){
 				str=str.substring(0, i)+aph.charAt((a+pos)%26)+str.substring(i+1,str.length());
 			}
 		}
 		return str;
     }
			
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(encryptMessage("GOOD LUCK", 3));

		System.out.println(decryptMessage("JRRG OXFN", 3));
	}

}
