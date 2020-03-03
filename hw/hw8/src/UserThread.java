package src;
import java.lang.*;
import java.lang.*;
import java.io.*;
class UserThread{
	StringBuffer CurrentLine = new StringBuffer();
	String user;
	BufferedReader buffer;
	UserThread(String newUser){
		user = newUser;
		try{
			buffer = new BufferedReader(new FileReader("../resources/" + newUser));
		}
		catch(FileNotFoundException e){
			System.out.println("File Not Found");
		}
	}

	void start(){
		System.out.println(buffer.readLine());
	}

}