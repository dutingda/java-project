public class exercise4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] suit={"clubs","diamonds","hearts","spades"};
		String [] value={"2","3","4","5","6","7","8","9","10","jack","queen","king","ace"};
		String [] result=new String[5];
		int [] su=new int[5];
		int [] va=new int[5];			
		int t;
		boolean f;
		for(int i=0; i<5; i++)
		{	if(i==0){
			su[i]=(int)(Math.random()*4);
			va[i]=(int)(Math.random()*13);
			}
			else if(i!=0)
			{
				do{
					f=false;
					su[i]=(int)(Math.random()*4);
					va[i]=(int)(Math.random()*13);
					for(int k=i-1;k>=0;k--){
						if(su[i]==su[k]&&va[i]==va[k]){
							f=true;
						}
					}
					
					}while(f==true);	
			}
		}
		for(int i=0;i<su.length-1;i++)
		{
			for(int j=i+1;j<su.length;j++){
				if(su[i]>su[j])
				{

					t=su[i];
					su[i]=su[j];
					su[j]=t;
					t=va[i];
					va[i]=va[j];
					va[j]=t;
				}
				else if(su[i]==su[j])
				{
					if(va[i]>va[j])
					{
						t=va[i];
						va[i]=va[j];
						va[j]=t;
					}
				}
			}
		}  
		for(int i=0; i<5; i++)
		{
			result[i]=suit[su[i]]+" "+value[va[i]];
			System.out.println(result[i]);
		}
	}
}
