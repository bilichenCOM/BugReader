import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HttpClient {
	public void run() {
		String domain = "https://stsystem.com.ua";
		try {
			URL url = new URL(domain);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			System.out.println("connection is established!");
			
			con.setRequestMethod("POST");
			con.setRequestProperty("Host", domain);
			con.setRequestProperty("Content-Type", "text/html");
			con.setDoInput(true);
			
			System.out.println(con.getResponseCode()+" "+con.getResponseMessage()+"\r\n"+con.getHeaderFields());
			
			Scanner sc = new Scanner(con.getInputStream(), "utf-8");
			
			while(sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
			
			con.disconnect();
			
		} catch (IOException e) {
			System.out.println("Error: IOException");
			e.printStackTrace();
		}
	}
}
