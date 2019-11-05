package gui;

import java.awt.event.*;
import javax.swing.JMenuItem;
import shapes.Shapes;

public class MenuItem_Ungroup extends JMenuItem implements ActionListener {

	public MenuItem_Ungroup(String name) {
		super(name);
		this.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		unGroup();
		Canvas.getInstance().repaint();
	}
	
	public void unGroup() {
		int GroupisSelectedNum = 0;
		Shapes unGroup = null;
		for( Shapes current : Canvas.getInstance().getArrayList() ) {
			if( current.getSelected() || current.isComposite() ) {
				GroupisSelectedNum++;
				unGroup = current;
			}
		}
		if(GroupisSelectedNum == 1) {
			for( Shapes objectInCom : unGroup.getList() ) {
				Canvas.getInstance().getArrayList().add(objectInCom);
			}
			Canvas.getInstance().getArrayList().remove(unGroup);
			Canvas.getInstance().sortArrayList();
		}
		unGroup = null;
	}
}
