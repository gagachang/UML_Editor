package buttons;

import java.awt.Color;
import java.awt.event.*;

import gui.*;
import gui.Canvas;
import modes.Mode_CreateUsecaseObject;

public class Button_UsecaseObject extends Buttons {

	public Button_UsecaseObject(String name, int width, int height) {
		super(name, width, height);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		System.out.println("Set to CreateUsecaseObject mode!!!");
		
		Button_Panel.getInstance().resetButtons();
		
		this.setBackground(Color.BLACK);
		
		Canvas.getInstance().setCurrentMode( new Mode_CreateUsecaseObject() );
	}
}
