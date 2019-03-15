import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.time.LocalDate;

import config.Configuration;
import model.Dimension;
import report.ReportBuilder;
import sys.CsvReader;
import sys.FileIterator;
import sys.HtmlData;

public class Engine {
	
	public void run() {
		FileIterator fi = new FileIterator("","*.csv");
		StringBuilder report = new StringBuilder();
		
		while(fi.hasNextFile()) {
		
			String bugreport_file = fi.nextFilePath();
			String serials_file = (fi.hasNextFile())?fi.nextFilePath():"";
	
			
			CsvReader bugreport = new CsvReader(bugreport_file);
			Dimension product_serials = new Dimension(serials_file, 2, 3, "\\|", "utf-8");
			Dimension product_names = new Dimension(Configuration.DB_DIRECTORY, 1, 2,"\t","utf-8");
			
			StringBuilder date = bugreport.readColumn(2);
			StringBuilder pcode = bugreport.readColumn(13);
			StringBuilder errormessage = bugreport.readColumn(20);
			
			ReportBuilder report_builder = new ReportBuilder(date, pcode, errormessage, product_names, product_serials);
//			report.append("files:["+bugreport_file+"]["+serials_file+"] has been processed\r\n\r\n");
			report.append(report_builder.buildReport());
//			report.append("\r\n");
			
		}
		
		if(report.toString().equals("")) return;
		System.out.println(report);
		
		HtmlData htmldata = new HtmlData(report, Configuration.DELIMITER);
		System.out.println(htmldata.getHtmlData());
		
		try {
			FileOutputStream fos = new FileOutputStream(new File("report"+System.currentTimeMillis()+"-"+LocalDate.now()+".html"));
			OutputStreamWriter osw = new OutputStreamWriter(fos,Charset.forName(Configuration.CHARSET));
			osw.write(htmldata.getHtmlData().toString());
			osw.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("File is currently being in use");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException!");
			e.printStackTrace();
		}
	}
	
	public void setupGUI() {
		//new GUI().run();
	}
}
