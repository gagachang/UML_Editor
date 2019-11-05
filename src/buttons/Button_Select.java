package buttons;

import java.awt.Color;
import java.awt.event.*;

import gui.*;
import modes.Mode_Select;

public class Button_Select extends Buttons {

	public Button_Select(String name, int width, int height) {
		super(name, width, height);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		System.out.println("Set to Select mode!!!");
		
		Button_Panel.getInstance().resetButtons();
		
		this.setBackground(Color.BLACK);
		
		Canvas.getInstance().setCurrentMode( new Mode_Select() );
	}
}
