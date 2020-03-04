package src;
import java.io.*;
class PrintJobThread extends Thread{
	FileInfo file;
	Printer printer;
	Disk disk;
	BufferedWriter out;
	PrintJobThread(Printer printer, Disk disk, FileInfo file, BufferedWriter out){
		this.printer = printer;
		this.disk = disk;
		this.file = file;
		this.out = out;
	}

	public void start(){
		StringBuffer line = new StringBuffer();
		try{
			for(int i = 0 ; i < file.fileLength; i++){
				StringBuffer line = diskManager.disks[file.diskNumber].read(file.startingSector+i);
				printerManager.printers[printerIndex].print(out,line);
			}

			out.close();
		}
		catch(IOException e){
			System.out.println("File cannot be closed");
		}
	}

}