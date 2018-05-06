public class random {
	public static void main(String[] args) {
		int array1[]={4,4,4,4,0,0};
		int array2[]={3,3,3,3,3,3};
		int array3[]={2,2,2,2,6,6};
		int array4[]={5,5,5,1,1,1};
		boolean [] result1=new boolean[20];
		boolean [] result2=new boolean[20];
		boolean [] result3=new boolean[20];
		for(int i=0;i<20;i++){
			int c1=(int)(Math.random()*6);
			int c2=(int)(Math.random()*6);
			if(array2[c1]>array3[c2])
				result1[i]=true;
		}
		for(int i=0;i<20;i++){
			int c1=(int)(Math.random()*6);
			int c2=(int)(Math.random()*6);
			if(array2[c1]>array4[c2])
				result2[i]=true;
		}
		for(int i=0;i<20;i++){
			int c1=(int)(Math.random()*6);
			int c2=(int)(Math.random()*6);
			if(array3[c1]>array4[c2])
				result3[i]=true;
		}
		for(int i=0;i<20;i++){
			System.out.print(result1[i]+" ");
		}
		System.out.println();
		for(int i=0;i<20;i++){
			System.out.print(result2[i]+" ");
		}
		System.out.println();
		for(int i=0;i<20;i++){
			System.out.print(result3[i]+" ");
		}
		
		
	}
}
