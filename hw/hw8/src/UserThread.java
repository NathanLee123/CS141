package src;
import java.lang.*;
import java.lang.*;
import java.io.*;
class UserThread{
	StringBuffer CurrentLine = new StringBuffer();
	String user;
	BufferedReader buffer;
	UserThread(String newUser, File file){
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
			System.out.println(buffer.readLine());
		}
		catch(IOException e){
			System.out.println("IOException");
		}
	}

}