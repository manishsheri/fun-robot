package elecage.fun_robot.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameEvent3 extends Frame implements ActionListener {
	Button redBtn, blueBtn;
	public FrameEvent3() {
		setLayout(new FlowLayout());
		
		redBtn = new Button("빨간색");
		blueBtn = new Button("파란색");
		
		add(redBtn);
		add(blueBtn);
		
		redBtn.addActionListener(this);
		blueBtn.addActionListener(this);
		
		setSize(300, 200);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == redBtn)
			this.setBackground(Color.red);
		else
			this.setBackground(Color.blue);

	}

}
