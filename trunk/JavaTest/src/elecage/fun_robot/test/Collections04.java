package elecage.fun_robot.test;

import java.util.*;

public class Collections04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("하나");
		list.add(2);
		list.add(3.42);
		list.add("넷");
		list.add("five");
		list.add(6);
		/*
		for(int i = 0 ; i < list.size() ; i++) {
			System.out.println(i + "번째 요소는 " + list.get(i));
		}
		
		*/
		Iterator elements = list.iterator();
		
		while(elements.hasNext())
			System.out.println(elements.next());
	}

}
