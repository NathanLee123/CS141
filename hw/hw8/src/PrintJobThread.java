package src;
import java.io.*;
class PrintJobThread extends Thread{
	FileInfo file;
	DiskManager diskManager;
	PrinterManager printerManager;
	DirectoryManager directoryManager;
	PrintJobThread(DiskManager diskManager, PrinterManager printerManager, DirectoryManager directoryManager, StringBuffer fileName){
		this.diskManager = diskManager;
		this.directoryManager = directoryManager;
		this.printerManager = printerManager;
		file = directoryManager.lookup(fileName);
	}

	public void start(){
		StringBuffer line = new StringBuffer();
		int printerIndex = printerManager.request();
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter("PRINTER"+Integer.toString(printerIndex+1)));
			for(int i = 0 ; i < file.fileLength; i++){
				line = diskManager.disks[file.diskNumber].read(file.startingSector+i);
				printerManager.printers[printerIndex].print(out,line);
			}

			out.close();
		}
		catch(IOException e){
			System.out.println("File cannot be closed");
		}
		printerManager.release(printerIndex);
	}

}