package test;

public class SwapNodesInPairs {
	public class Solution {
		public ListNode swapPairs(ListNode head) {
			if (head == null)
				return head;

			ListNode original = new ListNode(-1);
			original.next = head;

			ListNode pre = original;
			ListNode curr = head;
			ListNode next = head.next;

			while (curr != null && next != null) {
				ListNode p = next.next;

				// swap nodes
				pre.next = next;
				next.next = curr;
				curr.next = p;

				// more forward
				pre = next.next;
				curr = p;
				if (p == null)
					break;
				next = p.next;
			}
			return original.next;
		}
	}
}
