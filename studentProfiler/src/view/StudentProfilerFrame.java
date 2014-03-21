package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class StudentProfilerFrame extends JFrame {
	
	private MenuBar bar;
	private ProfileCreatePanel tab1;
	private MarkInputPanel tab2;
	private OverviewPanel tab3;
	
	public StudentProfilerFrame() {
		this.setTitle("Student Progress Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    //create bar
	    bar = new MenuBar();
	    bar = new MenuBar();
		this.setJMenuBar(bar);
	    
		//create tabPane
		JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
	    tabPane.setPreferredSize(new Dimension(400, 300));
	    this.add(tabPane); //add tab pane to the frame's content.
	    
	    //create tab1
		tab1 = new ProfileCreatePanel();
		tabPane.add("Create Profile", tab1);
		
		//create tab2
		tab2 = new MarkInputPanel();
		tabPane.add("Input Marks", tab2);
		
		//create tab3
		tab3 = new OverviewPanel();
		tabPane.add("Overview Results", tab3);
		
		//place tabs in the tabPane
		this.add(tabPane);
		
		this.pack();
		this.setVisible(true);
		//this.setResizable(false); // stop this container from being resized.
	}

	public MarkInputPanel getMarkInputPanel() {
		return tab2;
	}

	public ProfileCreatePanel getProfileCreatePanel() {
		return tab1;
	}

	public OverviewPanel getOverviewPanel() {
		return tab3;
	}
}
