package modes;

import java.awt.*;
import java.awt.event.MouseEvent;

import shapes.*;
import gui.Canvas;

public class Mode_CreateClassObject extends Modes {

	public Mode_CreateClassObject() {
		super(5);
	}
	
	@Override
	public void mouseClicked(MouseEvent coordinate) {
		/* Create a class object
		 * Width = 100 , Height = 50
		 * Get the arraylist in canvas and add the new object into it.  
		 */
		System.out.println("Create a class object!!");
		
		Point p = new Point(coordinate.getPoint());
		
		int Object_Width = 100;
		int Object_Height = 50;
		int Object_Depth = Canvas.getInstance().getCurrentDepth();
		
		Canvas.getInstance().getArrayList().add( new Object_Class( p , Object_Width , Object_Height , Object_Depth , "class" ) );
		
		Canvas.getInstance().setCurrentDepth(++Object_Depth);
	}

}
