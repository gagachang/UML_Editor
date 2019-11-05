package buttons;

import java.awt.event.*;

import javax.swing.*;

public class Buttons extends JButton implements ActionListener {
	
	public Buttons(String name, int width, int height) {
		super(name);
		this.setSize(width, height);
		this.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {}

}
