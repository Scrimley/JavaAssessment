package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Course;
import model.Module;

public class ProfileCreatePanel extends JPanel {

	private JComboBox<Course> cboCourses; 
	private JTextField name;
	private JTextField pnumber;
	private JButton createButton;
	private GridLayout experimentLayout = new GridLayout(0,2,10,5);

	public ProfileCreatePanel() {
		
		cboCourses = new JComboBox<Course>();
		Course[] courses = setupAndGetCourses();
		populateComboBox(courses);
		
		name = new JTextField();
        
        pnumber = new JTextField();
		
		createButton = new JButton("Create Profile");
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(createButton);
		
		final JPanel profileGrid = new JPanel();
		
		//make labels
		JLabel courselbl = new JLabel("Select course:", SwingConstants.RIGHT);
		JLabel namelbl = new JLabel("Input full name:", SwingConstants.RIGHT);
		JLabel pnumberlbl = new JLabel("Input P number:", SwingConstants.RIGHT);

		profileGrid.setLayout(experimentLayout);
	    profileGrid.add(courselbl);
        profileGrid.add(cboCourses);
        profileGrid.add(namelbl);
        profileGrid.add(name);
        profileGrid.add(pnumberlbl);
        profileGrid.add(pnumber);
        
        Box outerBox = Box.createVerticalBox();
        outerBox.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
        outerBox.add(profileGrid, BorderLayout.CENTER);
        outerBox.add(Box.createVerticalStrut(10), BorderLayout.SOUTH);
        outerBox.add(buttonBox, BorderLayout.SOUTH);
        
        this.add(outerBox);
	}

	public void populateComboBox(Course[] courses) { 
		for (Course c : courses) { 
			cboCourses.addItem(c); 
		} 
	} 

	private Course[] setupAndGetCourses() { //to be moved into controller
		Module ctec2121 = new Module("CTEC2121", "Organisations, Project Management and Research"); 
		Module ctec2122 = new Module("CTEC2122", "Forensics and Security"); 
		Module ctec2602 = new Module("CTEC2602", "OO Software Design and Development"); 
		Module ctec2701 = new Module("CTEC2701", "Multi-tier Web Applications"); 
		Module ctec2901 = new Module("CTEC2901", "Data Structures and Algorithms"); 
		Module lawg2003 = new Module("LAWG2003", "Issues in Criminal Justice"); 

		Course compSci = new Course("Computer Science"); 
		compSci.addModule(ctec2121); 
		compSci.addModule(ctec2602); 
		compSci.addModule(ctec2701); 
		compSci.addModule(ctec2901); 

		Course softEng = new Course("Software Engineering"); 
		softEng.addModule(ctec2121); 
		softEng.addModule(ctec2602); 
		softEng.addModule(ctec2701); 
		softEng.addModule(ctec2901); 

		Course compSecu = new Course("Computer Security"); 
		compSecu.addModule(ctec2121); 
		compSecu.addModule(ctec2122); 
		compSecu.addModule(ctec2701); 
		compSecu.addModule(ctec2901); 

		Course forenComp = new Course("Forensic Computing"); 
		forenComp.addModule(ctec2121); 
		forenComp.addModule(ctec2122); 
		forenComp.addModule(ctec2701); 
		forenComp.addModule(lawg2003); 

		Course[] courses = new Course[4]; 
		courses[0] = compSci; 
		courses[1] = softEng; 
		courses[2] = compSecu; 
		courses[3] = forenComp; 

		return courses; 
	}
}
