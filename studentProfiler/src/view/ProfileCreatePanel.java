package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Course;

public class ProfileCreatePanel extends JPanel {

	private JComboBox<Course> cboCourses; 
	private JTextField name;
	private JTextField pnumber;
	private JButton createButton;

	public ProfileCreatePanel() {
		
		cboCourses = new JComboBox<Course>();
		cboCourses.getPreferredSize();
		
		name = new JTextField(13);
        
        pnumber = new JTextField(13);
		
		createButton = new JButton("Create Profile");
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(createButton);
				
		//make labels
		JLabel courselbl = new JLabel("Select course:", SwingConstants.RIGHT);
		JLabel namelbl = new JLabel("Input full name:", SwingConstants.RIGHT);
		JLabel pnumberlbl = new JLabel("Input P number:", SwingConstants.RIGHT);
		courselbl.getPreferredSize();
		namelbl.getPreferredSize();
		pnumberlbl.getPreferredSize();

		//add items to grid
		GridLayout gridlayout = new GridLayout(0,2,10,5);
		final JPanel profileGrid = new JPanel();
		profileGrid.setLayout(gridlayout);
	    profileGrid.add(tempPanel.add(courselbl));
        profileGrid.add(tempPanel.add(cboCourses));
        profileGrid.add(tempPanel.add(namelbl));
        profileGrid.add(tempPanel.add(name));
        profileGrid.add(tempPanel.add(pnumberlbl));
        profileGrid.add(tempPanel.add(pnumber));
       
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
	
	public void addCreateListener(ActionListener al) {
		createButton.addActionListener(al);
	}
	
	public JComboBox<Course> getCourse() {
		return cboCourses;
	}
	
	public JTextField getNameInput() {
		return name;
	}
	
	public JTextField getpNumberInput() {
		return pnumber;
	}
}
