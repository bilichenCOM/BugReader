import sys.FileBrowser;

public class Main {
	
	public static void main(String[] args) {
	
		String bugreport_file = FileBrowser.getInterfaceFileNames("", "*.csv")[0];
		String serials_file = FileBrowser.getInterfaceFileNames("", "*.csv")[1];
		
		new Engine().run(bugreport_file, serials_file);
		
		System.out.println("files:["+bugreport_file+"]["+serials_file+"] were processed");
	}
}
