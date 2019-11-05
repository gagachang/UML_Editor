package gui;

import javax.swing.*;

public class UML_Editor extends JFrame {

	private MenuBar menubar;
	private Button_Panel buttonPanel;
	private Canvas canvas;
	
// Construct GUI
	public UML_Editor(String name){
			
		super(name);
		
	// Set the components in the main frame
		this.setFrame();
		this.setMenuBar();
		this.setButtonPanel();
		this.setCanvas();

		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new UML_Editor("UML_Editor Final");
	}

	public void setFrame() {	
		
	// Define frame's attributions
		setSize( 800, 600 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo(null);
		setResizable(false);
		this.getContentPane().setLayout(null);
	}
	
	public void setMenuBar() {
		menubar = new MenuBar();
		
		this.setJMenuBar(menubar);
	}
	
	public void setButtonPanel() {
		// Singleton Design Pattern
		buttonPanel = Button_Panel.getInstance();
		buttonPanel.setBounds( 0 , 0 , 100 , 600 );
		buttonPanel.setLayout(null);
		
		this.add(buttonPanel);
	}
	
	public void setCanvas() {
		// Singleton Design Pattern
		canvas = Canvas.getInstance();
		canvas.setBounds( 115 , 10 , 660 , 525 );

		this.add(canvas);
	}
}
