package elecage.fun_robot.test;

public class ThreadTest01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadExam t1 = new ThreadExam("첫번째 쓰레드");
		ThreadExam t2 = new ThreadExam("두번째 쓰레드");
		
		t1.start();
		t2.start();
		
	}

}
