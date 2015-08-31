package test;

public class ReverseLinkedList {
	public class Solution {
		public ListNode reverseList(ListNode head) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode pre = head; // < == set pre
			head = head.next;
			while (head != null) {
				pre.next = head.next;
				head.next = orig.next;
				orig.next = head;

				head = pre.next;
			}
			return orig.next;
		}
	}
}
