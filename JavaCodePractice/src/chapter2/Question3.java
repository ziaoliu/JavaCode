package chapter2;

public class Question3 {
	public static void main(String[] args) {
		Node head = new Node(8);
		MyList list = new MyList(head);
		list.appendList(new Node(6));
		list.appendList(new Node(4));
		Node t = new Node(2);
		list.appendList(t);
		list.appendList(new Node(8));
		list.appendList(new Node(4));
		list.printList();
		remove(list, t);
	}

	public static void remove(MyList list, Node n) {
		System.out.println("To remove Node: " + n.data + " - " + n.next);
		if (n == null || n.next == null) {
			System.out.println("");
			return;
		}
		n.data = n.next.data;
		n.next = n.next.next;
		list.printList();
	}
}
