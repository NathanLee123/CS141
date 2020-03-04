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
		if(interpret[0].equals(".save")){
				int diskIndex = os141.diskManager.request();
				System.out.println(diskIndex);
			}

		}
		catch(IOException e){
			System.out.println("IOException");
		}
	}

}