package sys;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;


public class FileIterator {

	DirectoryStream<Path> ds;
	Iterator<Path> it;
	
	public FileIterator(String dir, String glob) {
		Path p = Paths.get(dir);
		
		try {
			ds = Files.newDirectoryStream(p, glob);
			it = ds.iterator();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String nextFilePath() {
		String p = null;
		
		p = it.next().toString();
		
		return p;
	}
	
	public boolean hasNextFile() {
		return it.hasNext();
	}
	
	public void stop() {
		try {
			ds.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
