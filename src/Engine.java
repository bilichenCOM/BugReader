
public class Engine implements Configuration {
	Reader reader;
	Editor editor;
	Writer writer;
	
	public void run() {
		
		for(int i = 0; i<FILE_COUNT; i++) {
			reader = new Reader();
			reader.extract();
			editor = new Editor(reader.getString());
			editor.filter();
			writer = new Writer(editor.addComments());
			writer.writeFile();
		}
		
	}
}
