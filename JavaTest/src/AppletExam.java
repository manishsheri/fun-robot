import java.applet.*;
import java.awt.*;

public class AppletExam extends Applet {
	public void paint(Graphics g) {
		System.out.println("# paint() 메서드 수행");
		g.drawString("Hello Applet!", 30, 30);
	}

	@Override
	public void destroy() {
		System.out.println("# destroy() 메서드 수행");
		super.destroy();
	}

	@Override
	public void init() {
		System.out.println("# init() 메서드 수행");
		super.init();
	}

	@Override
	public void start() {
		System.out.println("# start() 메서드 수행");
		super.start();
	}

	@Override
	public void stop() {
		System.out.println("# stop() 메서드 수행");
		super.stop();
	}
}
