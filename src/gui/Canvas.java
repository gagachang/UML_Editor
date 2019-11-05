package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

import modes.*;
import shapes.*;

public class Canvas extends JPanel implements MouseListener {

	// Singleton Design Pattern
	private static Canvas uniqueInstance;
	
	// CurrentMode.getModeNum()
	// 1 = Select mode
	// 2 = Create association line mode
	// 3 = Create generalization line mode
	// 4 = Create composition line mode
	// 5 = Create class object mode
	// 6 = Create use case object mode
	private Modes CurrentMode = new Modes(0);
	
	// ArrayList contains all shape
	private ArrayList<Shapes> All_Shapes ;
	
	// The depth of current object (0~99)
	private int currentDepth;

// Constructor
	private Canvas() {
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
		All_Shapes = new ArrayList<Shapes>();
		currentDepth = 1;
	}
	
// Singleton Design Pattern
	public static Canvas getInstance() {
		if( uniqueInstance == null ) {
			uniqueInstance = new Canvas();
		}
		return uniqueInstance;
	}

// Set the current mode
	public void setCurrentMode(Modes mode) {
		this.CurrentMode = mode;
	}
// Get the current mode
	public Modes getCurrentMode() {
		return this.CurrentMode;
	}

// Paint the all shapes(Basic_Object, Line) in Canvas
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		this.sortArrayList();
		for(Shapes current : All_Shapes)		// draw the objects
			current.paint(g);
	}
	
// Get the ArrayList
	public ArrayList<Shapes> getArrayList() {
		return this.All_Shapes;
	}
	
	public int getArrayListSize() {
		return this.All_Shapes.size();
	}
	
	public void sortArrayList() {
		// Sorting small to big
		Collections.sort(All_Shapes, new Comparator<Shapes>() {
			@Override
		    public int compare(Shapes o1, Shapes o2) {
	            if( o1.getDepth() < o2.getDepth() )
	            	return -1;
	            else return 1;
	        }
		});
	}
	
// Current object depth
	public int getCurrentDepth() {
		return this.currentDepth;
	}
	
	public void setCurrentDepth(int depth) {
		this.currentDepth = depth;
	}

// Mouse events
	@Override
	public void mouseClicked(MouseEvent coordinate) {

		System.out.println(CurrentMode.getModeNum() + "  Clicked!!!");
		CurrentMode.mouseClicked(coordinate);

		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent coordinate) {
		System.out.println(CurrentMode.getModeNum() + "  Pressed!!!");
		CurrentMode.mousePressed(coordinate);

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent coordinate) {
		System.out.println(CurrentMode.getModeNum() + "  Released!!!");
		CurrentMode.mouseReleased(coordinate);

		repaint();
	}

}
