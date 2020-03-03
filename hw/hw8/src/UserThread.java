package src;
import java.lang.StringBuffer;
import java.lang.Thread;
import java.io.BufferedReader;
class UserThread{
	StringBuffer CurrentLine = new StringBuffer();
	String user;
	BufferedReader buffer;
	UserThread(String newUser){
		user = newUser;
		buffer = new BufferedReader(new FileReader("hw8/resources/" + newUser));
	}

	void start(){
		System.out.println(buffer.readLine())
	}

}