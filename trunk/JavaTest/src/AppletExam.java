import java.applet.*;
import java.awt.*;

public class AppletExam extends Applet {
	public void paint(Graphics g) {
		System.out.println("# paint() �޼��� ����");
		g.drawString("Hello Applet!", 30, 30);
	}

	@Override
	public void destroy() {
		System.out.println("# destroy() �޼��� ����");
		super.destroy();
	}

	@Override
	public void init() {
		System.out.println("# init() �޼��� ����");
		super.init();
	}

	@Override
	public void start() {
		System.out.println("# start() �޼��� ����");
		super.start();
	}

	@Override
	public void stop() {
		System.out.println("# stop() �޼��� ����");
		super.stop();
	}
}
