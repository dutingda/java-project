//Tingda Du
//Apr.9th
//Description: the program that sorting movies in the file in different ways and searching in terms of different category
//and display in what users what
import java.util.*;
import java.io.*;
import java.util.Collections;
import java.util.ArrayList;
public class SearchMovies {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(new File("input.txt"));	
		Scanner inp= new Scanner(System.in);
		ArrayList<Movie> movieDetail=new ArrayList<Movie> ();
		int temp=0; String choose="";int choice = 0,low=0,high=0;
		String keyTitle="",keyGenre="";
		//reading from file and record it into an arraylist, also catch necessary input errors
		while(in.hasNextLine()){
			try{
				StringTokenizer st = new StringTokenizer(in.nextLine());
				if(st.countTokens()<3)
					throw new Exception();
				String tempRating=st.nextToken();
				double rating = 0;
				if(tempRating.charAt(tempRating.length()-1)=='%'){
					rating=Double.parseDouble(tempRating.substring(0, tempRating.length()-1));
					if(rating<0||rating >100)
						throw new Exception();
				}
				else 
					throw new Exception();
				String s="";
				while(st.countTokens()>1){
					s=s+" "+st.nextToken();
				}
				String genre=st.nextToken();
				Movie movie=new Movie(rating, s.trim(), genre);
				movieDetail.add(movie);
				Movie.addMovies();
			}
			catch(Exception e){
				continue;
			}
		}
		//sort the arraylist in terms of rating only in descending order and label the ranking using the "setter" method of ranking in movie class to each movie object
		Collections.sort(movieDetail);
		int index = 0;
		int ranking = 1;
		int count = 1;
		while(index<movieDetail.size()){
			if(index==0)
				movieDetail.get(index).setRanking(ranking);
			else if(movieDetail.get(index).getRating()==movieDetail.get(index-1).getRating()){
				movieDetail.get(index).setRanking(ranking);
				count++;
			}
			else{
				ranking+=count;
				movieDetail.get(index).setRanking(ranking);
				count=1;
			}
			index++;
		}
		//using all kinds of criteria to sort the arraylist and make a copy to each of them in order to use them later rather than sort them every time
		Collections.sort(movieDetail, new GenreCompare());
		ArrayList <Movie> genreSort = (ArrayList) movieDetail.clone();
		Collections.sort(movieDetail, new MovieCompare());
		ArrayList <Movie>titleSort = (ArrayList) movieDetail.clone();
		Collections.sort(movieDetail, new MovieRatingCompare());
		ArrayList <Movie>movieRatingSort = (ArrayList) movieDetail.clone();
		Collections.sort(movieDetail, new GenreRatingCompare());
		ArrayList <Movie>genreRatingSort = (ArrayList) movieDetail.clone();
		// user operating part
		while(temp!=3){
			try{
				System.out.print("Searched By: 1)Title 2)Genre 3)Exit\nPlease enter 1, 2, or 3: ");			 
				temp = Integer.parseInt(inp.nextLine());
				//when the user want to search by title and deal with certain typing errors
				if(temp==1){
					do{
						System.out.print("Enter Title: ");
						keyTitle=inp.nextLine().trim();
						//find the index using binary search
						int i = Collections.binarySearch(titleSort,new Movie(0,keyTitle,null),new CompareTitle());
						if(i<0){
							System.out.println("The movie is not found!!!\n");
							break;
						}
						//check the duplicates around the designated index and record the boundary of the interval
						else{
							low = i;
							high = i;
							//left side
							while(low > 0 && titleSort.get(low - 1).getTitle().equalsIgnoreCase(titleSort.get(low).getTitle()))
								low --;
							//right side
							while(high < titleSort.size() -1 && titleSort.get(high + 1).getTitle().equalsIgnoreCase(titleSort.get(high).getTitle()))
								high ++;
						}
						do{
							try{
								System.out.print("If multiples are found, displayed by: 1) Alphabetic order of genre 2)ranking\nEnter 1 or 2: ");
								choice=Integer.parseInt(inp.nextLine());
								//print with the copied sorted array of certain criteria
								if(choice == 1){
									for(int a = low; a <= high; a++)
										System.out.println(titleSort.get(a));
								}
								else if(choice == 2){
									for(int a = low; a <= high; a++)
										System.out.println(movieRatingSort.get(a));
								}
								else 
									throw new NumberFormatException();
							}
							catch(NumberFormatException e){
								System.out.println("Invalid input!\n");
								continue;
							}
						}while(choice!=1&&choice!=2);
						//asking for any more elements of same searching criteria
						do{
							try{
								System.out.print("Any More Title? (y/n): ");
								choose=inp.nextLine();
								System.out.println();
								if(!(choose.equalsIgnoreCase("y")||choose.equalsIgnoreCase("n")))
									throw new Exception();

							}
							catch(Exception e){
								System.out.println("Invalid input!\n");
								continue;
							}
						}while(!(choose.equalsIgnoreCase("y")||choose.equalsIgnoreCase("n")));
					}while(choose.equalsIgnoreCase("y"));
				}
				//when the user want to search by genre and deal with certain typing errors
				else if(temp==2){
					do{
						System.out.print("Enter Genre: ");
						keyGenre=inp.nextLine().trim();
						//find the index using binary search
						int j = Collections.binarySearch(genreSort, new Movie(0, null, keyGenre), new CompareGenre());
						if(j<0){
							System.out.println("\nThe genre is not found!!!\n");
							break;
						}
						//check the duplicates around the designated index and record the boundary of the interval
						else{
							low = j;
							high = j;
							//left side
							while(low > 0 && genreSort.get(low - 1).getGenre().equalsIgnoreCase(genreSort.get(low).getGenre()))
								low --;
							//right side
							while(high < genreSort.size() -1 && genreSort.get(high + 1).getGenre().equalsIgnoreCase(genreSort.get(high).getGenre()))
								high ++;
						}
						do{
							try{
								System.out.print("If multiples are found, displayed by: 1) Alphabetic order of title 2)ranking\nEnter 1 or 2: ");
								choice=Integer.parseInt(inp.nextLine());
								//print with the copied sorted array of certain criteria
								if(choice == 1){
									for(int a = low; a <= high; a++)
										System.out.println(genreSort.get(a));
								}
								else if(choice == 2){
									for(int a = low; a <= high; a++)
										System.out.println(genreRatingSort.get(a));
								}
								else 
									throw new NumberFormatException();
							}
							catch(NumberFormatException e){
								System.out.println("Invalid input!\n");
								continue;
							}
						}while(choice!=1&&choice!=2);
						//asking for any more elements of same searching criteria
						do{
							try{
								System.out.print("Any More Genre? (y/n): ");
								choose=inp.nextLine();
								System.out.println();
								if(!(choose.equalsIgnoreCase("y")||choose.equalsIgnoreCase("n")))
									throw new Exception();
							}
							catch(Exception e){
								System.out.println("Invalid input!\n");
								continue;
							}
						}while(!(choose.equalsIgnoreCase("y")||choose.equalsIgnoreCase("n")));
					}while(choose.equalsIgnoreCase("y"));
				}
				else if(temp!=1&&temp!=2&&temp!=3){
					throw new NumberFormatException();
				}
			}catch(NumberFormatException e){
				System.out.println("Invalid Input!!\n");
				continue;
			}
		}
		System.out.println("\nProgram is Complete!!");
		in.close();
		inp.close();
	}
	
}

