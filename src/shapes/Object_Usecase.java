package shapes;

import java.awt.*;

public class Object_Usecase extends Object_Basic {

	public Object_Usecase(Point point, int width, int height, int depth, String name) {
		super(point, width, height, depth, name);
	}

	@Override
	public void paint(Graphics g) {
		g.drawOval( getOrigin().x, getOrigin().y, getWidth(), getHeight() );
		g.drawString(getName(),getOrigin().x + 27, getOrigin().y + 30);
		if( getSelected() ) {
			paintPorts(g);
		}
	}
}
