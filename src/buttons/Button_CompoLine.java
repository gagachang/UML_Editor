package buttons;

import java.awt.Color;
import java.awt.event.*;

import gui.*;
import modes.Mode_CreateCompoLine;

public class Button_CompoLine extends Buttons {

	public Button_CompoLine(String name, int width, int height) {
		super(name, width, height);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		System.out.println("Set to CreateCompoLine mode!!!");
		
		Button_Panel.getInstance().resetButtons();
		
		this.setBackground(Color.BLACK);
		
		Canvas.getInstance().setCurrentMode( new Mode_CreateCompoLine() );
	}
}
