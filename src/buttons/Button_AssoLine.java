package buttons;

import java.awt.Color;
import java.awt.event.*;

import gui.*;
import modes.Mode_CreateAssoLine;

public class Button_AssoLine extends Buttons {

	public Button_AssoLine(String name, int width, int height) {
		super(name, width, height);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Set to CreateAssoLine mode!!!");
		
		Button_Panel.getInstance().resetButtons();
		
		this.setBackground(Color.BLACK);

		Canvas.getInstance().setCurrentMode( new Mode_CreateAssoLine() );
	}
}
