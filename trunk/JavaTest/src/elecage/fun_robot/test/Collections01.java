package elecage.fun_robot.test;
import java.util.*;
public class Collections01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set set = new HashSet();
		System.out.println("����� ���� : " + set.size());
		set.add("�ϳ�");
		set.add(2);
		set.add(3.42);
		set.add("��");
		set.add("five");
		set.add(6);
		
		System.out.println("����� ���� : " + set.size());
		
		System.out.println(set);
		set.add("�ϳ�");
		
		System.out.println("����� ���� : " + set.size());
		
		System.out.println(set);
		
		Iterator element = set.iterator();
		while(element.hasNext())
			System.out.println(element.next());
	}

}
