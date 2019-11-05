package shapes;

import java.awt.*;

public class Port {

	private Point center;
	private Point origin;
	private int width;
	private int height;
	
	private int portNumber;
	
	public Port(Point center, int portNumber) {
		DefaultSettings(center, portNumber);
	}
	
	// center = 中心點
	// origin = 左上角的點
	// port長寬皆為6
	public void DefaultSettings(Point center, int portNumber) {
		this.center = center;
		this.width  = 6;
		this.height = 6;
		this.origin = new Point(center.x - width/2 , center.y - height/2 );
		this.portNumber = portNumber;
	}
	
	public boolean isInside(Point current) {
		if( current.x < this.origin.x )  				return false;
		if( current.y < this.origin.y )  				return false;
		if( current.x > this.origin.x + this.width )    return false;
		if( current.y > this.origin.y + this.height )   return false;
		return true;
	}
	
	public void paint( Graphics g ) {
		g.setColor(Color.RED);
		g.fillRect( this.origin.x , this.origin.y , this.width , this.height );
		g.setColor(Color.BLACK);
	}
	
	public void setPortOrigin(Point target) {
		this.origin = target;
	}
	
	public Point getPortOrigin() {
		return this.origin;
	}
	
	public void setPortCenter(Point target) {
		this.center = target;
	}
	
	public Point getPortCenter() {
		return this.center;
	}
	
	public int getPortNumer() {
		return this.portNumber;
	}
	
	public void move(int dx, int dy) {
		Point target = new Point(this.origin.x + dx, this.origin.y + dy);
		setPortOrigin(target);
		setPortCenter( new Point( this.origin.x + this.width/2, this.origin.y + this.height/2 ));
	}
}
