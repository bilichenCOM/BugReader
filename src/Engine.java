
public class Engine implements Configuration {
	Reader reader;
	Editor editor;
	Writer writer;
	GUI gui;
	
	public void runLocal() {
		
		for(int i = 0; i<FILE_COUNT; i++) {
			reader = new Reader();
			reader.extract();
			editor = new Editor(reader.getString());
			editor.filter();
			writer = new Writer(editor.addComments());
			writer.writeFile();
		}
		
	}
	public void runNetwork() {
		
	}
	public void setupGUI() {
		gui = new GUI();
		gui.run();
	}
}
