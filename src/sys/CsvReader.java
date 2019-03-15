package sys;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import config.Configuration;


public class CsvReader implements Configuration {	
	private String file_path;
	private String delimiter;
	private String charset;
	
	static final String DELIMITER = Configuration.DELIMITER;
	static final String CHARSET = Configuration.CHARSET;
	
	public CsvReader(String file_path, String delimiter, String charset) {
		this.file_path=file_path;
		this.delimiter=delimiter;
		this.charset=charset;
	}
	public CsvReader(String file_path) {
		this(file_path,DELIMITER,CHARSET);
	}
	
	public StringBuilder readColumn(int col_num) {
		StringBuilder strb = new StringBuilder("");
		try {
			
			Scanner scanner = new Scanner(new FileInputStream(file_path),charset);
			scanner.useDelimiter(delimiter);
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Scanner ls = new Scanner(line);
				ls.useDelimiter(delimiter);
				for(int i = 0; i<col_num-1; i++) {
					if(ls.hasNext()) ls.next();
					else break;
				}
				if(ls.hasNext()) strb.append(ls.next()+"\r\n");
				ls.close();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("file:"+file_path+" - not found");
		}
		
		return strb;
	}
	
	public StringBuilder readContent() {
		StringBuilder strb = new StringBuilder("");
		try {
			Scanner scanner = new Scanner(new FileInputStream(file_path),charset);
			scanner.useDelimiter(delimiter);
			while(scanner.hasNextLine()) {
				strb.append(scanner.nextLine()+"\r\n");
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("file:"+file_path+" - not found");
		}
		return strb;
	}
}
