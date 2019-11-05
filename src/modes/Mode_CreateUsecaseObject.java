package modes;

import java.awt.Point;
import java.awt.event.MouseEvent;

import gui.Canvas;
import shapes.*;

public class Mode_CreateUsecaseObject extends Modes {

	public Mode_CreateUsecaseObject() {
		super(6);
	}
	
	@Override
	public void mouseClicked(MouseEvent coordinate) {
		/* Create a usecase object
		 * Width = 100 , Height = 50
		 * Get the arraylist in canvas and add the new object into it.  
		 */
		System.out.println("Create a Usecase object!!");
		
		Point p = new Point(coordinate.getPoint());
		
		int Object_Width = 100;
		int Object_Height = 50;
		int Object_Depth = Canvas.getInstance().getCurrentDepth();
		
		Canvas.getInstance().getArrayList().add( new Object_Usecase( p , Object_Width , Object_Height , Object_Depth , "Usecase" ) );
		
		Canvas.getInstance().setCurrentDepth(++Object_Depth);
	}

}
