package src;
import java.io.*;
class Printer {
	int id;
	Printer(int id){
		this.id = id;
	}
	void print(StringBuff er data){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter("PRINTER"+String.valueOf(id)));
			out.write(data.toString(),0,data.length());
			out.newLine();
			out.flush();
			out.close();
			Thread.sleep(2750);
		}
		catch(InterruptedException e){
			System.out.println("InterruptedException");
		}
		catch(IOException e){
			System.out.println("IOException");
		}
	}  // call sleep
}
