package elecage.fun_robot.test;

public class ThreadTest01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadExam t1 = new ThreadExam("ù��° ������");
		ThreadExam t2 = new ThreadExam("�ι�° ������");
		
		t1.start();
		t2.start();
		
	}

}
