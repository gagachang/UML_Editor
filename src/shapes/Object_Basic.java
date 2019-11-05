package shapes;

import java.awt.*;
import java.util.*;

public class Object_Basic extends Shapes {

	private Point origin;
	private int width;
	private int height;
	private int depth;
	private String name;
	
	private ArrayList<Port> ports;
	private boolean selected;
	
	public Object_Basic(Point point, int width, int height, int depth, String name) {
		this.setOrigin(point);
		this.setWidth(width);
		this.setHeight(height);
		this.setDepth(depth);
		this.setPorts();
		this.setSelected(false);
		this.setName(name);
	}
	
	public void paint(Graphics g) {}
	
	public void paintPorts(Graphics g) {
		for(Port p : ports) {
			p.paint(g);
		}
	}
	
	public boolean isInside(Point current) {
		if( current.x < this.origin.x )  				return false;
		if( current.y < this.origin.y )  				return false;
		if( current.x > this.origin.x + this.width )    return false;
		if( current.y > this.origin.y + this.height )   return false;
		return true;
	}

	public Point getOrigin() { return origin; }
	public void setOrigin(Point origin) { this.origin = origin; }

	public int getWidth() { return width; }
	public void setWidth(int width) { this.width = width; }

	public int getHeight() { return height; }
	public void setHeight(int height) { this.height = height; }

	public int getDepth() { return depth; }
	public void setDepth(int depth) { this.depth = depth; }
	
	public boolean getSelected() { return this.selected; }
	public void setSelected(boolean b) { this.selected = b; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public ArrayList<Port> getPorts() { return this.ports; }
	public void setPorts() {
		ports = new ArrayList<Port>();
		/*    UP , portNumber = 1 */
			ports.add( new Port( new Point( this.origin.x + this.width/2 , this.origin.y                  ), 1 ));
		/*  LEFT , portNumber = 2 */
			ports.add( new Port( new Point( this.origin.x                , this.origin.y + this.height/2  ), 2 ));
		/*  DOWN , portNumber = 3 */ 
			ports.add( new Port( new Point( this.origin.x + this.width/2 , this.origin.y + this.height    ), 3 ));
		/* RIGHT , portNumber = 4 */ 
			ports.add( new Port( new Point( this.origin.x + this.width   , this.origin.y + this.height/2  ), 4 ));		
	}

/* Select Mode */
	// Move the object to target.
	// Reset the new origin and ports.
	@Override
	public void move(int dx, int dy) {
		Point target = new Point(this.getOrigin().x + dx, this.getOrigin().y + dy);
		setOrigin(target);
		movePorts(dx, dy);
	}

	public void movePorts(int dx, int dy) {
		for( Port p : this.ports ) {
			p.move(dx, dy);
		}
	}

	// Select multiple objects, check if the object is covered based on four ports. 
	@Override
	public boolean isCovered(Point P1, Point P2) {
		boolean result = true;
		for( Port port : this.ports ) {
			if( port.getPortCenter().x < P1.x ) {	result = false;	 break;  }
			if( port.getPortCenter().y < P1.y ) {	result = false;  break;	 }
			if( port.getPortCenter().x > P2.x ) {	result = false;	 break;	 }
			if( port.getPortCenter().y > P2.y ) {	result = false;  break;	 }
		}
		return result;
	}
	
/* Line Mode */
	@Override
	public Port getNearestPort(Point current) {
		int distance = 0, minDistance = 600;
		Port nearest = new Port( new Point(0, 0) ,0 );  // temp Port
		for(Port target : this.ports) {
			distance = (int) Math.sqrt( (int) Math.pow( current.x - target.getPortOrigin().x , 2) + (int) Math.pow( current.y - target.getPortOrigin().y , 2) );
			if( distance < minDistance ) {
				minDistance = distance;
				nearest = target;
			}
		}
		return nearest;
	}
	
}
