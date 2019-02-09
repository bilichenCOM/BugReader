import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Reader {
	private static final String OUT_FILE_NAME = "_extracted_bugs";
	private static final String DELIMITER = "(\\r)?\\n";
	
	private String file_path = "/";
	private String file_format = "csv";
	private String file_name = "_bug";
	private int file_count = 1;
	
	public Reader(int  file_count) {
		this.file_count=file_count;
	}
	private void setConfig() {
		
	}
	
	private void extract() {
		for(int i = 1; i<=this.file_count; i++) {

			InputStreamReader reader;
			OutputStreamWriter writer;
			Scanner scanner;

			try { 
				reader = new InputStreamReader(new FileInputStream(file_path+file_name+i+"."+file_format), Charset.forName("utf8").newDecoder());
				scanner = new Scanner(reader);
				writer = new OutputStreamWriter(new FileOutputStream(OUT_FILE_NAME+i+".txt"), Charset.forName("utf8").newEncoder());
				
				scanner.useDelimiter(DELIMITER);
				
				while(scanner.hasNext()) {
					String expression = scanner.next();
					expression=expression.replaceAll("^.+[\\|]", "");
					writer.write(expression+"\r\n");
				}
				reader.close();
				writer.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("File not found!");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IOException - operation is denied");
				e.printStackTrace();
			} 
		}

	}
	

	public static void main(String[] args) {
		Reader reader = new Reader(1);
		reader.extract();
		
		
	}

}
