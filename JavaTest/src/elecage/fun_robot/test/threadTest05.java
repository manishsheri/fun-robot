package elecage.fun_robot.test;

public class threadTest05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphicFrame f = new GraphicFrame();
		
		Thread t1 = new Thread(f, "�ȳ�");
		
		t1.start();

	}

}
