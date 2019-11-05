package shapes;

import java.awt.*;

public class Line_AssociationLine extends Line {

	public Line_AssociationLine( Port start, Port end ) {
		super(start, end);
	}
	
	@Override
	public void paint(Graphics g) {
		Point start = getLine_Start_Port().getPortCenter();
		Point end = getLine_End_Port().getPortCenter();
		g.drawLine( start.x , start.y , end.x , end.y );
	}
}
