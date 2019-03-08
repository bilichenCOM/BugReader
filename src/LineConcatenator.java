import java.util.Scanner;

import config.Configuration;

public class LineConcatenator implements Configuration{
	
	public static StringBuilder concatenate(StringBuilder lines1, StringBuilder lines2, String delimiter) {
		StringBuilder strb = new StringBuilder();
		Scanner s1 = new Scanner(lines1.toString());
		Scanner s2 = new Scanner(lines2.toString());
		
		delimiter = delimiter.replace("\\", "");
		
		while(s1.hasNextLine()||s2.hasNextLine()) {
		
			if(s1.hasNextLine()) strb.append(s1.nextLine()+delimiter);
			if(s2.hasNextLine()) strb.append(s2.nextLine()+delimiter);
			
			strb.append("\r\n");
		}
		s1.close();
		s2.close();
		
		return strb;
	}
	
	public static StringBuilder concatenate(StringBuilder lines1, StringBuilder lines2) {
		return concatenate(lines1, lines2, DELIMITER);
	}
}