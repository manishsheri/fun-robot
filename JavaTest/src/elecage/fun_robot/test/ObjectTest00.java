package elecage.fun_robot.test;

public class ObjectTest00 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point obj = new Point();
		System.out.println("Ŭ���� �̸� : " + obj.getClass());
		System.out.println("�ؽ��ڵ� : " + obj.hashCode());
		System.out.println("��ü���ڿ� : " + obj.toString());
		
		System.out.println("----------------");
		
		Point obj2 = new Point();
		System.out.println("Ŭ���� �̸� : " + obj2.getClass());
		System.out.println("�ؽ��ڵ� : " + obj2.hashCode());
		System.out.println("��ü���ڿ� : " + obj2.toString());
	}

}
