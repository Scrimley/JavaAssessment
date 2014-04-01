package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		
		//JPanel this = new JPanel();
		
		GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridbag);

        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        
        GridBagConstraints m = new GridBagConstraints();
        setLayout(gridbag);

        m.fill = GridBagConstraints.BOTH;
        m.weightx = 0.5;
        m.weighty = 0.5;
        
        this.add(tempPanel.add(new JLabel("Module")), c);
        this.add(tempPanel.add(new JLabel("Cwk Mark")), m);
        this.add(tempPanel.add(new JLabel("Exam Mark")), m);
		c.gridy = 1;
		m.gridy = 1;
		this.add(tempPanel.add(field1), c);
		this.add(tempPanel.add(cwk1), m);
		this.add(tempPanel.add(exam1), m);
		c.gridy = 2;
		m.gridy = 2;
		this.add(tempPanel.add(field2), c);
		this.add(tempPanel.add(cwk2), m);
		this.add(tempPanel.add(exam2), m);
		c.gridy = 3;
		m.gridy = 3;
		this.add(tempPanel.add(field3), c);
		this.add(tempPanel.add(cwk3), m);
		this.add(tempPanel.add(exam3), m);
		c.gridy = 4;
		m.gridy = 4;
		this.add(tempPanel.add(field4), c);
		this.add(tempPanel.add(cwk4), m);
		this.add(tempPanel.add(exam4), m);
		
        GridBagConstraints b = new GridBagConstraints();
        setLayout(gridbag);
        
		b.gridy = 5;
		
		clearButton = new JButton("Clear");
		submitButton = new JButton("Submit");
		b.gridx = 1;
		this.add(clearButton,b);
		b.gridx = 2;
		this.add(submitButton,b);
		b.gridy = 6;
		
		tempPanel p = new tempPanel();
		this.add(tempPanel.get(), b);
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
					break;
			case 2: field2.setText(module);
					break;
			case 3: field3.setText(module);
					break;
			case 4: field4.setText(module);
					break;
		}
	}
}
