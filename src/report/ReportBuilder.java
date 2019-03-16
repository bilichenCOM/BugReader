package report;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import config.Configuration;
import model.Dimension;

public class ReportBuilder implements Configuration{
	
	StringBuilder pcode;
	Dimension dates;
	Dimension product_names;
	Dimension product_serials;
	Dimension errors;
	
	private int line_count=1;
	
	private final static String DELIMITER = Configuration.DELIMITER;

	
	public ReportBuilder(StringBuilder pcode, Dimension dates, Dimension serials, Dimension names, Dimension err) {
		this.pcode=pcode;
		this.dates=dates;
		this.errors=err;
		this.product_names=names;
		this.product_serials=serials;
	}
	
	public StringBuilder buildReport() {
		StringBuilder strb = new StringBuilder();

		Scanner c_sc = new Scanner(removeDuplicates(pcode,"\\r\\n").toString());
		c_sc.useDelimiter(";");
		int count = 1;
		while(c_sc.hasNext()) {
			String pcode = c_sc.next();
			
			String date = dates.getValueOf(pcode);
			String serial = product_serials.getValueOf(pcode);
			String product_name = product_names.getValueOf(pcode);
			StringBuilder err = removeDuplicates(new StringBuilder(errors.getValueOf(pcode)),";");
			
			strb.append(date + DELIMITER);
			strb.append(pcode+DELIMITER);
			strb.append(serial+DELIMITER);
			strb.append(product_name+DELIMITER);
			strb.append(err);
			strb.append("\r\n");
			
			count++;
			
		}
		setLineCount(count-1);
		strb.append("errors count: "+(line_count));
		
		c_sc.close();
		
		
		return strb;	
	}
	
	private StringBuilder removeDuplicates(StringBuilder in_strb, String delimiter) {
		StringBuilder res_strb = new StringBuilder();
		
		Set<String> set = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return -1*s1.compareTo(s2);
			}
			
		});
		
		Scanner scanner = new Scanner(in_strb.toString());
		scanner.useDelimiter(delimiter);
		
		while(scanner.hasNext()) {
			set.add(scanner.next());
		}
		scanner.close();
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			res_strb.append(it.next());
			res_strb.append(";");
		}
		
		return res_strb;
	}
	public int getSize() {
		return this.line_count;
	}
	private void setLineCount(int line_count) {
		this.line_count=line_count;
	}
}
