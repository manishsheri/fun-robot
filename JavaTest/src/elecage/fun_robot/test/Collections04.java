package elecage.fun_robot.test;

import java.util.*;

public class Collections04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("�ϳ�");
		list.add(2);
		list.add(3.42);
		list.add("��");
		list.add("five");
		list.add(6);
		/*
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(i + "��° ��Ҵ� " + list.get(i));
		}
		
		*/
		Iterator elements = list.iterator();
		
		while(elements.hasNext())
			System.out.println(elements.next());
	}

}
