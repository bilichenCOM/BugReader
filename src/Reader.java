import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;


public class Reader implements Configuration {	
	InputStreamReader reader;
	Scanner scanner;
	String string;	
	
	private static int i = 0;
	
	public Reader() {
		i++;
	}
	public void extract() {

			try { 
				reader = new InputStreamReader(new FileInputStream(
						FILE_PATH+FILE_NAME+i+"."+FILE_FORMAT
						),Charset.forName("utf8").newDecoder());
				
				scanner = new Scanner(reader);
				scanner.useDelimiter("(\\r)?\\n");
				
				while(scanner.hasNext()) {
					String expression = scanner.next();
					expression=expression.replaceAll("^.+"+DELIMITER, "");
					if(expression!=null) this.string+=expression+DELIMITER; 
				}
				reader.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IOException - operation is denied");
				e.printStackTrace();
			} 
	}
	public String getString() {
		return this.string;
	}
	public static int getFileInd() {
		return i;
	}
}
