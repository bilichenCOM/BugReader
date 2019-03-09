package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import sys.CsvReader;

public class ProductCodes {

	Map<String, String> pcodes;
	
	public ProductCodes(String product_file) {
		pcodes = new HashMap<String, String>();
		
		CsvReader reader = new CsvReader(product_file,"\t","utf-8");
		
		StringBuilder keys = reader.readColumn(1);
		StringBuilder values = reader.readColumn(2);
		
		Scanner k_sc = new Scanner(keys.toString());
		Scanner v_sc = new Scanner(values.toString());
		
		while(k_sc.hasNextLine()&&v_sc.hasNextLine()) {
			pcodes.put(k_sc.nextLine(), v_sc.nextLine());
		}
		k_sc.close();
		v_sc.close();
	}
	
	public String getProductName(String key) {
		return key==null?"product code is empty":
			!pcodes.containsKey(key)?"<no product for this code>":
			pcodes.get(key);
	}
	
	public Map<String, String> getPcodes() {
		return pcodes;
	}
	
}
