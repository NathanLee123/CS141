package src;
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
		for(int i = 0 ; i < file.fileLength; i++){
			line = diskManager.disks[file.diskNumber].read(file.startingSector+i);
			printerManager.printers[printerIndex].print(line);
		}
	}

}