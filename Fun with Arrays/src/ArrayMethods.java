//Name: Tingda Du
//Date: Dec.1st
//Description: A sample main program that calls a collection of methods that use arrays
public class ArrayMethods {
		//Description: This method generate an array of doubles of a certain size, given certain range. Each double is rounded to 1 decimal place
		//parameters: the number to create, the lower bound and the upper bound
		//return: a double array
		private static double[] generateArray(int size, int min, int max){
			double[] firstList=new double[size];
			for(int i=0;i<firstList.length; i++){
				firstList [i]= (Math.round((Math.random()*(max-min+1)+min)*10))/10.0;
			}
			return firstList;
		}
		//Description: This method displays a given array in a organized table, with 8 numbers in each row.
		//parameters: the double array
		//return: /
		private static void displayArray(double[]firstList){
			for(int i=0;i<firstList.length;i++){
				if(i%8!=7){
					System.out.printf("%-10.1f",firstList[i]);
				}
				else
					System.out.printf("%-10.1f%n",firstList[i]);
			}
			System.out.println();
		}
		//Description: This method finds the average of all the numbers in the array
		//parameters: the double array
		//returns: the average which is double
		private static double averageOfArray(double[]firstList){
			double sum=0;
			for(int i= 0; i<firstList.length; i++){
				sum=sum+firstList[i];
			}
			double average=sum/firstList.length;
			return average;
		}
		//Description: This method finds the average of all the numbers in the array
		//parameters: the double array
		//returns: the index which is a integer
		private static int indexOfSmallest(double[]firstList){
			int index=0;
			for(int i=0; i<firstList.length; i++){
				if(firstList[i]<firstList[index])
					index=i;
			}
			return index;
		}
		//Description: This methods sorts the array from smallest element in the array. If there are duplicates of the number, it finds the first position
		//parameters: the double array
		//returns: /
		private static void sortArray(double [] firstList){
			double t;
			for(int i=0; i<firstList.length-1; i++){
				for(int j=i+1; j<firstList.length;j++){
					if(firstList[j]<firstList[i]){
						t=firstList[i];
						firstList[i]=firstList[j];
						firstList[j]=t;
					}
				}
			}
		}
		//Description: This method takes in two arrays, and combines them into one big sorted array
		//parameters: two different double arrays
		//return: the merged big array of two arrays in parameters
		private static double[] mergeArrays(double[]firstList,double[]secondList){
			double[]mergeList=new double [firstList.length+secondList.length];
			int i = 0, j = 0, k = 0;
		    while (i < firstList.length && j < secondList.length)
		    {
		        if (firstList[i] < secondList[j])
		            mergeList[k++] = firstList[i++];
		        else
		            mergeList[k++] = secondList[j++];
		    }// to merge two arrays in one array until one array is completely copied
		    while (i < firstList.length)
		        mergeList[k++] = firstList[i++];
		    //if the first length bigger, directly record of the left numbers in the order 
		    while (j < secondList.length)
		        mergeList[k++] = secondList[j++];
		    //if the second length bigger, directly record of the left numbers in the order 
		    return mergeList;
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println ("Using Methods with Arrays");


			// Generate an array of 30 doubles between 1 and 100
			double[] firstList = generateArray (30, 1, 100);

			// Display array
			System.out.println ("Here are the numbers: ");
			displayArray (firstList);

	
			// Find and display the average of the numbers in the array
			System.out.print ("The average of the numbers in the above array is: ");
			System.out.printf ("%.1f%n", averageOfArray (firstList));
	
	
			// Find and display the index and value of the smallest number
			int index = indexOfSmallest (firstList);
			System.out.print ("\nThe index of the smallest number is: ");
			System.out.println (index);
			System.out.print ("The smallest number in the above list is: ");
			System.out.printf ("%.2f%n", firstList [index]);
	
	
			// Sort and then display the array
			sortArray (firstList);
			System.out.println ("\nHere is the sorted array: ");
			displayArray (firstList);
	
	
			// Generate a second array of 25 elements between -100 and 100
			// and sort this second list
			double[] secondList = generateArray (25, -100, 100);
			sortArray (secondList);

	
			// Merge the two sorted arrays into a single sorted array
			double[] mergedList = mergeArrays (firstList, secondList);
	
	
			// Display the merged array
			System.out.println ("Here is the merged array: ");
			displayArray (mergedList);
	
	
			System.out.println ("The Using Methods with Arrays Program is Complete");
	
		}

	}


