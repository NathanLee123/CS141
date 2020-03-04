package src;
import java.lang.*;
import java.io.*;
class UserThread extends Thread{
	StringBuffer stringbuffer;
	String user;
	BufferedReader buffer;
	DiskManager diskManager;
	PrinterManager printerManager;
	DirectoryManager directoryManager;
	UserThread(String newUser, DiskManager diskManager, PrinterManager printerManager, DirectoryManager directoryManager){
		user = newUser;
		this.diskManager = diskManager;
		this.printerManager = printerManager;
		this.directoryManager = directoryManager;
		try{
			buffer = new BufferedReader(new FileReader("./inputs/" + newUser));
		}
		catch(FileNotFoundException e){
			System.out.println("FileNotFoundException");
		}
	}


	public void start(){
		processCommandLines();

	}




	void processCommandLines(){
		try{
			stringbuffer = new StringBuffer(buffer.readLine());
			String[] interpret = stringbuffer.toString().split(" ");
			switch(interpret[0]){
				case ".save":
					processSave(interpret[1]);
					break;

				case ".print":
					processPrint(interpret[1]);
					break;
			}

		}
		catch(IOException e){
			System.out.println("IOException");
		}
	}


	void writeDisk(FileInfo file, String name){
		boolean writing = true;
		while(writing){
			try{
				stringbuffer = new StringBuffer(buffer.readLine());
				System.out.println(stringbuffer.toString().equals(".end"));
				if(stringbuffer.toString().equals(".end") == false){
					diskManager.disks[file.diskNumber].write(file.startingSector+fileLength,stringbuffer);
					file.fileLength++;
				}
				else{
					writing = false;
				}
			}
			catch(IOException e){
				System.out.println("IOException");
			}
		}

		System.out.println(file.fileLength);
		directoryManager.enter(new StringBuffer(name),file);
			
	}

	void processSave(String name){
		int diskIndex = diskManager.request();
		FileInfo file = new FileInfo();
		file.diskNumber = diskIndex;
		file.startingSector = diskManager.disks[diskIndex].freeSector;
		file.fileLength = 0;
		writeDisk(file, name);
		diskManager.release(diskIndex);

	}

	void processPrint(String name){
		StringBuffer fileName = new StringBuffer(name);
		PrintJobThread p = new PrintJobThread(diskManager, printerManager,directoryManager, fileName);
		p.start();
	}

}