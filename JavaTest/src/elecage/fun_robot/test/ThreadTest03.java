package elecage.fun_robot.test;

public class ThreadTest03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RunnableExam r1 = new RunnableExam();
		RunnableExam r2 = new RunnableExam();
		
		Thread t1 = new Thread(r1, "첫번째 쓰레드");
		Thread t2 = new Thread(r2, "두번째 쓰레드");
		
		t1.start();
		t2.start();

	}

}
