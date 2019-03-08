import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import config.Configuration;

public class Editor implements Configuration {

	String output;
	Set<String> set;
	
	Scanner scanner;
	InputStreamReader reader;
	InputStream is;
	String input;
	
	public Editor(String input) {
		this.input=input;
	}
	
	public void filter() {
		try {
			is = new ByteArrayInputStream(this.input.getBytes(Charset.forName("utf8")));
			reader = new InputStreamReader(is);
			scanner = new Scanner(reader);
			set = new TreeSet<String>();
			scanner.useDelimiter(DELIMITER);
			scanner.next();
			
			while(scanner.hasNext()) {
				String word=scanner.next();
				word=word.replaceAll("[^\\w]$", "");
				if(word!=null) set.add(word);
			}
			
			scanner.close();
			reader.close();
			} catch (IOException e) {
				System.out.println("IOException");
				e.printStackTrace();
		}
	}
	public String addComments() {
		if(set.size()>0) {
			String shop="";
			switch(Reader.getFileInd()) { 
			case 1:
				shop=COMMENTS_SHOP1;
				break;
			case 2:
				shop=COMMENTS_SHOP2;
				break;
			default:
				shop="unknown shop";
				break;
			}
			output+=COMMENTS_HEADER+shop+DELIMITER;
		}
		Object[] o = set.toArray();
		for(int i = 0;i<set.size();i++) {
			String word =(String)o[i]+DELIMITER;
			output+=word;
		}
		return output!=null?output:"";
	}
}
