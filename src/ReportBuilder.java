import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import model.ProductCodes;

public class ReportBuilder {
	StringBuilder date;
	StringBuilder code;
	StringBuilder serial;
	StringBuilder errormessage;
	ProductCodes pcodes;
	
	public ReportBuilder(StringBuilder date, StringBuilder code,StringBuilder serial, StringBuilder errormessage, ProductCodes pcodes) {
		this.date=date;
		this.code=code;
		this.serial=serial;
		this.errormessage=errormessage;
		this.pcodes=pcodes;
	}
	
	public StringBuilder buildReport() {
		StringBuilder strb = new StringBuilder();
		
		Scanner d_sc = new Scanner(date.toString());
		Scanner c_sc = new Scanner(code.toString());
		Scanner s_sc = new Scanner(serial.toString());
		Scanner err_sc = new Scanner(errormessage.toString());
		
		while(d_sc.hasNextLine()&&c_sc.hasNextLine()&&err_sc.hasNextLine()) {
			String d = d_sc.nextLine();
			String c = c_sc.nextLine();
			String s = s_sc.nextLine();
			String err = err_sc.nextLine();
			String product_name = pcodes.getProductName(c);
			
			strb.append(d +" : ");
			strb.append(c+" : ");
			strb.append(s+" : ");
			strb.append(err+" : ");
			strb.append(product_name);
			strb.append("\r\n");
		}
		
		d_sc.close();
		c_sc.close();
		s_sc.close();
		err_sc.close();
		
		strb = removeDuplicates(strb);
		
		return strb;	
	}
	
	private StringBuilder removeDuplicates(StringBuilder strb) {
		Set<String> set = new HashSet<>();
		
		Scanner scanner = new Scanner(strb.toString());
		
		while(scanner.hasNextLine()) {
			set.add(scanner.nextLine());
		}
		scanner.close();
		
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			strb.append(it.next());
			strb.append("\r\n");
		}
		
		return strb;
	}
}
