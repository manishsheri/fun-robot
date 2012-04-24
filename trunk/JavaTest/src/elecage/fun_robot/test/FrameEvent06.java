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
		cb1 = new Checkbox("������");
		cb2 = new Checkbox("�Ķ���");
		cb3 = new Checkbox("�ʷϻ�");
		
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
		String strState = "����";
		if(arg0.getStateChange() == ItemEvent.SELECTED) 
			strState = "����";
		ta.append(arg0.getItem() + "�� " + strState + "�Ǿ����ϴ�.\n");

	}

}
