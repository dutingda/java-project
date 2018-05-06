
public class Words implements Comparable<Words>{

		private String word;
		private int frequency;
		
		//constructor
		public Words(String word){
			this.word = word;
			this.frequency = 1;
		}
		//add the frequency to the word
		public void addFrequency(){
			frequency++;
		}
		//get frequency
		public int getFrequency(){
			return frequency;
		}
		//to string method for diplaying
		public String toString(){
			return word+": "+frequency;
		}
		//for sorting the words list, which is comparing the freqency of the word
		public int compareTo(Words w){
			return w.frequency-this.frequency;
			
		}
	}


