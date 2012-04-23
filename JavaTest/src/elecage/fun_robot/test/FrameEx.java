package elecage.fun_robot.test;

import java.awt.*;
import java.awt.event.*;

public class FrameEx extends Frame {
	public FrameEx() {
		setLayout(new BorderLayout());
		add(new Button("Button 01"), "North");
		add(new Button("Button 02"), "West");
		add(new Button("Button 03"), "Center");
		add(new Button("Button 04"), "East");
		add(new Button("Button 05"), "South");
		setSize(300, 200);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}
}
