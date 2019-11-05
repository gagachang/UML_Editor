package shapes;

import java.awt.*;
import java.util.*;

public class Object_Composite extends Shapes {

	private Point origin;
	private int width;
	private int height;
	private int depth;
	private String name;
	private ArrayList<Shapes> Group;
	
	private boolean selected;
	
	public Object_Composite(Point point, int width, int height, int depth, String name, ArrayList<Shapes> container) {
		this.origin = point;
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.name = name;
		this.Group = container;
	}
	
	public void setOrigin(Point origin) { this.origin = origin; }
	public Point getOrigin() { return this.origin; }

	public void setSelected(boolean b)  { this.selected = b; };
	public boolean getSelected() { return this.selected; };
	
	public int getWidth() { return width; }
	public void setWidth(int width) { this.width = width; }

	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }
	
	public int getDepth() { return depth; }
	public void setDepth(int depth) { this.depth = depth; }
	
	public ArrayList<Shapes> getList(){	return this.Group; }
	
	public boolean isComposite() { return true;	}
	
	public void sortArrayList() {
		// Sorting small to big
		Collections.sort(Group, new Comparator<Shapes>() {
			@Override
		    public int compare(Shapes o1, Shapes o2) {
	            if( o1.getDepth() < o2.getDepth() )
	            	return -1;
	            else return 1;
	        }
		});
	}
	
	@Override
	public void paint(Graphics g) {
		for( Shapes every : this.Group ) {
			every.paint(g);
		}
		if(selected)
			g.setColor(Color.RED);
		g.drawRect( this.origin.x, this.origin.y, this.width, this.height );
		g.setColor(Color.BLACK);
	}
	
	@Override
	public boolean isInside(Point current) {
		if( current.x < this.origin.x )  return false;
		if( current.y < this.origin.y )  return false;
		if( current.x > this.origin.x + this.width  )  return false;
		if( current.y > this.origin.y + this.height )  return false;
		return true;
	}
	
	@Override
	public void move(int dx, int dy){
		Point target = new Point(this.origin.x + dx, this.origin.y + dy);
		setOrigin(target);
		
		for( Shapes every : this.Group ) {
			every.move(dx, dy);
		}
	}
	
	// Select multiple objects, check if the object is covered based on four ports. 
	@Override
	public boolean isCovered(Point P1, Point P2) {
		boolean result = true;
		if( this.origin.x < P1.x ) { result = false; }
		if( this.origin.y < P1.y ) { result = false; }
		if( this.origin.x + this.width  > P2.x ) { result = false;	}
		if( this.origin.y + this.height > P2.y ) { result = false; }
		return result;
	}
}
