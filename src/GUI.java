import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import config.Configuration;

public class GUI implements Configuration{
	JFrame frame;
	Panel epanel;
	Panel npanel;
	Panel spanel;
	Panel wpanel;
	JTable btable;
	JLabel label;
	JButton blocal;
	JButton bnetwork;
	
	private int window_height=300;
	private int window_width=400;
	
	
	public GUI(int window_heigth, int window_width) {
		this.window_height = window_heigth;
		this.window_width = window_width;
		frame = new JFrame();
		frame.setSize(this.window_width, this.window_height);
		frame.setTitle("BugReader");
	}
	public GUI() {
		frame = new JFrame();
		frame.setSize(this.window_width, this.window_height);
		frame.setTitle("BugReader");
	}
	
	public void run() {
		blocal = new JButton("Run\r\n(Local files)");
		blocal.setSize(100, 20);
		blocal.addMouseListener(new BLocalListener());
		bnetwork = new JButton("Run\r\n(Download files)");
		bnetwork.setSize(100, 20);
		label = new JLabel(ORGANIZATION+" "+YEAR);
		epanel = new Panel();
		epanel.add(blocal);
		epanel.add(bnetwork);
		wpanel = new Panel();
		wpanel.add(label);
		
		frame.getContentPane().add(BorderLayout.EAST,epanel);
		frame.getContentPane().add(BorderLayout.WEST, wpanel);
		frame.setVisible(true);
	}
	public class BLocalListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			Engine engine = new Engine();
			engine.run("o");
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
	public class BNetworkListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
//			Engine engine = new Engine();
//			engine.runNetwork();
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public int getWindow_height() {
		return window_height;
	}

	public void setWindow_height(int window_height) {
		this.window_height = window_height;
	}

	public int getWindow_width() {
		return window_width;
	}

	public void setWindow_width(int window_width) {
		this.window_width = window_width;
	}

	class Panel extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			g.setColor(Color.GREEN);
			this.setVisible(true);
			
		}
	}

}
