package view;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {

	//declared for access throughout class
	private JMenuItem loadItem, saveItem, exitItem, aboutItem;

	public MenuBar() {      

		//temp var for menus within this JMenuBar
		JMenu menu;

		//----------Build the first menu on the menu bar.--------------------
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);

		//define and add the 'Load' menu item
		loadItem = new JMenuItem("Load Student Data");

		loadItem.setMnemonic(KeyEvent.VK_L);
		loadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		menu.add(loadItem);

		//'Save' menu item
		saveItem = new JMenuItem("Save Student Data");

		saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		saveItem.setMnemonic(KeyEvent.VK_S);
		menu.add(saveItem);

		//...add a separator
		menu.addSeparator();

		//... add an 'Exit' item
		exitItem = new JMenuItem("Exit");

		exitItem.setMnemonic(KeyEvent.VK_E);
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		menu.add(exitItem);
		this.add(menu); //add the menu to this menubar;


		//----------Build the second menu on the menu bar.--------------------
		menu = new JMenu("Help");

		//'About' menu item
		aboutItem = new JMenuItem("About");

		aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		menu.add(aboutItem);

		this.add(menu); //add the menu to this menubar

	}
}
