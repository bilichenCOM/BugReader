package sys;

import java.util.Scanner;

public class HtmlData {

	private StringBuilder htmlData;
	
	public HtmlData(StringBuilder data, String data_file_delimiter) {
		this.htmlData=formateDataToHtml(data, data_file_delimiter);
	}
	
	private StringBuilder formateDataToHtml(StringBuilder data, String data_file_delimiter) {
		StringBuilder htmlData = new StringBuilder();
		
		if(data.length()==0) return new StringBuilder();
		
		Scanner scanner = new Scanner(data.toString());
		htmlData.append("<html><head><title>BugReport</title><style>table, th, td {border: 1px solid black;background-color: #f5f5f5;}</style></head><body><table>");
		while(scanner.hasNextLine()) {
			htmlData.append("<tr>");
			
			String[] line = scanner.nextLine().split(data_file_delimiter);
			for(String s:line) {
				htmlData.append("<td>");
				htmlData.append(s);
				htmlData.append("</td>");
			}
			htmlData.append("</tr>");
		}
		htmlData.append("</table></body></html>");
		scanner.close();
		
		
		return htmlData;
	}
	public StringBuilder getHtmlData() {
		return this.htmlData;
	}
}
