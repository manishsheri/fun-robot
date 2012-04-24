package elecage.fun_robot.test;

import java.awt.*;
import java.awt.event.*;

public class FrameEvent06 extends Frame implements ItemListener {
	Panel p;
	Checkbox cb1, cb2, cb3;
	TextArea ta;
	
	
	public FrameEvent06() throws HeadlessException {
		super();
		setLayout(new BorderLayout());
		
		p = new Panel();
		cb1 = new Checkbox("빨간색");
		cb2 = new Checkbox("파란색");
		cb3 = new Checkbox("초록색");
		
		p.add(cb1);
		p.add(cb2);
		p.add(cb3);
		
		ta = new TextArea();
		
		add(p, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		
		setSize(400, 200);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		String strState = "해제";
		if(arg0.getStateChange() == ItemEvent.SELECTED) 
			strState = "선택";
		ta.append(arg0.getItem() + "이 " + strState + "되었습니다.\n");

	}

}
