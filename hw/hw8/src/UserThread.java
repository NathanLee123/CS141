package src;
import java.lang.*;
import java.lang.*;
import java.io.*;
class UserThread{
	StringBuffer stringbuffer = new StringBuffer();
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
			stringbuffer = buffer.readLine();
			String interpret = stringbuffer.toString().split();
			if(interpret[0] == ".save"){
				continue;
			}

		}
		catch(IOException e){
			System.out.println("IOException");
		}
	}

}