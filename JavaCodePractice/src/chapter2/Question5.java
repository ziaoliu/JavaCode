package chapter2;

public class Question5 {
	public static void main(String[] args) {
		Node head = new Node(1);
		MyList list = new MyList(head);
		list.appendList(new Node(2));
		list.appendList(new Node(3));
		list.appendList(new Node(4));
		list.appendList(new Node(5));
		Node dup = new Node(6);
		list.appendList(dup);
		list.appendList(new Node(7));
		list.appendList(new Node(8));
		list.appendList(dup);
		//System.out.println("Length of the list: " + list.length);
		//list.printList();
		find(list);
	}
	public static void find(MyList list){
		Node slow = list.head;
		Node fast = list.head;
		
		//is it circular?
		while(fast != null){
			slow = slow.next;
			fast = fast.next.next;
			if(fast == null){
				System.out.println("No circle");
			}
			if(fast == slow){
				System.out.println("Found circle");
				break;
			}
		}
		Node k = slow;
		System.out.println(k.data);
	}
}
