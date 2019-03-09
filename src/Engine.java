import config.Configuration;
import model.ProductCodes;
import sys.CsvReader;

public class Engine implements Configuration {
	
	public void run() {
		CsvReader errors = new CsvReader("o1.csv");
		CsvReader serials = new CsvReader("o2.csv");
		ProductCodes pcodes = new ProductCodes("db/db.txt");
		
		StringBuilder date = errors.readColumn(1);
		StringBuilder code = errors.readColumn(13);
		StringBuilder serial = serials.readColumn(3);
		StringBuilder errormessage = errors.readColumn(20);
		
		ReportBuilder builder = new ReportBuilder(date, code, serial, errormessage, pcodes);
		StringBuilder report = builder.buildReport();
		
		System.out.println(report);
	}
	
	public void setupGUI() {
		new GUI().run();
	}
}
