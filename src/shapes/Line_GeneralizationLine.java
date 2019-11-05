package shapes;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Line_GeneralizationLine extends Line {

	private AffineTransform tx;
	private Polygon arrowHead;
	
	public Line_GeneralizationLine(Port start, Port end) {
		super(start, end);
		this.setPolygon();
	}

	@Override
	public void paint(Graphics g) {
		Point start = getLine_Start_Port().getPortCenter();
		Point end = getLine_End_Port().getPortCenter();
		g.drawLine( start.x , start.y , end.x , end.y );

		tx.setToIdentity();
	    double angle = Math.atan2( end.y - start.y , end.x - start.x );
	    tx.translate( end.x, end.y);
	    tx.rotate((angle-Math.PI/2d));

	    Graphics2D g2d = (Graphics2D) g.create();
	    g2d.transform(tx);   
	    g2d.fill(arrowHead);
	    g2d.dispose();
	}

	public void setPolygon() {
		tx = new AffineTransform();
		arrowHead = new Polygon();
		arrowHead.addPoint(  0 ,  0 );
		arrowHead.addPoint( -8 , -8 );
		arrowHead.addPoint(  8 , -8 );
	}
}
