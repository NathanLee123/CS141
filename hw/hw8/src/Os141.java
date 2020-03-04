package src;

static Os141 os141;

class Os141 {
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
		os141 = new Os141(args);

	}

	Os141(String args[]){
		NUM_USERS = Character.getNumericValue(args[0].charAt(1));
		NUM_DISKS = Character.getNumericValue(args[NUM_USERS+1].charAt(1));
		NUM_PRINTERS = Character.getNumericValue(args[NUM_USERS+2].charAt(1));

		userFiles = new String[NUM_USERS];
		userThreads = new UserThread[NUM_USERS];
		disks = new Disk[NUM_DISKS];
		printers = new Printer[NUM_PRINTERS];
		diskManager = new DiskManager(NUM_DISKS);
		printerManager = new PrinterManager(NUM_PRINTERS);
		configure(args);
	}

	void configure(String args[]){
		for( int i =  0; i < NUM_USERS; i++){
			userFiles[i] = args[i+1];
		}
		for (int i = 0; i < NUM_USERS; i++){
			userThreads[i] = new UserThread(userFiles[i],diskManager,printerManager);
		}
		for (int i = 0; i < NUM_PRINTERS; i++){
			printers[i] = new Printer(i+1);
		}
		for (int i = 0; i < NUM_DISKS; i++){
			disks[i] = new Disk(i+1);
		}
	}

}