
public class Test {
	private static int countStr(String searchStr, String str){
		searchStr=searchStr.toLowerCase();
		str=str.toLowerCase();
		if(searchStr.indexOf(str)==-1){
			return 0;
		}
		if(searchStr.indexOf(str)!=-1){
			return 1+countStr(searchStr.substring(searchStr.indexOf(str)+1),str);
		}
		return 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(countStr("abooooc","OO"));
	}

}
