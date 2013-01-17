package chapter2;

import java.util.LinkedList;

public class Question4 {
	public static void main(String[] args) {
		LinkedList<Integer> listA = new LinkedList<Integer>();
		LinkedList<Integer> listB = new LinkedList<Integer>();

		// 2 5 3
		listA.add(3);
		listA.add(5);
		listA.add(2);
		// 1 8 9
		listB.add(9);
		listB.add(8);
		listB.add(1);

		if (listA.size() >= listB.size())
			calc(listA, listB);
		else
			calc(listB, listA);
	}
	
	// list A has more digits
	public static void calc(LinkedList a, LinkedList b) {
		
	}
}
