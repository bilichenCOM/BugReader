import java.io.*;
import java.nio.charset.Charset;
import java.util.Scanner;


public class Reader {
	private static final String OUT_FILE_NAME = "_extracted_bugs";
	private static final String DELIMITER = "(\\r)?\\n";
	
	private String file_path = "";
	private String file_format = "csv";
	private String file_name = "_bug";
	private static int i = 0;
	
	InputStreamReader reader;
	OutputStreamWriter writer;
	Scanner scanner;
	
	public Reader() {
		i++;
	}
	private void setDefaultPath() {
		File f = new File("");
		String p = f.getAbsolutePath()+"/";
		this.file_path=p;
	}
	
	private void setConfig() {
		try {
			reader = new InputStreamReader(new FileInputStream("config.txt"), Charset.forName("utf8").newDecoder());
			scanner = new Scanner(reader);
			
			scanner.useDelimiter("(\\r)?\\n");
			
			while (scanner.hasNext()) {
				String word = scanner.next();
				word=word.replaceAll("\\s", "");
				if(word.indexOf("@filepath")>=0) {
					this.file_path=word.replaceAll("@\\w+:", "");
				} else if(word.indexOf("@filename")>=0) {
					this.file_name=word.replaceAll("@\\w+:", "");
				} else if(word.indexOf("@fileformat")>=0) {
					this.file_format=word.replaceAll("@\\w+:", "");
				}
			}
			
		} catch (Exception e) {
			System.out.println("config file not found. config is default");		}
	}
	
	private void extract() {

			try { 
				reader = new InputStreamReader(new FileInputStream(file_path+file_name+i+"."+file_format), Charset.forName("utf8").newDecoder());
				scanner = new Scanner(reader);
				writer = new OutputStreamWriter(new FileOutputStream(file_path+OUT_FILE_NAME+i+".txt"), Charset.forName("utf8").newEncoder());
				
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
	

	public static void main(String[] args) {
		Reader reader1 = new Reader();
		reader1.setDefaultPath();
		reader1.setConfig();
		reader1.extract();
		
		Reader reader2 = new Reader();
		reader2.setDefaultPath();
		reader2.setConfig();
		reader2.extract();

		
	}
	public String getFile_path() {
		return file_path;
	}
	public String getFile_format() {
		return file_format;
	}
	public String getFile_name() {
		return file_name;
	}

}
