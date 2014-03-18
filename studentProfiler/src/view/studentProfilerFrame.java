package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class studentProfilerFrame extends JFrame {
	
	private ProfileCreatePanel tab1;
	private markInputPanel tab2;
	
	public studentProfilerFrame() {
		this.setTitle("Student Progress Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create tabPane
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
	    tabPane.setPreferredSize(new Dimension(350, 300));
	    this.add(tabPane); //add tab pane to the frame's content.
		
	    //create tab1
		tab1 = new ProfileCreatePanel();
		tabPane.add("Create Profile", tab1);
		
		 //create tab2
		tab2 = new markInputPanel();
		tabPane.add("Input Marks", tab2);
		
		//place tabs in the tabPane
		this.add(tabPane);
		
		this.pack();
		this.setVisible(true);
		this.setResizable(false); // stop this container from being resized.
	}
	
	public static void main(String[] arg) {
		studentProfilerFrame frame = new studentProfilerFrame();
	}
}
