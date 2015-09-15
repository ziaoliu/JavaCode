package test;

public class LinkedListCycleII {
	public class Solution {
		public ListNode detectCycle(ListNode head) {
			if (head == null)
				return head;
			ListNode slow = head;
			ListNode fast = head;
			while (slow != null && fast != null) {
				slow = slow.next;
				if (fast.next != null)
					fast = fast.next.next;
				else
					fast = null;
				if (slow == fast)
					break;
			}
			if (fast == null)
				return null;
			while (head != slow) {
				head = head.next;
				slow = slow.next;
			}
			return head;
		}
	}
}
