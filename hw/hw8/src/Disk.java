package src;
import java.lang.StringBuffer;
import java.util.concurrent.Semaphore;

class Disk{
	static final int NUM_SECTORS = 1024;
	StringBuffer sectors[] = new StringBuffer[NUM_SECTORS];
	int freeSector = 0;
	int id;
	Disk(int id){
		this.id = id;
	}
	void write(int sector, StringBuffer data){
		//System.out.println("Writing to sector" + Integer.toString(sector) +": " + data.toString());
		//for(int i = 0 ; i < data.length(); i++){
		System.out.println("Disk" + Integer.toString(id) + " is writing to sector:" + Integer.toString(sector));
		sectors[sector] = new StringBuffer(data.toString());
		freeSector++;
		System.out.println("Disk" + Integer.toString(id) + "'s freeSector is now at: " + Integer.toString(freeSector));
		//}

	}
	StringBuffer read(int sector){
		//System.out.println("Reading data: "+ sectors[sector].toString());
		return sectors[sector];
	}
}