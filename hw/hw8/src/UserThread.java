package src;
import java.lang.*;
import java.io.*;
class UserThread extends Thread{
	StringBuffer stringbuffer;
	String user;
	BufferedReader buffer;
	DiskManager diskManager;
	PrinterManager printManager;
	UserThread(String newUser, DiskManager diskManager, PrinterManager printerManager){
		user = newUser;
		this.diskManager = diskManager;
		this.printerManager = printerManager;

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
					int diskIndex = diskManager.request();
					System.out.println("we should be saving");
					break;

				case ".print":
					int printerIndex = printerManager.request();
					System.out.println("We should be printing");
					break;
			}

		}
		catch(IOException e){
			System.out.println("IOException");
		}
	}

}