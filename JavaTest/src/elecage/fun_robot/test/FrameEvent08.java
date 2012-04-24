package elecage.fun_robot.test;

import java.awt.*;
import java.awt.event.*;


public class FrameEvent08 extends Frame implements ItemListener {

	Choice c;
	TextArea ta;
	public FrameEvent08() throws HeadlessException {
		c = new Choice();
		c.addItem("���");
		c.addItem("�ٳ���");
		c.addItem("����");
		c.addItem("�ٳ���");
		c.addItem("����");
		
		ta = new TextArea();
		
		setLayout(new BorderLayout());
		add(c, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		
		setSize(400, 300);
		setVisible(true);
		
		c.addItemListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}



	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if(arg0.getStateChange() == ItemEvent.SELECTED) 
			ta.append(arg0.getItem() + "��(��) ���õǾ����ϴ�.\n");

	}

}
