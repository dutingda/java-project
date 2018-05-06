//Tingda Du
//May 21st
//Description:the display the highest 20 word frequency with the word in the whole text file and in each chapter
import java.util.*;
import java.io.*;
public class WordFrequency {

	public static void main(String[] args) throws IOException,FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in =new Scanner(System.in);
		System.out.print("Please enter the file name: ");
		String textFileName=in.nextLine();
		Scanner inFile = new Scanner(new File(textFileName));
		System.out.println("\n20 Most Frequent Words in each chapter and in the whole text file");
		System.out.println("\nFile name: "+ textFileName);
		HashMap<String,Words> map= new HashMap<String,Words>();
		HashMap<String,Words> mapC= new HashMap<String,Words>();
		int count=0;
		//read the file from each line
		while(inFile.hasNextLine()){
			//use two string tokenizer: one for check the chapter word, one for put into hashmap
				String s=inFile.nextLine();
				StringTokenizer st = new StringTokenizer(s," ,.<>/?;:[]{}\\-=_+!@#$%^&*()\"|~`1234567890");
				StringTokenizer st1 = new StringTokenizer(s," ,.<>/?;:[]{}\\-=_+!@#$%^&*()\"|~`1234567890");
				//once meet the word chapter,add one to count, and if there is element in the chapter map, which is mapC, then sort and display
				//if it is the last chapter, every word to the end includes in this last chapter
				if((st1.hasMoreTokens()&&st1.nextToken().equalsIgnoreCase("chapter"))||!inFile.hasNextLine()){
					count++;
					if(!mapC.isEmpty()){
						System.out.println("\nChapter "+(count-1)+"'s 20 most Frequent Words");
						ArrayList <Words>listC=new ArrayList<Words>(mapC.values());
						Collections.sort(listC);
						ListIterator<Words>iterC=listC.listIterator();
						for(int i=0; i<20;i++){
							System.out.println((i+1)+") "+iterC.next());
						}
					}
					mapC.clear();
				}
				//put the tokens into the map if there is a new word
				//if there is not, then add the frequency to the word with particular key
				while(st.hasMoreTokens()){
					String name=st.nextToken().toLowerCase();
					if(!name.equals("'")&&!map.containsKey(name)){
						Words word=new Words(name);
						map.put(name, word);
					}
					else if(!name.equals("'")){
						map.get(name).addFrequency();
					}	
					if(!name.equals("'")&&!mapC.containsKey(name)&&count>=1){
						Words word=new Words(name);
						mapC.put(name, word);	
					}
					else if(!name.equals("'")&&count>=1){
						mapC.get(name).addFrequency();
					}
					
				}
				
		}
		System.out.println("\n20 most frequent words in the whole text file");
		ArrayList<Words> list = new ArrayList<Words>(map.values());
		Collections.sort(list);
		ListIterator<Words>iter=list.listIterator();
		for(int i=0;i<20;i++)
			System.out.println((i+1)+") "+iter.next());
		in.close();
		inFile.close();
		
	}

}
