import java.net.URLConnection;
import java.util.Scanner;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FtpExplorer {
	private String uname;
	private String pass;
	private String address;
	private String file;
	private int port;
	
	private URLConnection connection;
	/*
	 * 
	 * 
	 * 
	 */
	public FtpExplorer(String uname, String pass, String adress, String file, int port) {
		this.uname=uname;
		this.pass=pass;
		this.address=adress.trim();
		this.file=file.trim();
		this.port=port;
	}
	/*
	 * get InputStream from URLConnection and 
	 * retrieve file into StringBuilder
	 * 
	 */
	public StringBuilder getFile() {
		StringBuilder strb = new StringBuilder("");
		try {
			Scanner scanner = new Scanner(connection.getInputStream());
			while(scanner.hasNext()) {
				strb.append(scanner.hasNextLine());
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return strb;
	}
	/*
	 * open URLConnection
	 * 
	 */
	public void connect() {
		try {
			connection = new URL("sftp://"+uname+":"+pass+"@"+address+":"+port+"/"+file).openConnection();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 
	 * 
	 */
	public void disconnect() {
	}
	
}
