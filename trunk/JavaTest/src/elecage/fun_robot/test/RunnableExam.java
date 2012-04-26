package elecage.fun_robot.test;

public class RunnableExam implements Runnable {

	@Override
	public void run() {
		for(int i = 0 ; i < 5 ; i++) {
			for(int k = 0 ; k < 100000000 ; k++);
			System.out.println(Thread.currentThread().getName() + " : " + i);
		}

	}

}
