

import java.applet.Applet;
import java.awt.*;

public class ThreadTest06 extends Applet implements Runnable {
	Thread t1;
	int x = 100;
	
	
	@Override
	public void init() {
		super.init();
		t1 = new Thread(this);
		t1.start();
	}


	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			repaint();
			x += 5;
		}

	}


	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		Dimension d;
		d = getSize();
		
		arg0.setColor(Color.red);
		
		arg0.fillOval(x, d.height/2, 20, 20);
		
		if(x > d.width)
			x = 0;
	}

}
