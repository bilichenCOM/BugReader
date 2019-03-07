import java.awt.List;
import java.util.ArrayList;

public class Engine implements Configuration {
	
	public void runLocal() {
		CsvReader csvr = new CsvReader("a.csv");
		System.out.println(csvr.readContent().toString());
		System.out.println(csvr.readColumn(20).toString());

	}
	public void runNetwork() {
		
	}
	public void setupGUI() {
		new GUI().run();
	}
}
