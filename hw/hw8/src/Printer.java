package src;
import java.io.*;
class Printer {
	int id;
	Printer(int id){
		this.id = id;
	}
	void print(StringBuffer data){
		BufferedWriter out = new BufferedWriter(new FileWriter("PRINTER"+String.valueOf(id)));
		out.write(data.toString(),0,data.length());
		out.newLine();
		out.flush();
		out.close();
	}  // call sleep
}
