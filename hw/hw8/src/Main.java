package src;

public class Main{

	public static void main(String[] args){
		int NumUsers = Character.getNumericValue(args[0].charAt(1));
		int NumDisks = Character.getNumericValue(args[4].charAt(1));
		int NumPrinters = Character.getNumericValue(args[5].charAt(1));

		for (int i = 1; i < 1 + NumUsers; i++)
		{
			System.out.println(args[i]);
		}
	}
}
