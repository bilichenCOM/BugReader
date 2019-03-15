package report;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import config.Configuration;
import model.Dimension;

public class ReportBuilder implements Configuration{
	StringBuilder date;
	StringBuilder pcode;
	StringBuilder errormessage;
	Dimension product_names;
	Dimension product_serials;
	
	private final static String DELIMITER = Configuration.DELIMITER;
	
	public ReportBuilder(StringBuilder date, StringBuilder pcode, StringBuilder errormessage, Dimension product_names, Dimension product_serials) {
		this.date=date;
		this.pcode=pcode;
		this.errormessage=errormessage;
		this.product_names=product_names;
		this.product_serials=product_serials;
	}
	
	public StringBuilder buildReport() {
		StringBuilder strb = new StringBuilder();
		
		Scanner d_sc = new Scanner(date.toString());
		Scanner c_sc = new Scanner(pcode.toString());
		Scanner err_sc = new Scanner(errormessage.toString());
		
		while(d_sc.hasNextLine()&&c_sc.hasNextLine()&&err_sc.hasNextLine()) {
			String date = d_sc.nextLine();
			String pcode = c_sc.nextLine();
			String serial = product_serials.getValueOf(pcode);
			String err = err_sc.nextLine();
			String product_name = product_names.getValueOf(pcode);
			
			strb.append(date + DELIMITER);
			strb.append(pcode+DELIMITER);
			strb.append(serial+DELIMITER);
			strb.append(product_name+DELIMITER);
			strb.append(err);
			strb.append("\r\n");
			
		}
		
		d_sc.close();
		c_sc.close();
		err_sc.close();
		
		strb = removeDuplicates(strb);
		
		return strb;	
	}
	
	private StringBuilder removeDuplicates(StringBuilder in_strb) {
		StringBuilder res_strb = new StringBuilder();
		
		Set<String> set = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return -1*s1.compareTo(s2);
			}
			
		});
		
		Scanner scanner = new Scanner(in_strb.toString());
		
		while(scanner.hasNextLine()) {
			set.add(scanner.nextLine());
		}
		scanner.close();
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			res_strb.append(it.next());
			res_strb.append("\r\n");
		}
		
		res_strb.append("\r\ntotal lines count: "+set.size());
		
		return res_strb;
	}
}
