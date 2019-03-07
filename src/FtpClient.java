import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class FtpClient {
	private URLConnection connection;

	public void getContent(String url) {
		InputStream is;
		StringBuilder content;
		Scanner sc;
		
		OutputStream os;
		OutputStreamWriter osw;
		
		try {
			connection = new URL(url).openConnection();
			is = connection.getInputStream();
			content = new StringBuilder();
			sc = new Scanner(is);
			while (sc.hasNext()) {
				content.append(sc.next());
			}
			is.close();
			sc.close();
			
			os = new FileOutputStream("file.txt");
			osw = new OutputStreamWriter(os);
			osw.write(content.toString());
			osw.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("FIle not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void teardown() {
	}
	public URLConnection getConnection() {
		return connection;
	}
	public void setConnection(URLConnection connection) {
		this.connection = connection;
	}
}
