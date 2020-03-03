package src;

public class Main{

	public static void main(String[] args){
		int NumUsers = Integer.parseInt(args[0].charAt(1));
		int NumDisks = Integer.parseInt(args[4].charAt(1));
		int NumPrinters = Integer.parseInt(args[5].charAt(1));

		for (int i = 1; i < 1 + NumUsers; i++)
		{
			System.out.println(args[i]);
		}
	}
}
