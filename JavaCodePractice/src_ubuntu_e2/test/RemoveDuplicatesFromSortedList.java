package test;

//http://blog.csdn.net/linhuanmars/article/details/24354291
public class RemoveDuplicatesFromSortedList {
	public class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode pre = head;
			head = head.next;
			while (head != null) {
				if (pre.val == head.val)
					pre.next = head.next;
				else
					pre = pre.next;
				head = head.next;
			}
			return orig.next;
		}
	}

	public class SolutionOld {
		public ListNode deleteDuplicates(ListNode head) {
			if (head == null)
				return head;
			ListNode orig = new ListNode(-1);
			orig.next = head;
			ListNode pre = head;
			head = head.next;
			while (head != null) {
				while (head != null && pre.val == head.val) {
					head = head.next;
				}
				pre.next = head;
				pre = pre.next;
				if (head != null)
					head = head.next;
			}
			return orig.next;
		}
	}
}
