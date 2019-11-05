package modes;

import java.awt.event.*;

public class Modes implements MouseListener, MouseMotionListener {

	private int modeNum;
	
	public Modes(int modeNum) {
		this.setModeNum(modeNum);
	}
	
	public void setModeNum(int modeNum) { this.modeNum = modeNum; }	
	public int getModeNum() { return this.modeNum; }

	
	/* 
	 *  MouseEvents
	 */
	public void mouseClicked(MouseEvent coordinate) {}

	public void mouseEntered(MouseEvent coordinate) {}

	public void mouseExited(MouseEvent  coordinate) {}

	public void mousePressed(MouseEvent coordinate) {}

	/* 
	 *  MouseMotionEvents
	 */
	public void mouseReleased(MouseEvent coordinate) {}

	public void mouseDragged(MouseEvent  coordinate) {}

	public void mouseMoved(MouseEvent coordinate) {}
	
	public void groupObjects() {}

}
