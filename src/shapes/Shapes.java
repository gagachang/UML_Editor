package shapes;

import java.awt.*;
import java.util.*;

public class Shapes {

	public void paint(Graphics g) {};
	
	public Point getOrigin() { return null; };
	public void setOrigin(Point origin) {};

	public int getWidth()  { return 0; }
	public int getHeight() { return 0; }
	public int getDepth()  { return 0; }
	
/* Select mode */	
	public boolean isInside(Point current) { return false; };
	
	public boolean getSelected() { return false; };
	public void setSelected(boolean b) {};
	
	public void move(int dx, int dy) {};
	
	public boolean isCovered(Point P1, Point P2) { return false; };

	
/* Line mode */
	public Port getNearestPort(Point current) { return null; };
	
/* Group */
	public boolean isComposite() { return false; }
	
	public ArrayList<Shapes> getList(){ return null; }
	
/* Name */
	public void setName(String name) {}
}
