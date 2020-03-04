package src;
import java.io.*;
class Printer {
	int id;
	Printer(int id){
		this.id = id;
	}
	void print(StringBuffer data){
		System.out.println("Printing to PRINTER"+Integer.toString(id));
		System.out.println("Data printing: " + data.toString());
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter("PRINTER"+String.valueOf(id)));
			out.append(data.toString());
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
