import java.util.Comparator;
//comparator interface implemented to compare the title first, when there is duplicates, then compare genre alphabetically
public class MovieCompare implements Comparator<Movie>{
	public int compare(Movie m1, Movie m2) {
		if(m1.getTitle().compareToIgnoreCase(m2.getTitle())==0)
			return m1.getGenre().compareToIgnoreCase(m2.getGenre());
		return m1.getTitle().compareToIgnoreCase(m2.getTitle());
	}
}
//comparator interface implemented to compare the genre first, when there is duplicates, then compare title alphabetically
class GenreCompare implements Comparator<Movie>{

	@Override
	public int compare(Movie m1, Movie m2) {
		if(m1.getGenre().compareToIgnoreCase(m2.getGenre())==0)
			return m1.getTitle().compareToIgnoreCase(m2.getTitle());
		return m1.getGenre().compareToIgnoreCase(m2.getGenre());
	}
}
//comparator interface implemented to compare the genre first, when there is duplicates, then compare rating in descending order
class GenreRatingCompare implements Comparator<Movie>{

	@Override
	public int compare(Movie m1, Movie m2) {
		if(m1.getGenre().compareToIgnoreCase(m2.getGenre())==0)
			return (int)(m2.getRating()-m1.getRating());
		return m1.getGenre().compareToIgnoreCase(m2.getGenre());
	}
}
//comparator interface implemented to compare the title first, when there is duplicates, then compare rating in descending order
class MovieRatingCompare implements Comparator<Movie>{

	public int compare(Movie m1, Movie m2) {
		if(m1.getTitle().compareToIgnoreCase(m2.getTitle())==0)
			return (int)(m2.getRating()-m1.getRating());
		return m1.getTitle().compareToIgnoreCase(m2.getTitle());
	}
}
//comparator interface implemented to compare the genre only
class CompareGenre implements Comparator <Movie>{
	public int compare(Movie m1, Movie m2){
		return m1.getGenre().compareToIgnoreCase(m2.getGenre());
	}
}
//comparator interface implemented to compare the title only
class CompareTitle implements Comparator <Movie>{
	public int compare(Movie m1, Movie m2){
		return m1.getTitle().compareToIgnoreCase(m2.getTitle());
	}
}