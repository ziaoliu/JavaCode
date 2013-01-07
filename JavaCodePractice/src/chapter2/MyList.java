package chapter2;

public class MyList {
	Node head = null;
	public int length;
	public MyList() {

	}

	public MyList(Node n) {
		head = n;
		length++;
	}

	public void appendList(Node n) {
		if (this == null)
			head = new Node(n.data);
		else {
			n.next = head;
			head = n;
			length++;
		}
	}

	public void printList() {
		Node n = head;
		if(head == null) {
			System.out.println("Empty list");
			return;
		}
		while (n != null) {
			System.out.print(n.data + "--> ");
			n = n.next;
		}
		System.out.print("end");
		System.out.println();
	}
	
}
