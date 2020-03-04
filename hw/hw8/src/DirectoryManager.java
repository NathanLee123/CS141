package src;
import java.util.Hashtable;
class DirectoryManager {
	private Hashtable<String, FileInfo> T = 
						new Hashtable<String, FileInfo>();

	void enter(StringBuffer key, FileInfo file){
		T.put(key.toString(),file);
	}
	FileInfo lookup(StringBuffer key){
		return T.get(key.toString());
	}

}
