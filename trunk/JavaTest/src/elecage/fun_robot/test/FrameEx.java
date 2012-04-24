package elecage.fun_robot.test;

import java.awt.*;
import java.awt.event.*;

public class FrameEx extends Frame {
	Panel pan01, pan02, pan03;
	public FrameEx() {
		pan01 = new Panel();
		pan02 = new Panel();
		pan03 = new Panel();
		
		pan01.setBackground(Color.green);
		pan02.setBackground(Color.blue);
		pan03.setBackground(Color.red);
		
		add(BorderLayout.NORTH, pan01);
		add(BorderLayout.CENTER, pan02);
		add(BorderLayout.SOUTH, pan03);
		pan01.add(new Button("button 01"));
		pan01.add(new Button("button 02"));
		
		pan02.add(new Button("button 03"));
		pan03.add(new Button("button 04"));
		pan03.add(new Button("button 05"));
		
		/*
		
		setLayout(new GridLayout(3,2));
		add(new Button("Button 01"), "North");
		add(new Button("Button 02"), "West");
		add(new Button("Button 03"), "Center");
		add(new Button("Button 04"), "East");
		add(new Button("Button 05"), "South");
		*/
		setSize(300, 130);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}
}
