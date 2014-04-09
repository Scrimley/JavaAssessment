package view;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OverviewPanel extends JPanel {
	
	private JTextArea ResultArea;
	
	public OverviewPanel() {
		
		ResultArea = new JTextArea ("Overview will appear here",13,40);
		ResultArea.setEditable(false);
		this.add(tempPanel.add(ResultArea));
		
	}
	
	public void updateResultArea(String data) {
		
		ResultArea.setText(data);
		
	}
}
