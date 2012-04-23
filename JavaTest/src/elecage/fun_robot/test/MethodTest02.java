package elecage.fun_robot.test;

public class MethodTest02 {
	
	int abs(int num) {
		if(num < 0)
			num = -num;
		return num;
	}
	
	long abs(long num) {
		if(num < 0)
			num = -num;
		return num;
	}
	
	double abs(double num) {
		if(num < 0.0)
			num = -num;
		return num;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MethodTest02 mt = new MethodTest02();
		
		int var01 = -10;
		int var02;
		
		var02 = mt.abs(var01);
		System.out.println(var01 + "의 절대값은->" + var02);
		
		long var03 = -20L;
		long var04;
		var04 = mt.abs(var03);
		System.out.println(var01 + "의 절대값은 " + var04);
		
		double var05 = -3.4;
		double var06;
		var06 = mt.abs(var05);
		System.out.println(var05 + "의 절대값은 " + var06);
	}

}
