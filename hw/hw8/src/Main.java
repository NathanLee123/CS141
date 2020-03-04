package src;

public class Main{

	public static void main(String[] args){
		Os141 os141 = new Os141(args); 
		os141.userThreads[0].start();
	}
}
