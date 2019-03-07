import java.util.List;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.IDN;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

public class HttpClient{
	public void run() {
		HttpsURLConnection connection=null;
		String cookie="";
		String adress = "https://stsystem.com.ua/uiSNOC/anon/login/login";
		String keyword = "value=\"";
		String token = "";
		String query = "?uname=MBILICHENKO&upwd=%23bilichenCOM11235813&_csrf=";
		String url = adress+query+token;
		String method = "POST";
		String response = "";
		try {
			Pattern p = Pattern.compile(".*<input type=\"hidden\" name=\"_csrf\" value=.*>");
			Matcher matcher;
			
			for(int i = 0; i<5; i++) {
				connection = (HttpsURLConnection) new URL(url).openConnection();
				connection.setRequestMethod(method);
				connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
				connection.setRequestProperty("Cookie", cookie);
				connection.setRequestProperty("Content-Type", "text/html");
				connection.setRequestProperty("Accept", "*/*");
				connection.setRequestProperty("transfer-encoding", "chuncked");
				System.out.println(connection.getHeaderFields());
				cookie+=";"+connection.getHeaderField("Set-Cookie");
				System.out.println(url+" ["+connection.getHeaderField("Content-Length")+"]"+method);
				if(i>1&&i<3) method="GET";
				else method="POST";
				if(connection.getResponseCode()==403) continue;
				Scanner sc = new Scanner(connection.getInputStream(),"utf-8");
				response="";
				while(sc.hasNext()) {
					String line = sc.nextLine();
					matcher = p.matcher(line);
					if(matcher.matches()) {
						token = getToken(line, keyword);
					}
					response+=line;
				}
				sc.close();
				url = adress+query+token;
			}
			System.out.println(response);
		} catch (IOException e) {
			System.out.println("Error: IOException");
			e.printStackTrace();
		}
	}
	private static String getToken(String input, String keyword) {
		return input.indexOf(keyword)>=0?input.substring(input.indexOf(keyword)+keyword.length(), 
							   input.indexOf(keyword)+input.substring(input.indexOf(keyword)).indexOf("\"/>")):
								   "";
	}
}