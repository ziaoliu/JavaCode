package test;

public class RemoveNthNodeFromEndOfList_2 {
	public class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			if (head == null)
				return head;

			ListNode fastRunner = head;
			ListNode slowRunner = head;

			for (int i = 0; i < n; i++)
				fastRunner = fastRunner.next;

			if (fastRunner == null)
				return head.next;

			while (fastRunner.next != null) {
				fastRunner = fastRunner.next;
				slowRunner = slowRunner.next;
			}

			slowRunner.next = slowRunner.next.next;

			return head;
		}
	}
}
