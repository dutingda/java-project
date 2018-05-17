import java.util.*;

public class CD implements Cloneable{
	private String title;
	private int numOfSongs;
	ArrayList <Song> songs =new ArrayList<Song>();
	private Time time=new Time(0);
	
	//Constructor for CD
	public CD(String title, int numOfSongs){
		this.title=title;
		this.numOfSongs=numOfSongs;
	}
	//to get title of CD
	public String getTitle(){
		return this.title;
	}
	//to set the title of CD
	public void setTitle(String title){
		this.title=title;
	}
	//the to string method
	public String toString(){
		String s1 = "\n========= " + title + " ============";		
		String s2 = "\nCD title: " + title + "\nNumber of songs: " + numOfSongs + "\nSongs: ";
		String s3 = "";
		for(int i = 0; i < songs.size(); i++)
			s3 += "\t" + (i + 1) + ": " + songs.get(i).getTitle() + "\n";
		String s4 = "\nLength: " + time.toString();
		String s5 = "\n==================================\n";
		return s1 + s2 + s3 + s4 + s5;
	}
	public void addSong(Song s){
		songs.add(s);
	}
	
	public void addTime(){
		this.time.setMinutes(0);
		this.time.setSeconds(0);
		for(int i = 0; i < songs.size(); i++){
			this.time.setMinutes(this.time.getMinutes() + this.songs.get(i).getTime().getMinutes());
			this.time.setSeconds(this.time.getSeconds() + this.songs.get(i).getTime().getSeconds());
		}
		this.time.setMinutes(this.time.getMinutes() +  this.time.getSeconds() / 60);
		this.time.setSeconds(((int) this.time.getSeconds() % 60));
	}
	//To get the number of songs
	public int getNumOfSongs(){
		return numOfSongs;
	}
	public void setNumOfSongs(){
		this.numOfSongs=songs.size();
	}
	
	//implements cloneable and overriding it for CD clone
	@SuppressWarnings("unchecked")
	public Object clone() throws CloneNotSupportedException{
		CD cd = new CD(title,numOfSongs);
		cd.time=(Time) this.time.clone();
		cd.songs=(ArrayList<Song>) this.songs.clone();
		return cd;
	}
	
	
	
}
