package test;

public class ReorderList {
	public class Solution {
		// 1. find the middle point to get the second half
		// 2. reverse second half
		// 3. merge two parts
		public void reorderList(ListNode head) {
			if (head == null || head.next == null)
				return;
			// step 1
			ListNode slow = head;
			ListNode fast = head;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				if (fast.next != null)
					fast = fast.next.next;
				else
					fast = null;
			}
			// step 2
			ListNode pre = null;// set list pre
			ListNode cur = slow.next;// set list head
			slow.next = null;// cur off two lists
			while (cur != null) {
				ListNode tmp = cur.next;
				cur.next = pre;
				pre = cur;
				cur = tmp;
			}
			// step 3
			ListNode p1 = head;
			ListNode p2 = pre;
			while (p2 != null) {
				ListNode tmp1 = p1.next;
				ListNode tmp2 = p2.next;
				p1.next = p2;
				p2.next = tmp1;
				p1 = tmp1;
				p2 = tmp2;
			}
		}// end of method
	}
}
