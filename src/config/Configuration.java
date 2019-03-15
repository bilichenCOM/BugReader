package config;

public abstract interface Configuration {
	public static final String DELIMITER = "\\|";
	
	public static final String FILE_PATH="";
	public static final String FILE_NAME="a.csv";
	public static final String FILE_FORMAT="csv";
	public static final String CHARSET="utf-8";
	
	public static final String OUTPUT_FILE_NAME="extracted_bugs";
	public static final String OUTPUT_FILE_FORMAT="txt";
	public static final String DB_DIRECTORY = "db/db.txt";
	
	public static final String COMMENTS_HEADER="Помилки в ";
	public static final String COMMENTS_SHOP1="OWN-Shop";
	public static final String COMMENTS_SHOP2="E-Shop";
	
	public static final String ORGANIZATION = "KS";
	public static final String YEAR = "2019";
	
	public static final String CSS_blueTable = "table.blueTable {\r\n" + 
			"  border: 1px solid #1C6EA4;\r\n" + 
			"  background-color: #EEEEEE;\r\n" + 
			"  width: 100%;\r\n" + 
			"  text-align: left;\r\n" + 
			"  border-collapse: collapse;\r\n" + 
			"}\r\n" + 
			"table.blueTable td, table.blueTable th {\r\n" + 
			"  border: 1px solid #AAAAAA;\r\n" + 
			"  padding: 3px 2px;\r\n" + 
			"}\r\n" + 
			"table.blueTable tbody td {\r\n" + 
			"  font-size: 13px;\r\n" + 
			"}\r\n" + 
			"table.blueTable tr:nth-child(even) {\r\n" + 
			"  background: #D0E4F5;\r\n" + 
			"}\r\n" + 
			"table.blueTable thead {\r\n" + 
			"  background: #1C6EA4;\r\n" + 
			"  background: -moz-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);\r\n" + 
			"  background: -webkit-linear-gradient(top, #5592bb 0%, #327cad 66%, #1C6EA4 100%);\r\n" + 
			"  background: linear-gradient(to bottom, #5592bb 0%, #327cad 66%, #1C6EA4 100%);\r\n" + 
			"  border-bottom: 2px solid #444444;\r\n" + 
			"}\r\n" + 
			"table.blueTable thead th {\r\n" + 
			"  font-size: 15px;\r\n" + 
			"  font-weight: bold;\r\n" + 
			"  color: #FFFFFF;\r\n" + 
			"  border-left: 2px solid #D0E4F5;\r\n" + 
			"}\r\n" + 
			"table.blueTable thead th:first-child {\r\n" + 
			"  border-left: none;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"table.blueTable tfoot {\r\n" + 
			"  font-size: 14px;\r\n" + 
			"  font-weight: bold;\r\n" + 
			"  color: #FFFFFF;\r\n" + 
			"  background: #D0E4F5;\r\n" + 
			"  background: -moz-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);\r\n" + 
			"  background: -webkit-linear-gradient(top, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);\r\n" + 
			"  background: linear-gradient(to bottom, #dcebf7 0%, #d4e6f6 66%, #D0E4F5 100%);\r\n" + 
			"  border-top: 2px solid #444444;\r\n" + 
			"}\r\n" + 
			"table.blueTable tfoot td {\r\n" + 
			"  font-size: 14px;\r\n" + 
			"}\r\n" + 
			"table.blueTable tfoot .links {\r\n" + 
			"  text-align: right;\r\n" + 
			"}\r\n" + 
			"table.blueTable tfoot .links a{\r\n" + 
			"  display: inline-block;\r\n" + 
			"  background: #1C6EA4;\r\n" + 
			"  color: #FFFFFF;\r\n" + 
			"  padding: 2px 8px;\r\n" + 
			"  border-radius: 5px;\r\n" + 
			"}";
}
