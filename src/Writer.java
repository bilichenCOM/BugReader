import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Scanner;

import config.Configuration;

@Deprecated
public class Writer implements Configuration {
	
	Scanner scanner;
	OutputStreamWriter writer;
	InputStreamReader reader;
	InputStream is;
	String input;
	
	public Writer(String input) {
		this.input=input;
		is = new ByteArrayInputStream(this.input.getBytes(Charset.forName("utf8")));
		reader = new InputStreamReader(is);
		scanner = new Scanner(reader);
	}
	public void writeFile() {
		try {
			writer = new OutputStreamWriter(new FileOutputStream(
					OUTPUT_FILE_NAME+
					Reader.getFileInd()+
					"."+OUTPUT_FILE_FORMAT
					));
			scanner.useDelimiter(DELIMITER);

			boolean h=false;
			while(scanner.hasNext()) {
				String word = scanner.next();
				word = word.replaceAll("[^\\w]$", "")+"\r\n";
				word = word.replaceAll("null", "");
				if(h) word = "\t"+word;
				h=true;
				writer.write(word);
			}
			writer.close();
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File will be created!");
		} catch (IOException e) {
			System.out.println("IOEception");
			e.printStackTrace();
		}
	}
}
