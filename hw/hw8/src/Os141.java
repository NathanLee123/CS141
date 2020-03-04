package src;

static class Os141 {
	DiskManager diskManager;
	PrinterManager printerManager;
	UserThread userThreads[];
	String userFiles[];
	Disk disks[];
	Printer printers[];
	int NUM_USERS;
	int NUM_DISKS;
	int NUM_PRINTERS;

	Os141(String args[]){
		NUM_USERS = Character.getNumericValue(args[0].charAt(1));
		NUM_DISKS = Character.getNumericValue(args[NUM_USERS+1].charAt(1));
		NUM_PRINTERS = Character.getNumericValue(args[NUM_USERS+2].charAt(1));

		userFiles = new String[NUM_USERS];
		for( int i =  0; i < NUM_USERS; i++){
			userFiles[i] = args[i+1];
		}
		
		userThreads = new UserThread[NUM_USERS];
		for (int i = 0; i < NUM_USERS; i++){
			userThreads[i] = new UserThread(userFiles[i], "/home/namhoonl/cs141/hw/hw8/inputs/" + args[i+1]);
		}
		disks = new Disk[NUM_DISKS];
		printers = new Printer[NUM_PRINTERS];
	}

	void configure(){

	}

}