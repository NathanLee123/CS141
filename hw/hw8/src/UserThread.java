package src;
import java.lang.*;
import java.io.*;
class UserThread extends Thread{
	StringBuffer stringbuffer;
	String user;
	BufferedReader buffer;
	UserThread(String newUser, String file){
		user = newUser;
		try{
			buffer = new BufferedReader(new FileReader(file));
		}
		catch(FileNotFoundException e){
			System.out.println("FileNotFoundException");
		}
	}

	public void start(){
		processCommandLines();

	}


	void processCommandLines(){
		try{
			stringbuffer = new StringBuffer(buffer.readLine());
			String[] interpret = stringbuffer.toString().split(" ");
			switch(interpret[0]){
				case ".save":
					int diskIndex = os141.diskManager.request();
					System.out.println("we should be saving");
					break;

				case ".print":
					int printerIndex = os141.printerManager.request();
					System.out.println("We should be printing");
					break;
			}

		}
		catch(IOException e){
			System.out.println("IOException");
		}
	}

}