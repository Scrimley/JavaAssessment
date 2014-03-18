package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OverviewPanel extends JPanel {
	
	private JTextArea ResultArea;
	
	public OverviewPanel() {
		
		ResultArea = new JTextArea ("Overview will appear here",15,25);
		
		this.add(tempPanel.add(ResultArea));
		
		
	}
	
}
