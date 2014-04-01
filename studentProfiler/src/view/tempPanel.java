package view;

import java.awt.Component;

import javax.swing.JPanel;

public final class tempPanel {

	
	public tempPanel () {
		JPanel tempPanel = new JPanel();
	}
	
	public static JPanel add(Component item) {
		
		JPanel tempPanel = new JPanel();
		tempPanel.add(item);
		return tempPanel;
	}
	
	public static JPanel get () {
		JPanel tempPanel = new JPanel();
		return tempPanel;
	}

}
