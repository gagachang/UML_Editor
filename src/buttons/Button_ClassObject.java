package buttons;

import java.awt.Color;
import java.awt.event.*;

import gui.*;
import modes.*;

public class Button_ClassObject extends Buttons {

	public Button_ClassObject(String name, int width, int height) {
		super(name, width, height);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		System.out.println("Set to CreateClassObject mode!!!");
		
		Button_Panel.getInstance().resetButtons();
		
		this.setBackground(Color.BLACK);
		
		Canvas.getInstance().setCurrentMode( new Mode_CreateClassObject() );
	}
}
