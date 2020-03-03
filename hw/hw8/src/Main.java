package src;
import java.util.ArrayList;
public class Main{

	public static void main(String[] args){
		DirectoryManager d = new DirectoryManager();
		int NumUsers = Character.getNumericValue(args[0].charAt(1));
		int NumDisks = Character.getNumericValue(args[4].charAt(1));
		int NumPrinters = Character.getNumericValue(args[5].charAt(1));
		ArrayList UserList = new ArrayList();
		System.out.println("hello");
		for (int i = 1; i < 1 + NumUsers; i++)
		{
			String file = "/home/namhoonl/cs141/hw/hw8/inputs/" + args[i];
			UserThread user = new UserThread(args[i],file);
			user.start();
		}
	}
}
