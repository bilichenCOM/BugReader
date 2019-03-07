import java.util.Scanner;

public class Finder implements Configuration{
	
	public static String vlookup(String text, StringBuilder table, int column, String delimiter) {
		String match = "";
		Scanner scanner = new Scanner(table.toString());
		scanner.useDelimiter(delimiter);
		
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Scanner sc = new Scanner(line);
			
			if(sc.next().trim().equals(text.trim())) {
				
				for(int i = 0; i<column-2;i++) {
					sc.next();
				}
				
				match=sc.next();
				break;
			}
			sc.close();	
		}
		scanner.close();
		
		return match;
	}
	
	public static String vlookup(String text, StringBuilder table, int column) {
		return vlookup(text, table, column, DELIMITER);
	}
	
	public static String vlookup(String text, StringBuilder table) {
		return vlookup(text, table, 2, DELIMITER);
	}
}
