package src;
import java.lang.*;
import java.lang.*;
import java.io.*;
class UserThread{
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

	void start(){
		try{
			stringbuffer = new StringBuffer(buffer.readLine());
			String[] interpret = stringbuffer.toString().split(" ");
			if(interpret[0].equals(".save")){
				System.out.println("Saving");
			}

		}
		catch(IOException e){
			System.out.println("IOException");
		}
	}

}