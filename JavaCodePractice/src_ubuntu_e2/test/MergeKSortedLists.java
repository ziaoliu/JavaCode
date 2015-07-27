package test;

public class MergeKSortedLists {
	public class Solution {
		public ListNode mergeKLists(ListNode[] lists) {
			if (lists == null || lists.length <= 0)
				return null;

			return merge(lists, 0, lists.length - 1);

		}

		private ListNode merge(ListNode[] lists, int l, int r) {
			if (l < r) {
				int m = (l + r) / 2;
				return mergeTwoLists(merge(lists, l, m), merge(lists, m + 1, r));
			}
			return lists[l];
		}

		private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null && l2 == null)
				return l1;
			if (l1 == null || l2 == null)
				return l1 != null ? l1 : l2;

			ListNode original = new ListNode(-1);
			ListNode dummy = original;

			while (l1 != null || l2 != null) {
				int one = Integer.MAX_VALUE;
				int two = Integer.MAX_VALUE;
				int less = 0;

				if (l1 != null)
					one = l1.val;
				if (l2 != null)
					two = l2.val;

				if (one < two) {
					less = one;
					l1 = l1.next;
				} else {
					less = two;
					l2 = l2.next;
				}

				dummy.next = new ListNode(less);
				dummy = dummy.next;

			}

			return original.next;
		}
	}
}
