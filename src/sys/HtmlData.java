package sys;

import java.util.Scanner;

import config.Configuration;

public class HtmlData implements Configuration {

	private StringBuilder htmlData;
	
	private static final String DELIMITER = Configuration.DELIMITER;
	
	public HtmlData(StringBuilder data, String data_file_delimiter) {
		this.htmlData=formateDataToHtml(data, data_file_delimiter);
	}
	public HtmlData(StringBuilder data) {
		this(data, DELIMITER);
	}
	
	private StringBuilder formateDataToHtml(StringBuilder data, String data_file_delimiter) {
		StringBuilder htmlData = new StringBuilder();
		
		if(data.length()==0) return new StringBuilder();
		
		Scanner scanner = new Scanner(data.toString());
		htmlData.append("<html>"
				+ "<head><title>BugReport</title>"
				+ "<style>"
				+ CSS_blueTable
				+ "</style>"
				+ "</head>"
				+ "<body><table class='blueTable'>");
		if(scanner.hasNextLine()) {
			String[] header = scanner.nextLine().split(data_file_delimiter);
			htmlData.append("<thead><tr>");
			for(String s:header) {
				htmlData.append("<th>");
				htmlData.append(validate(s));
				htmlData.append("</th>");
			}
			htmlData.append("</thead></tr>");
		}
		while(scanner.hasNextLine()) {
			htmlData.append("<tr>");
			
			String[] line = scanner.nextLine().split(data_file_delimiter);
			for(String s:line) {
				htmlData.append("<td>");
				htmlData.append(validate(s));
				htmlData.append("</td>");
			}
			htmlData.append("</tr>");
		}
		htmlData.append("</table></body></html>");
		scanner.close();
		
		
		return htmlData;
	}
	private static String validate(String s) {
		String html = null;
		if(s==null) return html;
		html=s.replaceAll("<", "&lt;");
		html=html.replaceAll(">", "&gt;");
		html=html.replaceAll("\\\\","");
		return html;
	}
	
	public StringBuilder getHtmlData() {
		return this.htmlData;
	}
}
