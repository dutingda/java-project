package quetion9;
import java.util.*;
public class quesion9class {
	/* Description: to find the distance between two points
	 * Parameters:4 value, which is the x and y value of the first point and the x and y value of the second point
	 * return: return the value of the distance 
	 */
	private static double distanceBetween(double x1,double y1,double x2,double y2){
		double distance = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
		return distance;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double x1,x2,y1,y2;
		System.out.print("Please enter the x value for your first point: ");
		x1 = in.nextInt();
		System.out.print("Please enter the y value for your first point: ");
		y1 = in.nextInt();
		System.out.print("Please enter the x value for your second point: ");
		x2 = in.nextInt();
		System.out.print("Please enter the y value for your second point: ");
		y2 = in.nextInt();
		double d=distanceBetween(x1,y1,x2,y2);
		System.out.println("The distance between ("+ x1 +" , "+ y1 +") and (" +x2+" , "+y2+") is "+d+".");
		in.close();

	}

}
