package shapes;

import java.awt.*;

public class Line extends Shapes {

	private Port Start_Port, End_Port;
	
	public Line(Port start, Port end) {
		setPorts(start, end);
	}
	
	public void setPorts(Port start, Port end) {
		this.Start_Port = start;
		this.End_Port = end;
	}

	public void paint(Graphics g) {}

	public Port getLine_Start_Port() { return this.Start_Port; }
	public Port getLine_End_Port()   { return this.End_Port; }
	
	public boolean getSelected() { return false; }

	public void setSelected(boolean b) {}

}
