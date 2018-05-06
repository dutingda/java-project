public class Movie implements Comparable<Movie> {
	//set up the instance variable of a movie object
	private double rating;
	private String title;
	private String genre;
	private static int movieNum;
	private int ranking;
	
	//constructor initialize
	public Movie(double rating, String title, String genre){
		this.rating=rating;
		this.title=title;
		this.genre=genre;
	}
	//getter method for rating, title, and genre; setter method for ranking
	public double getRating(){
		return rating;
	}
	public String getTitle(){
		return title;
	}
	
	public String getGenre(){
		return genre;
	}
	public void setRanking(int index){
		this.ranking=index;
	}
	
	//static method of counting the total number of movie
	public static void addMovies(){
		 movieNum++;
	}
	//comparable interface implemented to compare the rating only in decreasing order when sorted
	@Override
	public int compareTo(Movie m) {
		// TODO Auto-generated method stub
		return (int)(m.rating-this.rating);	
	}
	// toString method to call it when use system.out.print
	public String toString(){
		return "Movie title: "+this.title+"\nGenre: "+this.genre+"\nRating: "+this.rating+"%\nRanking: "+ this.ranking+" out of "+movieNum+"\n";
	}
	
	
}
