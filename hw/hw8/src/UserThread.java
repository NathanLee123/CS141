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


	public void run(){
		processCommandLines();

	}




	void processCommandLines(){
		boolean processing = true;
		while(processing){
			try{
				stringbuffer = new StringBuffer(buffer.readLine());
				String[] interpret = stringbuffer.toString().split(" ");
				switch(interpret[0]){
					case ".save":
						System.out.println("Saving " + interpret[1]);
						processSave(interpret[1]);
						System.out.println("Done Saving " + interpret[1]);
						break;

					case ".print":
						System.out.println("Printing " + interpret[1]);
						processPrint(interpret[1]);
						System.out.println("Done Printing " + interpret[1]);

						break;
				}
			}
			catch(IOException e){
				System.out.println("IOException");
			}

			catch(NullPointerException e){
				processing = false;
			}
		}
	}


	void writeDisk(FileInfo file, String name){
		boolean writing = true;
		Disk disk = diskManager.disks[file.diskNumber];
		System.out.println(name + " is being written to disk" + Integer.toString(disk.id));

		while(writing){
			try{
				stringbuffer = new StringBuffer(buffer.readLine());
				if(stringbuffer.toString().equals(".end") == false){
					disk.write(disk.freeSector,stringbuffer);
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
		directoryManager.enter(new StringBuffer(name),file);
			
	}

	void processSave(String name){
		int diskIndex = diskManager.request();
		FileInfo file = new FileInfo();
		file.diskNumber = diskIndex;
		file.startingSector = diskManager.disks[diskIndex].freeSector;
		System.out.println(name+"'s starting Sector is :" + Integer.toString(file.startingSector) + " in disk" + Integer.toString(diskIndex+1));
		file.fileLength = 0;
		writeDisk(file, name);
		diskManager.release(diskIndex);

	}


	void processPrint(String name){
		StringBuffer fileName = new StringBuffer(name);
		try{
			FileInfo file = directoryManager.lookup(fileName);
			Disk disk = diskManager.disks[file.diskNumber];
			int printerIndex = printerManager.request();
			Printer printer = printerManager.printers[printerIndex];
			BufferedWriter out = new BufferedWriter(new FileWriter("PRINTER"+Integer.toString(printerIndex+1), true));
			PrintJobThread p = new PrintJobThread(printer,disk,file, out);
			p.start();
			try{
				p.join();
			}
			catch(InterruptedException e){
				System.out.println("Joining Printer Thread was Interrupted");
			}
			printerManager.release(printerIndex);	
		}
		catch(IOException e){
			System.out.println("Output Stream could not be created");
		}

	}

}