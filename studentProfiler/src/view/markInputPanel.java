package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class markInputPanel extends JPanel {
	
	//Labels
	private JLabel field1;
	private JLabel field2;
	private JLabel field3;
	private JLabel field4;
	
	//Course work textFields
	private JTextField cwk1;
	private JTextField cwk2;
	private JTextField cwk3;
	private JTextField cwk4;
	
	//Exam textFields
	private JTextField exam1;
	private JTextField exam2;
	private JTextField exam3;
	private JTextField exam4;
	
	//buttons
	private JButton clearButton;
	private JButton submitButton;
	
	public markInputPanel() {
		
		JLabel field1 = new JLabel("Profile not created");
		JLabel field2 = new JLabel("Profile not created");
		JLabel field3 = new JLabel("Profile not created");
		JLabel field4 = new JLabel("Profile not created");
		
		JTextField cwk1 = new JTextField(2);
		JTextField cwk2 = new JTextField(2);
		JTextField cwk3 = new JTextField(2);
		JTextField cwk4 = new JTextField(2);
		
		JTextField exam1 = new JTextField(2);
		JTextField exam2 = new JTextField(2);
		JTextField exam3 = new JTextField(2);
		JTextField exam4 = new JTextField(2);
		
		GridLayout gridLayout = new GridLayout(0,3,10,10);
		final JPanel inputGrid = new JPanel();
		inputGrid.setLayout(gridLayout);
		inputGrid.add(tempPanel.add(field1));
		inputGrid.add(tempPanel.add(cwk1));
		inputGrid.add(tempPanel.add(exam1));
		inputGrid.add(tempPanel.add(field2));
		inputGrid.add(tempPanel.add(cwk2));
		inputGrid.add(tempPanel.add(exam2));
		inputGrid.add(tempPanel.add(field3));
		inputGrid.add(tempPanel.add(cwk3));
		inputGrid.add(tempPanel.add(exam3));
		inputGrid.add(tempPanel.add(field4));
		inputGrid.add(tempPanel.add(cwk4));
		inputGrid.add(tempPanel.add(exam4));
		
		clearButton = new JButton("Clear");
		submitButton = new JButton("Submit");
		Box buttonBox = Box.createHorizontalBox();
		buttonBox.add(clearButton);
		buttonBox.add(Box.createHorizontalStrut(10));
		buttonBox.add(submitButton);
		
		Box outerBox = Box.createVerticalBox();
        outerBox.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
        outerBox.add(inputGrid, BorderLayout.CENTER);
        outerBox.add(Box.createVerticalStrut(10), BorderLayout.SOUTH);
        outerBox.add(buttonBox, BorderLayout.SOUTH);
		
		this.add(outerBox);
		
	}
	
}
