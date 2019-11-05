package modes;

import java.awt.Point;
import java.awt.event.MouseEvent;

import gui.Canvas;
import shapes.*;

public class Mode_CreateGeneLine extends Modes {

	private Port Line_Start_Port, Line_End_Port;
	
	public Mode_CreateGeneLine() {
		super(3);
	}

	@Override
	public void mousePressed(MouseEvent coordinate) {

		System.out.println("Mouse Pressed!!!");
		
		// Get the object port start side
		Point start = coordinate.getPoint();
		this.Line_Start_Port = null;
		for(Shapes current : Canvas.getInstance().getArrayList()) {
			if( current.isInside( start ) ) {
				this.Line_Start_Port = current.getNearestPort( start ) ;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent coordinate) {

		System.out.println("Mouse Released!!");		
		
		// Get the object port end side
		Point end = coordinate.getPoint();
		this.Line_End_Port = null;
		for(Shapes current : Canvas.getInstance().getArrayList()) {
			if( current.isInside( end ) ) {
				this.Line_End_Port = current.getNearestPort( end ) ;
			}
		}
		
		CreatGeneLine();
	}

	public void CreatGeneLine() {
		if( this.Line_Start_Port!=null && this.Line_End_Port!=null ) {
			Canvas.getInstance().getArrayList().add( new Line_GeneralizationLine( Line_Start_Port, Line_End_Port ) );
			System.out.println( "Start portNumber = " + Line_Start_Port.getPortNumer() + " , End portNumber = " + Line_End_Port.getPortNumer() );
		}
	}
}
