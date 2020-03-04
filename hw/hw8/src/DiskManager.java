package src;
import java.util.*;
class DiskManager extends ResourceManager{
	Disk disks[];
	DiskManager(int numberOfItems, Disk disks[]){
		super(numberOfItems);
		this.disks = disks;
	}

	void updateDisk(int diskIndex, int freeSector){
		disks[diskIndex].freeSector = freeSector;
	}
}
