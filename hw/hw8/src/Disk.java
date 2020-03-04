package src;
import java.lang.StringBuffer;
import java.util.concurrent.Semaphore;

class Disk{
	static final int NUM_SECTORS = 1024;
	StringBuffer sectors[] = new StringBuffer[NUM_SECTORS];
	int freeSector = 0;
	void write(int sector, StringBuffer data){
		System.out.println(data.toString());
	}
	StringBuffer read(int sector){
		return sectors[sector];
	}
}