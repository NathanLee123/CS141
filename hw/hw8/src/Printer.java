package src;
import java.io.*;
class Printer {
	int id;
	Printer(int id){
		this.id = id;
	}
	void print(BufferedWriter out, StringBuffer data){
		System.out.println("Printing to PRINTER"+Integer.toString(id));
		System.out.println("Data printing: " + data.toString());
		try{
			out.write(data.toString(),0,data.length());
			out.newLine();
			out.flush();
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
