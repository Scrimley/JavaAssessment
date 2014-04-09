package view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class StudentProfilerFrame extends JFrame {
	
	private MyMenuBar bar;
	private ProfileCreatePanel tab1;
	private MarkInputPanel tab2;
	private OverviewPanel tab3;
	private JTabbedPane tabPane;
	
	public StudentProfilerFrame() {
		this.setTitle("Student Progress Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    //create bar
	    bar = new MyMenuBar();
	    bar = new MyMenuBar();
		this.setJMenuBar(bar);
	    
		//create tabPane
		tabPane = new JTabbedPane(JTabbedPane.TOP);
	    tabPane.setPreferredSize(new Dimension(550, 280));
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
	
	public JTabbedPane getTabPane() {
		return tabPane;
	}
	
	public MyMenuBar getMyMenuBar() {
		return bar;
	}
}
