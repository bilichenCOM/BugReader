import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

import config.Configuration;

@Deprecated
public class Reader implements Configuration {	
	InputStreamReader reader;
	InputStreamReader reader_codes;
	Scanner scanner;
	Scanner scanner_codes;
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
				reader_codes = new InputStreamReader(new FileInputStream(
						DIRECTORY
						), Charset.forName("utf8"));
				
				scanner = new Scanner(reader);
				scanner_codes = new Scanner(reader_codes);
				scanner_codes.useDelimiter("\t");
				scanner.hasNextLine();
				
				while(scanner.hasNextLine()) {
					String expression = scanner.nextLine();
					expression=expression.replaceAll("^.+"+DELIMITER, "");
					if(expression!=null) this.string+=expression+DELIMITER; 
				}
				reader.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("Read-File not found!");
			} catch (IOException e) {
				System.out.println("IOException - operation is denied");
				e.printStackTrace();
			}
			try {
				reader = new InputStreamReader(new FileInputStream(
						FILE_PATH+i+FILE_NAME+"."+FILE_FORMAT
						), Charset.forName("utf8").newDecoder());
				
				scanner = new Scanner(reader);
				scanner.nextLine();
				
				while(scanner.hasNext()) {
					String expression="<>";
					String prod_name="<>";
					scanner.next();
					expression=scanner.next();
					while(scanner_codes.hasNext()) {
						if(expression.equals(scanner_codes.next())) {
							prod_name=scanner_codes.next();
						}
					}
					expression+=scanner.next()+ " : ";
					expression+=prod_name;
					scanner.nextLine();
					if(expression!=null) this.string+=expression+DELIMITER;
				}
				reader.close();
			} catch (Exception e) {
				
			}
	}
	public String getString() {
		return this.string;
	}
	public static int getFileInd() {
		return i;
	}
}
