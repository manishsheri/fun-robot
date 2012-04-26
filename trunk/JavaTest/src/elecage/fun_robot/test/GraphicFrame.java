package elecage.fun_robot.test;

import java.awt.*;
import java.awt.event.*;
public class GraphicFrame extends Frame implements Runnable {

	int x = 1;
	public GraphicFrame() {
		setBackground(new Color(0, 0, 0)); // 검은색
		setSize(370, 150);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			
			repaint();
			x += 5;
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Dimension d;
		d = getSize();
		
		g.setColor(Color.yellow);
		
		g.drawString("안녕하신가", x, d.height / 2);
		
		if(x > d.width)
			x = 0;
	}

}
