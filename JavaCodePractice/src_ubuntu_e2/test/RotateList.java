package test;

public class RotateList {
	public class Solution {
		public ListNode rotateRight(ListNode head, int k) {
			if (head == null || k <= 0)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode tmp = head;
			int count = 1;
			while (tmp.next != null) {
				tmp = tmp.next;
				count++;
			}
			if (k == count || k % count == 0)
				return head;
			int more = count - k % count;
			tmp.next = head;
			while (more > 0) {
				tmp = tmp.next;
				more--;
			}
			head = tmp.next;
			tmp.next = null;
			return head;
		}
	}
}
