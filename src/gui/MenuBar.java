package gui;

import java.awt.event.*;

import javax.swing.*;

public class MenuBar extends JMenuBar {

	private JMenu File;
	private JMenu Edit;
	private MenuItem_Group group;
	private MenuItem_Ungroup unGroup;
	private MenuItem_ChangeName changeName;
	
	public MenuBar() {
		this.setMenuBar();
	}

	public void setMenuBar() {
		this.File = new JMenu("File");
		this.Edit = new JMenu("Edit");
		this.group = new MenuItem_Group("Group");
		this.unGroup = new MenuItem_Ungroup("UnGroup");
		this.changeName = new MenuItem_ChangeName("Change object name");
		
		this.Edit.add(this.group);
		this.Edit.add(this.unGroup);
		this.Edit.add(this.changeName);
		
		this.add(this.File);
		this.add(this.Edit);
	}

}
