package chapter2;

import java.util.ArrayList;

//Write code to remove duplicates from an unsorted linked list.

public class Question1 {
	public static void main(String[] args) {
		Node head = new Node(8);
		MyList list = new MyList(head);
		list.appendList(new Node(6));
		list.appendList(new Node(4));
		list.appendList(new Node(2));
		list.appendList(new Node(8));
		list.appendList(new Node(4));
		System.out.println("Length of the list: " + list.length);
		list.printList();
		// removeDup(list);
		removeDup2(list);
		list.printList();
	}

	public static void removeDup(MyList list) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		Node n = list.head;
		Node pre = n;
		while (n != null) {
			if (!al.contains(n.data))
				al.add(n.data);
			else {
				pre.next = n.next;
			}
			pre = n;
			n = n.next;
		}
	}

	public static void removeDup2(MyList list) {
		Node current = list.head;
		Node iterator = current.next;
		if (iterator == null)
			return;
		while (current != null) {
			Node pre = current;
			iterator = current.next;
			while (iterator != null) {
				if (current.data == iterator.data) {
					System.out.println("duplicate found: " + current.data);
					pre.next = iterator.next;
				}
				pre = iterator;
				iterator = iterator.next;
			}
			current = current.next;
		}
	}
}
