package elecage.fun_robot.test;

import java.awt.*;
import java.awt.event.*;


public class FrameEvent07 extends Frame implements ItemListener {
	Checkbox cb1, cb2, cb3;
	CheckboxGroup colorGrp;
	
	public FrameEvent07() throws HeadlessException {
		setLayout(new FlowLayout());
		colorGrp = new CheckboxGroup();
		
		cb1 = new Checkbox("빨간색", colorGrp, false);
		cb2 = new Checkbox("파란색", colorGrp, false);
		cb3 = new Checkbox("초록색", colorGrp, false);
		
		add(cb1);
		add(cb2);
		add(cb3);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		
		setSize(400, 200);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		Object obj = arg0.getItem();
		
		Color backgroundColor = Color.black;
		if(obj == "빨간색") {
			backgroundColor = Color.red;
		}
		else if(obj == "파란색") {
			backgroundColor = Color.blue;
		}
		else
			backgroundColor = Color.green;
		
		this.setBackground(backgroundColor);
		cb1.setBackground(backgroundColor);
		cb2.setBackground(backgroundColor);
		cb3.setBackground(backgroundColor);

	}

}
