public class Time implements Cloneable{
	private int minutes;
	private int seconds;
	
	//constructor which set the minutes and seconds in seconds
	public Time(int seconds){
		this.seconds= seconds%60;
		this.minutes= (seconds-seconds%60)/60;
	}
	//constructor which set the minutes and seconds in a string display
	public Time(String display){
		minutes=Integer.parseInt(display.substring(0,display.indexOf(':')));
		if(display.charAt(display.indexOf(':')+1)!='0')
			seconds=Integer.parseInt(display.substring(display.indexOf(':')+1));
		else
			seconds=Integer.parseInt(display.substring(display.indexOf(':')+2));

	}
	//getter and setter method for minutes and seconds
	public int getMinutes(){
		return minutes;
	}
	
	public int getSeconds(){
		return seconds;
	}
	
	public void setMinutes(int i){
		this.minutes = i;
	}
	
	public void setSeconds(int i){
		this.seconds = i;
	}
	
	//The toString method for displaying time
	public String toString(){
		return minutes + ":" + seconds;
	}
	protected Object clone() throws CloneNotSupportedException{
	      return super.clone();
	}
}
