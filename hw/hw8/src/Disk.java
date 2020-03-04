package src;
import java.lang.StringBuffer;
import java.util.concurrent.Semaphore;

class Disk{
	int id;
	static final int NUM_SECTORS = 1024;
	StringBuffer sectors[] = new StringBuffer[NUM_SECTORS];
	Disk(int id){
		this.id = id;
	}
	void write(int sector, StringBuffer data){

	}
	void read(int sector, StringBuffer data){

	}
}