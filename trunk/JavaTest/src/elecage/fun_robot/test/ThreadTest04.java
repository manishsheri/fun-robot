package elecage.fun_robot.test;

public class ThreadTest04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RunnableExam2 r1 = new RunnableExam2(12);
		RunnableExam2 r2 = new RunnableExam2(15);
		RunnableExam2 r3 = new RunnableExam2(10);
		
		Thread t1 = new Thread(r1, "ù��° ������");
		Thread t2 = new Thread(r2, "�ι�° ������");
		Thread t3 = new Thread(r3, "����° ������");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
