package elecage.fun_robot.test;

public class RunnableExam2 implements Runnable {
	int count = 0;
	int num = 0;
	boolean timeOut = false;
	
	
	public RunnableExam2(int count) {
		super();
		this.count = count;
	}


	@Override
	public void run() {
		while(!timeOut) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			num++;
			if(count <= num)
				timeOut = true;
			
			System.out.println(Thread.currentThread().getName() + " : " + num);
		}
		
	}

}
