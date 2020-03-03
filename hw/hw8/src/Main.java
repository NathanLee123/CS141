package src;

public class Main{

	public static void main(String[] args){
		int NumUsers = Character.getNumericValue(args[0].charAt(1));
		int NumDisks = Character.getNumericValue(args[4].charAt(1));
		int NumPrinters = Character.getNumericValue(args[5].charAt(1));
		List UserList = new ArrayList()
		for (int i = 1; i < 1 + NumUsers; i++)
		{
			UserThread user = new UserThread(args[i]);
			user.start()
		}
	}
}
