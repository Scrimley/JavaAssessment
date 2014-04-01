package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

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
	
	public static JPanel addWithLayout(Component item, int f) {
		
		FlowLayout Layout = new FlowLayout();
		Layout.setAlignment(f);
		
		JPanel tempPanel = new JPanel();
		tempPanel.setLayout(Layout);
		tempPanel.add(item);
		return tempPanel;
	}
	
	public static JPanel get () {
		JPanel tempPanel = new JPanel();
		return tempPanel;
	}

}
