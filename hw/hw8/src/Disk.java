package src;
import java.lang.StringBuffer;
import java.util.concurrent.Semaphore;

class Disk{
	static final int NUM_SECTORS = 1024;
	StringBuffer sectors[] = new StringBuffer[NUM_SECTORS];
	int freeSector = 0;
	int write(int sector, StringBuffer data){
		for(int i = 0; i < data.length(); i++){
			sectors[sector].setCharAt(i,data.charAt(i));
			freeSector++;
		}
		Thread.sleep(200);
	}
	StringBuffer read(int sector){
		return sectors[sector];
	}
}