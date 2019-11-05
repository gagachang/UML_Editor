package shapes;

import java.awt.*;

public class Object_Class extends Object_Basic {

	public Object_Class(Point point, int width, int height, int depth, String name) {
		super( point , width , height , depth, name );
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawRect( getOrigin().x, getOrigin().y, getWidth(), getHeight() );
		//g.drawRect( getX(), getY() + getHeight()/3, getWidth(), getHeight()/3 );
		//g.drawRect( getX(), getY() + 2*getHeight()/3, getWidth(), getHeight()/3 );
		g.drawString(getName(), getOrigin().x + 35, getOrigin().y + 30);
		if( getSelected() ) {
			this.paintPorts(g);
		}
	}
}
