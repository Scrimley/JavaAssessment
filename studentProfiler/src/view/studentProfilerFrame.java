package view;

import javax.swing.JFrame;

public class studentProfilerFrame extends JFrame {
	
	private ProfileCreatePanel tab1;
	
	public studentProfilerFrame() {
		this.setTitle("Student Progress Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tab1 = new ProfileCreatePanel();
		this.add(tab1);
		this.pack();
		this.setVisible(true);
		this.setResizable(false); // stop this container from being resized.
	}
	
	public static void main(String[] arg) {
		studentProfilerFrame frame = new studentProfilerFrame();
	}
}
