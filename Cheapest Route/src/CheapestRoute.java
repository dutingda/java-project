//Tingda Du
//Mar 12th
//Description: a recursive program that will find the route to the movie theatre that will cost you a MINMUM amount of money
//You live at the bottom-left corner of a grid, and you are on your way to the movie theatre, which is at the top-right corner of the grid
//The cost of each toll is represented by the numbers. You can only walk either NORTH or EAST.
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class CheapestRoute {
	protected static int sum=Integer.MAX_VALUE;
	protected static String cheapestRoute="";
	protected static String direction="";
	//Description: To find all possible routes, while we record the path of each route, calculate the sum of toll and record and compare which one is smaller
	//Parameters: the current row when iterate, the current column, the  2d array to iterate(grid), the array to record the path of number, the index where the recursion is at, the array to record the direction
	//return:/
	private static void findPath(int currentRow, int currentColumn, int array[][], int[]current, int index, String []dir){
		//the temporary integer to represent the sum of one possible route
		int temp=0;
		//base case 1: when the point exceed the upper bond or the right bond, return
		if(currentRow < 0 || currentColumn >= array[0].length){
			return;
        }
		//base case 2: when the point get the destination, return; also find the sum of route and change the route and direction arrays the a string only when it is the current cheapest route
		if(currentRow==0 && currentColumn == array[0].length-1){
			current[index] = array[currentRow][currentColumn];
			temp=IntStream.of(current).sum();
			if(temp<sum){
				sum=temp;
				cheapestRoute=IntStream.of(current).boxed().collect(Collectors.toList()).stream().map(Object::toString).collect(Collectors.joining(" "));
				direction=String.join(" ",dir);
			}
			return;
 		}
		//record the current point
        current[index] = array[currentRow][currentColumn];
    	//check the east position and change the index
        dir[index] = "EAST";
        findPath(currentRow,currentColumn+1,array,current,index+1,dir);
        //check the north position and change the index
    	dir[index] = "NORTH";
        findPath(currentRow-1,currentColumn,array,current,index+1,dir);
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("input.txt"));
		int numberOfGrid = Integer.parseInt(in.readLine());
		System.out.println("Finding the Cheapest Routes:");
		//record the point into the 2d array
		for(int i = 0; i < numberOfGrid; i++){
			int row= Integer.parseInt(in.readLine());
			int column=Integer.parseInt(in.readLine());
			int[][]grid = new int[row][column];
			for(int j = 0; j < row; j++){
				StringTokenizer st = new StringTokenizer(in.readLine());
				for(int k = 0; k < column; k++)
					grid[j][k] = Integer.parseInt(st.nextToken());
			}
		//update the sum for every grid
		sum=Integer.MAX_VALUE;
		//if only north and east, we know the total length for path is row plus column minus one, and direction's length is row plus length minus two
		int []result=new int[grid.length + grid[0].length-1];
		String []dir=new String[grid.length + grid[0].length-2];
		//call the path finding method
		findPath(grid.length-1,0,grid,result,0,dir);
		//print the result for each grid
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
