package elecage.fun_robot.test;

import java.awt.Frame;
import java.awt.event.*;

public class FrameEvent extends Frame {
	public FrameEvent() {
		super("������ �̺�Ʈ");
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
