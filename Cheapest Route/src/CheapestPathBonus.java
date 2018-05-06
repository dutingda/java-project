//Tingda Du
//Mar 12th
//Description:Same target as previous one, but in this new neighborhood, not all places collect money. Therefore, one this new grid, these new friendlier tolls will
//be indicated with a zero or negative cost. Because of this new toll layout, we are allowed to move north, east, south, or west, so that you can incur the least amount
//of cost. The only restriction is you cannot go to the same toll more than once
import java.io.*;
import java.util.*;
import java.util.stream.*;
public class CheapestPathBonus {
	protected static int sum=Integer.MAX_VALUE;
	protected static String cheapestRoute="";
	protected static String direction="";
	//Description: To find all possible routes, while we record the path of each route, calculate the sum of toll and record and compare which one is smaller
	//Parameters: current row, current column, grid 2d array, arraylist of integer type for path, index, indicator of boolean 2d array, arraylist of string type for direction
	//Return:/
	private static void findPath(int currentRow, int currentColumn, int array[][], ArrayList<Integer> al, int index, boolean [][]check,ArrayList<String>sl){
		int temp=0;
		//base case: the end point, return;
		if(currentRow==0 && currentColumn == array[0].length-1){
			if(index==al.size())
				al.add(array[currentRow][currentColumn]);
    		else if(index<al.size())
				al.set(index, array[currentRow][currentColumn]);
			temp=al.stream().limit(index+1).mapToInt(Integer::intValue).sum();
			if(temp<sum){
				sum=temp;
				cheapestRoute=al.stream().limit(index+1).map(Object::toString).collect(Collectors.joining(" "));
				direction=sl.stream().limit(index).collect(Collectors.joining(" "));
			}
			return;
 		}
		//make the points that have been through be true
		check[currentRow][currentColumn]=true;
		//record the path
		if(index==al.size())
			al.add(array[currentRow][currentColumn]);
		else if(index<al.size())
			al.set(index, array[currentRow][currentColumn]);
    	if(currentColumn<array[0].length-1&&check[currentRow][currentColumn+1]==false){
    		//record the direction
    		if(index==sl.size())
    			sl.add("EAST");
    		else if(index<sl.size())
    			sl.set(index, "EAST");
    		findPath(currentRow,currentColumn+1,array,al,index+1,check,sl);
    		//when it backtrack make the previous one unchecked 
    		check[currentRow][currentColumn+1]=false;
    	}
    	if(currentRow>0&&check[currentRow-1][currentColumn]==false){
    		if(index==sl.size())
    			sl.add("NORTH");
    		else if(index<al.size())
    			sl.set(index, "NORTH");
    		findPath(currentRow-1,currentColumn,array,al,index+1,check,sl);
    		check[currentRow-1][currentColumn]=false;
    	}
    	if(currentColumn>0&&check[currentRow][currentColumn-1]==false&&currentRow!=0&&currentRow!=array.length-1&&array[currentRow][currentColumn-1]<=0){
    		if(index==sl.size())
    			sl.add("WEST");
    		else if(index<al.size())
    			sl.set(index, "WEST");
    		findPath(currentRow,currentColumn-1,array,al,index+1,check,sl);
    		check[currentRow][currentColumn-1]=false;
    	}
    	if(currentRow<array.length-1&&check[currentRow+1][currentColumn]==false&&currentColumn!=0&&currentColumn!=array[0].length-1&&array[currentRow+1][currentColumn]<=0){
    		if(index==sl.size())
    			sl.add("SOUTH");
    		else if(index<al.size())
    			sl.set(index, "SOUTH");
    		findPath(currentRow+1,currentColumn,array,al,index+1,check,sl);
    		check[currentRow+1][currentColumn]=false;
        }
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		int numberOfGrid = Integer.parseInt(in.readLine());
		System.out.println("Finding the Cheapest Routes:");
		for(int i = 0; i < numberOfGrid; i++){
			int row= Integer.parseInt(in.readLine());
			int column=Integer.parseInt(in.readLine());
			int[][]grid = new int[row][column];
			boolean[][]check = new boolean[row][column];
			for(int j = 0; j < row; j++){
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int k = 0; k < column; k++)
					grid[j][k] = Integer.parseInt(st.nextToken());
			}	
			sum=Integer.MAX_VALUE;
			ArrayList<Integer> al=new ArrayList<Integer>();
			ArrayList<String> sl=new ArrayList<String>();
			findPath(grid.length-1,0,grid,al,0,check,sl);
			System.out.println("Grid #"+(i+1)+":");
			for(int m = 0; m<row; m++)
			{
				for(int n = 0; n<column; n++)
				{
					System.out.print(grid[m][n]+" ");
				}
				System.out.println();
			}		
			System.out.println("Cheapest Route: "+cheapestRoute);
			System.out.println("Direction: "+direction);
			System.out.println("Cheapest Cost: $"+sum);
		}
		System.out.println("Program is Complete");
		in.close();
	}

}
