package elecage.fun_robot.test;

public class ThreadExam extends Thread {

	public ThreadExam(String arg0) {
		super(arg0);
	}

	@Override
	public void run() {
		for(int num = 1 ; num <= 5 ; num++) {
			for(int k = 1 ; k < 100000000 ; k++);
			System.out.println(getName() + " : " + num);
		}
	}

}
