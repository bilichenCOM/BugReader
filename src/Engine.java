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
	
			StringBuilder pcodes = new CsvReader(bugreport_file).readColumn(13);
			Dimension dates = new Dimension(bugreport_file,13,1,false);
			Dimension serials = new Dimension(serials_file,2,3);
			Dimension names = new Dimension(Configuration.DB_DIRECTORY,1,2,"\t",true,"utf-8");
			Dimension errors = new Dimension(bugreport_file,13,20);
			
			ReportBuilder report_builder = new ReportBuilder(pcodes, dates, serials, names, errors);
			report = report_builder.buildReport();
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
