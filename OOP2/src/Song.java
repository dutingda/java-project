public class Song implements Comparable<Song>{
	private String title;
	private String artistName;
	private String genre;
	private int rating;
	private Time time;
	
	//constructor for the song class
	public Song(String title, String artistName, String genre, int rating, Time time){
		this.title=title;
		this.artistName=artistName;
		this.genre=genre;
		this.rating=rating;
		this.time=time;
	}
	//getter and setter method
	public String getTitle(){
		return this.title;
	}
	
	public Time getTime(){
		return this.time;
	}
	public String getArtistName(){
		return artistName;
	}
	
	// to string method to display the song information
	public String toString(){
		String s1 = "\n======= " + title + " =========";
		String s3 = "\n========================================\n";
		return s1 + "\nTitle: " + title + "\nArtist Name: " + artistName + "\nGenre: " + genre + 
				"\nRating: " + rating + "\nLength: " + time + s3;
	}
	
	//to compare the title of two song
	@Override
	public int compareTo(Song s) {
		// TODO Auto-generated method stub
		return this.title.compareToIgnoreCase(s.title);
	}
	
	

	
	
	
}
