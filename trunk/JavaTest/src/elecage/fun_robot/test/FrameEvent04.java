package elecage.fun_robot.test;

import java.awt.*;
import java.awt.event.*;


public class FrameEvent04 extends Frame {
	Panel p1, p2;
	TextField txtID;
	TextField txtPW;
	
	public FrameEvent04() {
		setLayout(new BorderLayout());
		
		p1 = new Panel();
		p2 = new Panel();
		
		txtID = new TextField(20);
		txtPW = new TextField(20);
		txtPW.setEchoChar('*');
		
		p1.add(new Label("아 이 디"));
		p1.add(txtID);
		
		this.add(p1, BorderLayout.NORTH);
		p2.add(new Label("패스워드"));
		p2.add(txtPW);
		this.add(p2, BorderLayout.CENTER);
		
		setSize(400, 100);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		
		
		
	}
}
