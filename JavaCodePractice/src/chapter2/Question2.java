package chapter2;

//find the nth element to the last in the linkedlist

public class Question2 {
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
		find(list, 2);
	}

	public static void find(MyList list, int n) {
		if (n < 0 || n > list.length) {
			System.out.println("make sure the element you want is in the list");
			return;
		}
		Node head = list.head;
		Node counter = head;
		for(int i = 0; i < n; i++){
			counter = counter.next;
		}
		while(counter != null){
			head = head.next;
			counter = counter.next;
		}
		System.out.println(n+ " element to the last is: "+ head.data);
	}
}
