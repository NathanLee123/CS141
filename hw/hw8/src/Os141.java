package src;
import java.io.*;
class Os141 {
	DirectoryManager directoryManager;
	DiskManager diskManager;
	PrinterManager printerManager;
	UserThread userThreads[];
	String userFiles[];
	Disk disks[];
	Printer printers[];
	int NUM_USERS;
	int NUM_DISKS;
	int NUM_PRINTERS;

	public static void main(String args[]){
		Os141 os141 = new Os141(args);
		for(int i = 0; i < os141.NUM_USERS;i++){
			System.out.println("User" + Integer.toString(i+1) + " is starting");
			os141.userThreads[i].start();
		}
		for(int i = 0; i < os141.NUM_USERS;i++){
			try{
				os141.userThreads[i].join();
			}
			catch(InterruptedException e){
				System.out.println("Join failed");
			}
		}
	}

	Os141(String args[]){
		NUM_USERS = Character.getNumericValue(args[0].charAt(1));
		NUM_DISKS = Character.getNumericValue(args[NUM_USERS+1].charAt(1));
		NUM_PRINTERS = Character.getNumericValue(args[NUM_USERS+2].charAt(1));

		userFiles = new String[NUM_USERS];
		userThreads = new UserThread[NUM_USERS];
		disks = new Disk[NUM_DISKS];
		printers = new Printer[NUM_PRINTERS];
		diskManager = new DiskManager(NUM_DISKS, disks);
		printerManager = new PrinterManager(NUM_PRINTERS,printers);
		directoryManager = new DirectoryManager();
		configure(args);
	}

	void configure(String args[]){
		for( int i =  0; i < NUM_USERS; i++){
			userFiles[i] = args[i+1];
		}
		for (int i = 0; i < NUM_USERS; i++){
			userThreads[i] = new UserThread(userFiles[i],diskManager,printerManager, directoryManager);
		}
		for (int i = 0; i < NUM_PRINTERS; i++){
			printers[i] = new Printer(i+1);
			String printerIndex = Integer.toString(i+1);
			File printerFile = new File("PRINTER"+printerIndex);
			try{
				printerFile.createNewFile();
			}
			catch (IOException e){
				System.out.println("Printer file could not be created");
			}
		}
		for (int i = 0; i < NUM_DISKS; i++){
			disks[i] = new Disk(i+1);
		}
	}

}