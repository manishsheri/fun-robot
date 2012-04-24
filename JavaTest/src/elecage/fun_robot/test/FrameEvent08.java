package elecage.fun_robot.test;

import java.awt.*;
import java.awt.event.*;


public class FrameEvent08 extends Frame implements ItemListener {

	Choice c;
	TextArea ta;
	public FrameEvent08() throws HeadlessException {
		c = new Choice();
		c.addItem("사과");
		c.addItem("바나나");
		c.addItem("딸기");
		c.addItem("바나나");
		c.addItem("포도");
		
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
			ta.append(arg0.getItem() + "가(이) 선택되었습니다.\n");

	}

}
