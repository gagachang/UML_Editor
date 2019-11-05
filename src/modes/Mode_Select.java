package modes;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import gui.Canvas;
import shapes.*;

public class Mode_Select extends Modes {
	
	private Point Mouse_start, Mouse_end;
	private Shapes move_Object;
	
	public Mode_Select() {
		super(1);
	}

	@Override
	public void mouseClicked(MouseEvent coordinate) {		
		// Select the object
		boolean findObject = false;
		for( int i = Canvas.getInstance().getArrayListSize() - 1  ; i >= 0 ; i-- ) {
			Canvas.getInstance().getArrayList().get(i).setSelected(false);
			if( !findObject && Canvas.getInstance().getArrayList().get(i).isInside( new Point(coordinate.getPoint() ))) {
				Canvas.getInstance().getArrayList().get(i).setSelected(true);
				System.out.println("Current object depth: " + Canvas.getInstance().getArrayList().get(i).getDepth());
				findObject = true;
			}
		}
	}

	
	@Override
	public void mousePressed(MouseEvent coordinate) {
		Mouse_start = new Point( coordinate.getPoint() );
		this.move_Object = null;
		for( Shapes current : Canvas.getInstance().getArrayList() ) {
			if( current.isInside( Mouse_start )) {
				this.move_Object = current;
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent coordinate) {
		Mouse_end = new Point( coordinate.getPoint() );
		
		if( this.move_Object!=null && !(Mouse_start.equals(Mouse_end)) ) {
			moveObject();
		}
		else if( this.move_Object==null && !(Mouse_start.equals(Mouse_end)) )
			selectMultiObjects();
		
	}
	
	public void moveObject() {
		// calculate the displacement
		int dx, dy;
		dx = Mouse_end.x - Mouse_start.x;
		dy = Mouse_end.y - Mouse_start.y;
		
		move_Object.move(dx, dy);
	}
	
	public void selectMultiObjects() {
		System.out.println("bang!!!");
		
		Point P1 = new Point( Math.min(Mouse_start.x, Mouse_end.x) , Math.min(Mouse_start.y, Mouse_end.y) );
		Point P2 = new Point( Math.max(Mouse_start.x, Mouse_end.x) , Math.max(Mouse_start.y, Mouse_end.y) );
		
		// Select the objects in this area
		for( Shapes current : Canvas.getInstance().getArrayList() ) {
			current.setSelected(false);
			if( current.isCovered(P1, P2) ) {
				current.setSelected(true);
			}
		}
	}
	
	public void groupObjects() {
		Point min_point, max_point;
		//int CurrentObjectDepth = All_BO.size();
		int isSelectedNum = 0;
		ArrayList<Shapes> isSelected = new ArrayList<Shapes>();
	
		// Calculate the selected object number
		for( Shapes current : Canvas.getInstance().getArrayList() ) {
			if( current.getSelected() ) {
				isSelectedNum++;
			}
		}
		// More than one object are selected to be grouped
		if( isSelectedNum > 1) {
			// Add the selected objects into Arraylist of the composite object
			for( int i = Canvas.getInstance().getArrayListSize() - 1  ; i >= 0 ; i-- ) {
				if( Canvas.getInstance().getArrayList().get(i).getSelected() ) {
					Canvas.getInstance().getArrayList().get(i).setSelected(false);
					isSelected.add(Canvas.getInstance().getArrayList().get(i));
					Canvas.getInstance().getArrayList().remove(i);				
				}
			}
			
			Collections.sort(isSelected, new Comparator<Shapes>() {
				@Override
			    public int compare(Shapes o1, Shapes o2) {
		            if( o1.getDepth() < o2.getDepth() )
		            	return -1;
		            else return 1;
		        }
			});
			
			// Use the first basic object in Arraylist to be the min/max point
			min_point = new Point( isSelected.get(0).getOrigin().x, isSelected.get(0).getOrigin().y );
			max_point = new Point( isSelected.get(0).getOrigin().x, isSelected.get(0).getOrigin().y );
			
			// Find the lower coordinate of other objects
			for( Shapes current : isSelected ) {
				if( current.getOrigin().x < min_point.x )	 min_point.x = current.getOrigin().x;
				if( current.getOrigin().y < min_point.y )	 min_point.y = current.getOrigin().y;
				if( current.getOrigin().x + current.getWidth()  > max_point.x )  max_point.x = current.getOrigin().x + current.getWidth();
				if( current.getOrigin().y + current.getHeight() > max_point.y )  max_point.y = current.getOrigin().y + current.getHeight();
			}
			
			int Object_Depth = Canvas.getInstance().getCurrentDepth();
			
			Shapes Composite = new Object_Composite(min_point, max_point.x-min_point.x, max_point.y-min_point.y , Object_Depth , "composite" , isSelected );
						
			Canvas.getInstance().getArrayList().add( Composite );
			
			Canvas.getInstance().setCurrentDepth(++Object_Depth);
		}
	}
}
