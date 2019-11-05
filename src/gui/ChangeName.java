package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import shapes.Shapes;

public class ChangeName {

	private JFrame changeNameFrame;
	private JPanel changeNamePanel;
	private JTextField textfield;
	private JButton OK;
	private JButton cancel;
	private Shapes changeNameBO;
	
	public ChangeName(Shapes changeNameObject) {
		setFrame();
		setPanel();
		setChangeNameObject(changeNameObject);
	}
	
	public void setFrame() {
		changeNameFrame = new JFrame("Change Current Object Name");
		changeNameFrame.setSize( 400 , 100 );
		changeNameFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		changeNameFrame.setLocationRelativeTo(null);
		changeNameFrame.setResizable(false);
		changeNameFrame.getContentPane().setLayout(new BorderLayout());
		changeNameFrame.setVisible(true);
	}
	
	public void setPanel() {
		changeNamePanel = new JPanel();
		textfield = new JTextField(30);
		OK = new JButton("OK");
		cancel = new JButton("Cancel");
		
		textfield.setText("Input the name you want");
		textfield.selectAll();
		
		OK.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = textfield.getText();
				changeNameBO.setName(name);
				changeNameFrame.dispose();
				Canvas.getInstance().repaint();
			}			
		});
		
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				changeNameFrame.dispose();
			}			
		});
		
		changeNamePanel.add(textfield);
		changeNamePanel.add(OK);
		changeNamePanel.add(cancel);
		changeNameFrame.add(changeNamePanel);
	}
	
	public void setChangeNameObject(Shapes changeNameObject) {
		this.changeNameBO = changeNameObject;
	}
}
