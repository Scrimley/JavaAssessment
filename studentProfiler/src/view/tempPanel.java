package view;

import java.awt.Component;

import javax.swing.JPanel;

public final class tempPanel {
	
	private tempPanel () {
		JPanel tempPanel = new JPanel();
	}
	
	public static JPanel add(Component item) {
		
		JPanel tempPanel = new JPanel();
		tempPanel.add(item);
		return tempPanel;
	}

}
