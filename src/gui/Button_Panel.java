package gui;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import buttons.*;

public class Button_Panel extends JPanel {
	
	// Singleton Design Pattern
	private static Button_Panel uniqueInstance; 
	
	private ArrayList<Buttons> buttons;
	
	private Button_Panel() {
		this.setButtons();
		this.addButtonsToPanel();
	}
	
	// Singleton Design Pattern
	public static Button_Panel getInstance() {
		if( uniqueInstance == null ) {
			uniqueInstance = new Button_Panel();
		}
		return uniqueInstance;
	}
	
	public void setButtons() {
		
		int button_width  = 75;
		int button_height = 75;
		
		Buttons Select  = new Button_Select(       "Select"  , button_width, button_height );
		Buttons Asso    = new Button_AssoLine(     "Asso"    , button_width, button_height );
		Buttons Gene    = new Button_GeneLine(     "Gene"    , button_width, button_height );
		Buttons Compo   = new Button_CompoLine(    "Compo"   , button_width, button_height );
		Buttons Class   = new Button_ClassObject(  "Class"   , button_width, button_height );
		Buttons Usecase = new Button_UsecaseObject("Use Case", button_width, button_height );
			
		buttons = new ArrayList<Buttons>();		
		buttons.add(Select);
		buttons.add(Asso);
		buttons.add(Gene);
		buttons.add(Compo);
		buttons.add(Class);
		buttons.add(Usecase);		
	}
	
	public void addButtonsToPanel() {
		int initLocation_X = 20;
		int initLocation_Y = 10;
		int ButtonNum 	   =  0;

		for( Buttons Button : buttons ) {

			Button.setLocation( initLocation_X , initLocation_Y + 90 * ButtonNum++ );			
			Button.setBackground(null);
	
			this.add(Button);			
		}	
	}
	
	public ArrayList<Buttons> getButtons(){
		return this.buttons;
	}
	
	public void resetButtons() {
		for( Buttons button : buttons ) {
			button.setBackground(null);
		}
	}
}
