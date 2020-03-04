package src;

static Os141 os141;
public class Main{

	public static void main(String[] args){
		os141 = new Os141(args); 
		os141.userThreads[0].start();
	}
}
