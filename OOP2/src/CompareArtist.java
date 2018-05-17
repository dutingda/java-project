import java.util.Comparator;

public class CompareArtist implements Comparator<Song>{	
		//compare the two songs artist names
		@Override
		public int compare(Song o1, Song o2) {
		// TODO Auto-generated method stub
			return o1.getArtistName().compareToIgnoreCase(o2.getArtistName());
		}
	}
	class CompareTime implements Comparator<Song>{
		//compare the two songs time
		@Override
		public int compare(Song o1, Song o2) {
			// TODO Auto-generated method stub
			return o1.getTime().getMinutes()*60+o1.getTime().getSeconds()-o2.getTime().getMinutes()*60-o2.getTime().getSeconds();
		}	
	}
