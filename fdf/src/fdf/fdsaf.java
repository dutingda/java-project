package fdf;

public class fdsaf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[][]matrix = new double[3][5];
		double total=0;
		for (int i = 0 ; i < 3 ; i++){
			total+=matrix[1][i];
		}
		System.out.println(total);
		total=0;
		for(int row= 0; row< matrix.length; row++){
			for(int column = 0; column < matrix[row].length; column++){
				if((row+column)%2==0)
					total+=matrix[row][column];
			}
		}
		System.out.println(total);
	}

}
