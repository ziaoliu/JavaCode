package test;

public class ReverseLinkedListII {
	public class Solution {
		public ListNode reverseBetween(ListNode head, int m, int n) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode listStart = null;
			ListNode pre = orig;
			for (int i = 1; head != null; i++) {
				if (i <= n && i > m) {
					pre.next = head.next;
					head.next = listStart.next;
					listStart.next = head;

					head = pre.next;
				} else {
					if (i == m) {
						listStart = pre;
					}
					pre = pre.next;
					head = head.next;
				}
			}
			return orig.next;
		}
	}
}
