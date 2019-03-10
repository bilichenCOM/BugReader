import config.Configuration;
import model.Dimension;
import report.ReportBuilder;
import sys.CsvReader;

public class Engine implements Configuration {
	
	public void run(String bugreport_file, String serials_file) {
		CsvReader bugreport = new CsvReader(bugreport_file);
		Dimension product_serials = new Dimension(serials_file, 2, 3, "\\|", "utf-8");
		Dimension product_names = new Dimension("db/db.txt", 1, 2,"\t","utf-8");
		
		StringBuilder date = bugreport.readColumn(2);
		StringBuilder pcode = bugreport.readColumn(13);
		StringBuilder errormessage = bugreport.readColumn(20);
		
		ReportBuilder report = new ReportBuilder(date, pcode, errormessage, product_names, product_serials);
		System.out.println(report.buildReport());
		
	}
	
	public void setupGUI() {
		new GUI().run();
	}
}
