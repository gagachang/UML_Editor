package gui;

import java.awt.event.*;
import javax.swing.JMenuItem;
import shapes.Shapes;

public class MenuItem_ChangeName extends JMenuItem implements ActionListener {
	
	public MenuItem_ChangeName(String name) {
		super(name);
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		changeName();
		Canvas.getInstance().repaint();
	}
	
	public void changeName() {
		int ObjectisSelectedNum = 0;
		Shapes changeNameObject = null;
		for( Shapes current : Canvas.getInstance().getArrayList() ) {
			if( current.getSelected() ) {
				ObjectisSelectedNum++;
				changeNameObject = current;
			}
		}
		if(ObjectisSelectedNum == 1) {
			ChangeName CN = new ChangeName(changeNameObject);
		}
	}
}
