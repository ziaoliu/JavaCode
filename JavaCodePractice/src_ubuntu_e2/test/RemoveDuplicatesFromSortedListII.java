package test;

public class RemoveDuplicatesFromSortedListII {
	public class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode pre = orig;
			while (head != null) {
				while (head.next != null && head.next.val == head.val)
					head = head.next;
				if (pre.next == head)
					pre = pre.next;
				else {
					pre.next = head.next;
				}
				head = head.next;
			}
			return orig.next;
		}
	}
}
