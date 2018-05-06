
public class Anagram {
	private static String wildcardAnagram(){
		String str1="abba";
		String str2="b**a";
		if(str1.length()==str2.length()){
			for(int i=0; i< str2.length(); i++){
				int a = str1.indexOf(str2.charAt(i));
				if(a!=-1&&str2.charAt(i)!='*'){
					str1=str1.substring(0, a)+str1.substring(a+1, str1.length());
				}
				else if(str2.charAt(i)!='*'&&a==-1)
					return "N";
			}
			return "A";
		}
		else
			return "N";
	}
	public static void main(String args[]){
		System.out.println(wildcardAnagram());
	}
}

