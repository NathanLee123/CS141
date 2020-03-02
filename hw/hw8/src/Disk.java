import java.lang.StringBuffer;
import java.util.concurrent;
class Disk{
	staic final int NUM_SECTORS = 1024;
	Semaphore semaphore = Semaphore(1,True);
	StringBuffer sectors[] = new StringBuffer[NUM_SECTORS]
	void write(int sector, StringBuffer data);
	void read(int sector, StringBuffer data);
}