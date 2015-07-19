package test;

public class MergeTwoSortedLists {
	public class Solution {
		public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null && l2 == null)
				return null;
			if (l1 == null || l2 == null)
				return l1 == null ? l2 : l1;

			ListNode result = new ListNode(-1);
			ListNode dummy = result;

			while (l1 != null || l2 != null) {
				int one = Integer.MAX_VALUE;
				int two = Integer.MAX_VALUE;

				if (l1 != null)
					one = l1.val;
				if (l2 != null)
					two = l2.val;

				int small = 0;

				if (one < two) {
					small = one;
					l1 = l1.next;
				} else {
					small = two;
					l2 = l2.next;
				}

				dummy.next = new ListNode(small);
				dummy = dummy.next;
			}
			return result.next;
		}
	}
}
