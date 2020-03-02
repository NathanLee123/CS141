import java.lang.StringBuffer;
import java.util.concurrent.Semaphore;
import ./FileInfo.java;
class Disk{
	static final int NUM_SECTORS = 1024;
	Semaphore semaphore = new Semaphore(1,true);
	StringBuffer sectors[] = new StringBuffer[NUM_SECTORS];
	void write(int sector, StringBuffer data){

	}
	void read(int sector, StringBuffer data){}
}