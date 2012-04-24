package elecage.fun_robot.test;

import java.awt.*;
import java.awt.event.*;
import java.awt.Frame;

public class FrameEvent2 extends Frame {
	Button redBtn, blueBtn;
	public FrameEvent2() {
		setLayout(new FlowLayout());
		
		redBtn = new Button("빨간색");
		blueBtn = new Button("파란색");
		add(redBtn);
		add(blueBtn);
		
		ButtonListener handler = new ButtonListener(this);
		
		redBtn.addActionListener(handler);
		blueBtn.addActionListener(handler);
		
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
