package test;

public class RemoveNthNodeFromEndOfList {
	public class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			if (head == null || n < 0)
				return head;

			ListNode original = head;
			ListNode fastRunner = head;
			ListNode slowRunner = head;

			for (int i = 0; i < n; i++)
				fastRunner = fastRunner.next;

			if (fastRunner == null) // <<<<<<<<<<<< to remove head element
				return head.next;

			while (fastRunner.next != null) {
				fastRunner = fastRunner.next;
				slowRunner = slowRunner.next;
			}

			slowRunner.next = slowRunner.next.next;
			return original;
		}
	}
}
