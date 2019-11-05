package gui;

import java.awt.event.*;
import javax.swing.JMenuItem;

public class MenuItem_Group extends JMenuItem implements ActionListener {

	public MenuItem_Group(String name) {
		super(name);
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Group!!!");
		// Check if we are in select mode
		if( Canvas.getInstance().getCurrentMode().getModeNum() == 1 ) {
			Canvas.getInstance().getCurrentMode().groupObjects();
			Canvas.getInstance().repaint();
		}
	}
}
