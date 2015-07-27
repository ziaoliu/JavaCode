package test;

public class ReverseNodesInKGroup {
	public static void main(String[] args) {
		ReverseNodesInKGroup test = new ReverseNodesInKGroup();
		Solution t = test.new Solution();

		ListNode one = new ListNode(1);
		one.next = new ListNode(2);
		// one.next.next = new ListNode(3);
		t.reverseKGroup(one, 2);
	}

	public class Solution {
		public ListNode reverseKGroup(ListNode head, int k) {
			if (head == null || k < 2)
				return head;

			ListNode original = new ListNode(-1);
			original.next = head;

			ListNode pre = original;
			ListNode start = head;
			ListNode next = head.next;

			while (start != null) {
				ListNode temp = start;
				int i = 0;
				for (; i < k - 1 && temp != null; i++)
					temp = temp.next;

				if (i != k - 1 || temp == null)
					break;

				ListNode end = temp.next;

				while (next != end) {
					ListNode dup = next.next;
					next.next = pre.next;
					pre.next = next;
					next = dup;
				}
				pre = start;
				start.next = end;
				start = start.next;// start = end;

			}
			return original.next;
		}
	}
}
