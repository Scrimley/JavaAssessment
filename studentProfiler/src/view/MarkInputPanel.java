package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Course;

public class MarkInputPanel extends JPanel {
	
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
	
	public MarkInputPanel() {
		
		String msg = "Profile not created";
		
		field1 = new JLabel(msg);
		field2 = new JLabel(msg);
		field3 = new JLabel(msg);
		field4 = new JLabel(msg);
		
		cwk1 = new JTextField(2);
		cwk2 = new JTextField(2);
		cwk3 = new JTextField(2);
		cwk4 = new JTextField(2);
		
		exam1 = new JTextField(2);
		exam2 = new JTextField(2);
		exam3 = new JTextField(2);
		exam4 = new JTextField(2);
		
		GridLayout gridLayout = new GridLayout(0,3,10,10);
		final JPanel inputGrid = new JPanel();
		inputGrid.setLayout(gridLayout);
		inputGrid.add(tempPanel.add(new JLabel("Module")));
		inputGrid.add(tempPanel.add(new JLabel("Cwk Mark")));
		inputGrid.add(tempPanel.add(new JLabel("Exam Mark")));
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
	
	public void addClearListener(ActionListener al) {
		clearButton.addActionListener(al);
	}
	
	public void clearAll() {
		cwk1.setText("");
		cwk2.setText("");
		cwk3.setText("");
		cwk4.setText("");
		exam1.setText("");
		exam2.setText("");
		exam3.setText("");
		exam4.setText("");
	}
	
	public void addSubmitListener(ActionListener al) {
		submitButton.addActionListener(al);
	}
	
	public void setLabel(int i, String code, String Title) {
	
		String module = "" + code + " " + Title + "";
		
		switch (i) {
			case 1: field1.setText(module);
					field1.setBorder(new LineBorder(Color.BLACK));
					break;
			case 2: field2.setText(module);
			field2.setBorder(new LineBorder(Color.BLACK));
					break;
			case 3: field3.setText(module);
			field3.setBorder(new LineBorder(Color.BLACK));
					break;
			case 4: field4.setText(module);
			field4.setBorder(new LineBorder(Color.BLACK));
					break;
		}
	}
}
