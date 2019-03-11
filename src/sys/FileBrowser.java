package sys;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class FileBrowser {

	public static String[] getInterfaceFileNames(String dir, String glob) {
		String[] names = new String[2];
		
		Path p = FileSystems.getDefault().getPath(dir);
		
		try {
			DirectoryStream<Path> ds = Files.newDirectoryStream(p, glob);
			Iterator<Path> it = ds.iterator();
			
			for(int i = 0; i<2; i++) {
				if(it.hasNext()) {
					names[i]=it.next().toString();
				} else {
					break;
				}
			}
			
			ds.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return names;
	}
}
