package test;

public class PartitionList {
	public class Solution {
		public ListNode partition(ListNode head, int x) {
			if (head == null)
				return head;
			ListNode one = new ListNode(-1);
			ListNode oneCopy = one;
			ListNode two = new ListNode(-1);
			ListNode twoCopy = two;
			while (head != null) {
				if (head.val < x) {
					one.next = head;
					one = one.next;
				} else {
					two.next = head;
					two = two.next;
				}
				head = head.next;
			}
			two.next = null;
			one.next = twoCopy.next;
			return oneCopy.next;
		}
	}
}
