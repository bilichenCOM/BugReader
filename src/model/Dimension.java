package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import config.Configuration;
import sys.CsvReader;

public class Dimension implements Configuration{

	Map<String, String> dimension;
	
	public static final String DELIMITER = Configuration.DELIMITER;
	public static final String CHARSET = Configuration.CHARSET;
	
	public Dimension(String product_file, int keys_column, int value_column, String delimiter, String charset) {
		dimension = new HashMap<String, String>();
		
		CsvReader reader = new CsvReader(product_file,delimiter,charset);
		
		StringBuilder keys = reader.readColumn(keys_column);
		StringBuilder values = reader.readColumn(value_column);
		
		Scanner k_sc = new Scanner(keys.toString());
		Scanner v_sc = new Scanner(values.toString());
		
		while(k_sc.hasNextLine()&&v_sc.hasNextLine()) {
			String key = k_sc.nextLine();
			String value = v_sc.nextLine();
			if(dimension.containsKey(key))
			dimension.put(key, dimension.get(key)+"; "+value);
			else 
			dimension.put(key, value);
		}
		k_sc.close();
		v_sc.close();
	}
	public Dimension(String product_file, int keys_column, int value_column) {
		this(product_file, keys_column, value_column, DELIMITER, CHARSET);
	}
	
	public String getValueOf(String key) {
		return key==null?"product code is empty":
			!dimension.containsKey(key)?"<NAME VALUE>":
			dimension.get(key);
	}
	
	public Map<String, String> getDimension() {
		return dimension;
	}
	
}
