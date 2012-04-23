package elecage.fun_robot.test;

public class ObjectTest00 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Point obj = new Point();
		System.out.println("클래스 이름 : " + obj.getClass());
		System.out.println("해쉬코드 : " + obj.hashCode());
		System.out.println("객체문자열 : " + obj.toString());
		
		System.out.println("----------------");
		
		Point obj2 = new Point();
		System.out.println("클래스 이름 : " + obj2.getClass());
		System.out.println("해쉬코드 : " + obj2.hashCode());
		System.out.println("객체문자열 : " + obj2.toString());
	}

}
